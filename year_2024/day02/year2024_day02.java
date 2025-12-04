package year_2024.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static allg.aoc_allg.pathOfInput;


public class year2024_day02 {
    public static void main(String[] args) {
        System.out.println(day02(pathOfInput(2024,2)));
    }

    public static int day02(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            for (String s : input) {
                String[] in = s.split(" ");
                if (day02_isSafe(in)) output++;
                else for (int i = 0; i < in.length; i++) {
                    String[] modified = day02_remove(in, i);
                    if (day02_isSafe(modified)) {
                        output++;
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static boolean day02_isSafe(String[] in) {
        boolean down = false;
        boolean up = false;
        for (int i = 1; i < in.length; i++) {
            int b = Integer.parseInt(String.valueOf(in[i - 1]));
            int a = Integer.parseInt(String.valueOf(in[i]));
            int diff = Math.abs(a - b);
            if (b > a) {
                if (up) return false;
                down = true;
            } else if (b < a) {
                if (down) return false;
                up = true;
            } else return false;
            if (diff > 3) return false;
        }
        return true;
    }

    private static String[] day02_remove(String[] in, int index) {
        String[] modified = new String[in.length - 1];
        int n = 0;
        for (int i = 0; i < in.length; i++) if (i != index) modified[n++] = in[i];
        return modified;
    }
}
