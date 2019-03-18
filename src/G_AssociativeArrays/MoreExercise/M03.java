//03. MOBA Challenger

package G_AssociativeArrays.MoreExercise;

import java.util.*;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Player> playersMap = new HashMap<>();

        while (!"Season end".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.replaceAll(" ", "").split("(->)");

            if (data.length == 3) {
                String playerName = data[0];
                String position = data[1];
                int skill = Integer.parseInt(data[2]);

                playersMap.putIfAbsent(playerName, new Player(playerName));
                Player player = playersMap.get(playerName);
                player.addSkill(position, skill);
            } else {
                data = input.split("\\s+", -1);
                if (data.length == 3 && data[1].equalsIgnoreCase("vs")) {
                    Player player1 = playersMap.get(data[0]);
                    Player player2 = playersMap.get(data[2]);
                    if (player1 != null && player2 != null) {

                        int winner = playersDuel(player1, player2);

                        if (winner == 1) playersMap.remove(player2.getName());
                        if (winner == 2) playersMap.remove(player1.getName());
                    }
                }
            }
        }

        playersMap.entrySet()
                .stream()
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getValue().getTotalSkill(), x.getValue().getTotalSkill());
                    if (sort == 0) sort = x.getKey().compareTo(y.getKey());
                    return sort;
                })
                .forEach(entry -> entry.getValue().printPlayerStats());
    }

    private static int playersDuel(Player p1, Player p2) {
        int duels = 0;
        int winsP1 = 0;
        int winsP2 = 0;

        for (Map.Entry<String, Integer> entry : p1.getPositions().entrySet()) {
            String position = entry.getKey();
            if (p2.getPositions().containsKey(position)) {
                int skill1 = p1.getSkill(position);
                int skill2 = p2.getSkill(position);
                duels++;
                if (skill1 > skill2) winsP1++;
                if (skill2 > skill1) winsP2++;
            }
        }

        return winsP1 > winsP2 ? 1 : winsP2 > winsP1 ? 2 : 0;
     }
}

class Player {
    private String name;
    private int totalSkill;
    private Map<String, Integer> positions;


    String getName() { return name; }
    void setName(String name) { this.name = name; }
    int getTotalSkill() { return totalSkill; }
    Map<String, Integer> getPositions() { return positions; }

    Player(String name) {
        this.name = name;
        this.totalSkill = 0;
        this.positions = new HashMap<>();
    }

    void addSkill(String position, int skill) {
        this.positions.putIfAbsent(position, 0);
        int oldSkill = positions.get(position);
        if (oldSkill < skill) {
            this.positions.put(position, skill);
            this.totalSkill += skill - oldSkill;
        }
    }

    int getSkill(String position) {
       return  this.positions.get(position);
    }

    void printPlayerStats() {
        System.out.println(String.format("%s: %d skill", this.name, this.getTotalSkill()));
        this.getPositions()
                .entrySet()
                .stream()
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getValue(), x.getValue());
                    if (sort == 0) sort = x.getKey().compareTo(y.getKey());
                    return sort;
                })
                .forEach(entry -> System.out.println(String.format("- %s <::> %d", entry.getKey(), entry.getValue())));
    }
}
