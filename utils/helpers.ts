export function char2DArr(lines: string[]): string[][] {
    let map: string[][] = [];
    for (let y = 0; y < lines.length; y++) {
        const line = lines[y]!;
        let lineArr: string[] = [];
        for (let x = 0; x < line.length; x++) lineArr[x] = line[x]!;
        map[y] = lineArr;
    }
    return map;
}

export function displayAsMap(map: string[][]): string {
    let output: string = "";
    for (const mapElement of map) {
        for (const string of mapElement) output += string;
        output += "\n";
    }
    return output;
}