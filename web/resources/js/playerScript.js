var player = document.getElementById('player');

var currTime = null;
var durationTime = null;
var progressPlay = document.getElementById('progress_play');

var dur = null;
var cur = null;

function audioTime(time) {
    time = Math.floor(time);
    var minutes = Math.floor(time / 60);
    var seconds = Math.floor(time - minutes * 60);
    var minutesVal = minutes;
    var secondsVal = seconds;
    if(minutes < 10) {
        minutesVal = '0' + minutes;
    }
    if(seconds < 10) {
        secondsVal = '0' + seconds;
    }
    return minutesVal + ':' + secondsVal;
}


function addPlayer(url,title,album,artist,time) {
    player = document.getElementById('player');
    player.setAttribute('src',url);
    player.setAttribute('autoplay','true');
    document.getElementById('title').innerHTML=title;
    document.getElementById('album').innerHTML=album;
    document.getElementById('artist').innerHTML=artist;
    currTime = document.getElementById('currTime');
    durationTime = document.getElementById('duration');
    durationTime.innerHTML = time;
    progressPlay = document.getElementById('progress_play');
    addEvents();

}
function initPlayerForWork() {
    player = document.getElementById('playerWork');
    player.setAttribute('autoplay','true');
    currTime = document.getElementById('currTime');
    durationTime = document.getElementById('duration');
    progressPlay = document.getElementById('progress_play');
    addEvents();
    getAudio();
}
function addEvents() {
    document.getElementById('play').addEventListener('click',playTrack);
    document.getElementById('pause').addEventListener('click',pauseTrack);
    player.addEventListener('timeupdate',audioTimeShow);
    progressPlay.addEventListener('click',e => setPlayTime(e));
}
function playTrack() {
    player.play()

}
function pauseTrack() {
    player.pause();
}
function audioTimeShow() {
    var current_time = player.currentTime;
    if (current_time>0)
    {
        progress = (Math.floor(player.currentTime) / (Math.floor(player.duration) / 100));
        progressPlay.value = progress
    }
    currTime.innerHTML = audioTime(player.currentTime);
}
function setPlayTime(e) {
    var duration_time = player.duration;
    if(duration_time>0) {
        var x = e.pageX - document.getElementById('progress_td').offsetLeft - 12;
        var clickedValue = x * progressPlay.max / document.getElementById('progress_td').offsetWidth;
        progressPlay.value = clickedValue;
        player.currentTime = player.duration * (clickedValue / 100);

    }
}