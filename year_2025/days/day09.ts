import {displayAsMap} from "../../utils/helpers.ts";

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
    let width = 0;
    let height = 0;
    for (const line of lines) {
        let numbers: number[] = line.split(',').map(n => Number(n));
        if (numbers[0]! > width) width = numbers[0]!;
        if (numbers[1]! > height) height = numbers[1]!;
    }

    const isTileValid = (x: number, y: number) =>
        redTiles.some(p => p.x === x && p.y === y) ||
        greenTiles.some(p => p.x === x && p.y === y);

    let redTiles: { x: number, y: number }[] = [];
    let greenTiles: { x: number, y: number }[] = [];

    for (const line of lines) {
        let [x, y]: number[] = line.split(',').map(Number);
        redTiles.push({x: x!, y: y!});
    }
    height++;
    width++;

    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        let pointB = redTiles[i + 1]!;
        if (i + 1 === redTiles.length) pointB = redTiles[0]!;

        // Vertical line
        if (pointA.x === pointB.x) {
            let startY = Math.min(pointA.y, pointB.y);
            let endY = Math.max(pointA.y, pointB.y);

            for (let y = startY; y <= endY; y++) {
                if (!isTileValid(pointA.x, y)) greenTiles.push({x: pointA.x, y: y});
            }
        }
        // Horizontal line
        else if (pointA.y === pointB.y) {
            let startX = Math.min(pointA.x, pointB.x);
            let endX = Math.max(pointA.x, pointB.x);

            for (let x = startX; x <= endX; x++) {
                if (!isTileValid(x, pointA.y)) greenTiles.push({x: x, y: pointA.y});
            }
        }
    }

    for (let y = 0; y < height; y++) {
        for (let x = 0; x < width; x++) {
            if (!isTileValid(x, y) && checkIfInsideOfWall(x, y)) greenTiles.push({x, y});
        }
    }

    function checkIfInsideOfWall(x: number, y: number) {
        let leftWall = false, rightWall = false, topWall = false, bottomWall = false;
        // Check left wall
        for (let lx = x - 1; lx >= 0; lx--) {
            if (isTileValid(lx, y)) {
                leftWall = true;
                break;
            }
        }
        // Check right wall
        for (let rx = x + 1; rx < width; rx++) {
            if (isTileValid(rx, y)) {
                rightWall = true;
                break;
            }
        }
        // Check top wall
        for (let ty = y - 1; ty >= 0; ty--) {
            if (isTileValid(x, ty)) {
                topWall = true;
                break;
            }
        }
        // Check bottom wall
        for (let by = y + 1; by < height; by++) {
            if (isTileValid(x, by)) {
                bottomWall = true;
                break;
            }
        }
        return leftWall && rightWall && topWall && bottomWall;
    }

    let biggestArea: number = 0;
    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        for (let j = 0; j < redTiles.length; j++) {
            let pointB = redTiles[j]!;
            if (i === j) continue;
            let valid = true;
            for (let y = Math.min(pointA.y, pointB.y); y <= Math.max(pointA.y, pointB.y); y++) {
                for (let x = Math.min(pointA.x, pointB.x); x <= Math.max(pointA.x, pointB.x); x++) {
                    if (!(redTiles.some(p => p.x === x && p.y === y) ||
                        greenTiles.some(p => p.x === x && p.y === y))) {
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