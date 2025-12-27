function day10_part1(lines: string[]): number {
    let output: number = 0;
    for (let line of lines) {
        const parts = line.split(" ");

        const diagramLights: number[] = parts[0]!.slice(1, -1).split("").map(l => l === "." ? 0 : 1);
        const buttons: number[][] = parts.slice(1, -1).map(b => b.replace(/[()]/g, "").split(",").map(n => Number(n)));

        // change buttons to binary
        for (let i = 0; i < buttons.length; i++) {
            let newButton: number[] = new Array(diagramLights.length).fill(0);
            for (let j = 0; j < buttons[i]!.length; j++) newButton[buttons[i]![j]!] = 1;
            buttons[i] = newButton;
        }

        const anzCombinations = Math.pow(2, buttons.length);
        let smallestNrOfPresses = Number.MAX_SAFE_INTEGER;

        for (let combinationIndex = 1; combinationIndex < anzCombinations; combinationIndex++) {
            const lights: number[] = new Array(diagramLights.length).fill(0);
            let presses = 0;

            for (let buttonIndex = 0; buttonIndex < buttons.length; buttonIndex++) {
                // Integer to Binär
                if ((combinationIndex & (1 << buttonIndex)) !== 0) {
                    presses++;

                    for (let light = 0; light < lights.length; light++) {
                        // Button press (XOR)
                        lights[light]! ^= buttons[buttonIndex]![light]!;
                    }
                }
            }

            // check if match
            let match = true;
            for (let i = 0; i < lights.length; i++) {
                if (lights[i] !== diagramLights[i]) {
                    match = false;
                    break;
                }
            }
            if (match) smallestNrOfPresses = Math.min(smallestNrOfPresses, presses);
        }
        output += smallestNrOfPresses;
    }
    return output;
}

function day10_part2(lines: string[]): number {
    let output: number = 0;
    for (let line of lines) {
        const parts = line.split(" ");

        const diagramLights: number[] = parts[0]!.slice(1, -1).split("").map(l => l === "." ? 0 : 1);
        const buttons: number[][] = parts.slice(1, -1).map(b => b.replace(/[()]/g, "").split(",").map(n => Number(n)));

        // change buttons to binary
        for (let i = 0; i < buttons.length; i++) {
            let newButton: number[] = new Array(diagramLights.length).fill(0);
            for (let j = 0; j < buttons[i]!.length; j++) newButton[buttons[i]![j]!] = 1;
            buttons[i] = newButton;
        }

        const anzCombinations = Math.pow(2, buttons.length);
        let smallestNrOfPresses = Number.MAX_SAFE_INTEGER;

        for (let combinationIndex = 1; combinationIndex < anzCombinations; combinationIndex++) {
            const lights: number[] = new Array(diagramLights.length).fill(0);
            let presses = 0;

            for (let buttonIndex = 0; buttonIndex < buttons.length; buttonIndex++) {
                // Integer to Binär
                if ((combinationIndex & (1 << buttonIndex)) !== 0) {
                    presses++;

                    for (let light = 0; light < lights.length; light++) {
                        // Button press (XOR)
                        lights[light]! ^= buttons[buttonIndex]![light]!;
                    }
                }
            }

            // check if match
            let match = true;
            for (let i = 0; i < lights.length; i++) {
                if (lights[i] !== diagramLights[i]) {
                    match = false;
                    break;
                }
            }
            if (match) smallestNrOfPresses = Math.min(smallestNrOfPresses, presses);
        }
        output += smallestNrOfPresses;
    }
    return output;
}

export {day10_part1, day10_part2};