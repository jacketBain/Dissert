var audioCtx = new (window.AudioContext || window.webkitAudioContext)();
var context = new AudioContext();

var isConnectSource = false;
var isConnectFilter = false;

var gainNode = audioCtx.createGain();
var distNode = audioCtx.createWaveShaper();

var oscillator = audioCtx.createOscillator();
oscillator.type = 'sine';


var filter = audioCtx.createBiquadFilter();


var mp3file = null;
var source = null;



function setFreqOscillatorSound(freq) {
    oscillator.frequency.setValueAtTime(freq, audioCtx.currentTime);
}

function startOscillatorSound() {


    oscillator.connect(audioCtx.destination);
    oscillator.start();
}
function stopOscillatorSound() {
    oscillator.disconnect();
}

function getAudio(url) {
    var request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.responseType = 'arraybuffer';
    request.onload = function() {
        audioCtx.decodeAudioData(request.response, function(buffer) {
            mp3file = buffer;
        }, onerror);
    }
    request.send();
}
function playAudio() {
    source = audioCtx.createBufferSource();
    source.buffer = mp3file;
    source.connect(audioCtx.destination);
    document.getElementById("startFilter").disabled = false;
    document.getElementById("stopFilter").disabled = false;
    document.getElementById("startDist").disabled = false;
    document.getElementById("stopDist").disabled = false;
    source.start(0);
    isConnectSource=true;
}
function stopAudio() {
    document.getElementById("startFilter").disabled = true;
    document.getElementById("stopFilter").disabled = true;
    stopFilter();
    source.stop();
}
function pause() {
    audioCtx.suspend();
}
function resume() {
    audioCtx.resume();
}

function startFilter() {
    source.disconnect();
    source.connect(filter);
    filter.connect(audioCtx.destination);
    isConnectFilter = true;
    document.getElementById('freq').innerHTML=filter.frequency.value.toFixed(2) + " Гц";
    document.getElementById('q').innerHTML=filter.Q.value.toFixed(2) + " Дц";
}
function stopFilter(){
    filter.disconnect()
    source.connect(audioCtx.destination);
    isConnectFilter = false;
    document.getElementById('freq').innerHTML="Выкл";
    document.getElementById('q').innerHTML="Выкл";
}
function setFreqFilter(freq){
    if(isConnectFilter) {
        var minValue = 40;
        var maxValue = audioCtx.sampleRate / 2.0;
        var numberOfOctaves = Math.log(maxValue / minValue) / Math.LN2;
        var multiplier = Math.pow(2, numberOfOctaves * (freq - 1.0));
        filter.frequency.setValueAtTime(maxValue * multiplier, audioCtx.currentTime);
        document.getElementById('freq').innerHTML = filter.frequency.value.toFixed(2) + " Гц";
    }
}
function setQFilter(q) {
    if(isConnectFilter)
    {
        filter.Q.value = q;
        document.getElementById('q').innerHTML = filter.Q.value.toFixed(2) + " Дц";
    }
}
function setTypeFilter(type) {
    if(isConnectFilter)
    {
        filter.type = type;
    }
}
function startDistortion() {
    distNode.curve = makeDistortionCurve(document.getElementById('distAmountRange').valueAsNumber);
    source.disconnect(0);
    source.connect(gainNode);
    gainNode.connect(distNode);
    distNode.connect(audioCtx.destination);
    document.getElementById("amountDist").value = (document.getElementById('distAmountRange').valueAsNumber/400) * 100;
}
function stopDistortion() {
    distNode.disconnect();
    gainNode.disconnect();
    source.connect(audioCtx.destination);
}
function setAmountDistortion(amount) {

    distNode.curve = makeDistortionCurve(amount);
    document.getElementById("amountDist").value = (amount/400) *100;
    var amountBar = document.querySelector('#amountDist');
    if( amount > 340)
    {

        amountBar.setAttribute('class','dist_progress_danger');

    }
    else
    {
        amountBar.setAttribute('class','dist_progress');
    }

}
// https://medium.com/@alexanderleon/web-audio-series-part-2-designing-distortion-using-javascript-and-the-web-audio-api-446301565541
function makeDistortionCurve(amount) {
    var k = amount,
        n_samples = typeof sampleRate === 'number' ? sampleRate : 44100,
        curve = new Float32Array(n_samples),
        deg = Math.PI / 180,
        i = 0,
        x;
    for ( ; i < n_samples; ++i ) {
        x = i * 2 / n_samples - 1;
        curve[i] = (3 + k)*Math.atan(Math.sinh(x*0.25)*5) / (Math.PI + k * Math.abs(x));
    }
    return curve;
}

