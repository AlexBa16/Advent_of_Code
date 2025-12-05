import {readFileAsArray, readFileAsString} from "../utils/files.ts";
import {day01_part1, day01_part2} from "./days/day01.ts";

const startTime = performance.now();

console.log("===== Day01 =====");
console.log('Part1:', day01_part1(readFileAsArray(2023, 1)));
console.log('Part2:', day01_part2(readFileAsArray(2023, 1)));

console.log("\n==== Runtime ====");
console.log(Number((performance.now() - startTime).toFixed(5)), "ms");