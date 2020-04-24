var audioCtx = new (window.AudioContext || window.webkitAudioContext)();
var context = new AudioContext();

var oscillator = audioCtx.createOscillator();
oscillator.type = 'sine';

var filter = context.createBiquadFilter();

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
        context.decodeAudioData(request.response, function(buffer) {
            mp3file = buffer;
        }, onerror);
    }
    request.send();
}
function playAudio() {
    source = context.createBufferSource(); // creates a sound source
    source.buffer = mp3file;                    // tell the source which sound to play
    source.connect(context.destination);       // connect the source to the context's destination (the speakers)
    source.start(0);                           // play the source now
                                               // note: on older systems, may have to use deprecated noteOn(time);
}
function stopAudio() {
    source.stop();
}
function startFilter() {
    source.connect(filter)
    filter.connect(context.destination);
    filter.type = 'lowpass';
    filter.frequency.value = 2000;
    source.start(0);
}
function stopFilter(freq) {
    filter.disconnect()
}
function setFreqFilter(freq) {
    filter.frequency.value = freq;
}
