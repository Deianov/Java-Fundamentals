//08. Company Users

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, List<String>> companies = new TreeMap<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("( -> )");
            String companyName = data[0];
            String ID = data[1];

            companies.putIfAbsent(companyName, new ArrayList<>());
            List<String> IDs = companies.get(companyName);
            if (!IDs.contains(ID)) {
                IDs.add(ID);
            }
        }

        companies
                .entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().forEach(u -> System.out.println("-- " + u));
                });
    }
}
