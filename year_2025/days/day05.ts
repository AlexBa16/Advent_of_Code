function day05_part1(lines: string[]): number {
    let output: number = 0;
    let range: { from: number, to: number }[] = [];
    for (const line of lines) {
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
    for (const line of lines) {
        const parts = line.split('-');
        if (parts.length === 2) {
            const from = Number(parts[0]);
            const to = Number(parts[1]);
            range.push({from, to});
        }
    }
    let somethingGotRemoved = false;
    while (!somethingGotRemoved) {
        for (let i = 0; i < range.length; i++) {
            let duplicateCounter = 0;

            const from = range[i]!.from;
            const to = range[i]!.to;

            for (let j = 0; j < range.length; j++) {
                let compare = range[j]!;
                if (compare.from === from && compare.to === to || from === to) {
                    duplicateCounter++;
                    if (duplicateCounter > 1) {
                        range[i]!.from = 0;
                        range[i]!.to = 0;
                    }
                    continue;
                }
                if (compare.from <= from && compare.to >= to) {
                    range[i]!.from = 0;
                    range[i]!.to = 0;
                    somethingGotRemoved = true;
                    continue;
                }
                if (from > compare.from && from < compare.to) {
                    if (to > compare.to) {
                        range[j]!.to = to;
                        range[i]!.from = 0;
                        range[i]!.to = 0;
                        somethingGotRemoved = true;
                    }
                }
            }
        }
    }

    for (let rangeElement of range) {
        if (rangeElement.from !== 0 && rangeElement.to !== 0) output += rangeElement.to - rangeElement.from + 1;
    }
    return output;
}

// function day05_part2_optimizedByAI(lines: string[]): number {
//     const ranges: { from: number, to: number }[] = [];
//
//     // Read only the range lines (stop at the empty line)
//     for (const line of lines) {
//         if (!line.includes("-")) break;
//         const parts = line.split('-');
//         const from = Number(parts[0]);
//         const to = Number(parts[1]);
//         ranges.push({from, to});
//     }
//
//     // Sort ranges by starting value
//     ranges.sort((a, b) => a.from - b.from);
//
//     // Merge overlapping or touching ranges
//     const merged: { from: number, to: number }[] = [];
//     let current = ranges[0]!;
//
//     for (let i = 1; i < ranges.length; i++) {
//         const next = ranges[i]!;
//
//         // If the next range overlaps or directly touches the current one, merge them
//         if (next.from <= current.to + 1) {
//             current.to = Math.max(current.to, next.to);
//         } else {
//             // Otherwise finalize the current range and start a new one
//             merged.push(current);
//             current = next;
//         }
//     }
//     merged.push(current);
//
//     // Sum the total number of IDs covered by all merged ranges
//     return merged.reduce((sum, r) => sum + (r.to - r.from + 1), 0);
// }


export {day05_part1, day05_part2};