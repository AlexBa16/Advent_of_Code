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

    return output;
}

export {day06_part1, day06_part2};