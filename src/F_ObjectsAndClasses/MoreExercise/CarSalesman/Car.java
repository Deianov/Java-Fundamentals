package F_ObjectsAndClasses.MoreExercise.CarSalesman;

class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    private String getModel() { return model; }
    private Engine getEngine() { return engine; }
    private String getWeight() { return weight; }
    private String getColor() { return color; }

    Car(String[] data) {
        this.model = data[0];
        this.engine = Engines.getEngine(data[1]);
        this.weight = "n/a";
        this.color = "n/a";

        if (data.length == 3) {
            if (Main.isInteger(data[2])) this.weight = data[2];
            else this.color = data[2];
        } else if (data.length > 3) {
            if (Main.isInteger(data[2])) {
                this.weight = data[2];
                this.color = data[3];
            } else {
                this.weight = data[3];
                this.color = data[2];
            }
        }
    }

    void printCar() {
        System.out.printf("%n%s:", this.getModel());
        this.getEngine().printEngine();
        System.out.printf("%nWeight: %s%nColor: %s", this.getWeight(), this.getColor());
    }
}
