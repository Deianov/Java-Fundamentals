//01. Ranking

package G_AssociativeArrays.MoreExercise;

import java.util.*;

public class M01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // contest - password
        Map<String, String> mapPasswords = new HashMap<>();
        // users - User
        Map<String, User> mapUsers = new TreeMap<>();

        while (!"end of contests".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("(:)+");
            if (data.length == 2) {
                mapPasswords.put(data[0], data[1]);
            }
        }

        while (!"end of submissions".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("=>");
            if (data.length == 4) {
                String contestName = data[0];
                String pass = data[1];
                String userName = data[2];
                int points = Integer.parseInt(data[3]);

                if (mapPasswords.containsKey(contestName) && mapPasswords.get(contestName).equals(pass)) {
                    mapUsers.putIfAbsent(userName, new User(userName));
                    User user = mapUsers.get(userName);
                    user.addContest(contestName, points);
                }
            }
        }

        User bestUser = mapUsers
                .entrySet()
                .stream()
                .max((x, y) -> x.getValue().getPoints() > y.getValue().getPoints() ? 1 : -1).get().getValue();

        String bestUserName = bestUser.getName();
        System.out.println(String.format("Best candidate is %s with total %d points.", bestUserName, bestUser.getPoints()));
        System.out.println("Ranking: ");

        mapUsers.forEach((key, value) -> value.printUser());
    }
}

class User {
    private String name;
    private int points;
    private Map<String, Integer> contests;

    String getName() { return name; }
    int getPoints() { return points; }

    User(String name) {
        this.name = name;
        this.points = 0;
        this.contests = new HashMap<>();
    }

    void addContest(String contestName, int points) {
        this.contests.putIfAbsent(contestName, 0);
        int oldPoints = this.contests.get(contestName);
        if (points > oldPoints) {
            this.contests.put(contestName, points);
            this.points += points - oldPoints;
        }
    }

    void printUser() {
        System.out.println(this.name);
        this.contests
                .entrySet()
                .stream()
                .sorted((x, y) -> Integer.compare(y.getValue(), x.getValue()))
                .forEach(entry -> {
            System.out.println(String.format("#  %s -> %d", entry.getKey(), entry.getValue()));
        });
    }
}
