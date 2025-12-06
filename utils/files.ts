// @ts-ignore
import {readFileSync} from "fs";

export function readFileAsArray(year: number, day: number): string[] {
    return linesToArray(readFileSync('./../year_' + year + '/input/input_day' + (day < 10 ? "0" : "") + day + '.txt', 'utf-8'));
}

export function readFileAsString(year: number, day: number): string {
    return readFileSync('./../year_' + year + '/input/input_day' + (day < 10 ? "0" : "") + day + '.txt', 'utf-8');
}

export function linesToArray(input: string): string[] {
    return input.split(/\r?\n/).map(l => l).filter(l => l.length > 0);
}
