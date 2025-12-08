function day08_part1(lines: string[]): number {
    let junctionBoxes: { x: number, y: number, z: number }[] = [];
    for (const line of lines) {
        let split = line.split(',');
        let x = Number(split[0]);
        let y = Number(split[1]);
        let z = Number(split[2]);
        junctionBoxes.push({x, y, z})
    }
    let circuits: number[][] = junctionBoxes.map((_, i) => [i]);

    let distances: { pair: number[], distance: number }[] = [];
    for (let i = 0; i < junctionBoxes.length; i++) {
        for (let j = i + 1; j < junctionBoxes.length; j++) {
            distances.push({pair: [i, j], distance: calcDistance(junctionBoxes[i]!, junctionBoxes[j]!)});
        }
    }
    distances.sort((a, b) => a.distance - b.distance);

    let counter = 10;
    for (const entry of distances) {
        const [a, b] = entry.pair;

        if (counter < 1) break;
        if (mergeCircuits(a!, b!)) counter--;
    }

    function mergeCircuits(a: number, b: number): boolean {
        const aIndex = findCircuitIndex(a);
        const bIndex = findCircuitIndex(b);
        if (aIndex === bIndex) return false; // already connected -> skip
        const merged = [...circuits[aIndex]!, ...circuits[bIndex]!];
        circuits.splice(Math.max(aIndex, bIndex), 1);
        circuits.splice(Math.min(aIndex, bIndex), 1);
        circuits.push(merged);
        return true;
    }

    function findCircuitIndex(node: number): number {
        return circuits.findIndex(c => c.includes(node));
    }

    circuits.sort((a, b) => b.length - a.length);
    console.log(circuits.length);
    let output = 1;
    for (let i = 0; i < 3 && i < circuits.length; i++) {
        output *= circuits[i]!.length;
    }

    return output;
}

function calcDistance(a: { x: number, y: number, z: number }, b: { x: number, y: number, z: number }): number {
    const dx = a.x - b.x;
    const dy = a.y - b.y;
    const dz = a.z - b.z;
    return Math.sqrt(dx * dx + dy * dy + dz * dz);
}

function day08_part2(lines: string[]): number {
    let output: number = 0;

    return output;
}

export {day08_part1, day08_part2};