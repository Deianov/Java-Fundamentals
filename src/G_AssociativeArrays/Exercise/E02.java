//02. A Miner Task

package G_AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String resource;

        Map<String, Long> resources = new LinkedHashMap<>();

        while (!"stop".equalsIgnoreCase(resource = scanner.nextLine())) {
            long quantity = Long.parseLong(scanner.nextLine());

            resources.putIfAbsent(resource, 0l);
            resources.put(resource, resources.get(resource) + quantity);
        }

        for (Map.Entry<String, Long> entry : resources.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
