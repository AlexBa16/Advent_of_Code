// @ts-ignore
import {readFileSync} from 'fs';

export function readFileAsArray(year: number, day: number): string[] {
    return linesToArray(readFileSync('./../year_' + year + '/input/input_day' + (day < 10 ? "0" : "") + day + '.txt', 'utf-8'));
}

export function readFileAsString(year: number, day: number): string {
    return readFileSync('./../year_' + year + '/input/input_day' + (day < 10 ? "0" : "") + day + '.txt', 'utf-8');
}

export function linesToArray(input: string): string[] {
    return input.split(/\r?\n/).map(l => l.trim()).filter(l => l.length > 0);
}

export function char2DArr(lines: string[]): string[][] {
    let map: string[][] = [];
    for (let i = 0; i < lines.length; i++) {
        const line = lines[i]!;
        let lineArr: string[] = [];
        for (let j = 0; j < line.length; j++) {
            lineArr[j] = line[j]!;
        }
        map[i] = lineArr;
    }
    return map;
}