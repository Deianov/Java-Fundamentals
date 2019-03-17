//03. MOBA Challenger

package G_AssociativeArrays.MoreExercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class M03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    }
}

class Player {
    private String name;
    private int totalSkill;
    private Map<String, Integer> positions;


    String getName() { return name; }
    void setName(String name) { this.name = name; }
    int getTotalSkill() { return totalSkill; }
    void setTotalSkill(int totalSkill) { this.totalSkill = totalSkill; }

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
}
