function day05_part1(lines: string[]): number {
    let output: number = 0;
    let range: { from: number, to: number }[] = [];
    for (const line of lines) {
        console.log(line)
        const parts = line.split('-');
        if (parts.length === 2) {
            const from = Number(parts[0]);
            const to = Number(parts[1]);
            range.push({from, to});
        } else {
            let value = Number(line);
            for (let rangeElement of range) {
                if (value >= rangeElement.from && value <= rangeElement.to) {
                    output++;
                    break;
                }
            }
        }
    }
    return output;
}

function day05_part2(lines: string[]): number {
    let output: number = 0;
    let range: { from: number, to: number }[] = [];
    // let smallestNumber = 0;
    // let biggestNumber = 0;
    for (const line of lines) {
        const parts = line.split('-');
        if (parts.length === 2) {
            const from = Number(parts[0]);
            const to = Number(parts[1]);
            // if (to > biggestNumber) biggestNumber = to;
            range.push({from, to});
        }
    }
    let stop = false;
    while (!stop) {
        for (let i = 0; i < range.length; i++) {

            const from = range[i]!.from;
            const to = range[i]!.to;

            for (let j = 0; j < range.length; j++) {
                let compare = range[j]!;
                // console.log(from, to, ":", compare);
                if (compare.from === from && compare.to === to) continue;
                if (from > compare.from && from < compare.to) {
                    if (to > compare.to) {
                        // console.log("change:", range[j], " to:", to);
                        range[j]!.to = to;
                        range[i]!.from = 0;
                        range[i]!.to = 0;
                        stop = true;
                    }
                }
            }
        }
    }

    for (let rangeElement of range) {
        // for (let i = rangeElement.from; i <= rangeElement.to; i++) {
            // console.log(i);
        // }
        if (rangeElement.from !== 0 && rangeElement.to !== 0) {
            output += rangeElement.to - rangeElement.from + 1;
        }
    }
    return output;
}

export {day05_part1, day05_part2};