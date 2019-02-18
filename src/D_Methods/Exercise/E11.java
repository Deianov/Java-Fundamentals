// 11. Array Manipulator

package D_Methods.Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class E11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int[] arr = Arrays
                .stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        while (!"end".equals(input = scanner.nextLine().toLowerCase())) {
            String[] command = input.split("\\s+");
            switch (command[0]) {
                case "exchange":
                    exchange(arr, Integer.parseInt(command[1]));
                    break;
                case "max":
                    printMaxValue(arr, command[1].equals("even"));
                    break;
                case "min":
                    printMinValue(arr, command[1].equals("even"));
                    break;
                case "first":
                    printCountValues(arr, true, Integer.parseInt(command[1]), command[2].equals("even"));
                    break;
                case "last":
                    printCountValues(arr, false, Integer.parseInt(command[1]), command[2].equals("even"));
                    break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void exchange(int[] arr, int index) {
        int length = arr.length;
        int[] temp = new int[length];

        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return;
        }
        if (index == length - 1) {return;}

        int split = index + 1;
        for (int i = 0; i < length ; i++) {
            if (split >= length) split = 0;
            temp[i] = arr[split++];
        }
        System.arraycopy(temp,0,arr,0,length);
    }

    private static void printMaxValue (int[] array, boolean isEven) {
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = -1;
        int caseEvenOdd = isEven ? 0 : 1;

        for (int i = 0; i < array.length ; i++) {
            if (array[i] % 2 == caseEvenOdd && array[i] >= maxValue) {
                maxValue = array[i];
                maxValueIndex = i;
            }
        }
        System.out.println(maxValueIndex > -1 ? maxValueIndex : "No matches");
    }

    private static void printMinValue(int[] array, boolean isEven) {
        int minValue = Integer.MAX_VALUE;
        int minValueIndex = -1;
        int caseEvenOdd = isEven ? 0 : 1;

        for (int i = 0; i < array.length ; i++) {
            if (array[i] % 2 == caseEvenOdd && array[i] <= minValue) {
                minValue = array[i];
                minValueIndex = i;
            }
        }
        System.out.println(minValueIndex > -1 ? minValueIndex : "No matches");
    }

    private static void printCountValues(int[] array, boolean isFirst, int count, boolean isEven) {
        if (count < 0 || count > array.length) {
            System.out.println("Invalid count");
            return;
        }

        int caseEvenOdd = isEven ? 0 : 1;
        int countAdded = 0;
        int[] temp = new int[array.length];

        for (int number: array) {
            if (number % 2 == caseEvenOdd) {
                temp[countAdded++] = number;
            }
        }

        if (count == 0 || countAdded == 0) {
            System.out.println("[]");
            return;
        }

        int indexStart = isFirst ? 0 : countAdded - Math.min(count, countAdded);
        int indexEnd = indexStart + Math.min(count, countAdded);
        System.out.println(Arrays.toString(Arrays.stream(temp, indexStart, indexEnd).toArray()));
    }
}
