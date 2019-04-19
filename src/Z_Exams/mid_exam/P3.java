//Technology Fundamentals Mid Exam - 16 April 2019 - group 1
//Problem 3 - Easter Shopping
package Z_Exams.mid_exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = new ArrayList<>(Arrays.asList(input.split("\\s+")));
        int n = Integer.parseInt(scanner.nextLine());

        ListEdit shops = new ListEdit(list);

        while (n-- > 0) {
            input = scanner.nextLine();
            String[] data = input.split("\\s");
            String command = data[0];

            switch (command) {
                case "Include" :
                    shops.add(data[1]);
                    break;
                case "Visit" :
                    boolean fromFirst = data[1].equals("first");
                    int number = Integer.parseInt(data[2]);

                    if (number > -1 && number <= list.size()) {
                        shops.visit(fromFirst, number);
                    }
                    break;
                case "Prefer" :
                    shops.switchItems(Integer.parseInt(data[1]), Integer.parseInt(data[2]));
                    break;
                case "Place" :
                    shops.insertAfter(data[1], Integer.parseInt(data[2]));
                    break;
            }
        }
        System.out.println("Shops left:");
        shops.printList();
    }
}


class ListEdit {
    private List<String> list;

    ListEdit(List<String> list) {
        this.list = list;
    }

    void add(String item) {
        this.list.add(item);
    }

    void visit(boolean fromFirst, int count) {

        for (int i = 0; i < count ; i++) {
            this.list.remove(fromFirst ? 0 : this.list.size() - 1);
        }
    }

    void switchItems(int index1, int index2) {
        int size = this.list.size();

        if (index1 > -1 && index1 < size && index2 > -1 && index2 < size) {
            String item1 = this.list.get(index1);
            String item2 = this.list.get(index2);

            this.list.set(index1, item2);
            this.list.set(index2, item1);
        }
    }

    void insertAfter(String item, int index) {
        if (index > -1 && index <= (this.list.size() - 2)) {
            this.list.add(index + 1, item);
        }
    }

    void printList() {
        System.out.println(this.list.toString().replaceAll("[\\[\\],]", ""));
    }
}