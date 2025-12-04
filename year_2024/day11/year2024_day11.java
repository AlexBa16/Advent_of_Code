package year_2024.day11;

import allg.aoc_allg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class year2024_day11 {
    public static Map<Long, List<Stone>> cache = new HashMap<>();

    public static void main(String[] args) {
        String[] lines = aoc_allg.readFile("src/year_2024/day11/day11_input.txt").getFirst().split(" ");
        Map<Long, Long> stoneCounts = new HashMap<>();
        for (String line : lines) {
            long value = Long.parseLong(line);
            stoneCounts.put(value, stoneCounts.getOrDefault(value, 0L) + 1);
        }
        int blinks = 75;
        for (int i = 0; i < blinks; i++) {
//        for (int i = 0; i < blinks; i++) day11(stones);
            stoneCounts = day11_part2(stoneCounts);
        }
        System.out.println(stoneCounts.values().stream().mapToLong(Long::longValue).sum());
    }

    public static void day11(List<Stone> stones) {
        List<Stone> addStones = new ArrayList<>();
        for (Stone stone : stones) {
            if (stone.value == 0) {
                stone.value = 1;
                continue;
            }
            long len = String.valueOf(stone.value).length();
            if ((len & 1) == 0) {
                long left = Long.parseLong(String.valueOf(stone.value).substring(0, (int) (len / 2)));
                long right = Long.parseLong(String.valueOf(stone.value).substring((int) (len / 2)));
                stone.value = left;
                Stone stone1 = new Stone(right);
                addStones.add(stone1);
            } else stone.value *= 2024;
        }
        stones.addAll(addStones);
    }

    public static Map<Long, Long> day11_part2(Map<Long, Long> stoneCount) {
        Map<Long, Long> newStones = new HashMap<>();
        for (Map.Entry<Long, Long> entry : stoneCount.entrySet()) {
            long value = entry.getKey();
            long count = entry.getValue();

            if (value == 0) {
                newStones.put(1L, newStones.getOrDefault(1L, 0L) + count);
                continue;
            }
            long len = String.valueOf(value).length();
            if ((len & 1) == 0) {
                long left = Long.parseLong(String.valueOf(value).substring(0, (int) (len / 2)));
                long right = Long.parseLong(String.valueOf(value).substring((int) (len / 2)));
                newStones.put(left, newStones.getOrDefault(left, 0L) + count);
                newStones.put(right, newStones.getOrDefault(right, 0L) + count);
            } else {
                long insert = value * 2024;
                newStones.put(insert, newStones.getOrDefault(insert, 0L) + count);

            }
        }
        return newStones;
    }

    public static class Stone {
        public long value;

        public Stone(long value) {
            this.value = value;
        }
    }
}