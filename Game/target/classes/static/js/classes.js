class Coordinate {
    constructor(x,y) {
        this.x = x;
        this.y = y;
    }
}
class Tile {
    constructor(el, x, y) {
        this.el = el;
        this.x = x; // Coordinates.
        this.y = y; // Coordinates.
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

class Order {
    constructor(ship_id, turn, coordinateList, fire, load, ammunitionType, target) {
        this.ship_id = ship_id;
        this.turn = turn;
        this.coordinateList = coordinateList;
        this.fire = fire;
        this.load = load;
        this.ammunitionType = ammunitionType;
        this.target = target;
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