"use strict";

var animationObj;
function animation(){
    const splitStr = "=====\n";
    let timerId;

    let slideTypes = {
        "blank": BLANK,
        "exercise": EXERCISE,
        "juggler": JUGGLER,
        "bike": BIKE,
        "dive": DIVE,
        "custom": CUSTOM
    }

    let current = 0;
    let slides = slideTypes['custom'].split(splitStr);

    function playSlide(){
        let nextSlide = slides[current];
        document.getElementById("animationBox").innerHTML = nextSlide;
        current = (current + 1) % slides.length;
    };

    return {
        startAnimation: function(intervalTime){
            timerId = setInterval(playSlide,  intervalTime);
        },

        stopAnimation: function(){
            clearInterval(timerId);
        },

        setAnimation: function(aniSel) {
            slides = slideTypes[aniSel.toLowerCase()].split(splitStr);
            current = 0;
        }
    }
    
};

function buttonStart(){
    let timeInterval = 50;
    if(!document.getElementById("speedBox").checked){
        timeInterval = 250;
    }
    animationObj.startAnimation(timeInterval);
    document.getElementById("startBtn").disabled = true;
    document.getElementById("stopBtn").disabled = false;
};

function buttonStop(){
    animationObj.stopAnimation();
    document.getElementById("startBtn").disabled = false;
    document.getElementById("stopBtn").disabled = true;
}

function animationChange(){
    animationObj.setAnimation(document.getElementById("animationSelect").value);
}

function changeFontSize(){
    let newSize = document.getElementById("animationSize").value;
    document.getElementById("animationBox").style.fontSize = newSize;
}

window.onload = () => {
    animationObj = animation();

    document.getElementById("startBtn").onclick = buttonStart;
    document.getElementById("stopBtn").onclick = buttonStop;
    document.getElementById("animationSelect").onchange = animationChange;
    document.getElementById("animationSize").onchange = changeFontSize;
};