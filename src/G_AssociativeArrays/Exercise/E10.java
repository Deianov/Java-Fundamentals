//10. SoftUni Exam Results

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // language - users - points
        Map<String, HashMap<String, Integer>> mapExams = new LinkedHashMap<>();
         // language - submissions
        Map<String, Integer> mapSubmissions = new LinkedHashMap<>();
        List<String> bannedUsers = new ArrayList<>();


        while (!"exam finished".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("(-)+");
            String userName = data[0];

            if (data.length == 3) {
                String languageName = data[1];
                int points = Integer.parseInt(data[2]);

                mapExams.putIfAbsent(languageName, new HashMap<>());
                if(mapExams.get(languageName).containsKey(userName)) {
                    int oldPoints = mapExams.get(languageName).get(userName);
                    points = Math.max(points, oldPoints);
                }
                mapExams.get(languageName).put(userName, points);

                mapSubmissions.putIfAbsent(languageName, 0);
                mapSubmissions.put(languageName, mapSubmissions.get(languageName) + 1);

            } else if (data.length == 2 && data[1].equalsIgnoreCase("banned")) {
                if (!bannedUsers.contains(userName)) {
                    bannedUsers.add(userName);
                }
            }
        }

        Map<String, Integer> mapUsers = new HashMap<>();
        for (Map.Entry<String, HashMap<String, Integer>> exam : mapExams.entrySet()) {
            for (Map.Entry<String, Integer> user : exam.getValue().entrySet()) {
                mapUsers.putIfAbsent(user.getKey(), 0);
                mapUsers.put(user.getKey(), mapUsers.get(user.getKey()) + user.getValue());
            }
        }

        System.out.println("Results:");
        mapUsers.entrySet()
                .stream()
                .filter(e -> !bannedUsers.contains(e.getKey()))
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getValue(), x.getValue());
                    if (sort == 0) { sort = x.getKey().compareTo(y.getKey()); }
                    return sort;
                })
                .forEach(entry -> System.out.println(entry.getKey() + " | " + entry.getValue()));

        System.out.println("Submissions:");
        mapSubmissions.entrySet()
                .stream()
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getValue(), x.getValue());
                    if (sort == 0) { sort = x.getKey().compareTo(y.getKey()); }
                    return sort;
                })
                .forEach(entry -> System.out.println(String.format("%s - %d", entry.getKey(), entry.getValue())));
    }
}