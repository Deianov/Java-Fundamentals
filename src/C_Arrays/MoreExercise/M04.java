// 04. Longest Increasing Subsequence

package C_Arrays.MoreExercise;

import java.util.Arrays;
import java.util.Scanner;

public class M04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int length = nums.length;
        int[] lens = new int[length];
        String[] subSequences  = new String[length];
        for (int i = 0; i < length ; i++) {
            lens[i] = 1;
            subSequences [i] = "" + nums[i];
            for (int j = 0; j < i ; j++) {
                if (nums[i] > nums[j]) {
                    if (lens[j] + 1 > lens[i]) {
                        lens[i] = lens[j] + 1;
                        subSequences[i] = subSequences[j] + " " + nums[i];
                    }
                }
            }
        }
        int maxIndex = -1;
        int maxLen = -1;
        for (int i = 0; i < length ; i++) {
            if (lens[i] > maxLen) {
                maxLen = lens[i];
                maxIndex = i;
            }
        }
        System.out.println(subSequences[maxIndex]);
    }
}