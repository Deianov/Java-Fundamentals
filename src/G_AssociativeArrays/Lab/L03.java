//03. Odd Occurrences

package G_AssociativeArrays.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();

        for (String word : words) {
            String wordInLowerCase = word.toLowerCase();
            if(counts.containsKey(wordInLowerCase)) {
                counts.put(wordInLowerCase, counts.get(wordInLowerCase) + 1);
            } else {
                counts.put(wordInLowerCase, 1);
            }
        }
        String result = counts.entrySet()
                .stream()
                .filter(e -> e.getValue() % 2 != 0)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
