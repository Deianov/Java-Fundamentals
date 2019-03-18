//04. Snowwhite

package G_AssociativeArrays.MoreExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class M04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<Integer, Dwarf> dwarfsMap = new LinkedHashMap<>();
        int index = 0;

        while (!"Once upon a time".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("\\s+<:>\\s+", -1);
            if (data.length < 3) continue;

            String name = data[0];
            String color = data[1];
            int physics = Integer.parseInt(data[2]);

            Dwarf sameDwarf = searchDwarf(dwarfsMap, name, color);

            if (sameDwarf == null) {
                dwarfsMap.put(index, new Dwarf(index, name, color, physics));
                index++;
            } else if (physics > sameDwarf.getPhysics()){
                dwarfsMap.remove(sameDwarf.getIndex());
                dwarfsMap.put(index, new Dwarf(index, name, color, physics));
                index++;
            }
        }

        // set count by color in Dwarf objects
        for (Dwarf dwarf : dwarfsMap.values()) {
            dwarf.setCountByColor(countColor(dwarfsMap, dwarf.getColor()));
        }

        dwarfsMap.values()
                .stream()
                .sorted((x, y) -> {
                    int sort = Integer.compare(y.getPhysics(), x.getPhysics());
                    if (sort == 0) sort = Integer.compare(y.getCountByColor(), x.getCountByColor());
                    if (sort == 0) sort = Integer.compare(x.getIndex(), y.getIndex());
                    return sort;
                })
                .forEach(Dwarf::printDwarf);
    }

    private static int countColor(Map<Integer, Dwarf> dwarfs, String color) {
        int count = 0;
        for (Dwarf dwarf : dwarfs.values()) {
            if (dwarf.getColor().equals(color)) count++;
        }
        return count;
    }

    private static Dwarf searchDwarf(Map<Integer, Dwarf> dwarfs, String name, String color) {
        for (Dwarf dwarf: dwarfs.values()) {
            if (dwarf.getName().equals(name) && dwarf.getColor().equals(color)) return dwarf;
        }
        return null;
    }
}

class Dwarf {
    private String name;
    private String color;
    private int physics;
    private int index;
    private int countByColor;

    String getName() { return name; }
    String getColor() { return color; }
    int getPhysics() { return physics; }
    int getIndex() { return index; }
    int getCountByColor() { return countByColor; }
    void setCountByColor(int countByColor) { this.countByColor = countByColor; }

    Dwarf(int index, String name, String color, int physics) {
        this.name = name;
        this.color = color;
        this.physics = physics;
        this.index = index;
        this.countByColor = 1;
    }

    void printDwarf() {
        System.out.println(String.format("(%s) %s <-> %d", this.color, this.name, this.physics));
    }
}
