let chosenShip = null;




function initalizeMove(ship) {
    chosenShip = ship;
    console.log(chosenShip);
    changeStatsView(ship);
    var url = "/bareentest";
    var method = "POST";
    var postData = order;

// You REALLY want shouldBeAsync = true.
// Otherwise, it'll block ALL execution waiting for server response.
    var shouldBeAsync = true;

    var request = new XMLHttpRequest();


    request.onload = function () {

        // Because of javascript's fabulous closure concept, the XMLHttpRequest "request"
        // object declared above is available in this function even though this function
        // executes long after the request is sent and long after this function is
        // instantiated. This fact is CRUCIAL to the workings of XHR in ordinary
        // applications.

        // You can get all kinds of information about the HTTP response.
        var status = request.status; // HTTP response status, e.g., 200 for "200 OK"
        var data = request.responseText; // Returned data, e.g., an HTML document.
    }

    request.open(method, url, shouldBeAsync);

    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
// Or... request.setRequestHeader("Content-Type", "text/plain;charset=UTF-8");
// Or... whatever
    request.send(postData);

}

function finalizeMove(tile) {
    console.log(tile);
    if (chosenShip!=null) {
        console.log("inde");

        console.log(tile.el.style.top);
        console.log(tile.el.style.left);
        chosenShip.el.style.top = tile.el.style.top;
        chosenShip.el.style.left = tile.el.style.left;

        chosenShip = null;
    }

}

function changeStatsView(ship) {

    // Saving all our elements we want to change
    let shipimage = document.getElementById("statsshipimage");
    let shiptype = document.getElementById("statsshiptype");
    let shipcountry = document.getElementById("statscountry");
    let shipcaptain = document.getElementById("statscaptain");
    let shiphealth = document.getElementById("statshealth");
    let shipspeed = document.getElementById("statsspeed");
    let shipcanon = document.getElementById("statscanon");
    let shipchain = document.getElementById("statschain");
    let shipgrape = document.getElementById("statsgrape");

    // Changing the ship type element stats.
    shiptype.innerText = ship.shipType.type;

    // Changing the ship image stats.
    let imageString = "../img/ships/" + ship.shipType.type.replace(/\s/g,'') + "/" + ship.nationality.color + ".png";
    shipimage.src = imageString;

    // Changing the ship country stats.
    shipcountry.innerText = ship.nationality.country;

    // Changing the ship captain stats.
    shipcaptain.innerText = ship.nationality.captain;

    // Changing the ship health stats.
    let percentageOfMaxHealth = (((ship.health - ship.shipType.max_health)/ship.shipType.max_health)*100)+100;
    shiphealth.style.width = percentageOfMaxHealth + "%";
    shiphealth.innerText = ship.health + " / " + ship.shipType.max_health;

    // Changing the ship speed stats.
    let currentMaxSpeed = 0;

    if (percentageOfMaxHealth > 75) {
        currentMaxSpeed = ship.shipType.max_speed;
    } else if (percentageOfMaxHealth < 75 && percentageOfMaxHealth > 50) {
        currentMaxSpeed = ship.shipType.speed_75;
    } else if (percentageOfMaxHealth < 50 && percentageOfMaxHealth > 25) {
        currentMaxSpeed = ship.shipType.speed_50;
    } else if (percentageOfMaxHealth < 25) {
        currentMaxSpeed = ship.shipType.speed_25;
    }

    let percentageOfMaxSpeed = ((((ship.speed - currentMaxSpeed)/currentMaxSpeed)*100)+100);

    shipspeed.innerText = ship.speed + " / " + currentMaxSpeed;
    shipspeed.style.width = percentageOfMaxSpeed + "%";

    // Changing the ship ammo stats.
    shipcanon.className = shipcanon.className.replace(" active", "");
    shipchain.className = shipchain.className.replace(" active", "");
    shipgrape.className = shipgrape.className.replace(" active", "");

    if (ship.currentAmmunitionType === 0) {

        shipcanon.className += " active"

    } else if (ship.currentAmmunitionType === 1) {

        shipchain.className += " active"

    } else if (ship.currentAmmunitionType === 2) {

        shipgrape.className += " active"
    }
}