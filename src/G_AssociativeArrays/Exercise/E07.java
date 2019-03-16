//07. Student Academy

package G_AssociativeArrays.Exercise;

import java.util.*;

public class E07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        while (count-- > 0) {
            String studentName = scanner.nextLine();
            double studentGrade = Double.parseDouble(scanner.nextLine());

            students.putIfAbsent(studentName, new ArrayList<>());
            List<Double> grades = students.get(studentName);
            grades.add(studentGrade);
        }

        students
                .entrySet()
                .stream()
                .filter(e -> getAverage(e.getValue()) >= 4.5)
                .sorted((a, b) -> Double.compare(getAverage(b.getValue()), getAverage(a.getValue())))
                .forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), getAverage(e.getValue()))));
    }

    private static double getAverage(List<Double> list ) {
        return list.size() > 0 ? list.stream().mapToDouble(a -> a).average().getAsDouble() : 0.0;
    }
}
