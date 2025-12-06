function day06_part1(lines: string[]): number {
    let output: number = 0;
    let input: string[][] = [];
    for (const line of lines) input.push(line.split(/ +/));
    let problems: string[][] = [];

    for (let y = 0; y < input.length; y++) {
        for (let x = 0; x < input[0]!.length; x++) {
            if (!problems[x]) problems[x] = [];
            problems[x]![y] = input[y]![x]!;
        }
    }

    for (const problem of problems) {
        let opp: string = problem[problem.length - 1]!;
        let mathOutput: number = 0;
        if (opp === '+') for (let i = 0; i < problem.length - 1; i++) mathOutput += Number(problem[i]);
        if (opp === '*') {
            mathOutput = 1;
            for (let i = 0; i < problem.length - 1; i++) mathOutput *= Number(problem[i]);
        }
        output += mathOutput;
    }
    return output;
}

function day06_part2(lines: string[]): number {
    let output: number = 0;
    const width = Math.max(...lines.map(l => l.length));
    const grid = lines.map(l => l.padEnd(width, " "));

    let input: string[][] = [];
    for (let x = 0; x < width; x++) {
        input[x] = [];
        for (let y = 0; y < grid.length; y++) input[x]![y] = grid[y]![x]!;
    }
    let opp = "";
    let partialOutputAdd: number = 0;
    let partialOutputMulti: number = -1;
    for (let y = 0; y < input.length; y++) {
        const lastChar = input[y]?.[input[y]!.length - 1];
        if (lastChar === '*' || lastChar === '+') {
            opp = lastChar;
            if (partialOutputMulti === -1) output += partialOutputAdd;
            else output += partialOutputMulti * -1;
            partialOutputAdd = 0;
            partialOutputMulti = -1;
        }
        let numberString = "";
        for (const num of input[y]!) {
            if (/\d/.test(num)) numberString += num;
        }
        if (opp === '+') partialOutputAdd += Number(numberString);
        else if (opp === '*' && Number(numberString) != 0) partialOutputMulti *= Number(numberString);
    }
    if (partialOutputMulti === -1) output += partialOutputAdd;
    else output += partialOutputMulti * -1;

    return output;
}

export {day06_part1, day06_part2};