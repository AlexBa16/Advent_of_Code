import {char2DArr} from "../../utils/helpers.ts";

let splits: number = 0;

function day07_part1(lines: string[]): number {
    let map = char2DArr(lines);
    splitSearch(map, map[0]!.indexOf("S"), 1);
    return splits;
}

function splitSearch(map: string[][], x: number, y: number): void {
    if (y >= map.length) return;
    if (map[y]![x] === '^') {
        splitSearch(map, x - 1, y + 1);
        splitSearch(map, x + 1, y + 1);
        splits++;
    } else if (map[y]![x] === '.') {
        map[y]![x] = '|';
        splitSearch(map, x, y + 1);
    }
}

function day07_part2(lines: string[]): number {
    let map = char2DArr(lines);
    let cache: Map<string, number> = new Map();
    return timelineSearch(map, map[0]!.indexOf("S"), 1, cache)!;
}

function timelineSearch(map: string[][], x: number, y: number, cache: Map<string, number>): number | undefined {
    let key = x + ',' + y;
    if (cache.has(key)) return cache.get(key);
    if (y >= map.length && x >= 0 && x < map.length) return 1;
    let result = 0;
    if (map[y]![x] === '^') {
        result = timelineSearch(map, x - 1, y + 1, cache)! + timelineSearch(map, x + 1, y + 1, cache)!;
    } else if (map[y]![x] === '.') {
        result = timelineSearch(map, x, y + 1, cache)!;
    }
    cache.set(key, result);
    return result;
}

export {day07_part1, day07_part2};