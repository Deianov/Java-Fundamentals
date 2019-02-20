// 06. List of Products

package E_Lists.Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class L06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>();

        while (lines-- > 0) {
            products.add(scanner.nextLine());
        }
        Collections.sort(products);

        for (int i = 0; i < products.size() ; i++) {
            System.out.printf("%d.%s%n",i + 1, products.get(i));
        }
    }
}
