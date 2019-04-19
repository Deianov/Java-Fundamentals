//Technology Fundamentals Mid Exam - 16 April 2019 - group 1
//Problem 2 - Easter Gifts
package Z_Exams.mid_exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> gifts = Arrays.asList(input.split("\\s+"));

        while (!(input = scanner.nextLine()).equals("No Money")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            String gift = data[1];
            int index = data.length > 2 ? Integer.parseInt(data[2]) : -1;

            switch (command) {
                case "OutOfStock":
                    for (int i = 0; i < gifts.size() ; i++) {
                        if (gifts.get(i).equals(gift)) {
                            gifts.set(i, "None");
                        }
                    }
                    break;
                case "Required":
                    if (index > -1 && index < gifts.size()) {
                        gifts.set(index, gift);
                    }
                    break;
                case "JustInCase":
                    if (gifts.size() > 0) {
                        gifts.set(gifts.size() - 1, gift);
                    }
                    break;
            }
        }
        gifts = gifts.stream().filter(s -> !s.equals("None")).collect(Collectors.toList());
        System.out.println(gifts.toString().replaceAll("[\\[\\],]", ""));
    }
}
