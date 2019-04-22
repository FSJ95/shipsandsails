const backgroundmusic = new Audio('music/somali.mp3');


function music_toggle() {
    if (backgroundmusic.paused) {
        document.getElementById("musicButton").innerHTML= "MUTE MUSIC";
        backgroundmusic.play();
    } else {
        document.getElementById("musicButton").innerHTML= "UNMUTE MUSIC";
        backgroundmusic.pause();
    }
}