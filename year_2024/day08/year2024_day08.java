package year_2024.day08;

import allg.aoc_allg;

import java.util.*;


public class year2024_day08 {

    public static void main(String[] args) {
        System.out.println(day08());
    }

    public static long day08() {
        long output = 0;
        List<String> lines = aoc_allg.readFile("src/year_2024/day08/day08_input.txt");
        Map<Character, List<int[]>> antennen = new HashMap<>();

        char[][] grid = new char[lines.size()][];
        for (int y = 0; y < lines.size(); y++) {
            grid[y] = lines.get(y).toCharArray();
            for (int x = 0; x < lines.get(y).length(); x++)
                if (grid[y][x] != '.')
                    antennen.computeIfAbsent(grid[y][x], _ -> new ArrayList<>()).add(new int[]{y, x});
        }

        Set<String> antinodes = new HashSet<>();
        for (Map.Entry<Character, List<int[]>> frequenz : antennen.entrySet()) {
            List<int[][]> pairs = getPairs(frequenz.getValue());

            List<int[]> position = frequenz.getValue();
            for (int[] pos : position) antinodes.add(pos[0] + "," + pos[1]);

            for (int[][] pair : pairs) {
                int y1 = pair[0][0], x1 = pair[0][1], y2 = pair[1][0], x2 = pair[1][1];
                int diffY = y2 - y1, diffX = x2 - x1;
                int gcd = gcd(Math.abs(diffY), Math.abs(diffX));

                diffY /= gcd;
                diffX /= gcd;

                int tempY = y2, tempX = x2;
                int tempY2 = y1, tempX2 = x1;

                while (tempY >= 0 && tempY < grid.length && tempX >= 0 && tempX < grid[0].length) {
                    antinodes.add(tempY + "," + tempX);
                    tempY += diffY;
                    tempX += diffX;
                }
                while (tempY2 >= 0 && tempY2 < grid.length && tempX2 >= 0 && tempX2 < grid[0].length) {
                    antinodes.add(tempY2 + "," + tempX2);
                    tempY2 -= diffY;
                    tempX2 -= diffX;
                }
//                int diffY = y2 - y1, diffX = x2 - x1;
//                antinodes.add((y1 - diffY) + "," + (x1 - diffX));
//                antinodes.add((y2 + diffY) + "," + (x2 + diffX));
            }
        }
        for (String node : antinodes) {
            String[] parts = node.split(",");
            int y = Integer.parseInt(parts[0]);
            int x = Integer.parseInt(parts[1]);

            if (y >= 0 && y < lines.size() && x >= 0 && x < lines.getFirst().length()) {
                grid[y][x] = '#';
                output++;
            }
        }

        for (char[] c : grid) System.out.println(c);
        return output;
    }

    public static List<int[][]> getPairs(List<int[]> pos) {
        List<int[][]> pairs = new ArrayList<>();
        for (int i = 0; i < pos.size(); i++)
            for (int j = i + 1; j < pos.size(); j++) pairs.add(new int[][]{pos.get(i), pos.get(j)});
        return pairs;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    /*
    public static void commandMap(Map<Character, List<int[]>> a) {
        for (Map.Entry<Character, List<int[]>> entry : a.entrySet()) {
            char key = entry.getKey();
            List<int[]> value = entry.getValue();
            System.out.println("Schlüssel: " + key);
            for (int[] array : value) {
                System.out.print("Wert: ");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
    */
}