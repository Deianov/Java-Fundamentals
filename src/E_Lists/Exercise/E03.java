// 03. House Party

package E_Lists.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commands = Integer.parseInt(scanner.nextLine());
        List<String> partyGuests = new ArrayList<>();

        while (commands-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");

            if (line.length == 3 &&
                    line[1].equalsIgnoreCase("is") &&
                    line[2].equalsIgnoreCase("going!")) {
                String name = line[0];
                personAdd(partyGuests, name);
            } else if (line.length == 4 &&
                    line[1].equalsIgnoreCase("is") &&
                    line[2].equalsIgnoreCase("not") &&
                    line[3].equalsIgnoreCase("going!")) {
                String name = line[0];
                personRemove(partyGuests, name);
            }
        }

        if (partyGuests.size() > 0) printListNewLine(partyGuests);
    }

    private static void personAdd(List<String> partyGuests, String name) {
        if (partyGuests.contains(name)) {
            System.out.println(name + " is already in the list!");
        } else {
            partyGuests.add(name);
        }
    }

    private static void personRemove(List<String> partyGuests, String name) {
        if (partyGuests.contains(name)) {
            partyGuests.remove(name);
        } else {
            System.out.println(name + " is not in the list!");
        }
    }

    private static void printListNewLine(List<String> list) {
        for (String item : list) {
            System.out.println(item);
        }
    }
}
