package year_2024.day15;

import java.util.ArrayList;
import java.util.List;

import static allg.aoc_allg.readFile;

public class year2024_day15 {
    public static void main(String[] args) {
        List<String> lines = readFile(2024, 15);
        List<String> map = new ArrayList<>();
        boolean movementInput = false;
        StringBuilder movement = new StringBuilder();
        for (String line : lines) {
            if (line.isEmpty()) movementInput = true;
            if (movementInput) movement.append(line);
            else map.add(line);
        }
        char[][] grid = new char[map.size()][];
        int robotY = 0, robotX = 0;
        for (int y = 0; y < map.size(); y++) {
            grid[y] = map.get(y).toCharArray();
            if (map.get(y).contains("@")) {
                robotY = y;
                robotX = map.get(y).indexOf("@");
                grid[robotY][robotX] = '.';
            }
        }

        System.out.println(day15(grid, movement.toString(), robotY, robotX));
    }

    public static long day15(char[][] grid, String movement, int y, int x) {
        char wall = '#', box = 'O';
        for (char move : movement.toCharArray()) {
            char left = grid[y][x - 1], right = grid[y][x + 1], top = grid[y - 1][x], bottom = grid[y + 1][x];
            char nextLeft = grid[y][x - 2], nextRight = grid[y][x + 2], nextTop = grid[y - 2][x], nextBottom = grid[y + 2][x];

            switch (move) {
                case '^': {
                    //mehrere boxen könne verschoben werden.
                    break;
                }
                case '>': {
                    //>
                    break;
                }
                case 'v': {
                    //v
                    break;
                }
                case '<': {
                    //<
                    break;
                }
                default:
                    throw new IllegalStateException("Unexpected value: " + move);
            }
        }
        return 0;
    }
}
