import java.util.*;
//Intersection of Two Arrays II
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Arrays.stream(s.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}))
                .forEach(System.out::println);
//        System.out.println(s.hIndex(new int[]{}));
//        System.out.println(s.hIndex(new int[]{1}));
//        System.out.println(s.hIndex(new int[]{0, 1, 3, 5, 6}));
//        System.out.println(s.hIndex(new int[]{0, 1, 2, 3, 4}));
//        System.out.println(s.hIndex(new int[]{2, 2, 2, 2, 2}));
    }

//    public int hIndex(int[] citations) {
//        if (citations == null || citations.length == 0) return 0;
//
//    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.stream(nums1).forEach(i -> {
            map.compute(i, (k, v) -> v == null ? 1 : v + 1);
        });
        List<Integer> res = new ArrayList<>();
        for (int i : nums2) {
            map.computeIfPresent(i, (k, v) -> {
                res.add(k);
                return v == 1 ? null : v - 1;
            });
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
