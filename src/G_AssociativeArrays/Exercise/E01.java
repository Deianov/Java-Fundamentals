//01. Count Chars in a String

package G_AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine().replaceAll(" ", "");

        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < text.length() ; i++) {
            String c = Character.toString(text.charAt(i));

            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }

        map.entrySet().forEach(entry -> System.out.println(forPrint(entry)));
    }

    private static String forPrint (Map.Entry<String, Integer> entry) {
        return String.format("%s -> %d", entry.getKey(), entry.getValue());
    }
}
