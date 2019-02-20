// 03. Merging Lists

package E_Lists.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class L03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums1 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> nums2 = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> result = new ArrayList<>();
        List<Integer> maxSize = nums2.size() > nums1.size() ? nums2 : nums1;
        List<Integer> minSize = nums2.size() > nums1.size() ? nums1 : nums2;

        for (int i = 0; i < minSize.size() ; i++) {
            result.add(nums1.get(i));
            result.add(nums2.get(i));
        }

        result.addAll(getRemainigElements(maxSize, minSize));
        System.out.println(result.toString().replaceAll("[\\[\\],]",""));
    }
    static List<Integer> getRemainigElements(List<Integer> longerList, List<Integer> shorterList) {
        List<Integer> items = new ArrayList<>();
         for (int i = shorterList.size(); i < longerList.size() ; i++) {
             items.add(longerList.get(i));
         }
         return items;
    }
}
