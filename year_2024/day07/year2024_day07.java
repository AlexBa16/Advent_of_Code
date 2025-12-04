package year_2024.day07;

import allg.aoc_allg;

import java.util.ArrayList;
import java.util.List;


public class year2024_day07 {

    public static void main(String[] args) {
        System.out.println(day07());
    }

    public static long day07() {
        long output = 0;
        List<String> lines = aoc_allg.readFile("src/year_2024/day07/day07_input.txt");
        for (String line : lines) {
            String[] split = line.split(": ");
            long value = Long.parseLong(split[0]);
            List<Long> numbers = new ArrayList<>();
            for (String s : split[1].split(" ")) numbers.add(Long.parseLong(s.trim()));
            if (findValidExpression(numbers, value, 1, numbers.getFirst())) output += value;
        }
        return output;
    }

    public static boolean findValidExpression(List<Long> numbers, long value, int index, long current) {
        if (index >= numbers.size()) return current == value;
        return findValidExpression(numbers, value, index + 1, current + numbers.get(index))
                || findValidExpression(numbers, value, index + 1, current * numbers.get(index))
                || findValidExpression(numbers, value, index + 1, Long.parseLong(current + "" + numbers.get(index)));
    }
}