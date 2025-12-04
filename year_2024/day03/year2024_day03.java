package year_2024.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static allg.aoc_allg.pathOfInput;

public class year2024_day03 {
    public static void main(String[] args) {
        System.out.println(day03(pathOfInput(2024,3)));
    }

    public static int day03(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            boolean enable = true;
            for (String s : input) {
                Matcher matcher = Pattern.compile("(mul\\((\\d+),(\\d+)\\))|(do\\(\\))|(don't\\(\\))").matcher(s);
                while (matcher.find()) {
                    if (matcher.group(5) != null) {
                        enable = false;
                        continue;
                    }
                    if (matcher.group(4) != null) {
                        enable = true;
                        continue;
                    }
                    if (enable) output += (Integer.parseInt(matcher.group(2)) * Integer.parseInt(matcher.group(3)));
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }
}
