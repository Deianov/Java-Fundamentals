//09. ForceBook

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // side - users
        Map<String, List<String>> sides = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {
            boolean isMake = input.contains(" | ");
            String[] data = input.split(isMake ? "( [|] )" : "( -> )", -1);

            if (data.length < 2 || (!isMake && !input.contains(" -> "))) continue;

            String userName = data[isMake ? 1 : 0];
            String sideName = data[isMake ? 0 : 1];

            // remove user from old side
            for (Map.Entry<String, List<String>> entry : sides.entrySet()) {
                entry.getValue().remove(userName);
            }

            if (!isMake) {
                System.out.println(String.format("%s joins the %s side!", userName, sideName));
            }

            sides.putIfAbsent(sideName, new ArrayList<>());
            sides.get(sideName).add(userName);

        }

        sides.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 0)
                .sorted(Comparator.comparingInt(E09::listSize).reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.println(String.format("Side: %s, Members: %d", entry.getKey(), entry.getValue().size()));
                    entry.getValue()
                            .stream()
                            .sorted()
                            .forEach(e -> System.out.println("! " + e));
                });
    }

    private static int listSize(Map.Entry<String, List<String>> e) {
        return e.getValue().size();
    }
}
