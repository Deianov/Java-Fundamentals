package F_ObjectsAndClasses.MoreExercise.CarSalesman;

import java.util.ArrayList;
import java.util.List;

class Engines {
    private static List<Engine> engineList = new ArrayList<>();

    Engines() {
    }

    void addEngine(String[] data) {
        String model = data[0];
        int power = Integer.parseInt(data[1]);
        String displacements = "n/a";
        String efficiency = "n/a";

        if (data.length == 3) {
            if (Main.isInteger(data[2])) displacements = data[2];
            else efficiency = data[2];
        } else if (data.length > 3) {
            if (Main.isInteger(data[2])) {
                displacements = data[2];
                efficiency = data[3];
            } else {
                displacements = data[3];
                efficiency = data[2];
            }
        }

        engineList.add(new Engine(model, power, displacements, efficiency));
    }

     static Engine getEngine(String model) {
        for (Engine engine : engineList) {
            if (engine.getModel().equalsIgnoreCase(model)) {
                return engine;
            }
        }
        return null;
    }
}
