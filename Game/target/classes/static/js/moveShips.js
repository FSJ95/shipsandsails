let chosenShip = null;

function initalizeMove(ship) {
    chosenShip = ship;
    console.log(chosenShip);
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