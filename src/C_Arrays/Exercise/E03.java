// 03. Zig-Zag Arrays

package C_Arrays.Exercise;

import java.util.Scanner;

public class E03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String[] a = new String[length];
        String[] b = new String[length];
        for (int i = 0; i < length ; i++) {
            String[] input = scanner.nextLine().split(" ");
            a[i] = input[(i + 1) % 2 == 0 ? 1 : 0];
            b[i] = input[(i + 1) % 2 == 0 ? 0 : 1];
        }
        System.out.println(String.join(" ", a));
        System.out.println(String.join(" ", b));
    }
}
