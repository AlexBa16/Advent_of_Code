function day09_part1(lines: string[]): number {
    let redTiles: { x: number, y: number }[] = [];
    for (const line of lines) {
        let [x, y]: number[] = line.split(',').map(Number);
        redTiles.push({x: x!, y: y!});
    }
    let biggestArea: number = 0;
    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        for (let j = 0; j < redTiles.length; j++) {
            let pointB = redTiles[j]!;
            if (i === j) continue;
            biggestArea = Math.max(biggestArea, (pointB.x - pointA.x + 1) * (pointB.y - pointA.y + 1));
        }
    }
    return biggestArea;
}

function day09_part2(lines: string[]): number {
    console.log("---- creating Red Tiles ----");
    let redTiles: { x: number, y: number }[] = [];

    for (const line of lines) {
        let [x, y]: number[] = line.split(',').map(Number);
        redTiles.push({x: x!, y: y!});
    }

    let width = Math.max(...redTiles.map(p => p.x)) + 1;
    let height = Math.max(...redTiles.map(p => p.y)) + 1;
    let validTiles = new Set<string>();
    for (const tile of redTiles) validTiles.add(tile.x + ',' + tile.y);

    console.log("---- creating Walls ----");

    // Add green wall tiles
    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        let pointB = redTiles[i + 1]!;
        if (i + 1 === redTiles.length) pointB = redTiles[0]!;

        // Vertical line
        if (pointA.x === pointB.x) {
            const [y1, y2] = [Math.min(pointA.y, pointB.y), Math.max(pointA.y, pointB.y)];
            for (let y = y1; y <= y2; y++) validTiles.add(pointA.x + ',' + y);
        }
        // Horizontal line
        else {
            const [x1, x2] = [Math.min(pointA.x, pointB.x), Math.max(pointA.x, pointB.x)];
            for (let x = x1; x <= x2; x++) validTiles.add(x + ',' + pointA.y);
        }
    }

    console.log("---- Fill Map ----");

    const visited = new Set<string>();
    const temp: [number, number][] = [];

    for (let x = 0; x < width; x++) temp.push([x, 0], [x, height - 1]);
    for (let y = 0; y < height; y++) temp.push([0, y], [width - 1, y]);
    while (temp.length > 0) {
        // console.log(temp.length);
        const [x, y] = temp.shift()!;
        if (x < 0 || x >= width || y < 0 || y >= height) continue;
        const key = x + ',' + y;
        if (visited.has(key)) continue;
        if (validTiles.has(key)) continue;
        visited.add(key);
        temp.push([x + 1, y], [x - 1, y], [x, y + 1], [x, y - 1]);
    }


    for (let y = 0; y < height; y++) {
        for (let x = 0; x < width; x++) {
            const key = x + ',' + y;
            if (!visited.has(key)) validTiles.add(key);
        }
    }

    console.log("---- calculate Areas ----");

    let biggestArea: number = 0;
    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        for (let j = 0; j < redTiles.length; j++) {
            let pointB = redTiles[j]!;
            if (i === j) continue;
            let valid = true;
            for (let y = Math.min(pointA.y, pointB.y); y <= Math.max(pointA.y, pointB.y); y++) {
                for (let x = Math.min(pointA.x, pointB.x); x <= Math.max(pointA.x, pointB.x); x++) {
                    if (!validTiles.has(x + ',' + y)) {
                        valid = false;
                        break;
                    }
                }
                if (!valid) break;
            }
            if (valid) biggestArea = Math.max(biggestArea, (pointB.x - pointA.x + 1) * (pointB.y - pointA.y + 1));
        }
    }
    return biggestArea;
}

export {day09_part1, day09_part2};