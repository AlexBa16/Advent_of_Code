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
    let output: number = 0;
    let connections: Map<string, string[]> = new Map();
    let connectedToOut: string[] = [];
    for (const line of lines) {
        let parts = line.split(" ");
        let start = parts.shift()!.replaceAll(":", "");
        if (parts[0] === "out" && parts.length === 1) connectedToOut.push(start);
        connections.set(start, parts);
    }
    connections.get("svr")?.forEach((line) => {
        recursiveConnection(line, false, false, "");
    });

    function recursiveConnection(search: string, visitedDAC: boolean, visitedFFT: boolean, list: string) {
        if (connectedToOut.includes(search)) {
            if (visitedDAC && visitedFFT) output++;
            console.log(list);
            return;
        }
        let nextConnections: string[] = connections.get(search)!;
        let temp = "";
        if (search === "dac") {
            visitedDAC = true;
            temp += "DAC,";
        }
        if (search === "fft") {
            visitedFFT = true;
            temp += "FFT,";
        }
        if (temp === "") list += search + ",";
        else list += temp;
        nextConnections?.forEach((connection) => {
            recursiveConnection(connection, visitedDAC, visitedFFT, list);
        });
        return;
    }

    return output;
}

export {day11_part1, day11_part2};