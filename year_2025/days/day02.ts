function day02_part1(lines: string): number {
    let output: number = 0;
    let linesArray = lines.split(',');
    for (const line of linesArray) {
        let from: number = Number(line.split('-')[0]);
        let to: number = Number(line.split('-')[1]);
        for (let number = from; number <= to; number++) {
            if (repeatTwoTimes(number.toString())) output += number;
        }
    }
    return output;
}

function repeatTwoTimes(str: string): boolean {
    if (str.length % 2 !== 0) return false;
    const half = str.length / 2;
    const first = str.slice(0, half);
    const second = str.slice(half);
    return first === second;
}

function day02_part2(lines: string): number {
    let output: number = 0;
    let linesArray = lines.split(',');
    for (const line of linesArray) {
        let from: number = Number(line.split('-')[0]);
        let to: number = Number(line.split('-')[1]);
        for (let number = from; number <= to; number++) {
            const pattern = /^(\d+)\1+$/;
            let str = number.toString();
            if (str.match(pattern)) output += number;
        }
    }
    return output;
}

export {day02_part1, day02_part2};