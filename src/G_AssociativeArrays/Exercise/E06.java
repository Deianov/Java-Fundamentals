//06. Courses

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, List<String>> courses = new LinkedHashMap<>();

        while (!"end".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] line = input.split(" : ");
            String courseName = line[0];
            String studentName = line[1];

            courses.putIfAbsent(courseName, new ArrayList<>());
            List<String> students = courses.get(courseName);
            students.add(studentName);
            Collections.sort(students);
        }

        courses
                .entrySet()
                .stream()
                .sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEach(entry -> {
                    System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
                    entry.getValue().forEach(e -> System.out.println("-- " + e));
                });
    }
}