let tiles = [];

class Tile {
    constructor(el, x, y) {
        this.el = el;
        this.x = x; // Coordinates.
        this.y = y; // Coordinates.
    }
}

function generateMap(height, width) {

    // Where to place the titles
    let map = document.getElementById('tiles');

    // Get the size of the map.
    let mapHeightPixels = document.getElementById('gameView').clientHeight;
    let mapWidthPixels = document.getElementById('gameView').clientWidth;

    // Number of outofbounds tiles on each side.
    const outofbounds = 2;

    // The size of the map.
    const mapWidthCount =  outofbounds + width  + outofbounds;
    const mapHeightCount = outofbounds + height + outofbounds;

    // Checks how big the tiles should be to fit the game container.
    // Depending whether game mapHeightCount or with is lower.
    const tileSizeFromWidth = (mapWidthPixels/((mapWidthCount * 0.75) + 1));
    const tileSizeFromHeight = (mapHeightPixels/(mapHeightCount + 1));

    let tileSize;
    console.log(tileSizeFromWidth)
    console.log(tileSizeFromHeight)

    if (tileSizeFromHeight < tileSizeFromWidth) {
        tileSize = Math.round(tileSizeFromHeight);
        console.log("height")
        console.log(tileSize)
    } else {
        tileSize = Math.round(tileSizeFromWidth);
        console.log("width")
        console.log(tileSize)
    }
    console.log("så langt så godt")

    // Center the map in the game container
    const tilesCenterWidth =  (mapWidthPixels - ((tileSize*0.75) * mapWidthCount) + (tileSize*0.25))/2;
    const tilesCenterHeight = (mapHeightPixels - (tileSize * mapHeightCount) + tileSize)/2;

    // Nested forloop as we need x and y pos (First column and every second after that).
    for (var i = 0-outofbounds; i < mapWidthCount-outofbounds; i++) {
        for (var j = 0-outofbounds; j < mapHeightCount-outofbounds; j++) {

            // Creates a new div element.
            let div = document.createElement('div');

            // Adds the title class and styles to the element.
            // Adds the title class and styles to the element.
            if (j<0 || j>=height || i<0 || i>=width) {
                div.classList.add('outofboundstile');
            } else {
                div.classList.add('tile');
            }

            if ((i % 2) === 0){
                div.style.top  = tilesCenterHeight + ((j+outofbounds) * tileSize) + "px";
                div.style.left = tilesCenterWidth + ((i+outofbounds) * tileSize*0.75) + "px";
            } else {
                div.style.top  = tilesCenterHeight + (-tileSize*0.5) + ((j+outofbounds) * tileSize)   + "px";
                div.style.left = tilesCenterWidth + ((i+outofbounds) * tileSize*0.75) + "px";
            }

            div.style.backgroundSize = tileSize + "px";
            div.style.height = tileSize + "px";
            div.style.width = tileSize + "px";

            // Adds the div, x position and y position to the tiles list.
            tiles.push( new Tile(div, i,j) );

            // Appends the newly created div(tile) to the webpage.
            map.append(div);

        }
    }



    /*// Checks how big the tiles should be to fit the game container.
    // Depending whether game mapHeightCount or with is lower.
    const tileSizeFromWidth = (mapWidthPixels/(mapWidthCount*2));
    const tileSizeFromHeight = (mapHeightPixels/(mapHeightCount + 1)); // Adds 2 to create extra space

    let tileSize;



    // Center the map in the game container
    const tilesCenterWidth =  (mapWidthPixels  - (tileSize * 1.5) * mapWidthCount  + (tileSize  ))/2;
    const tilesCenterHeight = (mapHeightPixels - (tileSize      ) * mapHeightCount + (tileSize*2))/2;

    // Add the first set of tiles (First column and every second after that).
    for (var i = -1; i < mapWidthCount-1; i++) {
        for (var j = -2; j < mapHeightCount-2; j++) {

            // Creates a new div element.
            let div = document.createElement('div');

            // Adds the title class and styles to the element.
            if (j<0 || j>=height || i<0 || i>test-1) {
                div.classList.add('outofboundstile');
            } else {
                div.classList.add('tile');
            }
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
    for (var i = -1; i < mapWidthCount-1; i++) {

        for (var j = -2; j < mapHeightCount-2; j++) {

            // Creates a new div element.
            let div = document.createElement('div');

            // Adds the title class and styles to the element.
            if (j<0 || j>=height || i<0 || i>test-1) {
                div.classList.add('outofboundstile');
            } else {
                div.classList.add('tile');
            }
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
    }*/
}