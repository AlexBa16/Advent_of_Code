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