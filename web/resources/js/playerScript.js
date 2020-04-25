var audioCtx = new (window.AudioContext || window.webkitAudioContext)();
var mp3file = null;
var source = null;

//bool
var isLoaded = false;
var isPlayed = false;
var isPaused = false;
//tags
var title = null;
var album = null;
var artist = null;

function getAudio(url,title,album,artist)
{
    if(source != null)
    {
        playAudio();
    }
    var request = new XMLHttpRequest();
    request.open('GET', url, true);
    request.responseType = 'arraybuffer';
    /*request.onload = function() {
        audioCtx.decodeAudioData(request.response, function(buffer) {
            mp3file = buffer;
        }, onerror);
    }*/
    request.send();
    request.onreadystatechange = function () {
        source = audioCtx.createBufferSource();
        if (request.readyState == 4)
        {

            audioCtx.decodeAudioData(request.response, function(buffer) {
                mp3file = buffer;
                source.buffer = mp3file;
                source.connect(audioCtx.destination);
            });
            isLoaded = true;
            document.getElementById("play").disabled = false;
            document.getElementById("pause").disabled = false;
            document.getElementById('title').innerHTML=title;
            document.getElementById('album').innerHTML=album;
            document.getElementById('artist').innerHTML=artist;
            playAudio()
        }


}



    //
    //document.getElementById('artist').innerHTML=source.buffer.duration.valueAsNumber;
    //
}
function playAudio() {
    if(isPlayed)
    {
        source.stop();
        isPlayed = false;
    }
    else
    {

        source.start(audioCtx.currentTime,70,source.buffer.duration);
        isPlayed = true;
    }

}
function pauseAudio() {
    if(isPaused)
    {
        audioCtx.resume();
        isPaused = false;
    }
    else
    {
        audioCtx.suspend();
        isPaused = true;
    }
}
function secToTime(sec) {
    var h = sec/3600 ^ 0 ;
    var m = (sec-h*3600)/60 ^ 0 ;
    var s = sec-h*3600-m*60 ;
    alert((h<10?"0"+h:h)+" ч. "+(m<10?"0"+m:m)+" мин. "+(s<10?"0"+s:s)+" сек.") ;
}