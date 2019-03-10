package F_ObjectsAndClasses.MoreExercise.RawData;

class Cargo {

    private int weight;
    private String type;

    String getType() { return type; }

    Cargo(int weight, String type) {
        this.weight = weight;
        this.type = type;
    }
}
