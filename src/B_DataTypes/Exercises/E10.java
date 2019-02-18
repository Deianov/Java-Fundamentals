package B_DataTypes.Exercises;

import java.util.Scanner;

public class E10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        int tempN = N;
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int targets = 0;
        while (N >= M) {
            N -= M;
            if (Y != 0 && N * 2 == tempN) N = N / Y;
            targets++;
        }
        System.out.println(N);
        System.out.println(targets);

    }
}
