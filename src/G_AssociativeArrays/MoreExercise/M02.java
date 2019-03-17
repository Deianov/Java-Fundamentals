//02. Judge

package G_AssociativeArrays.MoreExercise;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class M02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        // contest - JudgeUsers
        Map<String, List<JudgeUser>> mapContests = new LinkedHashMap<>();
        // userName - JudgeUser
        Map<String, JudgeUser> mapUsers = new HashMap<>();

        while (!"no more time".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.replaceAll(" ", "").split("->");
            if (data.length != 3) continue;

            String userName = data[0];
            String contestName = data[1];
            int points = Integer.parseInt(data[2]);

            mapUsers.putIfAbsent(userName, new JudgeUser(userName));
            JudgeUser user = mapUsers.get(userName);
            mapContests.putIfAbsent(contestName, new ArrayList<>());
            List<JudgeUser> contestUsers = mapContests.get(contestName);

            if (!contestUsers.contains(user)) {
                contestUsers.add(user);
            }

            user.addContest(contestName, points);
        }

        AtomicInteger index = new AtomicInteger();
        mapContests
                .forEach((key, value) -> {
                    System.out.println(String.format("%s: %d participants", key, value.size()));
                    index.set(1);
                    value.stream()
                            .sorted((x, y) -> {
                                int sort = Integer.compare(y.getContest(key), x.getContest(key));
                                if (sort == 0) sort = x.getName().compareTo(y.getName());
                                return sort;
                            })
                            .forEach(u -> System.out.println(String.format("%d. %s <::> %d",index.getAndIncrement(), u.getName(), u.getContest(key))));
                });

        System.out.println("Individual standings: ");
        index.set(1);
        mapUsers.entrySet()
                .stream()
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getValue().getPoints(), x.getValue().getPoints());
                    if (sort == 0) { sort = x.getKey().compareTo(y.getKey()); }
                    return sort;
                })
                .forEach(entry -> System.out.println(entry.getValue().userStats(index.getAndIncrement())) );
    }
}

class JudgeUser {
    private String name;
    private int points;
    private Map<String, Integer> contests;

    String getName() { return name; }
    int getPoints() { return points; }

    JudgeUser(String name) {
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

    int getContest(String contestName) {
       return this.contests.get(contestName);
    }

    String userStats(int index) {
        return String.format("%d. %s -> %d", index, this.name, this.points);
    }
}