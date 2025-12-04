package year_2024.day06;

import allg.aoc_allg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;


public class year2024_day06 {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(day06());
        System.out.println(System.currentTimeMillis() - start);
    }

    public static int day06() {
        int output = 0;
        List<String> lines = aoc_allg.readFile("src/year_2024/day06/day06_input.txt");
        String[][] map = new String[lines.size()][];
        String orientation = "";
        int x = 0, y = 0;
        for (int y1 = 0; y1 < lines.size(); y1++) {
            map[y1] = new String[lines.get(y1).length()];
            for (int x1 = 0; x1 < map[y1].length; x1++) {
                map[y1][x1] = String.valueOf(lines.get(y1).charAt(x1));
                if (map[y1][x1].equals("^") || map[y1][x1].equals("v") || map[y1][x1].equals("<") || map[y1][x1].equals(">")) {
                    x = x1;
                    y = y1;
                    orientation = map[y1][x1];
                    map[y1][x1] = ".";
                }
            }
        }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {

                final String[][] mapOp = new String[map.length][];
                for (int k = 0; k < map.length; k++) {
                    mapOp[k] = Arrays.copyOf(map[k], map[k].length);
                }

                mapOp[i][j] = "#";
                if (part2(y, x, mapOp, orientation)) output++;
            }
        }
        return output;
    }

    public static int part1(int y, int x, String[][] map, String orientation) {
        int output = 0;
        while (y < map.length - 1 && y > 0 && x < map[0].length - 1 && x > 0) {
            System.out.println(orientation);
            System.out.println(x + ", " + y);

            switch (orientation) {
                case "^": {
                    if (map[y - 1][x].equals("#")) {
                        orientation = ">";
                        continue;
                    } else {
                        map[y][x] = "X";
                        y--;
                    }
                    break;
                }
                case ">": {
                    if (map[y][x + 1].equals("#")) {
                        orientation = "v";
                        continue;
                    } else {
                        map[y][x] = "X";
                        x++;
                    }
                    break;
                }
                case "v": {
                    System.out.println("v: " + x + ", " + y);
                    if (map[y + 1][x].equals("#")) {
                        orientation = "<";
                        continue;
                    } else {
                        map[y][x] = "X";
                        y++;
                    }
                    break;
                }
                case "<": {
                    if (map[y][x - 1].equals("#")) {
                        orientation = "^";
                        continue;
                    } else {
                        map[y][x] = "X";
                        x--;
                    }
                    break;
                }
                default:
                    System.out.println("hello");
            }
        }
        for (String[] strings : map) {
            for (String string : strings) {
                if (string.equals("X")) output++;
            }
        }
        return output;
    }

    public static boolean part2(int y, int x, String[][] map, String orientation) {
        HashSet<String> memory = new HashSet<>();
        while (y < map.length - 1 && y > 0 && x < map[0].length - 1 && x > 0) {
            switch (orientation) {
                case "^": {
                    if (map[y - 1][x].equals("#")) {
                        orientation = ">";
                        continue;
                    } else {
                        map[y][x] = "X";
                        y--;
                    }
                    break;
                }
                case ">": {
                    if (map[y][x + 1].equals("#")) {
                        orientation = "v";
                        continue;
                    } else {
                        map[y][x] = "X";
                        x++;
                    }
                    break;
                }
                case "v": {
                    if (map[y + 1][x].equals("#")) {
                        orientation = "<";
                        continue;
                    } else {
                        map[y][x] = "X";
                        y++;
                    }
                    break;
                }
                case "<": {
                    if (map[y][x - 1].equals("#")) {
                        orientation = "^";
                        continue;
                    } else {
                        map[y][x] = "X";
                        x--;
                    }
                    break;
                }
            }
            String state = x + "," + y + "," + orientation;
            System.out.println(state);
            if (memory.contains(state)) {
                return true;
            }
            memory.add(state);
        }
        return false;
    }
}