function getBigger() {
    let tArea = document.getElementById("myTextarea");
    let curFontSize = parseInt(tArea.style.fontSize);
    console.log(curFontSize)
    if (curFontSize) {
        tArea.style.fontSize = curFontSize + 2 + "pt";
    } else {
        tArea.style.fontSize = "14pt";
    }

    fitHeight(tArea);
}

function alertFunction() {
    let intervalId = setInterval(getBigger, 500);
    setTimeout(() => {
        console.log("stopping the interval");
        clearInterval(intervalId);
    }, 2400);
}

function fitHeight(element){
    element.style.height = element.scrollHeight + "px";
};

function bling() {
    // alert("Bling!");

    let bling = document.getElementById("blingCheck");
    let tArea = document.getElementById("myTextarea");
    if(!bling.checked) {
        tArea.style.fontWeight = "Normal";
        tArea.style.color = "black";
        tArea.style.textDecoration = "None";
    } else {
        tArea.style.color = "green";
        tArea.style.textDecoration = "underline";
        tArea.style.fontWeight = "Bold";
    }
    // fitHeight(tArea);

}