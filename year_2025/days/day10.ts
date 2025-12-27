function day10_part1(lines: string[]): number {
    let output: number = 0;
    for (let line of lines) {
        const parts = line.split(" ");

        const diagramLights: number[] = parts[0]!.slice(1, -1).split("").map(l => l === "." ? 0 : 1);
        const lights: number[] = new Array(diagramLights.length).fill(0).map(() => 0);
        const buttons: number[][] = parts.slice(1, -1).map(b => b.replace(/[()]/g, "").split(",").map(n => Number(n)));

        for (let i = 0; i < buttons.length; i++) {
            let newButton: number[] = new Array(lights.length).fill(0);
            for (let j = 0; j < buttons[i]!.length; j++) newButton[buttons[i]![j]!] = 1;
            buttons[i] = newButton;
        }

        const patternNr = Math.pow(2, buttons.length);
        let smallestNrOfPresses: number = -1;



        // XOR -> toggle

        // console.log(patternNr)
        // console.log(diagramLights)
        console.log(buttons)
        // console.log(lights)
    }
    return output;
}


function day10_part2(lines: string[]): number {
    return 0;
}

export {day10_part1, day10_part2};