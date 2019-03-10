//02. Raw Data

package F_ObjectsAndClasses.MoreExercise.RawData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsList = new ArrayList<>();

        while (n-- > 0) {
            carsList.add(new Car(scanner.nextLine().split("\\s+")));
        }

        switch (scanner.nextLine().toLowerCase()) {
            case "fragile":
                carsList.stream()
                        .filter(e -> e.getCargo().getType().equals("fragile"))
                        .filter(e -> e.getTire().getPressure() < 1)
                        .forEach(Car::printModel);
                break;
            case "flamable":
                carsList.stream()
                        .filter(e -> e.getCargo().getType().equals("flamable"))
                        .filter(e -> e.getEngine().getPower() > 250)
                        .forEach(Car::printModel);
                break;
        }
    }
}
