class Tile {
    constructor(el, x, y) {
        this.el = el;
        this.x = x; // These are coordinates, not pixel positions.
        this.y = y;
    }
}

let tiles = [];

window.onload = function() {

    generateMap(10);

};

function generateMap(mSize) {

    console.log(tiles);
    if(!isEmpty(tiles)) {

        tiles = [];

        let elements = document.getElementsByClassName('tile');
        for (var i = elements.length; i--;) {
            elements[i].parentNode.removeChild(elements[i]);
        }


    }

    console.log(document.getElementsByClassName('tile').length);

    // Where to place the titles
    let map = document.getElementById('tiles');

    // Get the size of the map.
    let mapHeight = document.getElementById('gameView').clientHeight;
    let mapWidth = document.getElementById('gameView').clientWidth;

    // The size of the map.
    // Change size to get a bigger/smaller map.
    let mapSize = mSize;
    const width = mapSize; // Divide by 2 to get a X by X map. Without its X by X*2.
    const height = mapSize;;

    // Checks how big the tiles should be to fit the game container.
    // Depending whether game height or with is lower.
    const tileSizeFromWidth = (mapWidth/(width*2));
    const tileSizeFromHeight = (mapHeight/(height + 1)); // Adds 2 to create extra space

    let tileSize;

    if (tileSizeFromHeight < tileSizeFromWidth) {
        tileSize = Math.round(tileSizeFromHeight);
    } else {
        tileSize = Math.round(tileSizeFromWidth);
    }

    // Center the map in the game container
    const tilesCenterWidth =  (mapWidth  - (tileSize * 1.5) * width  + (tileSize  ))/2;
    const tilesCenterHeight = (mapHeight - (tileSize      ) * height + (tileSize*2))/2;

    // Add the first set of tiles (First column and every second after that).
    for (var i = 0; i < width; i++) {
        for (var j = 0; j < height; j++) {

            // Creates a new div element.
            let div = document.createElement('div');

            // Adds the title class and styles to the element.
            div.classList.add('tile');
            div.style.top  += tilesCenterHeight + (j * (tileSize-tileSize*0.05))+ "px";
            div.style.left += tilesCenterWidth + (i * ((tileSize-tileSize*0.04) + tileSize*0.5)) + "px";
            div.style.backgroundSize = tileSize + "px";
            div.style.height = tileSize + "px";
            div.style.width = tileSize + "px";

            // Adds the div, x position and y position to the tiles list.
            tiles.push( new Tile(div, i,j) )

            // Appends the newly created div(tile) to the webpage.
            map.append(div);

        }
    }

    // Add the second set of tiles (Second column and every second after that).
    for (var i = 0; i < width; i++) {

        for (var j = 0; j < height; j++) {

            // Creates a new div element.
            let div = document.createElement('div');

            // Adds the title class and styles to the element.
            div.classList.add('tile');
            div.style.top  += tilesCenterHeight + (-tileSize*0.5) + (j * (tileSize-tileSize*0.05))   + "px";
            div.style.left += tilesCenterWidth + tileSize*0.73 + (i * ((tileSize-tileSize*0.04) + tileSize*0.5)) + "px";
            div.style.backgroundSize = tileSize + "px";
            div.style.height = tileSize + "px";
            div.style.width = tileSize + "px";

            // Adds the div, x position and y position to the tiles list.
            tiles.push( new Tile(div, i,j) )

            // Appends the newly created div(tile) to the webpage.
            map.append(div);

        }

    }

    function isEmpty(obj) {
        for(var key in obj) {
            if(obj.hasOwnProperty(key))
                return false;
        }
        return true;
    }

}