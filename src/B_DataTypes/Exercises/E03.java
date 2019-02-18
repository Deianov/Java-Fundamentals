package B_DataTypes.Exercises;

import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());
        int courses = 0;
        if (capacity > 0) {
            courses = people / capacity;
            if (people % capacity != 0) courses++;
        }
        System.out.println(courses);
    }
}
