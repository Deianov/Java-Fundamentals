//05. SoftUni Parking

package G_AssociativeArrays.Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class E05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, User>  map = new LinkedHashMap<>();

        while (count-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            String command = data[0].toLowerCase();
            if (data.length < 2) continue;
            String name = data[1];

            map.putIfAbsent(name, new User(name, null));

            if ("register".equals(command)) {
                String license = data[2];
                if (map.get(name).getLicense() == null) {
                    map.get(name).setLicense(license);
                    System.out.printf("%s registered %s successfully%n", name, license);
                } else {
                    System.out.printf("ERROR: already registered with plate number %s%n", map.get(name).getLicense());
                }
            }
            if ("unregister".equals(command)) {
                if (map.get(name).getLicense() == null) {
                    System.out.printf("ERROR: user %s not found%n", name);
                } else {
                    map.get(name).setLicense(null);
                    System.out.printf("%s unregistered successfully%n", name);
                }
            }
        }

        map.entrySet()
                .stream()
                .filter(e -> e.getValue().getLicense() != null)
                .forEach(e -> e.getValue().printUser());
    }
}

class User {
    private String name;
    private String license;

    String getName() { return name; }
    void setName(String name) { this.name = name; }
    String getLicense() { return license; }
    void setLicense(String license) { this.license = license; }

    User(String name, String license) {
        this.name = name;
        this.license = license;
    }

    void printUser() {
        System.out.printf("%s => %s%n", this.getName(), this.getLicense());
    }
}