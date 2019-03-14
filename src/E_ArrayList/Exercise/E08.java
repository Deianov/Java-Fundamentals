//08. Anonymous Threat

package E_ArrayList.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = Arrays.stream(input.split("\\s+")).collect(Collectors.toList());

        while (!"3:1".equals(input = scanner.nextLine().toLowerCase())) {
            String[] command = input.split("\\s+");

            switch (command[0]) {
                case "merge":
                    int startIndex = Integer.parseInt(command[1]);
                    int endIndex = Integer.parseInt(command[2]);
                    mergeArrayList(list, startIndex, endIndex);
                    break;
                case "divide":
                    int index = Integer.parseInt(command[1]);
                    int partitions = Integer.parseInt(command[2]);
                    divideArrayList(list, index, partitions);
                    break;
            }
        }
        printArrayList(list);
    }

    private static void divideArrayList(List<String> elementsList, int elementIndex, int parts) {
        String element = elementsList.get(elementIndex);
        if (parts < 2 || element.length() < parts) {
            return;
        }

        int partLength = element.length() / parts;
        boolean isDividable = element.length() % parts == 0;

        // divide element
        String[] temp = new String[parts];
        for (int i = 0; i < parts ; i++) {
            temp[i] = element.substring(i * partLength, (i + 1) * partLength);
        }
        if (!isDividable) {
            temp[parts - 1] = element.substring(partLength * (parts - 1));
        }

        // add elements to list
        elementsList.set(elementIndex, temp[0]);
        for (int i = 1; i < temp.length ; i++) {
            elementsList.add(elementIndex + i, temp[i]);
        }
    }

    private static void mergeArrayList(List<String> list, int startIndex, int endIndex) {
        int length = list.size();
        if (startIndex >= length || endIndex < 0) {
            return;
        }
        int start = Math.max(0, startIndex);
        int end = Math.min(length - 1, endIndex);
        String temp = "";

        // get elements
        for (int i = start; i <= end ; i++) {
            temp += list.get(i);
        }

        //delete indexes
        for (int i = end; i >= start ; i--) {
            list.remove(i);
        }

        // add merged element
        if (list.size() == 0) {
            list.add(temp);
        } else {
            list.add(start, temp);
        }
    }

    private static void printArrayList(List<String> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]",""));
    }
}
