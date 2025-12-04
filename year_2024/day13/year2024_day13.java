package year_2024.day13;

import allg.aoc_allg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class year2024_day13 {
    public static void main(String[] args) {
        List<String> lines = aoc_allg.readFile("src/year_2024/day13/day13_input.txt");
        Pattern pattern = Pattern.compile("(Button A: X\\+(\\d+), Y\\+(\\d+))|(Button B: X\\+(\\d+), Y\\+(\\d+))|(Prize: X=(\\d+), Y=(\\d+))");
        List<String> insert = new ArrayList<>();
        List<Block> blocks = new ArrayList<>();
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                if (matcher.group(1) != null) insert.add(matcher.group(2) + "," + matcher.group(3));
                else if (matcher.group(4) != null) insert.add(matcher.group(5) + "," + matcher.group(6));
                else if (matcher.group(7) != null) insert.add(matcher.group(8) + "," + matcher.group(9));
            }
            if (line.isEmpty() || line.equals(lines.getLast())) {
                blocks.add(new Block(insert));
                insert = new ArrayList<>();
            }
        }
        long out = 0;
        for (Block block : blocks) {
//            out += day13(block);
            out += day13_part2(block);
        }
        System.out.println(out);
    }

    public static long day13(Block block) {
        long output = Long.MAX_VALUE;
        System.out.println(output);
        for (long pressB = 0; pressB <= 100; pressB++) {
            long restBx = block.prizeX - (pressB * block.bX);
            long restBy = block.prizeY - (pressB * block.bY);
            if (restBx < 0 || restBy < 0) break;
            if (restBx % block.aX == 0) {
                System.out.println(restBx);
                long pressA = restBx / block.aX;
                if (block.aY * pressA == restBy) {
                    System.out.println(output);
                    output = Math.min(3 * pressA + pressB, output);
                }
            }
        }
        return output == Long.MAX_VALUE ? 0 : output;
    }

    public static long day13_part2(Block block) {
        long a_x = block.aX, a_y = block.aY, b_x = block.bX, b_y = block.bY;
        long temp = a_x * b_x * block.prizeY - a_y * b_x * block.prizeX;
        long temp2 = a_x * b_y - a_y * b_x;
        long x_intersection = temp / temp2;
        long pressB = x_intersection / b_x;
        long pressA = (block.prizeX - x_intersection) / a_x;
        if (pressA >= 0 && pressB >= 0
                && a_y * pressA + b_y * pressB == block.prizeY
                && a_x * pressA + b_x * pressB == block.prizeX)
            return 3 * pressA + pressB;
        return 0;
    }

    public static class Block {
        public long aX, aY, bX, bY, prizeX = 10000000000000L, prizeY = 10000000000000L;

        public Block(List<String> insert) {
            String a = insert.getFirst();
            String b = insert.get(1);
            String p = insert.get(2);
            this.aX = Integer.parseInt(a.split(",")[0]);
            this.aY = Integer.parseInt(a.split(",")[1]);
            this.bX = Integer.parseInt(b.split(",")[0]);
            this.bY = Integer.parseInt(b.split(",")[1]);
            this.prizeX += Long.parseLong(p.split(",")[0]);
            this.prizeY += Long.parseLong(p.split(",")[1]);
        }
    }
}
