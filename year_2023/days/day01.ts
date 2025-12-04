function day01_part1(lines: string[]): number {
    let output: number = 0;
    for (const line of lines) {
        let regex = /[a-z]/g;
        let string: string = line.replaceAll(regex, '');
        output += Number(string.charAt(0) + string.charAt(string.length - 1));
    }
    return output;
}

function day01_part2(lines: string[]): number {
    let output: number = 0;
    let numbers = ["one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    for (const line of lines) {
        let string: string = line;
        console.log(line);
        // First words need to be removed first
        for (let i = 0; i < numbers.length; i++) {
            string = string.replaceAll(numbers[i]!, String(i + 1));
        }
        console.log(string);

        let regex = /[a-z]/g;
        string = line.replaceAll(regex, '');
        output += Number(string.charAt(0) + string.charAt(string.length - 1));
    }
    return output;
}

export {day01_part1, day01_part2};