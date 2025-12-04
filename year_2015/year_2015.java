package year_2015;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.*;

@SuppressWarnings("unused")
public class year_2015 {
    @SuppressWarnings("CommentedOutCode")
    public static void main(String[] args) {
//        System.out.println("Day01, Part1: " + day01_1(pathOfInput(1)));
//        System.out.println("Day01, Part2: " + day01_2(pathOfInput(1)));
//        System.out.println("Day02, Part1: " + day02_1(pathOfInput(2)));
//        System.out.println("Day02, Part2: " + day02_2(pathOfInput(2)));
//        System.out.println("Day03, Part1: " + day03_1(pathOfInput(3)));
//        System.out.println("Day03, Part2: " + day03_2(pathOfInput(3)));
//        System.out.println("Day04, Part1: " + day04_1("yzbqklnj"));
//        System.out.println("Day04, Part2: " + day04_2("yzbqklnj"));
//        System.out.println("Day05, Part1: " + day05_1(pathOfInput(5)));
//        System.out.println("Day05, Part2: " + day05_2(pathOfInput(5)));
//        System.out.println("Day06, Part1: " + day06_1(pathOfInput(6)));
//        System.out.println("Day06, Part2: " + day06_2(pathOfInput(6)));
        System.out.println("Day07, Part1: " + day07_1(pathOfInput(7)));
        System.out.println("Day07, Part2: " + day07_2(pathOfInput(7)));
//        System.out.println("Day08, Part1: " + day08_1(pathOfInput(8)));
//        System.out.println("Day08, Part2: " + day08_2(pathOfInput(8)));
//        System.out.println("Day09, Part1: " + day09_1(pathOfInput(9)));
//        System.out.println("Day09, Part2: " + day09_2(pathOfInput(9)));
//        System.out.println("Day10, Part1: " + day10_1("1113122113", 40));
//        System.out.println("Day10, Part2: " + day10_2("1113122113", 50));
//        System.out.println("Day11, Part1: " + day11_1("vzbxkghb"));
//        System.out.println("Day11, Part2: " + day11_2("vzbxkghb"));
//        System.out.println("Day12, Part1: " + day12_1(pathOfInput(12)));
//        System.out.println("Day12, Part2: " + day12_2(pathOfInput(12)));
//        System.out.println("Day13, Part1: " + day13_1(pathOfInput(13)));
//        System.out.println("Day13, Part2: " + day13_1(pathOfInput(13)));
//        System.out.println("Day14, Part1: " + day14_1(pathOfInput(14)));
//        System.out.println("Day14, Part2: " + day14_2(pathOfInput(14)));

    }

    public static Path pathOfInput(int day) {
        return day <= 9 ? Path.of("src/year_2015/day0" + day + "_input.txt") : Path.of("src/year_2015/day" + day + "_input.txt");
    }

