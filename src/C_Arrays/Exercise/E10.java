// 10. LadyBugs

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int fieldSize = Integer.parseInt(input);

        // Base field
        int[] baseIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] field = new int[fieldSize];
        for (int i : baseIndexes) {
            if (i >= 0 && i < fieldSize) {
                field[i] = 1;
            }
        }

        String[] command = new String[fieldSize];
        int oldIndex = -1;
        int flyLength = 0;
        int direction = 0;
        int newIndex = -1;

        while (!"end".equals(input = scanner.nextLine())) {
            command = input.split(" ");
            oldIndex = Integer.parseInt(command[0]);
            direction = command[1].equals("left") ? -1 : 1;
            flyLength = Integer.parseInt(command[2]);

            // empty/outside base field, zero length
            if (oldIndex < 0 || oldIndex > fieldSize - 1 || flyLength == 0 || field[oldIndex] == 0) continue;

            // calculate new index
            newIndex = oldIndex;
            while (true) {
                newIndex += flyLength * direction;
                if (newIndex < 0 || newIndex > fieldSize - 1) {
                    newIndex = -1;
                    break;
                } else if (field[newIndex] == 0) {
                    break;
                }
            }

            // delete last index
            field[oldIndex] = 0;
            // fly to new index
            if (newIndex >= 0) field[newIndex] = 1;
        }
        System.out.println(Arrays.stream(field).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
    }
}
