let chosenShip = null;

function initalizeMove(ship) {
    chosenShip = ship;
    console.log(chosenShip);
    changeStatsView(ship)

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
    let shiphull = document.getElementById("statshull");

    // Changing the ship type element.
    shiptype.innerText = ship.nationality.type;

    // Changing the ship image.
    let imageString = "../img/ships/" + ship.shipType.type + "/" + ship.nationality.color + ".png";
    shipimage.src = imageString;

    // Changing the ship country.
    shipcountry.innerText = ship.nationality.country;

    // Changing the ship captain.
    shipcaptain.innerText = ship.nationality.captain;

    // Changing the ship health.

    // Changing the

    // Changing the




    shiphull.value = ship.hull_health;

}