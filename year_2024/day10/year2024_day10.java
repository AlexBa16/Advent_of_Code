package year_2024.day10;

import allg.aoc_allg;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class year2024_day10 {
    public static void main(String[] args) {
        System.out.println(day10());
    }

    public static long day10() {
        List<String> lines = aoc_allg.readFile("src/year_2024/day10/day10_input.txt");
        List<Point> starts = new ArrayList<>();
        int[][] grid = new int[lines.size()][];
        for (int y = 0; y < lines.size(); y++) {
            grid[y] = new int[lines.get(y).length()];
            for (int x = 0; x < lines.get(y).length(); x++) {
                grid[y][x] = Integer.parseInt(String.valueOf(lines.get(y).charAt(x)));
                if (grid[y][x] == 0) starts.add(new Point(x, y));
            }
        }
        System.out.println(starts);
        soutGrid(grid);

        long output = 0;
        for (Point startPoint : starts) {
            output += day10_part1(grid, startPoint, -1, new HashSet<>()).size();
//            output += day10_part2(grid, startPoint, -1);
        }
        return output;
    }

    public static HashSet<String> day10_part1(int[][] grid, Point position, int lastPosition, HashSet<String> out) {
        int y = position.y, x = position.x;
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) return out;
        int thisPosition = grid[y][x];
        if (thisPosition != lastPosition + 1) return out;
        if (thisPosition == 9) {
            out.add(x + "," + y);
            return out;
        }
        day10_part1(grid, new Point(x + 1, y), thisPosition, out);
        day10_part1(grid, new Point(x, y + 1), thisPosition, out);
        day10_part1(grid, new Point(x - 1, y), thisPosition, out);
        day10_part1(grid, new Point(x, y - 1), thisPosition, out);
        return out;
    }

    public static long day10_part2(int[][] grid, Point position, int lastPosition) {
        int y = position.y, x = position.x;
        if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) return 0;
        int thisPosition = grid[y][x];
        if (thisPosition != lastPosition + 1) return 0;
        if (thisPosition == 9) return 1;
        long out = 0;
        out += day10_part2(grid, new Point(x + 1, y), thisPosition);
        out += day10_part2(grid, new Point(x, y + 1), thisPosition);
        out += day10_part2(grid, new Point(x - 1, y), thisPosition);
        out += day10_part2(grid, new Point(x, y - 1), thisPosition);
        return out;
    }

    static void soutGrid(int[][] m) {
        for (int[] i : m) System.out.println(Arrays.toString(i));
    }
}