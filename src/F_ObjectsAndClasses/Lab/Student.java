//05. Students

package F_ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student {
    private String firstName;
    private String lastName;
    private int age;
    private String city;

    private void setFirstName(String firstName) { this.firstName = firstName; }
    private String getFirstName() { return firstName; }

    private void setLastName(String lastName) { this.lastName = lastName; }
    private String getLastName() { return lastName; }

    private void setAge(int age) { this.age = age; }
    private int getAge() { return age; }

    private void setCity(String city) { this.city = city; }
    private String getCity() { return city; }

    private Student(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        List<Student> studentsList = new ArrayList<>();

        while (!"end".equals(line = scanner.nextLine())) {
            String[] fields = line.split(" ");

            String firstName = fields[0];
            String lastName = fields[1];
            int age = Integer.parseInt(fields[2]);
            String city = fields[3];

            Student student = new Student(firstName, lastName, age, city);
            studentsList.add(student);
        }

        String city = scanner.nextLine();
        List<Student> filter = studentsList.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());

        for (Student student : filter) {
            student.print();
        }
    }

    private void print() {
        System.out.printf("%s %s is %d years old%n", this.firstName, this.lastName, this.age);
    }
}
