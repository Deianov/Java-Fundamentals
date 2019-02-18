// 09. Kamino Factory

package C_Arrays.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class E09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();

        String bestDna = "";
        int bestDnaLength = 0;
        int bestDnaIndex = 0;
        int bestDnaSample = 0;
        int bestDnaSum = 0;
        int countSamples = 0;

        while (!"Clone them!".equals(input)) {
            countSamples++;
            int[] arr = Arrays
                    .stream(input.replaceAll("(!)+", "!").split("!"))
                    .mapToInt(Integer::parseInt).toArray();

            int maxLengthIndex = 0;
            int maxLength = 0;
            int sum = 0;
            int count = 0;

            for (int i = 0; i < length ; i++) {
                if (arr[i] == 1) {
                    sum++;
                    count++;
                    if (count > maxLength) {
                        maxLength = count;
                        maxLengthIndex = i - count + 1;
                    }
                } else {
                    count = 0;
                }
            }

            boolean isBest = false;
            if (maxLength > bestDnaLength || countSamples == 1) {
                isBest = true;
            } else if (maxLength == bestDnaLength && maxLengthIndex < bestDnaIndex) {
                isBest = true;
            } else if (maxLength == bestDnaLength && bestDnaSum < sum) {
                isBest = true;
            }
            if (isBest) {
                bestDnaLength = maxLength;
                bestDnaIndex = maxLengthIndex;
                bestDnaSample = countSamples;
                bestDnaSum = sum;
                bestDna = Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(" "));
            }
            input = scanner.nextLine();
        }
        if (countSamples > 0) {
            System.out.printf("Best DNA sample %d with sum: %d.%n", bestDnaSample, bestDnaSum);
            System.out.println(bestDna);
        }
    }
}
