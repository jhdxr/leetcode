import java.util.*;
//Intersection of Two Arrays
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Arrays.stream(s.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
                .forEach(System.out::println);
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Arrays.stream(nums1).forEach(i -> set1.add(i));
        Set<Integer> set2 = new HashSet<>();
        Arrays.stream(nums2).forEach(i -> {
            if (set1.contains(i)) {
                set2.add(i);
            }
        });
        int[] res = new int[set2.size()];
        int i = 0;
        for (int j : set2) {
            res[i++] = j;
        }
        return res;
    }
}
