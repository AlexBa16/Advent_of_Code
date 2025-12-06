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
        let subNumbers = generateSubNumbers(problem);
        if (opp === '+') {
            for (const subNumber of subNumbers) mathOutput += subNumber;
        }
        if (opp === '*') {
            mathOutput = 1;
            for (const subNumber of subNumbers) mathOutput *= subNumber;
        }
        console.log(subNumbers, mathOutput);
        output += mathOutput;
    }
    return output;
}

function generateSubNumbers(problem: string[]): number[] {
    let numbers: number[][] = [];
    let longestNumber = 0;

    for (let i = 0; i < problem.length - 1; i++) {
        let subNumbers: number[] = [];
        for (let j = 0; j < problem[i]!.length; j++) {
            subNumbers.push(Number(problem[i]![j]));
        }
        numbers.push(subNumbers);
        if (subNumbers.length > longestNumber) longestNumber = subNumbers.length;
        // mathOutput *= Number(problem[i]);
    }
    for (let i = 0; i < numbers.length; i++) numbers[i] = numbers[i]!.reverse();
    let subNumbers: number[] = [];
    for (let x = 0; x < longestNumber; x++) {
        let numberString: string = "";
        for (let y = 0; y < numbers.length; y++) {
            if (numbers[y]![x]) numberString += numbers[y]![x];
        }
        subNumbers.push(Number(numberString));
    }
    return subNumbers;
}

export {day06_part1, day06_part2};