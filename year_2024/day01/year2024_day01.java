package year_2024.day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static allg.aoc_allg.pathOfInput;

public class year2024_day01 {
    public static void main(String[] args) {
        System.out.println(day01(pathOfInput(2024,1)));
    }

    public static int day01(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            ArrayList<Integer> a = new ArrayList<>();
            ArrayList<Integer> b = new ArrayList<>();
            Map<Integer, Integer> map = new HashMap<>();
            for (String s : input) {
                String[] temp = s.split(" +");
                a.add(Integer.parseInt(temp[0].trim()));
                b.add(Integer.parseInt(temp[1].trim()));
            }
            for (int i : b) map.put(i, map.getOrDefault(i, 0) + 1);
            for (int i : a) output += i * map.getOrDefault(i, 0);
//            Collections.sort(a);
//            Collections.sort(b);
//            for (int i = 0; i < a.size(); i++) {
//                int temp = 0;
//                for (Integer integer : b) {
//                    if (a.get(i).equals(integer)) temp++;
//                }
//                output += a.get(i) * temp;
//                output += Math.abs(a.get(i) - b.get(i));
//            }

        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }
}
