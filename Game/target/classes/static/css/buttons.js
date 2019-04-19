const audio = new Audio("music/somali.mp3")
audio.play()

function music_toggle() {
    if (audio.paused) audio.play()
    else audio.pause()
}