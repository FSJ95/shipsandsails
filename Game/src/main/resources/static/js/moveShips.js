let chosenShip = null;

function initalizeMove(ship) {
    chosenShip = ship;
    console.log(chosenShip);
    changeStatsView(ship)

}

function changeStatsView(ship) {
    let shiptype = document.getElementById("statsshiptype");

    let shiptypeName = "";

    switch (ship.shipType) {
        case 1:
            shiptypeName = "Brig";
            break;
        case 2:
            shiptypeName = "Ship of the line";
            break;
        case 3:
            shiptypeName = "Man at war";
            break;
    }

    shiptype.innerText = shiptypeName;

    let shipimage = document.getElementById("statsshipimage");

    switch (ship.nationality.country) {
        case "Denmark":
            shipimage.src = '../img/ships/brig/red.png';
            break;
        case "Japan":
            shipimage.src = '../img/ships/brig/white.png';
            break;
        case "Argentina":
            shipimage.src = '../img/ships/brig/teal.png';
            break;
        case "Portugal":
            shipimage.src = '../img/ships/brig/green.png';
            break;
    }

    let country = document.getElementById("statscountry");
    country.innerText = ship.nationality.country;

    let captain = document.getElementById("statscaptain");
    captain.innerText = ship.nationality.captain;

    let hull = document.getElementById("statshull");
    hull.value = ship.hull_health;

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