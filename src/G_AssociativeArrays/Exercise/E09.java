//09. ForceBook

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // side - users
        Map<String, TreeSet<String>> sides = new LinkedHashMap<>();

        while (!"Lumpawaroo".equals(input = scanner.nextLine())) {
            boolean isMake = input.contains("|");
            String[] data = Arrays.stream(input.split("\\s+\\|\\s+|\\s+->\\s+")).toArray(String[]::new);

            if (data.length < 2 || (!isMake && !input.contains(" -> "))) continue;

            String userName = data[isMake ? 1 : 0];
            String sideName = data[isMake ? 0 : 1];

            boolean foundUser = searchUser(sides, userName);

            sides.putIfAbsent(sideName, new TreeSet<>());

            if (isMake) {
                // add user if not found
                if (!foundUser) {
                    sides.get(sideName).add(userName);
                }
            }

            if (input.contains("->")) {
                // remove user from old side
                if (foundUser) {
                    sides.forEach((key, value) -> value.remove(userName));
                }
                // register new user
                sides.get(sideName).add(userName);
                System.out.println(String.format("%s joins the %s side!", userName, sideName));
            }
        }

        sides.entrySet()
                .stream()
                .filter(entry -> entry.getValue().size() > 0)
                .sorted(Comparator.comparingInt(E09::listSize).reversed()
                        .thenComparing(Map.Entry::getKey))
                .forEach(entry -> {
                    System.out.println(String.format("Side: %s, Members: %d", entry.getKey(), entry.getValue().size()));
                    System.out.println("! " + String.join(System.lineSeparator() + "! ", entry.getValue()));
                });
    }

    private static int listSize(Map.Entry<String, TreeSet<String>> e) {
        return e.getValue().size();
    }

    private static boolean searchUser(Map<String, TreeSet<String>> map, String name) {
        for (Map.Entry<String, TreeSet<String>> entry : map.entrySet()) {
            if (entry.getValue().contains(name)) {
                return true;
            }
        }
        return false;
    }
}
