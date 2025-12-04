package year_2024.day09;

import allg.aoc_allg;

import java.util.ArrayList;
import java.util.List;

public class year2024_day09 {
    public static void main(String[] args) {
//        System.out.println(day09_part1());
        System.out.println(day09_part2());
    }

    public static long day09_part1() {
        List<String> lines = aoc_allg.readFile("src/year_2024/day09/day09_input.txt"); //Speichert input in line Liste
        String input = lines.getFirst(); //speichert zeile in string line
        List<Block> blocks = loadInput(input); //nimmt objekte mit allen blocken an
        int front = 0, back = blocks.size() - 1; //indexe von vorne und von hinten
        while (front < back) { //wird ausgeführt so lange der vorne index nicht größer als der hintere index wird.
            Block frontBlock = blocks.get(front); //nimmt den block von vorne am index vorne
            Block backBlock = blocks.get(back); //nimmt den block von hinten am index hinten
            while (frontBlock.free > 0) { //wird ausgeführt so lange der freie space nach dem aktuellen front block großer als 0 ist
                if (backBlock.length <= 0) { //wenn der block von hinten leer ist, dann gehe einen block nach vorne
                    blocks.remove(backBlock); //entfernen den leeren block
                    back--;
                    if (front == back) break; //wenn die zwei indexe an der gleichen Stelle sind → abbruch
                    backBlock = blocks.get(back); //neuen letzten block definieren
                }
                frontBlock.space.add(backBlock.id); //beim vorderen block wird die originale Stelle eingefügt
                frontBlock.free--; //der freie Platz des blockes wird verkleinert
                backBlock.length--; //die länge des verschobenen objektes wird verkleinert
            }
            front++; //Es wird zum nächsten element von vorne gegangen, wenn der freie Platz am element weg ist
        }
        return getOutput(blocks);
    }

    public static long day09_part2() {
        List<String> lines = aoc_allg.readFile("src/year_2024/day09/day09_input.txt"); //Speichert input in line Liste
        String input = lines.getFirst(); //speichert zeile in string line
        List<Block> blocks = loadInput(input); //nimmt objekte mit allen blocken an
        int front = 0, back = blocks.size() - 1; //indexe von vorne und von hinten
        while (front < back) { //wird ausgeführt so lange der vorne index nicht größer als der hintere index wird.
            Block frontBlock = blocks.get(front); //nimmt den block von vorne am index vorne
            Block backBlock = blocks.get(back); //nimmt den block von hinten am index hinten
            while (frontBlock.free >= backBlock.length) { //wird ausgeführt so lange der freie space nach dem aktuellen front block großer als 0 ist
                if (backBlock.length <= 0) { //wenn der block von hinten leer ist, dann gehe einen block nach vorne
                    blocks.remove(backBlock); //entfernen den leeren block
                    back--;
                    if (front == back) break; //wenn die zwei indexe an der gleichen Stelle sind → abbruch
                    backBlock = blocks.get(back); //neuen letzten block definieren
                }
                for (int pos = 0; pos < backBlock.length; pos++) {
                    frontBlock.space.add(backBlock.id); //alle teile von backBlock werden als ID in den space von frontBlock gespeichert
                }
                frontBlock.free -= backBlock.length; //der freie Platz des blockes wird um die länge von dem Back Block verkleinert
                backBlock.length = 0; //die länge des verschobenen objektes wird verkleinert
            }
            front++; //Es wird zum nächsten element von vorne gegangen, wenn der freie Platz am element weg ist
        }
        return getOutput(blocks);
    }

    private static long getOutput(List<Block> blocks) {
        long output = 0; //Output welcher immer erhöht wird
        long position = 0; //die aktuelle Position
        for (Block block : blocks) { //geht durch jeden block durch
            for (int i = 0; i < block.length; i++) {
                output += position * block.id; //id der originalen Blöcke mal der aktuellen position
                position++; //position wird erhöht
            }
            for (int id : block.space) {
                output += position * id; //id der verschobenen Blöcke mal der aktuellen position
                position++; //position wird erhöht
            }
        }
        return output;
    }

    private static List<Block> loadInput(String input) {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < input.length(); i += 2) { //geht durch jedes 2 element
            int len = Character.getNumericValue(input.charAt(i)); //speichert länge der speicherstelle
            int free = 0;
            if (i + 1 < input.length())
                free = Character.getNumericValue(input.charAt(i + 1)); //speichert länge des freien platzes nach der speicherstelle
            blocks.add(new Block(blocks.size(), len, free)); //erstellt neues objekt mit der aktuellen länge der block List (id), len, free
        }
        return blocks;
    }

    static class Block {
        int id, length, free;
        List<Integer> space;

        public Block(int id, int length, int free) {
            this.id = id; //Position in original input
            this.length = length; //länge der speicherstelle
            this.free = free; //freier speicher nach speicherstelle
            space = new ArrayList<>(); //der Bereich wo die verschobenen blöcke reinkommen
        }
    }
}