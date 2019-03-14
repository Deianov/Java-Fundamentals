//02. Car Race

package E_ArrayList.MoreExercise;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class M02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        double leftTime = 0;
        for (int i = 0; i < numbers.size() / 2 ; i++) {
            int time = numbers.get(i);
            leftTime = (time == 0) ? leftTime * 0.8 : leftTime + time;
        }

        double rightTime = 0;
        for (int i = numbers.size() - 1; i > (numbers.size() / 2) ; i--) {
            int time = numbers.get(i);
            rightTime = (time == 0) ? rightTime * 0.8 : rightTime + time;
        }

        if (leftTime < rightTime) {
            System.out.printf("The winner is left with total time: %.1f", leftTime);
        } else if (rightTime < leftTime) {
            System.out.printf("The winner is right with total time: %.1f", rightTime);
        }
    }
}
