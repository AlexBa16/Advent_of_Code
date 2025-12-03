function day03_part1(lines: string[]): number {
    let output: number = 0;
    for (const line of lines) {
        let biggestNumber: number = -1;
        let maxRightDigit: number = -1;

        for (let index = line.length - 1; index >= 0; index--) {
            let value = Number(line.charAt(index));
            if (maxRightDigit != -1) {
                let possibleCandidate: number = 10 * value + maxRightDigit;
                if (possibleCandidate > biggestNumber) biggestNumber = possibleCandidate;
            }
            if (value > maxRightDigit) maxRightDigit = value;
        }
        output += biggestNumber;
    }
    return output;
}

function day03_part2(lines: string[]): number {
    let output: number = 0;
    for (const line of lines) {
        let delCount: number = line.length - 12;
        let stack: number[] = [];
        for (let index = 0; index < line.length; index++) {
            let thisNumber: number = Number(line.charAt(index));
            while (delCount > 0 && stack.length > 0) {
                const last = stack[stack.length - 1]!; // '!' -> I know that it isn't undefined
                if (last >= thisNumber) break;
                stack.pop();
                delCount--;
            }
            stack.push(thisNumber);
        }
        let outputNumber: string = "";
        for (let i = 0; i < 12; i++) outputNumber += stack.at(i);
        output += Number(outputNumber);
    }
    return output;
}

export {day03_part1, day03_part2};