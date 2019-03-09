//04. Mixed up Lists

package E_Lists.MoreExercise;

import java.util.*;
import java.util.stream.Collectors;

public class M04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondList = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int size = Math.min(firstList.size(), secondList.size());

        if (Math.abs(firstList.size() - secondList.size()) != 2) {
            return;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size ; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(secondList.size() - 1 - i));
        }

        int range1, range2;
        if (firstList.size() > secondList.size()) {
            range1 = firstList.get(size);
            range2 = firstList.get(size + 1);
        } else {
            range1 = secondList.get(secondList.size() - (size + 1));
            range2 = secondList.get(secondList.size() - (size + 2));
        }

        int minValue = Math.min(range1, range2);
        int maxValue = Math.max(range1, range2);

        result = result.stream().filter(e -> (e > minValue && e < maxValue)).collect(Collectors.toList());
        Collections.sort(result);

        System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
    }
}
