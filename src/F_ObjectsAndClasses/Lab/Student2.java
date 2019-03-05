//06. Students 2.0

package F_ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Student2 {
    private String firstName;
    private String lastName;
    private int age;
    private String city;

    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getFirstName() { return firstName; }

    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getLastName() { return lastName; }

    public void setAge(int age) { this.age = age; }
    public int getAge() { return age; }

    public void setCity(String city) { this.city = city; }
    public String getCity() { return city; }

    private Student2(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        List<Student2> studentsList = new ArrayList<>();

        while (!"end".equals(line = scanner.nextLine())) {
            String[] fields = line.split(" ");

            String firstName = fields[0];
            String lastName = fields[1];
            int age = Integer.parseInt(fields[2]);
            String city = fields[3];

            Student2 student = new Student2(firstName, lastName, age, city);
            studentsList.add(student);
        }

        String city = scanner.nextLine();
        List<Student2> filter = studentsList.stream().filter(e -> e.getCity().equals(city)).collect(Collectors.toList());

        for (Student2 student : filter) {
            student.print();
        }
    }

    private void print() {
        System.out.printf("%s %s is %d years old%n", this.firstName, this.lastName, this.age);
    }
}
