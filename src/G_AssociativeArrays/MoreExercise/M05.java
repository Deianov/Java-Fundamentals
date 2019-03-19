//05. Dragon Army

package G_AssociativeArrays.MoreExercise;

import java.util.*;

public class M05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        // type, name, dragon
        Map<String, Map<String, Dragon>> dragonTypesMap = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] data = scanner.nextLine().split("\\s+", -1);
            String type = data[0];
            String name = data[1];
            String damage = data[2];
            String health = data[3];
            String armor = data[4];

            Dragon newDragon = new Dragon(name, damage, health, armor);
            dragonTypesMap.putIfAbsent(type, new TreeMap<>());
            // name, dragon
            Map<String, Dragon> dragonNamesMap = dragonTypesMap.get(type);

            if (dragonNamesMap.containsKey(name)) {
                Dragon oldDragon = dragonNamesMap.get(newDragon.getName());
                oldDragon.setValues(newDragon.getDamage(), newDragon.getHealth(), newDragon.getArmor());
            } else {
                dragonNamesMap.put(newDragon.getName(), newDragon);
            }
        }

        dragonTypesMap
                .forEach((key, value) -> {
                    double d = value.values().stream().mapToDouble(Dragon::getDamage).average().getAsDouble();
                    double h = value.values().stream().mapToDouble(Dragon::getHealth).average().getAsDouble();
                    double a = value.values().stream().mapToDouble(Dragon::getArmor).average().getAsDouble();
                    System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", key, d, h, a));
                    value.values().forEach(Dragon::printDragon);
                });
    }
}

class Dragon {
    private String name;
    private int damage;
    private int health;
    private int armor;

    String getName() { return name; }
    int getDamage() { return damage; }
    int getHealth() { return health; }
    int getArmor() { return armor; }

    Dragon(String name, String damage, String health, String armor) {
        this.name = name;
        this.damage = getIntOrDefault(damage, 45);
        this.health = getIntOrDefault(health, 250);
        this.armor = getIntOrDefault(armor, 10);
    }

    void setValues(int damage, int health, int armor) {
        this.damage = damage;
        this.health = health;
        this.armor = armor;
    }

    void printDragon() {
        System.out.println(String.format("-%s -> damage: %d, health: %d, armor: %d",
                this.name,
                this.damage,
                this.health,
                this.armor));
    }

    private int getIntOrDefault(String value, int def) {
        try {
            return Integer.parseInt(value.replaceAll(" ", ""));
        } catch (NumberFormatException e) {
            return def;
        }
    }
}