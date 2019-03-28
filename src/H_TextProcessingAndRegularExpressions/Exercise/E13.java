//13. Nether Realms
package H_TextProcessingAndRegularExpressions.Exercise;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E13 {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();

        Pattern patternCodes = Pattern.compile("([^0-9\\+\\-\\*\\/\\.])");
        Pattern patternNumbers = Pattern.compile("((?:[-+]?\\d+\\.\\d+)|(?:[-+]?\\d+)|(?:[\\*\\/]))");

        Map<String, Demon> demonMap = new TreeMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (String name : input.split("\\s*,\\s*")) {

            stringBuilder.setLength(0);
            Matcher matcherPoints = patternCodes.matcher(name);
            while (matcherPoints.find()) {
                stringBuilder.append(matcherPoints.group(1));
            }
            int health = stringBuilder.codePoints().sum();

            double damage = 0;
            double damageSymbols = 1.0;
            Matcher matcher = patternNumbers.matcher(name);
            while (matcher.find()) {
                String value = matcher.group(1);
                switch (value) {
                    case "*" : damageSymbols *= 2.0;break;
                    case "/" : damageSymbols /= 2.0;break;
                    default:
                        damage = damage + Double.parseDouble(matcher.group(1));
                        break;
                }
            }
            damage = damage * damageSymbols;
            demonMap.put(name, new Demon(name, health, damage));
        }
        demonMap.values().forEach(Demon::printDemon);
    }
}

class Demon {
    private String name;
    private int health;
    private double damage;

    public String getName() { return name; }

    Demon(String name, int health, double damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    void printDemon(){
        System.out.println(String.format("%s - %d health, %.2f damage", this.name, this.health, this.damage));
    }
}