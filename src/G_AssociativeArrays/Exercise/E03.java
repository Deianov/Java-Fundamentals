//03. Legendary Farming

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> materials = new HashMap<>();
        materials.put("shards", 0);
        materials.put("fragments", 0);
        materials.put("motes", 0);

        String item = null;
        boolean end = false;

        while (!end) {
            String data[] = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < data.length ; i = i + 2) {

                int quantity = Integer.parseInt(data[i]);
                String material = data[i + 1];

                materials.putIfAbsent(material, 0);
                int newQuantity = materials.get(material) + quantity;
                materials.put(material, newQuantity);
                if (newQuantity >= 250 && isLegendary(material) != null ) {
                    materials.put(material, newQuantity - 250);
                    item = isLegendary(material);
                    end = true;
                    break;
                }
            }
        }

        System.out.printf("%s obtained!%n", item);
        materials
                .entrySet()
                .stream()
                .filter(entry -> isLegendary(entry.getKey()) != null)
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                .thenComparing(Map.Entry.comparingByKey()))
                .forEach(E03::printMaterial);
        materials
                .entrySet()
                .stream()
                .filter(entry -> isLegendary(entry.getKey()) == null)
                .sorted(Map.Entry.comparingByKey())
                .forEach(E03::printMaterial);
    }

    private static void printMaterial (Map.Entry<String, Integer> entry) {
        System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
    }

    private static String isLegendary(String mamaterial) {
        switch (mamaterial) {
            case "shards": return "Shadowmourne";
            case "fragments": return "Valanyr";
            case "motes": return "Dragonwrath";
            default: return null;
        }
    }
}
