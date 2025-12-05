function day05_part1(lines: string[]): number {
    let output: number = 0;
    let fresh: number[] = [];
    for (const line of lines) {
        console.log(line)
        if (line.split('-')[1] !== undefined) {
            let from = Number(line.split('-')[0]);
            let to = Number(line.split('-')[1]);
            for (let i = from; i <= to; i++) {
                fresh.push(i);
            }
        } else {
            console.log(fresh)
            if (fresh.includes(Number(line))) output++;
        }
    }
    return output;
}

function day05_part2(lines: string[]): number {
    let output: number = 0;

    return output;
}

export {day05_part1, day05_part2};