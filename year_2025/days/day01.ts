function day01_part1(lines: string[]): number {
    let pos: number = 50;
    let zeros: number = 0;

    for (let line of lines) {
        let dir: string | undefined = line[0];
        const value: number = Number(line.slice(1));
        if (dir === 'R') pos = (pos + value) % 100;
        else if (dir === 'L') pos = (pos - value) % 100;
        if (pos === 0) zeros++;
    }
    return zeros;
}

function day01_part2(lines: string[]): number {
    let pos: number = 50;
    let zeros: number = 0;

    for (let line of lines) {
        let dir: string | undefined = line[0];
        const value: number = Number(line.slice(1));

        // calculate distance to the first zero the dial will encounter
        let firstZero: number = 0;

        // distance to 0 when moving
        if (dir === 'R') firstZero = (100 - pos) % 100;
        else if (dir === 'L') firstZero = pos % 100;

        if (firstZero === 0) firstZero = 100; // special case: already at zero

        // count how many times 0 is passed during this rotation
        // 1 for the first time plus one for each full 100-step loop
        if (value >= firstZero) zeros += 1 + Math.floor((value - firstZero) / 100);

        if (dir === 'L') {
            pos = (pos - value) % 100;
            pos = (pos + 100) % 100; // fix for negative values
        } else {
            pos = (pos + value) % 100;
            pos = (pos + 100) % 100; // fix for negative values
        }
    }
    return zeros;
}

export {day01_part1, day01_part2};