const backgroundmusic = new Audio('music/trampsomali.mp3');

function music_toggle() {
    if (backgroundmusic.paused) {
        document.getElementById("musicButton").innerHTML= "MUTE MUSIC";
        backgroundmusic.play();
    } else {
        document.getElementById("musicButton").innerHTML= "UNMUTE MUSIC";
        backgroundmusic.pause();
    }
}

function endturn() {
    $.ajax({
        url : "/endturn",
        type : 'POST',
        dataType : 'json',
        data : JSON.stringify(orderList),
        contentType : 'application/json',
        mimeType : 'application/json'
    }).done(function(data) {

    }).fail(function(error) {
        // parseToPageAlerts(error.responseText);
    }).always(function() {
        // hideLoading()
    });

    location.reload();
}