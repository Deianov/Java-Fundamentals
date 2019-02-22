// 01. Train

package E_Lists.Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Integer> wagons = Arrays.stream(input.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        int maxPassengers = Integer.parseInt(scanner.nextLine());

        while (!"end".equals(input = scanner.nextLine().toLowerCase())) {
            String[] line = input.split(" ");
            if ("add".equals(line[0])) {
                wagons.add(Integer.parseInt(line[1]));
            } else {
                int newPassengers = Integer.parseInt(line[0]);
                addPassengers(wagons,newPassengers,maxPassengers);
            }
        }
        printList(wagons);
    }

    static void printList(List<Integer> list) {
        System.out.println(list.toString().replaceAll("[\\[\\],]", ""));
    }

    static void addPassengers(List<Integer> wagons, int newPassengers, int maxPassengers) {
        for (int i = 0; i < wagons.size() ; i++) {
            int passengers = wagons.get(i);
            if (passengers + newPassengers <= maxPassengers) {
                wagons.set(i, passengers + newPassengers);
                return;
            }
        }
    }
}
