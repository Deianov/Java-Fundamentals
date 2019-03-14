//04. Word Filter

package G_AssociativeArrays.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class L04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String word : words) {
            map.putIfAbsent(word, word.length());
        }
        map.entrySet().stream().filter(e -> e.getValue() % 2 == 0).map(Map.Entry::getKey).forEach(System.out::println);
    }
}
