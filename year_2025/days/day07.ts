import {char2DArr} from "../../utils/helpers.ts";

let part1Counter: number = 0;

function day07_part1(lines: string[]): number {
    let map = char2DArr(lines);
    part1RecursiveSearch(map, map[0]!.indexOf("S"), 1);
    return part1Counter;
}

function part1RecursiveSearch(map: string[][], x: number, y: number): void {
    if (y >= map.length) return;
    if (map[y]![x] === '^') {
        part1RecursiveSearch(map, x - 1, y + 1);
        part1RecursiveSearch(map, x + 1, y + 1);
        part1Counter++;
    } else if (map[y]![x] === '.') {
        map[y]![x] = '|';
        part1RecursiveSearch(map, x, y + 1);
    }
}

let part2Counter: number = 0;

function day07_part2(lines: string[]): number {
    let map = char2DArr(lines);
    part2RecursiveSearch(map, map[0]!.indexOf("S"), 1);
    return part2Counter;
}

function part2RecursiveSearch(map: string[][], x: number, y: number): void {
    if (y >= map.length) {
        part2Counter++;
        return;
    }
    if (map[y]![x] === '^') {
        part2RecursiveSearch(map, x - 1, y + 1);
        part2RecursiveSearch(map, x + 1, y + 1);
        // part2Counter++;
    } else if (map[y]![x] === '.') {
        // map[y]![x] = '|';
        part2RecursiveSearch(map, x, y + 1);
    }
}

export {day07_part1, day07_part2};