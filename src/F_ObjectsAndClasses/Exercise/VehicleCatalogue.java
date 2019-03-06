//06. Vehicle Catalogue

package F_ObjectsAndClasses.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue {

    private String type;
    private String model;
    private String color;
    private int power;

    private String getType() { return type; }
    private String getModel() { return model; }
    private int getPower() { return power; }

    private VehicleCatalogue(String type, String model, String color, int power) {
        this.type = type.substring(0, 1).toUpperCase() + type.substring(1).toLowerCase();
        this.model = model.substring(0, 1).toUpperCase() + model.substring(1).toLowerCase();
        this.color = color.toLowerCase();
        this.power = power;
    }

    private void print() {
        System.out.printf("%nType: %s%nModel: %s%nColor: %s%nHorsepower: %d",this.type, this.model, this.color, this.power);
    }

    private static void averagePower(List<VehicleCatalogue> list, String typeVehicle) {
        long carPower = list.stream().filter(o -> o.getType().equals(typeVehicle)).mapToLong(VehicleCatalogue::getPower).sum();
        long carCount = list.stream().filter(o -> o.getType().equals(typeVehicle)).count();
        System.out.printf("%n%ss have average horsepower of: %.2f.", typeVehicle, carCount == 0? 0 : (double)carPower / carCount);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        List<VehicleCatalogue> catalogue = new ArrayList<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            VehicleCatalogue vehicle = new VehicleCatalogue(data[0], data[1], data[2], Integer.parseInt(data[3]));
            catalogue.add(vehicle);
        }

        while (!"Close the Catalogue".equals(input = scanner.nextLine())) {
            String inputModel = input;
            catalogue.stream().filter(e -> e.getModel().equals(inputModel)).forEach(VehicleCatalogue::print);
        }

        averagePower(catalogue, "Car");
        averagePower(catalogue, "Truck");
    }
}
