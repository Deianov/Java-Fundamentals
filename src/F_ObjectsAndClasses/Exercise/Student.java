//05. Students

package F_ObjectsAndClasses.Exercise;

        import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;
        import java.util.Scanner;

public class Student {

    private String firstName;
    private String lastName;
    private Double grade;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Double getGrade() {
        return grade;
    }

    public Student(String firstName, String lastName, Double grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grade = grade;
    }

    private void print() {
        System.out.printf("%s %s: %.2f%n", this.getFirstName(), this.getLastName(), this.getGrade());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Student> studentList = new ArrayList<>();

        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            Student student = new Student(line[0], line[1], Double.parseDouble(line[2]));
            studentList.add(student);
        }

        // sorting, revers and print
        studentList.stream()
                .sorted(Comparator.comparingDouble(Student::getGrade).reversed())
                .forEach(Student::print);
    }
}
