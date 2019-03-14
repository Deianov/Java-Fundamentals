//05. Drum Set

package E_ArrayList.MoreExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double savings = Double.parseDouble(input);

        input = scanner.nextLine();
        List<Integer> drumsListOrigin = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> drumsList = new ArrayList<>(drumsListOrigin);

        while (!"Hit it again, Gabsy!".equalsIgnoreCase(input = scanner.nextLine())) {
            int power = Integer.parseInt(input);
            int breakIndex;

            drumsList = drumsList.stream().map(e -> e - power).collect(Collectors.toList());

            while ((breakIndex = getBreakIndex(drumsList)) >= 0) {
                int drumBasePower = drumsListOrigin.get(breakIndex);
                int drumPrice = drumBasePower * 3;

                if (drumPrice <= savings) {
                    drumsList.set(breakIndex, drumBasePower);
                    savings = savings - drumPrice;
                } else {
                    drumsList.remove(breakIndex);
                    drumsListOrigin.remove(breakIndex);
                }
            }
        }

        printArrayList(drumsList);
        System.out.printf("Gabsy has %.2flv.", savings);
    }

    private static void printArrayList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }

    private static int getBreakIndex(List<Integer> list) {
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i) <= 0) {
                return i;
            }
        }
        return -1;
    }
}
