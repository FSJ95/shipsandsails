let ships = [];

class Coordinate {
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}

class Ship {
    constructor(el, shipId, shipType, nationality, name, coordinate, direction, speed, hull_health, sail_health, sailors, load, currentAmmunitionType) {
        this.el = el;
        this.shipId = shipId;
        this.shipType = shipType;
        this.nationality = nationality;
        this.name = name;
        this.coordinate = coordinate;
        this.direction = direction;
        this.speed = speed;
        this.hull_health = hull_health;
        this.sail_health = sail_health;
        this.sailors = sailors;
        this.load = load;
        this.currentAmmunitionType = currentAmmunitionType;
    }
}



function drawShips(ShipList) {

    // Where to place the titles
    let map = document.getElementById('ships');

    for (var i = 0; i < ShipList.length; i++) {

        // Create a new div for each ship element.
        let div = document.createElement('div');

        // Fill our javascript constructor with the values recieved from our controller.
        let coordinate = new Coordinate(ShipList[i].coordinate.x,ShipList[i].coordinate.y);

        let ship = new Ship(div, ShipList[i].shipId, ShipList[i].shipType,
            ShipList[i].nationality, ShipList[i].name, coordinate,
            ShipList[i].direction, ShipList[i].speed, ShipList[i].hull_health,
            ShipList[i].sail_health, ShipList[i].sailors, ShipList[i].load,
            ShipList[i].currentAmmunitionType);

        div.classList.add('brig-Red');

        for (var j = 0; j < tiles.length; j++) {
            if (ship.coordinate.x === tiles[j].x && ship.coordinate.y === tiles[j].y) {
                div.style.top = tiles[j].el.style.top;
                div.style.left = tiles[j].el.style.left;
                div.style.height = tiles[j].el.style.height;
                div.style.width = tiles[j].el.style.width;
                div.style.zIndex = 999;
            }
        }

        ships.push(ship);
        map.append(div);

    }


    console.log(ships);
}
