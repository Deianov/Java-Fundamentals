//03. Car Salesman

package F_ObjectsAndClasses.MoreExercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Engines enginesList = new Engines();

        int count = Integer.parseInt(scanner.nextLine());

        while (count-- > 0) {
            enginesList.addEngine(scanner.nextLine().split("\\s+"));
        }

        count = Integer.parseInt(scanner.nextLine());

        List<Car> cars = new ArrayList<>();

        while (count-- > 0) {
            cars.add(new Car(scanner.nextLine().split("\\s+")));
        }

        cars.forEach(Car::printCar);
    }

    static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
