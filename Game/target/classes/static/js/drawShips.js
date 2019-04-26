let ships = [];

function drawShips(ShipList) {

    // Where to place the titles
    let map = document.getElementById('ships');

    for (var i = 0; i < ShipList.length; i++) {

    // Create a new div for each ship element.
        let div = document.createElement('div');

        // Fill our javascript constructors with the values recieved from our controller.
        let coordinate = new Coordinate(ShipList[i].coordinate.x, ShipList[i].coordinate.y);

        let shipType = new Shiptype(ShipList[i].shipType.ship_type_id, ShipList[i].shipType.type,
            ShipList[i].shipType.max_speed, ShipList[i].shipType.max_speed_change, ShipList[i].shipType.speed_75,
            ShipList[i].shipType.speed_50,ShipList[i].shipType.speed_25,ShipList[i].shipType.max_health,ShipList[i].shipType.damage);

        let nationality = new Nationality(ShipList[i].nationality.nationality_id, ShipList[i].nationality.country,
            ShipList[i].nationality.color, ShipList[i].nationality.captain);

        let ship = new Ship(div, ShipList[i].ship_id, shipType, nationality, coordinate,
            Direction[ShipList[i].direction], ShipList[i].speed,
            ShipList[i].health, ShipList[i].load, ShipList[i].currentAmmunitionType);

        div.classList.add(ship.shipType.type.replace(/\s/g,'') + "-" + ship.nationality.color);

        for (var j = 0; j < tiles.length; j++) {
            if (ship.coordinate.x === tiles[j].x && ship.coordinate.y === tiles[j].y) {
                div.style.top = tiles[j].el.style.top;
                div.style.left = tiles[j].el.style.left;
                div.style.height = tiles[j].el.style.height;
                div.style.width = tiles[j].el.style.width;
                div.style.transform = "rotate(" + (ship.direction * 60) + "deg)";
                div.style.zIndex = 999;
            }
        }

        div.onclick = function() {
            initalizeMove(ship);
        };

        ships.push(ship);
        console.log(ship);
        map.append(div);
    }
}
