import {displayAsMap} from "../../utils/helpers.ts";

function day09_part1(lines: string[]): number {
    // let maxWidth = 0;
    // let maxHeight = 0;
    // for (const line of lines) {
        // let numbers: number[] = line.split(',').map(n => Number(n));
        // if (numbers[0]! > maxWidth) maxWidth = numbers[0]!;
        // if (numbers[1]! > maxHeight) maxHeight = numbers[1]!;
    // }
    // let map: string[][] = Array.from({length: maxHeight + 1}, () => new Array(maxWidth + 1).fill('.'));
    let redTiles: { x: number, y: number }[] = [];

    for (const line of lines) {
        let [x, y]: number[] = line.split(',').map(Number);
        // map[y!]![x!] = '#';
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
    let output: number = 0;

    return output;
}

export {day09_part1, day09_part2};