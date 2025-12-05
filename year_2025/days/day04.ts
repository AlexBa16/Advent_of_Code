import {char2DArr} from "../../utils/helpers.ts";

function day04_part1(lines: string[]): number {
    let output: number = 0;
    let map: string[][] = char2DArr(lines);
    for (let y = 0; y < map.length; y++) {
        let line: string[] = map[y]!;
        for (let x = 0; x < line.length; x++) {
            let counter: number = 0;
            if (line[x] === '@') {
                let topLine = map[y - 1];
                let bottomLine = map[y + 1];

                if (topLine !== undefined) {
                    if (topLine[x - 1] === '@') counter++;
                    if (topLine[x + 1] === '@') counter++;
                    if (topLine[x] === '@') counter++;
                }
                if (bottomLine !== undefined) {
                    if (bottomLine[x - 1] === '@') counter++;
                    if (bottomLine[x + 1] === '@') counter++;
                    if (bottomLine[x] === '@') counter++;
                }
                let left = line[x - 1];
                let right = line[x + 1];
                if (left === '@') counter++;
                if (right === '@') counter++;

                if (counter < 4) output++;
            }
        }
    }
    return output;
}

function day04_part2(lines: string[]): number {
    let output: number = 0;
    let map: string[][] = char2DArr(lines);

    while (true) {
        let nothingRemoved: boolean = true;
        for (let y = 0; y < map.length; y++) {
            let line: string[] = map[y]!;
            for (let x = 0; x < line.length; x++) {
                let counter: number = 0;
                if (line[x] === '@') {
                    let topLine = map[y - 1];
                    let bottomLine = map[y + 1];

                    if (topLine !== undefined) {
                        let leftTop = topLine[x - 1];
                        let rightTop = topLine[x + 1];
                        let middleTop = topLine[x];
                        if (leftTop === '@' || leftTop === 'x') counter++;
                        if (rightTop === '@' || rightTop === 'x') counter++;
                        if (middleTop === '@' || middleTop === 'x') counter++;
                    }
                    if (bottomLine !== undefined) {
                        let leftBottom = bottomLine[x - 1];
                        let rightBottom = bottomLine[x + 1];
                        let middleBottom = bottomLine[x];
                        if (leftBottom === '@' || leftBottom === 'x') counter++;
                        if (rightBottom === '@' || rightBottom === 'x') counter++;
                        if (middleBottom === '@' || middleBottom === 'x') counter++;
                    }
                    let left = line[x - 1];
                    let right = line[x + 1];
                    if (left === '@' || left === 'x') counter++;
                    if (right === '@' || right === 'x') counter++;

                    if (counter < 4) {
                        output++;
                        map[y]![x] = 'x';
                        nothingRemoved = false;
                    }
                }
            }
        }
        for (let y = 0; y < map.length; y++) for (let x = 0; x < map[y]!.length; x++) if (map[y]![x] === 'x') map[y]![x] = '.';
        if (nothingRemoved) break;
    }
    return output;
}

export {day04_part1, day04_part2};