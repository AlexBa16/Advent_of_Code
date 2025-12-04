package year_2024.day17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static allg.aoc_allg.readFile;

public class year2024_day17 {
    static List<String> lines = readFile(2024, 17);
    static int regA = Integer.parseInt(lines.getFirst().split(": ")[1]);
    static int regB = Integer.parseInt(lines.get(1).split(": ")[1]);
    static int regC = Integer.parseInt(lines.get(2).split(": ")[1]);
    static int[] program = Arrays.stream(Arrays.stream(lines.get(4).split(": ")[1].split(",")).mapToInt(Integer::parseInt).toArray()).toArray();

    public static void main(String[] args) {
//        System.out.println(day17_part1());
        long t = System.currentTimeMillis();
        System.out.println(day17_part2());
        System.out.println(System.currentTimeMillis() - t + " -> Time");
    }

    public static String day17_part1() {
        List<Integer> output = new ArrayList<>();
        int pointer = 0;
        while (pointer < program.length) {
            boolean skipIncrease = false;
            int code = program[pointer];
            int litOperator = program[pointer + 1];
            int compOperator = getCompOperator(program[pointer + 1]);
            switch (code) {
                case 0 -> regA /= (int) Math.pow(2, compOperator);
                case 1 -> regB = regB ^ litOperator;
                case 2 -> regB = compOperator % 8;
                case 3 -> {
                    if (regA != 0) {
                        pointer = litOperator;
                        skipIncrease = true;
                    }
                }
                case 4 -> regB = regB ^ regC;
                case 5 -> output.add(compOperator % 8);
                case 6 -> regB = regA / (int) Math.pow(2, compOperator);
                case 7 -> regC = regA / (int) Math.pow(2, compOperator);
                default -> throw new IllegalStateException("Unexpected value: " + code);
            }
            if (!skipIncrease) pointer += 2;
        }
        return String.join(",", output.stream().map(Long::toString).toList());
    }

    public static long day17_part2() {
        int fixedRegA = 0;
        StringBuilder goal = new StringBuilder();
        for (int i = 0; i < program.length; i++) {
            goal.append(program[i]);
            if (i != program.length - 1) goal.append(",");
        }
        String out;
        while (true) {
            regA = fixedRegA;
            out = day17_part1();
            if (out.contentEquals(goal)) return fixedRegA;
            fixedRegA++;
            if (fixedRegA % 1000000 == 0) System.out.println(fixedRegA);
        }
    }

    public static int getCompOperator(int value) {
        return switch (value % 8) {
            case 0, 1, 2, 3 -> value;
            case 4 -> regA;
            case 5 -> regB;
            case 6 -> regC;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }
}
