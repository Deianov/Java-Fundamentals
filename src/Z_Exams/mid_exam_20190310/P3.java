//Technology Fundamentals Mid Exam - 10 March 2019 Group 1
//03. Last Stop
package Z_Exams.mid_exam_20190310;

import java.util.*;
import java.util.stream.Collectors;

public class P3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Integer> numbers = Arrays.stream(input.split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        ListEdit listEdit = new ListEdit(numbers);

        while (!(input = scanner.nextLine()).equals("END")) {
            String[] data = input.split("\\s+");
            String command = data[0];
            int a = data.length > 1 ? Integer.parseInt(data[1]) : -1;
            int b = data.length > 2 ? Integer.parseInt(data[2]) : -1;

            switch (command) {
                case "Change":
                    listEdit.change(a, b);
                    break;
                case "Hide":
                    listEdit.hide(a);
                    break;
                case "Switch":
                    listEdit.switchItems(a, b);
                    break;
                case "Insert":
                    listEdit.insertAfter(a, b);
                    break;
                case "Reverse":
                    listEdit.reverse();
                    break;
            }
        }
        listEdit.printList();
    }
}

class ListEdit {
    private List<Integer> list;

    ListEdit(List<Integer> list) {
        this.list = list;
    }

    void change(int number, int newNumber) {
        int index = this.list.indexOf(number);
        if (index > -1) this.list.set(index, newNumber);
    }

    void hide(int number) {
        int index = this.list.indexOf(number);
        if (index > -1) this.list.remove(index);
    }

    void switchItems(int a, int b) {
        int index1 = this.list.indexOf(a);
        int index2 = this.list.indexOf(b);
        if (index1 > -1 && index2 > -1) {
            this.list.set(index1, b);
            this.list.set(index2, a);
        }
    }

    void insertAfter(int index, int number) {
        if (this.list.size() > index) {
            if (this.list.size() == index + 1) {
                this.list.add(number);
            } else {
                this.list.add(index + 1, number);
            }
        }
    }

    void reverse() {
        Collections.reverse(this.list);
    }

    void printList() {
        System.out.println(this.list.toString().replaceAll("[\\[\\],]", ""));
    }
}