    public static int day01_1(Path path) {
        int output = 0;
        try {
            String input = Files.readString(path);
            for (char element : input.toCharArray()) {
                if (element == '(') output++;
                else if (element == ')') output--;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static int day01_2(Path path) {
        int pos = 0;
        try {
            String input = Files.readString(path);
            int output = 0;
            for (char element : input.toCharArray()) {
                pos++;
                if (element == '(') output++;
                else if (element == ')') output--;
                if (output == -1) break;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return pos;
    }

    public static int day02_1(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            for (String line : input) {
                List<Integer> values = Arrays.stream(line.split("x")).map(Integer::parseInt).toList();
                List<Integer> dimensions = new ArrayList<>(List.of(values.getFirst() * values.get(1), values.getFirst() * values.getLast(), values.getLast() * values.get(1)));
                int min = Integer.MAX_VALUE;
                for (Integer dimension : dimensions) {
                    output += dimension * 2;
                    if (dimension < min) min = dimension;
                }
                output += min;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static int day02_2(Path path) {
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            for (String line : input) {
                List<Integer> dimensions = new ArrayList<>(Arrays.stream(line.split("x")).map(Integer::parseInt).toList());
                int max = 0;
                for (Integer dimension : dimensions) if (dimension > max) max = dimension;
                dimensions.remove((Integer) max);
                output += dimensions.getFirst() + dimensions.getFirst() + dimensions.get(1) + dimensions.get(1) + (dimensions.getFirst() * dimensions.get(1) * max);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static int day03_1(Path path) {
        Set<String> houses = new HashSet<>();
        try {
            String input = Files.readString(path);
            int x = 1, y = 1;
            houses.add(x + ", " + y);
            for (char line : input.toCharArray()) {
                switch (line) {
                    case '<':
                        x--;
                        break;
                    case '>':
                        x++;
                        break;
                    case 'v':
                        y--;
                        break;
                    case '^':
                        y++;
                        break;
                }
                houses.add(x + ", " + y);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return houses.size();
    }

    public static int day03_2(Path path) {
        Set<String> houses = new HashSet<>();
        try {
            String input = Files.readString(path);
            int x = 1, y = 1, xR = 1, yR = 1;
            houses.add(x + ", " + y);
            for (int i = 0; i < input.length(); i++) {
                if (i % 2 == 0) {
                    switch (input.charAt(i)) {
                        case '<':
                            x--;
                            break;
                        case '>':
                            x++;
                            break;
                        case 'v':
                            y--;
                            break;
                        case '^':
                            y++;
                            break;
                    }
                    houses.add(x + ", " + y);
                } else {
                    switch (input.charAt(i)) {
                        case '<':
                            xR--;
                            break;
                        case '>':
                            xR++;
                            break;
                        case 'v':
                            yR--;
                            break;
                        case '^':
                            yR++;
                            break;
                    }
                    houses.add(xR + ", " + yR);
                }
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return houses.size();
    }

    public static int day04_1(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int i = 0;
            byte[] array;
            do {
                array = md.digest(key.concat(Integer.toString(i++)).getBytes());
            } while (array[0] != 0 || array[1] != 0 || (array[2] >> 4 & 0xf) != 0);
            return i - 1;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return 0;
    }

    public static int day04_2(String key) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            int i = 0;
            byte[] array;
            while (true) {
                array = md.digest(key.concat(Integer.toString(i++)).getBytes());
                if (array[0] == 0 && array[1] == 0 && (array[2] >> 4 & 0xf) == 0) if (array[2] == 0) break;
            }
            return i - 1;
        } catch (Exception e) {
            e.getStackTrace();
        }
        return 0;
    }

    public static int day05_1(Path path) {
        int niceCt = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                if (Arrays.stream(new String[]{"ab", "cd", "pq", "xy"}).anyMatch(line::contains)) continue;
                int tempCt = 0;
                for (char element : line.toCharArray())
                    if (element == 'a' || element == 'e' || element == 'i' || element == 'o' || element == 'u')
                        tempCt++;
                if (tempCt < 3) continue;
                tempCt = 0;
                for (int i = 0; i < line.length() - 1; i++) if (line.charAt(i) == line.charAt(i + 1)) tempCt++;
                if (tempCt < 1) continue;
                niceCt++;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return niceCt;
    }

    public static int day05_2(Path path) {
        int niceCt = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                boolean first = false;
                boolean second = false;
                for (int i = 2; i < line.length() - 1; i++)
                    if (line.substring(i).contains(line.substring(i - 2, i))) {
                        first = true;
                        break;
                    }
                for (int i = 0; i < line.length() - 2; i++)
                    if (line.charAt(i) == line.charAt(i + 2)) {
                        second = true;
                        break;
                    }
                if (first && second) niceCt++;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return niceCt;
    }

    public static int day06_1(Path path) {
        int lightCt = 0;
        try {
            boolean[][] grid = new boolean[1000][1000];
            for (String line : Files.readAllLines(path)) {
                int rowStart, colStart, rowEnd, colEnd;
                if (line.startsWith("turn")) {
                    line = line.replaceFirst("turn ", "");
                    if (line.startsWith("on")) {
                        line = line.replaceFirst("on ", "");
                        List<Integer> cords = day06_1_extractCoordinates(line);
                        rowStart = cords.getFirst();
                        colStart = cords.get(1);
                        rowEnd = cords.get(2);
                        colEnd = cords.getLast();
                        if (rowStart >= 1000 || rowEnd >= 1000 || colStart >= 1000 || colEnd >= 1000) continue;
                        for (int i = rowStart; i <= rowEnd; i++)
                            for (int k = colStart; k <= colEnd; k++) grid[i][k] = true;
                    } else {
                        line = line.replaceFirst("off ", "");
                        List<Integer> cords = day06_1_extractCoordinates(line);
                        rowStart = cords.getFirst();
                        colStart = cords.get(1);
                        rowEnd = cords.get(2);
                        colEnd = cords.getLast();
                        for (int i = rowStart; i <= rowEnd; i++)
                            for (int k = colStart; k <= colEnd; k++) grid[i][k] = false;
                    }
                } else {
                    line = line.replaceFirst("toggle ", "");
                    List<Integer> cords = day06_1_extractCoordinates(line);
                    rowStart = cords.getFirst();
                    colStart = cords.get(1);
                    rowEnd = cords.get(2);
                    colEnd = cords.getLast();
                    for (int i = rowStart; i <= rowEnd; i++)
                        for (int k = colStart; k <= colEnd; k++) grid[i][k] = !grid[i][k];
                }
            }
            for (boolean[] row : grid) for (boolean light : row) if (light) lightCt++;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return lightCt;
    }

    public static List<Integer> day06_1_extractCoordinates(String line) {
        List<Integer> coordinates = new ArrayList<>();
        for (String part : line.replaceAll(" ", "").split("through")) {
            coordinates.add(Integer.parseInt(part.split(",")[0]));
            coordinates.add(Integer.parseInt(part.split(",")[1]));
        }
        return coordinates;
    }

    public static int day06_2(Path path) {
        int totalBrightness = 0;
        try {
            int[][] grid = new int[1000][1000];
            for (String line : Files.readAllLines(path)) {
                int rowStart, colStart, rowEnd, colEnd;
                if (line.startsWith("turn")) {
                    line = line.replaceFirst("turn ", "");
                    if (line.startsWith("on")) {
                        line = line.replaceFirst("on ", "");
                        List<Integer> cords = day06_1_extractCoordinates(line);
                        rowStart = cords.getFirst();
                        colStart = cords.get(1);
                        rowEnd = cords.get(2);
                        colEnd = cords.getLast();
                        if (rowStart >= 1000 || rowEnd >= 1000 || colStart >= 1000 || colEnd >= 1000) continue;
                        for (int i = rowStart; i <= rowEnd; i++)
                            for (int k = colStart; k <= colEnd; k++) grid[i][k] += 1;
                    } else {
                        line = line.replaceFirst("off ", "");
                        List<Integer> cords = day06_1_extractCoordinates(line);
                        rowStart = cords.getFirst();
                        colStart = cords.get(1);
                        rowEnd = cords.get(2);
                        colEnd = cords.getLast();
                        for (int i = rowStart; i <= rowEnd; i++)
                            for (int k = colStart; k <= colEnd; k++) if (grid[i][k] != 0) grid[i][k] -= 1;
                    }
                } else {
                    line = line.replaceFirst("toggle ", "");
                    List<Integer> cords = day06_1_extractCoordinates(line);
                    rowStart = cords.getFirst();
                    colStart = cords.get(1);
                    rowEnd = cords.get(2);
                    colEnd = cords.getLast();
                    for (int i = rowStart; i <= rowEnd; i++)
                        for (int k = colStart; k <= colEnd; k++) grid[i][k] += 2;
                }
            }
            for (int[] row : grid) for (int light : row) totalBrightness += light;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return totalBrightness;
    }

    public static int day07_1(Path path) {
        Map<String, Integer> values = new TreeMap<>();
        try {
            List<String> lines = Files.readAllLines(path);
            for (String s : lines) {
                String[] parts = s.split(" -> ");
                int set;
                if (parts[0].contains("AND")) {
                    String[] split = parts[0].split(" AND ");
                    set = values.get(split[0]) & values.get(split[1]);
                } else if (parts[0].contains("NOT")) {
                    int temp = values.get(parts[0].split("NOT ")[1]);
                    set = ~temp & 0xFFFF;
                } else if (parts[0].contains("LSHIFT")) {
                    String[] split = parts[0].split(" LSHIFT ");
                    set = values.get(split[0]) << Integer.parseInt(split[1]);
                } else if (parts[0].contains("RSHIFT")) {
                    String[] split = parts[0].split(" RSHIFT ");
                    set = values.get(split[0]) >>> Integer.parseInt(split[1]);
                } else if (parts[0].contains("OR")) {
                    String[] split = parts[0].split(" OR ");
                    set = values.get(split[0]) | values.get(split[1]);
                } else set = Integer.parseInt(parts[0]);
                values.put(parts[1], set);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(values);
        return values.get("a");
    }

    public static int day07_2(Path path) {
        return 0;
    }

    public static int day08_1(Path path) {
        int strings = 0;
        int memory = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                strings += line.length();
                int ct = 0;
                for (int i = 1; i < line.length() - 1; i++) {
                    if (line.charAt(i) == '\\') {
                        if (line.charAt(i + 1) == '\\' || line.charAt(i + 1) == '"') {
                            ct++;
                            i++;
                        } else if (line.charAt(i + 1) == 'x') {
                            ct++;
                            i += 3;
                        }
                    } else ct++;
                }
                memory += ct;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return strings - memory;
    }

    public static int day08_2(Path path) {
        int original = 0;
        int processed = 0;
        try {
            for (String line : Files.readAllLines(path)) {
                original += line.length();
                int ct = 2;
                for (int i = 0; i < line.length(); i++) {
                    if (line.charAt(i) == '\"' || line.charAt(i) == '\\') ct += 2;
                    else ct++;
                }
                processed += ct;
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return processed - original;
    }

    public static int day09_1(Path path) {
        //Unfinished
        int output = 0;
        try {
            List<String> input = Files.readAllLines(path);
            List<List<String>> values = new ArrayList<>();
            Set<String> locations = new TreeSet<>();
            for (String line : input)
                values.add(List.of(line.substring(0, line.indexOf(" to ")), line.substring(line.indexOf(" to ") + 4, line.indexOf(" = ")), line.substring(line.indexOf(" = ") + 3)));
            for (List<String> value : values) {
                locations.add(value.getFirst());
                locations.add(value.get(1));
            }
            System.out.println(locations);
        } catch (IOException e) {
            e.getStackTrace();
        }
        return output;
    }

    public static int day09_2(Path path) {
        int output = 0;
        output++;
        return output;
    }

    public static int day10_1(String input, int repeat) {
        StringBuilder output = new StringBuilder();
        for (int k = 0; k < repeat; k++) {
            int ct = 0;
            char thisChar = 0;
            for (int i = 0; i < input.length(); i++) {
                if (i == 0) thisChar = input.charAt(0);
                if (input.charAt(i) != thisChar) {
                    output.append(ct).append(thisChar);
                    thisChar = input.charAt(i);
                    ct = 1;
                } else ct++;
            }
            input = String.valueOf(output.append(ct).append(thisChar));
            output = new StringBuilder();
        }
        return input.length();
    }

    public static int day10_2(String input, int repeat) {
        return day10_1(input, repeat);
    }

    public static int day11_1(String input) {
        return 0;
    }

    public static int day11_2(String input) {
        return 0;
    }

    public static int day12_1(Path path) {
//        Problem: Strings sollen nicht gezählt werden und bei mehrstelligen Zahlen werden alle stellen einzeln addiert!
        int value = 0;
        try {
            for (String line : Files.readAllLines(path))
                for (int i = 0; i < line.length(); i++) {
                    if (Character.isDigit(line.charAt(i))) {
                        int digit = Integer.parseInt(String.valueOf(line.charAt(i)));
                        if (line.charAt(i - 1) == '-') value += digit * -1;
                        else value += digit;
                    }
                }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return value;
    }

    public static int day12_2(Path path) {
//        try {
//            for (String line : Files.readAllLines(path)) {
//
//            }
//        } catch (IOException e) {
//            e.getStackTrace();
//        }
        return 0;
    }

    public static int day13_1(Path path) {
        int totalHappiness = 0;
        try {
            List<String> input = Files.readAllLines(path);
            Set<String> names = new HashSet<>();
            for (String line : input) {
                names.add(line.substring(0, line.indexOf(' ')));

            }
            System.out.println(names);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalHappiness;
    }

    public static int day13_2(Path path) {
        int totalHappiness = 0;
        try {
            List<String> input = Files.readAllLines(path);
            Set<String> names = new HashSet<>();
            for (String line : input) {
                names.add(line.substring(0, line.indexOf(' ')));

            }
            System.out.println(names);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return totalHappiness;
    }

    public static int day14_1(Path path) {
        int maxDistance = 0;
        try {
            List<String> input = Files.readAllLines(path);
            Map<String, long[]> reindeer = new HashMap<>();

            for (String line : input) {
                String[] words = line.split(" ");
                long speed = Integer.parseInt(words[3]); // Geschwindigkeit
                long duration = Integer.parseInt(words[6]); // Dauer der Bewegung
                long restTime = Integer.parseInt(words[13]); // Ruhezeit

                int totalTime = 2503; // Gesamtzeit
                int cycleTime = (int) (duration + restTime); // Bewegungszeit + Ruhezeit
                int fullCycles = totalTime / cycleTime; // Wie viele vollständige Zyklen
                int remainingTime = totalTime % cycleTime; // Restsekunden nach den vollständigen Zyklen

                long distance = fullCycles * speed * duration; // Distanz in den vollständigen Zyklen

                // Restliche Zeit prüfen: Ist sie größer als die Bewegungsdauer, dann die gesamte Bewegungsdauer hinzufügen
                if (remainingTime >= duration) {
                    distance += speed * duration;
                } else {
                    // Wenn nicht, dann nur für die restlichen Sekunden
                    distance += speed * remainingTime;
                }
                maxDistance = Math.max(maxDistance, (int) distance);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return maxDistance;
    }

    public static int day14_2(Path path) {
        int maxDistance = 0;
        try {
            List<String> input = Files.readAllLines(path);
            Map<String, long[]> reindeer = new HashMap<>();

            for (String line : input) {
                String[] words = line.split(" ");
                long speed = Integer.parseInt(words[3]); // Geschwindigkeit
                long duration = Integer.parseInt(words[6]); // Dauer der Bewegung
                long restTime = Integer.parseInt(words[13]); // Ruhezeit


                int totalTime = 2503; // Gesamtzeit
                int cycleTime = (int) (duration + restTime); // Bewegungszeit + Ruhezeit
                int fullCycles = totalTime / cycleTime; // Wie viele vollständige Zyklen
                int remainingTime = totalTime % cycleTime; // Restsekunden nach den vollständigen Zyklen

                long distance = fullCycles * speed * duration; // Distanz in den vollständigen Zyklen

                // Restliche Zeit prüfen: Ist sie größer als die Bewegungsdauer, dann die gesamte Bewegungsdauer hinzufügen
                if (remainingTime >= duration) {
                    distance += speed * duration;
                } else {
                    // Wenn nicht, dann nur für die restlichen Sekunden
                    distance += speed * remainingTime;
                }
                maxDistance = Math.max(maxDistance, (int) distance);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return maxDistance;
    }
}