//02. Word Synonyms

package G_AssociativeArrays.Lab;

import java.util.*;

public class L02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, List<String>> map = new LinkedHashMap<>();

        while (n-- > 0) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            map.putIfAbsent(word, new ArrayList<>());
            map.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
