var player = null;

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
    if(document.getElementById('player_td')!=null)
    {
        document.getElementById('player_td').remove();
    }
    var request = new XMLHttpRequest();
    request.open("GET", "/assets/audio/18.mp3", true);
    request.responseType = "blob";

    var td = document.createElement("td")
    td.setAttribute('id','player_td')
    document.getElementById('infoTrack').append(td);

    player = document.createElement("audio");
    player.setAttribute('src',url);
    player.setAttribute('id','player');
    player.setAttribute('preload','none');
    player.setAttribute('autoplay','true');
    //player.setAttribute('controls','controls');
    document.getElementById('player_td').append(player);

    document.getElementById('title').innerHTML=title;
    document.getElementById('album').innerHTML=album;
    document.getElementById('artist').innerHTML=artist;
    currTime = document.getElementById('currTime');
    durationTime = document.getElementById('duration');
    durationTime.innerHTML = time;
    progressPlay = document.getElementById('progress_play');
    player = document.getElementById('player');
    addEvents();

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