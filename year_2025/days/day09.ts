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
            let area = (pointB.x - pointA.x + 1) * (pointB.y - pointA.y + 1);
            if (biggestArea < area) biggestArea = area;
        }
    }
    return biggestArea;
}


function day09_part2(lines: string[]): number {
    let maxWidth = 0;
    let maxHeight = 0;
    for (const line of lines) {
        let numbers: number[] = line.split(',').map(n => Number(n));
        if (numbers[0]! > maxWidth) maxWidth = numbers[0]!;
        if (numbers[1]! > maxHeight) maxHeight = numbers[1]!;
    }
    let map: string[][] = Array.from({length: maxHeight + 3}, () => new Array(maxWidth + 3).fill('.'));


    let redTiles: { x: number, y: number }[] = [];
    let greenTiles: { x: number, y: number }[] = [];

    for (const line of lines) {
        let [x, y]: number[] = line.split(',').map(Number);
        map[y!]![x!] = '#';
        redTiles.push({x: x!, y: y!});
    }


    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        let pointB = redTiles[i + 1]!;
        if (i + 1 === redTiles.length) pointB = redTiles[0]!;

        // Vertical line
        if (pointA.x === pointB.x) {
            let startY = Math.min(pointA.y, pointB.y);
            let endY = Math.max(pointA.y, pointB.y);

            for (let y = startY; y <= endY; y++) {
                if (map[y]![pointA.x] === '.') {
                    greenTiles.push({x: pointA.x, y: y});
                    map[y]![pointA.x] = 'X';
                }
            }
        }
        // Horizontal line
        else if (pointA.y === pointB.y) {
            let startX = Math.min(pointA.x, pointB.x);
            let endX = Math.max(pointA.x, pointB.x);

            for (let x = startX; x <= endX; x++) {
                if (map[pointA.y]![x] === '.') {
                    greenTiles.push({x: x, y: pointA.y});
                    map[pointA.y]![x] = 'X';
                }
            }
        }
    }

    // for (let y = 0; y < map.length; y++) {
    //     let inside = false;
    //     for (let x = 0; x < map[y]!.length; x++) {
    //         if (map[y]![x] === '#' || map[y]![x] === 'X') {
    //             inside = !inside;
    //         } else if (inside) {
    //             map[y]![x] = 'X';
    //             greenTiles.push({x, y});
    //         }
    //     }
    // }

    // for (let y = 0; y < map.length; y++) {
    //     let row = map[y]!;
    //     // for (let x = 0; x < row.length; x++) {
    //     let stringRow = row.join('');
    //     let firstWallIndex = Math.min(
    //         ...['X', '#'].map(char => {
    //             let idX = stringRow.indexOf(char);
    //             return idX === -1 ? Infinity : idX;
    //         })
    //     );
    //     let lastWallIndex = Math.max(
    //         ...['X', '#'].map(char => stringRow.lastIndexOf(char))
    //     );
    //
    //     if (firstWallIndex === Infinity) firstWallIndex = -1;
    //
    //     console.log(firstWallIndex, lastWallIndex);
    // }


    console.log(displayAsMap(map));

    let biggestArea: number = 0;
    for (let i = 0; i < redTiles.length; i++) {
        let pointA = redTiles[i]!;
        for (let j = 0; j < redTiles.length; j++) {
            let pointB = redTiles[j]!;
            if (i === j) continue;
            let x = pointB.x - pointA.x + 1;
            let y = pointB.y - pointA.y + 1;

            let area = x * y;
            if (biggestArea < area) biggestArea = area;
        }
    }
    return biggestArea;
}

export {day09_part1, day09_part2};