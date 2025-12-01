// noinspection ES6UnusedImports
import {readFileAsArray} from "../helpers.ts";
import {day01_part1, day01_part2} from "./days/day01.ts";
import {day02_part1, day02_part2} from "./days/day02.ts";

console.log("===== Day01 =====");
console.log('Part1:', day01_part1(readFileAsArray(2025, 1)));
console.log('Part2:', day01_part2(readFileAsArray(2025, 1)));

console.log("===== Day02 =====");
console.log('Part1:', day02_part1(readFileAsArray(2025, 2)));
console.log('Part2:', day02_part2(readFileAsArray(2025, 2)));
