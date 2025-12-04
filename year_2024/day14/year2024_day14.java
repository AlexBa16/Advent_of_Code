package year_2024.day14;

import allg.aoc_allg;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class year2024_day14 {
    public static void main(String[] args) {
        System.out.println(day14());
    }

    public static int day14() {
        List<String> lines = aoc_allg.readFile("src/year_2024/day14/day14_input.txt");
        List<Robot> robots = new ArrayList<>();
        Pattern pattern = Pattern.compile("p=(\\d+),(\\d+) v=(-*\\d+),(-*\\d+)");
        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                robots.add(new Robot(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4))));
            }
        }
        final int width = 101;
        final int height = 103;
        int[][] grid = new int[height][width];
        final int seconds = 10000;
        for (int i = 1; i <= seconds; i++) {
            for (Robot robot : robots) {
                robot.position.y += robot.velocity.y;
                robot.position.x += robot.velocity.x;
                if (robot.position.y >= grid.length) robot.position.y -= grid.length;
                if (robot.position.y < 0) robot.position.y += grid.length;
                if (robot.position.x >= grid[0].length) robot.position.x -= grid[0].length;
                if (robot.position.x < 0) robot.position.x += grid[0].length;
            }
            if (i > 3000) {
                RobotsToImage panel = new RobotsToImage(robots);
                try {
                    panel.saveImage("C:\\Users\\alexb\\Downloads\\pictures\\second" + i + ".png", width, height);
                } catch (Exception e) {
                    System.out.println("Error at Image path");
                }
            }
        }
        for (Robot robot : robots) grid[robot.position.y][robot.position.x]++;
        return getOutput(grid);
    }

    private static int getOutput(int[][] grid) {
        int sector = 0;
        int output = 1;
        int len = grid.length;
        int width = grid[0].length;
        for (int y = 0; y < len / 2; y++)
            for (int x = 0; x < width / 2; x++) sector += grid[y][x];
        if (sector != 0) output *= sector;
        sector = 0;
        for (int y = len / 2 + 1; y < len; y++)
            for (int x = 0; x < width / 2; x++) sector += grid[y][x];
        if (sector != 0) output *= sector;
        sector = 0;
        for (int y = 0; y < len / 2; y++)
            for (int x = width / 2 + 1; x < width; x++) sector += grid[y][x];
        if (sector != 0) output *= sector;
        sector = 0;
        for (int y = len / 2 + 1; y < len; y++)
            for (int x = width / 2 + 1; x < width; x++) sector += grid[y][x];
        if (sector != 0) output *= sector;
        return output;
    }
}

