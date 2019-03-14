// 04. List Operations

package E_ArrayList.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> numbers = Arrays
                .stream(line.split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int number, index;

        while (!"end".equals(line = scanner.nextLine().toLowerCase())) {
            String[] command = line.split("\\s+");
            switch (command[0]) {
                case "add":
                    number = Integer.parseInt(command[1]);
                    numbers.add(number);
                    break;
                case "insert":
                    number = Integer.parseInt(command[1]);
                    index = Integer.parseInt(command[2]);
                    numberInsert(numbers, index, number);
                    break;
                case "remove":
                    index = Integer.parseInt(command[1]);
                    indexRemove(numbers, index);
                    break;
                case "shift":
                    switch (command[1]) {
                        case "left":
                            shiftArrayList(numbers, Integer.parseInt(command[2]), false);
                            break;
                        case "right":
                            shiftArrayList(numbers, Integer.parseInt(command[2]), true);
                    }
                    break;
            }
        }

        printList(numbers);
    }

    private static void shiftArrayList(List<Integer> numbers, int count, boolean isRightShift) {
        int size = numbers.size();
        if (size < 2) return;

        while (count-- > 0) {
            List<Integer> temp = new ArrayList<>(size);
            if (isRightShift) {
                temp.add(numbers.get(size - 1));

                for (int i = 0; i < size - 1 ; i++) {
                    temp.add(numbers.get(i));
                }
                // shift left
            } else {

                for (int i = 1; i < size ; i++) {
                    temp.add(numbers.get(i));
                }
                temp.add(numbers.get(0));
            }
            // copy temp to numbers
            for (int i = 0; i < size ; i++) {
                numbers.set(i, temp.get(i));
            }
        }
    }

    private static void indexRemove(List<Integer> numbers, int index) {
        if (index >= 0 && index < numbers.size() ) {
            numbers.remove(index);
        } else {
            invalidIndex();
        }
    }

    private static void numberInsert(List<Integer> numbers, int index, int number) {
        if (index >= 0 && index < numbers.size() ) {
            numbers.add(index, number);
        } else {
            invalidIndex();
        }
    }

    private static void invalidIndex () {
        System.out.println("Invalid index");
    }

    private static void printList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
