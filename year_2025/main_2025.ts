import {readFileAsArray, readFileAsString} from "../utils/files.ts";
import {day01_part1, day01_part2} from "./days/day01.ts";
import {day02_part1, day02_part2} from "./days/day02.ts";
import {day03_part1, day03_part2} from "./days/day03.ts";
import {day04_part1, day04_part2} from "./days/day04.ts";
import {day05_part1, day05_part2} from "./days/day05.ts";
import {day06_part1, day06_part2} from "./days/day06.ts";

const startTime = performance.now();

// console.log("===== Day01 =====");
// console.log('Part1:', day01_part1(readFileAsArray(2025, 1)));
// console.log('Part2:', day01_part2(readFileAsArray(2025, 1)));
//
// console.log("===== Day02 =====");
// console.log('Part1:', day02_part1(readFileAsString(2025, 2)));
// console.log('Part2:', day02_part2(readFileAsString(2025, 2)));
//
// console.log("===== Day03 =====");
// console.log('Part1:', day03_part1(readFileAsArray(2025, 3)));
// console.log('Part2:', day03_part2(readFileAsArray(2025, 3)));
//
// console.log("===== Day04 =====");
// console.log('Part1:', day04_part1(readFileAsArray(2025, 4)));
// console.log('Part2:', day04_part2(readFileAsArray(2025, 4)));
//
// console.log("===== Day05 =====");
// console.log('Part1:', day05_part1(readFileAsArray(2025, 5)));
// console.log('Part2:', day05_part2(readFileAsArray(2025, 5)));
//
console.log("===== Day06 =====");
console.log('Part1:', day06_part1(readFileAsArray(2025, 6)));
console.log('Part2:', day06_part2(readFileAsArray(2025, 6)));

console.log("\n==== Runtime ====");
console.log(Number((performance.now() - startTime).toFixed(5)), "ms");