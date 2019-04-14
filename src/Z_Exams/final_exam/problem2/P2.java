//Technology Fundamentals Final Exam - 14 April 2019
//Problem 2 - On the Way to Annapurna
package Z_Exams.final_exam.problem2;

import java.util.*;

public class P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        Map<String, Store> stores = new LinkedHashMap<>();

        while (!(input = scanner.nextLine()).equals("END")) {
            String[] data = input.split("->");
            String command = data[0];
            String name = data[1];

            if (command.equals("Add")) {

                stores.putIfAbsent(name, new Store(name));
                Store store = stores.get(name);

                for (String item : data[2].split(",")) {
                    store.addItem(item);
                }
            } else if (command.equals("Remove")) {
                stores.remove(name);
            }
        }

        System.out.println("Stores list:");
        stores.values()
                .stream()
                .sorted(Comparator.comparingInt(Store::getItemsCount)
                        .thenComparing(Store::getName).reversed())
                .forEach(Store::printStore);
    }
}

class Store {
    private String name;
    private List<String> items;
    private int itemsCount;

    Store(String name) {
        this.name = name;
        this.items = new ArrayList<>();
        this.itemsCount = 0;
    }

    String getName() { return name; }
    int getItemsCount() { return itemsCount; }

    void addItem(String item) {
        this.items.add(item);
        this.itemsCount++;
    }

    void printStore() {
        System.out.println(this.name);
        for (String item : this.items) {
            System.out.println("<<" + item + ">>");
        }
    }
}
