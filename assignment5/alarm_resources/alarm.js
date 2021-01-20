"use strict";

var timerId;
var total_sec;
function endAlarm(){
    clearInterval(timerId);
    document.getElementsByClassName("awesome").item(0).style.backgroundColor = "red";
}

function countdown() {
    total_sec --;
    let seconds = total_sec % 60;
    let minutes = (total_sec - seconds) / 60;

    if(minutes == 0) minutes = null;
    if(seconds == 0) seconds = null;
    document.getElementById("min").value = minutes;
    document.getElementById("sec").value = seconds;

    if(!minutes && !seconds) {endAlarm();}
}

function startAlarm() {
    document.getElementsByClassName("awesome").item(0).style.backgroundColor = "white";
    let minutes = parseInt(document.getElementById("min").nodeValue)
    if (!minutes) {minutes = 0;}
    let seconds = parseInt(document.getElementById("sec").value)
    if (!seconds) {seconds = 0;}
    total_sec = minutes* 60 + seconds;
    if(total_sec > 0) {
        timerId = setInterval(countdown, 1000);
    }
}

window.onload = (() => {
    document.getElementById("go").onclick = startAlarm;
})