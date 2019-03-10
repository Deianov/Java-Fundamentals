package F_ObjectsAndClasses.MoreExercise.RawData;

class Car {

    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire;

    Engine getEngine() { return engine; }
    Cargo getCargo() { return cargo; }
    Tire getTire() { return tire; }

    Car(String[] car) {
        this.model = car[0];
        this.engine = new Engine(Integer.parseInt(car[1]), Integer.parseInt(car[2]));
        this.cargo = new Cargo(Integer.parseInt(car[3]), car[4]);
        this.tire = new Tire(
                Double.parseDouble(car[5]),
                Integer.parseInt(car[6]),
                Double.parseDouble(car[7]),
                Integer.parseInt(car[8]),
                Double.parseDouble(car[9]),
                Integer.parseInt(car[10]),
                Double.parseDouble(car[11]),
                Integer.parseInt(car[12]));
    }

    void printModel() {
        System.out.println(this.model);
    }
}
