//12. Star Enigma
package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int attacked = 0;
        int destroyed = 0;

        Map<String, String> planetsMap = new TreeMap<>();

        Pattern patternCount = Pattern.compile("[starSTAR]");
        Pattern pattern = Pattern.compile("[^@]*@[^A-Za-z@!:>-]*([A-Z][a-z]+)[^A-Za-z@!:>-]*:[^0-9@!:>-]*\\d+[^0-9@!:>-]*![^AD@!:>-]*([AD])[^AD@!:>-]*![^@!:>-]*->[^0-9@!:>-]*\\d+");

        StringBuilder stringBuilder = new StringBuilder();

        while (count-- > 0) {
            String msg = scanner.nextLine();
            int offset = 0;
            stringBuilder.setLength(0);

            Matcher matcher = patternCount.matcher(msg);
            while (matcher.find()) {
                offset++;
            }

            for (int c : msg.toCharArray()) {
                stringBuilder.append((char)(c - offset));
            }

            matcher = pattern.matcher(stringBuilder.toString());
            if (matcher.find()) {
                String name = matcher.group(1);
                String type = matcher.group(2).toUpperCase();
                planetsMap.putIfAbsent(name, type);
                if (type.equals("A")) attacked++;
                else destroyed++;
            }
        }

        System.out.println(String.format("Attacked planets: %d", attacked));
        planetsMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals("A"))
                .forEach(e -> System.out.println("-> " + e.getKey()));

        System.out.println(String.format("Destroyed planets: %d", destroyed));
        planetsMap.entrySet()
                .stream()
                .filter(e -> e.getValue().equals("D"))
                .forEach(e -> System.out.println("-> " + e.getKey()));
    }
}
