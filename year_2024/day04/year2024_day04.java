package year_2024.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static allg.aoc_allg.pathOfInput;

public class year2024_day04 {
    public static int day04(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            char[][] in = new char[input.size()][];
            for (int i = 0; i < in.length; i++) {
                in[i] = new char[input.get(i).length()];
                for (int j = 0; j < in[i].length; j++) in[i][j] = input.get(i).charAt(j);
            }
            for (int y = 0; y < in.length; y++)
                for (int x = 0; x < in[y].length; x++) output += day04_findWord(x, y, in);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static int day04_findWord(int x, int y, char[][] in) {
        int out = 0;
        try {
            if (((in[y][x] == 'A' && in[y - 1][x + 1] == 'M' && in[y + 1][x - 1] == 'S') || in[y][x] == 'A' && in[y - 1][x + 1] == 'S' && in[y + 1][x - 1] == 'M') || (in[y - 1][x - 1] == 'M' && in[y + 1][x + 1] == 'S') || (in[y - 1][x - 1] == 'S' && in[y + 1][x + 1] == 'M'))
                out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return out;

        /*
        //Part1
        int out = 0;
        try {
            if (in[y][x] == 'X' && in[y][x + 1] == 'M' && in[y][x + 2] == 'A' && in[y][x + 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y][x - 1] == 'M' && in[y][x - 2] == 'A' && in[y][x - 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y + 1][x] == 'M' && in[y + 2][x] == 'A' && in[y + 3][x] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y - 1][x] == 'M' && in[y - 2][x] == 'A' && in[y - 3][x] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y - 1][x - 1] == 'M' && in[y - 2][x - 2] == 'A' && in[y - 3][x - 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y + 1][x + 1] == 'M' && in[y + 2][x + 2] == 'A' && in[y + 3][x + 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y + 1][x - 1] == 'M' && in[y + 2][x - 2] == 'A' && in[y + 3][x - 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        try {
            if (in[y][x] == 'X' && in[y - 1][x + 1] == 'M' && in[y - 2][x + 2] == 'A' && in[y - 3][x + 3] == 'S') out++;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return out;
         */
    }

    public static void main(String[] args) {
        System.out.println(day04(pathOfInput(2024, 4)));
    }
}
