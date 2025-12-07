import {char2DArr} from "../../utils/helpers.ts";

let part1Counter: number = 0;

function day07_part1(lines: string[]): number {
    let map = char2DArr(lines);
    search(map, map[0]!.indexOf("S"), 1)!;
    return part1Counter;
}

function search(map: string[][], x: number, y: number): void {
    if (y >= map.length) return;
    if (map[y]![x] === '^') {
        search(map, x - 1, y + 1);
        search(map, x + 1, y + 1);
        part1Counter++;
    } else if (map[y]![x] === '.') {
        map[y]![x] = '|';
        search(map, x, y + 1);
    }
}

function day07_part2(lines: string[]): number {
    let output: number = 0;

    return output;
}

export {day07_part1, day07_part2};