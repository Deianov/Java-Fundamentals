//7. Order by Age

package F_ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Person2 {

    private String name;
    private String ID;
    private int age;

    private Person2(String name, String ID, int age) {
        this.name = name;
        this.ID = ID;
        this.age = age;
    }

    private String getName() { return name; }
    private String getID() { return ID; }
    private int getAge() { return age; }

    @Override
    public String toString() {
        return String.format("%s with ID: %s is %d years old.", this.getName(), this.getID(), this.getAge());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        List<Person2> person2List = new ArrayList<>();

        while (!"End".equalsIgnoreCase(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String name = data[0];
            String id = data[1];
            int age = Integer.parseInt(data[2]);

            Person2 person2 = new Person2(name, id, age);

            person2List.add(person2);
        }

        person2List.stream()
                .sorted(Comparator.comparingInt(Person2::getAge))
                .forEach(o -> System.out.println(o.toString()));
    }
}
