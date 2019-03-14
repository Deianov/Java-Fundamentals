// 02. Change List

package E_ArrayList.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Integer> list = Arrays.stream(input.split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        while (!"end".equals(input = scanner.nextLine().toLowerCase())) {
            String[] line = input.split("\\s+");
            if("delete".equals(line[0])) {
                int element = Integer.parseInt(line[1]);
                deleteElement(list,element);
            } else if ("insert".equals(line[0])) {
                int element = Integer.parseInt(line[1]);
                int position = Integer.parseInt(line[2]);
                insertElement(list, position, element);
            }
        }
        printList(list);
    }

    static void insertElement(List<Integer> list, int position, int element) {
        if (position >= 0 && position < list.size()) {
            list.add(position, element);
        }
    }

    static void deleteElement(List<Integer> list, int element) {
        for (int i = 0; i < list.size() ; i++) {
            if (list.get(i).equals(element)) {
                list.remove(i--);
            }
        }
    }

    static void printList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }
}
