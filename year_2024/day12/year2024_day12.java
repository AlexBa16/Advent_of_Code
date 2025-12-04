package year_2024.day12;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static allg.aoc_allg.charArrayGrid;
import static allg.aoc_allg.readFile;


public class year2024_day12 {
    public static void main(String[] args) {
        List<String> lines = readFile(2024, 12);
        System.out.println(day12(lines));
    }

    public static long day12(List<String> lines) {
        Map<Character, Integer> plants = new HashMap<>();
        Map<Character, Integer> plantsArea = new HashMap<>();
        char[][] grid = charArrayGrid(lines);
        for (int y = 0; y < grid.length; y++)
            for (int x = 0; x < grid[y].length; x++) {
                char plant = lines.get(y).charAt(x);
                int value = plants.getOrDefault(plant, 0);
                plantsArea.put(plant, plantsArea.getOrDefault(plant, 0) + 1);
                if (y == 0) value++;
                else if (grid[y - 1][x] != plant) value++;
                if (y == grid.length - 1) value++;
                else if (grid[y + 1][x] != plant) value++;
                if (x == 0) value++;
                else if (grid[y][x - 1] != plant) value++;
                if (x == grid[y].length - 1) value++;
                else if (grid[y][x + 1] != plant) value++;
                plants.put(plant, value);
            }
        System.out.println("Perimeter\t" + plants);
        System.out.println("Area\t\t" + plantsArea);
        int price = 0;
        for (Map.Entry<Character, Integer> entry : plants.entrySet())
            price += entry.getValue() * plantsArea.get(entry.getKey());
        return price;
    }
}
