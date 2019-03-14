//09. Pokemon Don't Go

package E_ArrayList.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Long> distances = Arrays.stream(scanner.nextLine().split("\\s+")).map(Long::parseLong).collect(Collectors.toList());
        long removed = 0;
        Long element;

        while (distances.size() > 0) {
            int index = Integer.parseInt(scanner.nextLine().replaceAll("( )+", ""));
            element = getArrayListValue(distances, index);
            if (element == null) {
                // the given index is LESS than 0
                if (index < 0) {
                    element = distances.get(0);
                    distances.remove(0);
                    removed += element;
                    increaseElements(distances, element);
                    distances.add(0, distances.get(distances.size() - 1));
                // the given index is GREATER than the last index
                } else {
                    element = distances.get(distances.size() - 1);
                    distances.remove(distances.size() - 1);
                    removed += element;
                    increaseElements(distances, element);
                    distances.add(distances.get(0));
                }
            } else {
                distances.remove(index);
                removed += element;
                increaseElements(distances, element);
            }
        }

        System.out.println(removed);
    }

    private static void increaseElements(List<Long> list, long value) {
        for (int i = 0; i < list.size() ; i++) {
            long listValue = list.get(i);
            // set increased/decreased value
            list.set(i, listValue > value ? listValue - value : listValue + value);
        }
    }

    private static Long getArrayListValue(List<Long> list, int index) {
        Long result = null;
        if (list.size() > 0 && index >= 0 && index < list.size()) {
            result = list.get(index);
        }
        return result;
    }
}
