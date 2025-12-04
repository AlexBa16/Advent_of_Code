package year_2024.day16;

import java.awt.*;

import static allg.aoc_allg.*;

public class year2024_day16 {
    public static void main(String[] args) {
        char[][] grid = charArrayGrid(readFile(2024, 15));
        Point positionS = findChar(grid, 'S');
        System.out.println(day16(grid, positionS.y, positionS.x));
    }

    public static long day16(char[][] grid, int y, int x) {
        long output = 0;

        return output;
    }
}
