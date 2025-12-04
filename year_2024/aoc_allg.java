package allg;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class aoc_allg {
    public static List<String> readFile(String s) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(s));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static List<String> readFile(int y, int d) {
        List<String> lines;
        try {
            lines = Files.readAllLines(pathOfInput(y, d));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }

    public static Path pathOfInput(int year, int day) {
        return day <= 9 ? Path.of("src/year_" + year + "/day0" + day + "/day0" + day + "_input.txt") : Path.of("src/year_" + year + "/day" + day + "/day" + day + "_input.txt");
    }

    public static char[][] charArrayGrid(List<String> lines) {
        char[][] grid = new char[lines.size()][];
        for (int y = 0; y < lines.size(); y++) grid[y] = lines.get(y).toCharArray();
        return grid;
    }

    public static Point findChar(char[][] grid, char find) {
        Point pos = new Point(-1, -1);
        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (grid[y][x] == find) pos.setLocation(x, y);
            }
        }
        return pos;
    }
}
