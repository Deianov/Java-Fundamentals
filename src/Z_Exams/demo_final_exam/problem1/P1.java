//01. Word
package Z_Exams.demo_final_exam.problem1;

import java.util.*;

public class P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> words = Arrays.asList(scanner.nextLine().toLowerCase().split("\\s+[|]\\s+"));
        String command = scanner.nextLine().toLowerCase();

        Map<String, Word> mapWords = new TreeMap<>();

        for (String s: input.split("\\s+[|]\\s+")) {
            String[] wordAndDef = s.split(": ");
            String word = wordAndDef[0];
            String def = wordAndDef[1];

            mapWords.putIfAbsent(word.toLowerCase(), new Word(word, new ArrayList<>(), words.contains(word.toLowerCase())));
            mapWords.get(word.toLowerCase()).getDefinitions().add(def);
        }

        if (command.contains("list")) {
            System.out.println(mapWords.keySet().toString().replaceAll("[\\[\\],]", ""));
        } else if (command.contains("end")) {
            mapWords.values()
                    .stream()
                    .filter(Word::isPrintable)
                    .forEach(Word::printWord);
        }
    }
}

class Word {
    private String word;
    private List<String> definitions;
    private boolean printable;

    List<String> getDefinitions() { return definitions; }
    boolean isPrintable() { return printable; }

    Word(String word, List<String> definitions, boolean printable) {
        this.word = word;
        this.definitions = definitions;
        this.printable = printable;
    }

    void printWord() {
        System.out.println(this.word);
        this.definitions.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .forEach(e -> System.out.println(" -" + e));
    }
}
