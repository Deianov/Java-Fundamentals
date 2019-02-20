import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        // TODO: 18.2.2019 г.
        String str = "[1, 2, 3]";
        List<Number> numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(1.0);
        numbers.add(2.5);
        numbers.add(2.5);
        System.out.println(numbers.get(0).equals(1.0));
    }
}
