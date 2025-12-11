function day11_part1(lines: string[]): number {
    let output: number = 0;
    let connections: Map<string, string[]> = new Map();
    let connectedToOut: string[] = [];
    for (const line of lines) {
        let parts = line.split(" ");
        let start = parts.shift()!.replaceAll(":", "");
        if (parts[0] === "out" && parts.length === 1) connectedToOut.push(start);
        connections.set(start, parts);
    }
    connections.get("you")?.forEach((line) => recursiveConnection(line));

    function recursiveConnection(search: string) {
        if (connectedToOut.includes(search)) {
            output++;
            return;
        }
        let nextConnections: string[] = connections.get(search)!;
        nextConnections?.forEach((connection) => recursiveConnection(connection));
        return;
    }

    return output;
}

function day11_part2(lines: string[]): number {
    let connections: Map<string, string[]> = new Map();
    let connectedToOut: string[] = [];
    let cache = new Map<string, number>();

    for (const line of lines) {
        let parts = line.split(" ");
        let start = parts.shift()!.replaceAll(":", "");
        if (parts[0] === "out" && parts.length === 1) connectedToOut.push(start);
        connections.set(start, parts);
    }
    let output = 0;
    connections.get("svr")?.forEach((line) => output += recursiveConnection(line, false, false));
    return output;

    function recursiveConnection(search: string, visitedDAC: boolean, visitedFFT: boolean): number {
        const cacheKey = search + '-' + visitedDAC + '-' + visitedFFT;
        if (cache.has(cacheKey)) return cache.get(cacheKey)!;

        if (connectedToOut.includes(search)) {
            if (visitedDAC && visitedFFT) {
                cache.set(cacheKey, 1);
                return 1;
            }
            cache.set(cacheKey, 0);
            return 0;
        }

        let nextConnections: string[] = connections.get(search)!;
        if (search === "dac") visitedDAC = true;
        if (search === "fft") visitedFFT = true;

        let result = 0;
        nextConnections?.forEach((connection) => {
            result += recursiveConnection(connection, visitedDAC, visitedFFT);
        });
        cache.set(cacheKey, result);
        return result;
    }
}

export {day11_part1, day11_part2};