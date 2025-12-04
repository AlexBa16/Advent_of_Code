package year_2024.day05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static allg.aoc_allg.pathOfInput;

public class year2024_day05 {
    public static void main(String[] args) {
        System.out.println(day05(pathOfInput(2024,5)));
    }

    public static int day05(Path path) {
//        int output = 0;
//        try {
//            List<String> input = Files.readAllLines(path);
//            List<int[]> rules = new ArrayList<>();
//            List<List<Integer>> updates = new ArrayList<>();
//            boolean cont = false;
//            for (String line : input) {
//                if (line.isEmpty()) {
//                    cont = true;
//                    continue;
//                }
//                if (!cont)
//                    rules.add(new int[]{Integer.parseInt(line.split("\\|")[0]), Integer.parseInt(line.split("\\|")[1])});
//                else for (String s : line.split("\n")) {
//                    List<Integer> i = new ArrayList<>();
//                    for (String p : s.split(",")) i.add(Integer.parseInt(p));
//                    updates.add(i);
//                }
//            }
//            for (int i = 0; i < updates.size() - 1; i++) {
//                List<Integer> up = updates.get(i);
//                List<int[]> usingRules = new ArrayList<>();
//                for (int[] r : rules) {
//                    if (up.contains(r[0]) && up.contains(r[1])) {
//                        usingRules.add(r);
//                    }
//                }
//                int current = up.get(i);
//                int next = up.get(i + 1);
//                if (!day05_valid(rules, current, next)) {
//                    List<Integer> upOrdert = day05_makeValid(rules, up);
//                    System.out.println(upOrdert);
//                    int temp = upOrdert.size() / 2;
//                    output += upOrdert.get(temp);
//                }
//
//            }
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
//        return output;

        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int blankLineIndex = lines.indexOf("");
        List<String> rules = lines.subList(0, blankLineIndex);
        List<String> updates = lines.subList(blankLineIndex + 1, lines.size());

        int middleCount = 0;

        for (String update : updates) {
            String[] updateArray = update.split(",");
            List<Integer> pages = Arrays.stream(updateArray).map(Integer::parseInt).toList();

            if (!isValidUpdate(pages, rules)) {
                List<Integer> correctedOrder = day05_makeValid(pages, rules);

                int middleIndex = correctedOrder.size() / 2;
                middleCount += correctedOrder.get(middleIndex);
            }
        }

        return middleCount;

    }

    public static boolean day05_valid(List<String> rules, int num1, int num2) {
        for (String s : rules) {
            String[] rule = s.split("\\|");
            int a = Integer.parseInt(rule[0]);
            int b = Integer.parseInt(rule[1]);

            if (a == num1 && b == num2) {
                return false;
            }

            if (a == num2 && b == num1) {
                return true;
            }
        }
        return true;


//        Map<Integer, Integer> pos = new HashMap<>();
//        for (int i = 0; i < up.size(); i++) pos.put(up.get(i), i);
//
//        for (int[] i : r) {
//            int a = i[0], b = i[1];
//            if (pos.containsKey(a) && pos.containsKey(b)) if (pos.get(a) > pos.get(b)) return false;
//        }
//        return true;
    }

    static boolean isValidUpdate(List<Integer> pages, List<String> rules) {
        for (int i = 0; i < pages.size(); i++) {
            for (int j = i + 1; j < pages.size(); j++) {
                if (day05_valid(rules, pages.get(i), pages.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<Integer> day05_makeValid(List<Integer> pages, List<String> rules) {
        List<Integer> correctedOrder = new ArrayList<>(pages);

        boolean sorted;
        do {
            sorted = true;
            for (int i = 0; i < correctedOrder.size() - 1; i++) {
                int current = correctedOrder.get(i);
                int next = correctedOrder.get(i + 1);

                if (day05_valid(rules, current, next)) {
                    Collections.swap(correctedOrder, i, i + 1);
                    sorted = false;
                }
            }
        } while (!sorted);

        return correctedOrder;
    }
}
