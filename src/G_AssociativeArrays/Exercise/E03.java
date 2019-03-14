//03. Legendary Farming

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> keyMaterials = new LinkedHashMap<>();
        keyMaterials.put("shards", "Shadowmourne");
        keyMaterials.put("fragments", "Valanyr");
        keyMaterials.put("motes", "Dragonwrath");

        Map<String, Integer> materials = new HashMap<>();
        String item = null;

        while (true) {

            // TODO: 15.03.2019 read 
            String material = scanner.nextLine().toLowerCase();
            int quantity = Integer.parseInt(scanner.nextLine());

            materials.putIfAbsent(material, 0);
            int newQuantity = materials.get(material) + quantity;
            materials.put(material, newQuantity);
            if (newQuantity >= 250 && isLegendary(material) != null ) {
                materials.put(material, newQuantity - 250);
                item = isLegendary(material);
                break;
            }
        }

        System.out.printf("%s obtained!%n", item);
        materials.entrySet().stream()
                .filter(entry -> isLegendary(entry.getKey()) != null)
                .sorted(Map.Entry.comparingByValue())
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
