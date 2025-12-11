import {readFileAsString} from "../../utils/files.ts";

function day10_part1(lines: string[]): number {
    let output: number = 0;
    for (let line of lines) {
        const parts = line.split(" ");

        const lights: boolean[] = parts[0]!.slice(1, -1).split("").map(l => l !== ".");
        const buttons: number[][] = parts.slice(1, -1).map(b => b.replace(/[()]/g, "").split(",").map(n => Number(n)));

        function combinations<T>(buttons: T[]): T[][] {
            const result: T[][] = [];

            function helper(start: number, combo: T[]) {
                for (let i = start; i < buttons.length; i++) {
                    const newCombo = [...combo, buttons[i]!];
                    result.push(newCombo);
                    helper(i + 1, newCombo);
                }
            }

            helper(0, []);
            return result;
        }

        function calcValue(buttons: number[][]): number {
            let value: number = 0;
            for (const button of buttons) {
                for (let i = 0; i < button.length; i++) {
                    lights[button[i]!] = !lights[button[i]!];
                    if (!lights.includes(false)) {
                        value++;
                        break;
                    }

                }
            }
            return value;
        }

        const results: Map<string, number> = new Map();
        const allCombos = combinations(buttons);

        for (const combo of allCombos) {
            results.set(JSON.stringify(combo), calcValue(combo));
            // console.log(combo);
        }

        console.log(results);
        // console.log(lights);
        // console.log(buttons);

    }
    return output;
}


function day10_part2(lines: string[]): number {
    return 0;
}

export {day10_part1, day10_part2};