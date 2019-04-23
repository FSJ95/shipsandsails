let ships = [];

class Coordinate {
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}

class Nationality{
    constructor(id, country, color, captain) {
        this.id = id;
        this.country = country;
        this.color = color;
        this.captain = captain;
    }
}

class Ship {
    constructor(el, shipId, shipType, nationality, coordinate, direction, speed, hull_health, sail_health, sailors, load, currentAmmunitionType) {
        this.el = el;
        this.shipId = shipId;
        this.shipType = shipType;
        this.nationality = nationality;
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

// Used to turn our enum into corresponding numbers.
var Direction = {
    N : 0,
    NE : 1,
    SE : 2,
    S : 3,
    SW : 4,
    NW : 5
};

// Used to turn our shiptype numbers into corresponding ships.
var ShipType = {
    1 : "brig",
    2 : "shipoftheline",
    3 : "manatwar"
};

// Freeze our enums so they cant be changed.
Object.freeze(Direction);
Object.freeze(ShipType);

function drawShips(ShipList) {
    // Where to place the titles
    let map = document.getElementById('ships');

    for (var i = 0; i < ShipList.length; i++) {
        // Create a new div for each ship element.
        let div = document.createElement('div');

        // Fill our javascript constructor with the values recieved from our controller.
        let coordinate = new Coordinate(ShipList[i].coordinate.x, ShipList[i].coordinate.y);
        let nationality = new Nationality(ShipList[i].nationality.id, ShipList[i].nationality.country,
            ShipList[i].nationality.color, ShipList[i].nationality.captain);

        let ship = new Ship(div, ShipList[i].shipId, ShipList[i].shipType,
            nationality, coordinate, Direction[ShipList[i].direction], ShipList[i].speed,
            ShipList[i].hull_health, ShipList[i].sail_health, ShipList[i].sailors,
            ShipList[i].load, ShipList[i].currentAmmunitionType);

        div.classList.add(ShipType[ship.shipType] + "-" + ship.nationality.color);

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

        map.append(div);
    }
}
