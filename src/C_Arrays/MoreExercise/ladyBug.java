package C_Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class ladyBug {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int fieldSize = Integer.parseInt(scanner.nextLine());

        int[] fieldPos = new int[fieldSize];

        int[] initialIndexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();

        for (int i = 0; i < initialIndexes.length; i++) {
            int pos = initialIndexes[i];
            if (pos <= fieldPos.length - 1) {
                fieldPos[pos] = 1;
            }
        }

        String command = "";

        while (!"end".equals(command = scanner.nextLine())) {

            String[] data = Arrays.stream(command.split(" ")).filter(e -> !e.equals("")).toArray(String[]::new);
            int initialPos = Integer.parseInt(data[0]);
            int movement = Integer.parseInt(data[2]);
            String directtion = data[1];


            if (directtion.equals("right")) {
                fieldPos[initialPos] = 0;
                if (initialPos + movement <= fieldSize - 1 && fieldPos[initialPos + movement] == 0) {
                    fieldPos[initialPos + movement] = 1;
                } else {
                    while (true) {
                        movement++;
                        if (initialPos + movement <= fieldSize - 1 && initialPos + movement >= 0 && fieldPos[initialPos + movement] == 0) {
                            fieldPos[initialPos + movement] = 1;
                            break;
                        }
                        if (initialPos + movement > fieldSize - 1) {
                            break;
                        }
                    }
                }
            }
            if (directtion.equals("left")) {
                fieldPos[initialPos] = 0;
                if (initialPos - movement >= 0 && initialPos - movement <= fieldSize - 1 && fieldPos[initialPos - movement] == 0) {
                    fieldPos[initialPos - movement] = 1;
                } else {
                    while (true) {
                        movement++;
                        if (initialPos - movement >= 0 && fieldPos[initialPos - movement] == 0) {
                            fieldPos[initialPos - movement] = 1;
                            break;
                        }
                        if (initialPos - movement < 0) {
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < fieldPos.length; i++) {
            System.out.print(fieldPos[i] + " ");
        }
    }
}