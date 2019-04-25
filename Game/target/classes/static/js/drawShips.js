let ships = [];
let order;

class Coordinate {
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}

class Nationality{
    constructor(nationality_id, country, color, captain) {
        this.nationality_id = nationality_id;
        this.country = country;
        this.color = color;
        this.captain = captain;
    }
}
class Shiptype{
    constructor(ship_type_id, type, max_speed, max_speed_change, speed_75, speed_50, speed_25, max_health, damage) {
        this.ship_type_id = ship_type_id;
        this.type = type;
        this.max_speed = max_speed;
        this.max_speed_change = max_speed_change;
        this.speed_75 = speed_75;
        this.speed_50 = speed_50;
        this.speed_25 = speed_25;
        this.max_health = max_health;
        this.damage = damage;
    }
}
class Ship {
    constructor(el, ship_id, shipType, nationality, coordinate, direction, speed, health, load, currentAmmunitionType) {
        this.el = el;
        this.ship_id = ship_id;
        this.shipType = shipType;
        this.nationality = nationality;
        this.coordinate = coordinate;
        this.direction = direction;
        this.speed = speed;
        this.health = health;
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

// Freeze our enums so they cant be changed.
Object.freeze(Direction);

function drawShips(ShipList) {
    // Where to place the titles
    let map = document.getElementById('ships');

    for (var i = 0; i < ShipList.length; i++) {

        var order = new Order();
        order.turnNumber = 1;

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
