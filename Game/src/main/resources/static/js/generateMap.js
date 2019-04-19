class Tile {
    constructor(el, x, y) {
        this.el = el;
        this.x = x; // Coordinates.
        this.y = y; // Coordinates.
    }
}

let tiles = [];

function generateMap(height, width) {

    // Where to place the titles
    let map = document.getElementById('tiles');

    // Get the size of the map.
    let mapHeightPixels = document.getElementById('gameView').clientHeight;
    let mapWidthPixels = document.getElementById('gameView').clientWidth;

    // The size of the map.
    // Change size to get a bigger/smaller map.
    const mapWidthCount = width/2; // Divide by 2 to get a X by X map. Without its X by X*2.
    const mapHeightCount = height;

    // Checks how big the tiles should be to fit the game container.
    // Depending whether game mapHeightCount or with is lower.
    const tileSizeFromWidth = (mapWidthPixels/(mapWidthCount*2));
    const tileSizeFromHeight = (mapHeightPixels/(mapHeightCount + 1)); // Adds 2 to create extra space

    let tileSize;

    if (tileSizeFromHeight < tileSizeFromWidth) {
        tileSize = Math.round(tileSizeFromHeight);
    } else {
        tileSize = Math.round(tileSizeFromWidth);
    }

    // Center the map in the game container
    const tilesCenterWidth =  (mapWidthPixels  - (tileSize * 1.5) * mapWidthCount  + (tileSize  ))/2;
    const tilesCenterHeight = (mapHeightPixels - (tileSize      ) * mapHeightCount + (tileSize*2))/2;

    // Add the first set of tiles (First column and every second after that).
    for (var i = 0; i < mapWidthCount; i++) {
        for (var j = 0; j < mapHeightCount; j++) {

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
    for (var i = 0; i < mapWidthCount; i++) {

        for (var j = 0; j < mapHeightCount; j++) {

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
}