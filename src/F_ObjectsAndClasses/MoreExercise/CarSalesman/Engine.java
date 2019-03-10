package F_ObjectsAndClasses.MoreExercise.CarSalesman;

class Engine {
    private String model;
    private int power;
    private String displacements;
    private String efficiency;


    String getModel() {
        return model;
    }

    Engine(String model, int power, String displacements, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacements = displacements;
        this.efficiency = efficiency;
    }

    void printEngine() {
        System.out.printf("%n%s:%nPower: %d%nDisplacement: %s%nEfficiency: %s"
                ,this.model
                ,this.power
                ,this.displacements
                ,this.efficiency);
    }
}
