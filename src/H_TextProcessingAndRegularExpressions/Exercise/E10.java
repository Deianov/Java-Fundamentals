//10. Race

package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> mapParticipants = new LinkedHashMap<>();
        for (String name : input.split(", ")) {
            mapParticipants.put(name, 0);
        }

        Pattern patternLetters = Pattern.compile("[A-Za-z]+");
        Pattern patternDigits = Pattern.compile("\\d");

        while (!"end of race".equalsIgnoreCase(input = scanner.nextLine())) {
            String name = "";
            int dist = 0;

            Matcher matchLetters = patternLetters.matcher(input);
            Matcher matchDigits = patternDigits.matcher(input);

            while (matchLetters.find()) {
                name = name + matchLetters.group();
            }

            if (mapParticipants.containsKey(name)) {
                while (matchDigits.find()) {
                    dist += Integer.parseInt(matchDigits.group());
                }
                mapParticipants.put(name, mapParticipants.get(name) + dist);
            }
        }

        AtomicInteger index = new AtomicInteger();
        index.set(1);
        mapParticipants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> {
                    int i = index.getAndIncrement();
                    if (i < 4) {
                        System.out.println(String.format("%d%s place: %s", i, i == 1 ? "st" : i == 2 ? "nd" : "rd", e.getKey()));
                    }
                });
    }
}
