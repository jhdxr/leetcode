import java.util.*;
//Summary Ranges
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.summaryRanges(new int[]{0, 1, 2, 4, 5, 7}).stream().forEach(System.out::println);
        System.out.println();
        s.summaryRanges(new int[]{0, 1, 2}).stream().forEach(System.out::println);
        System.out.println();
        s.summaryRanges(new int[]{0}).stream().forEach(System.out::println);
        System.out.println();
        s.summaryRanges(new int[]{0, 4, 7}).stream().forEach(System.out::println);
        System.out.println();
        s.summaryRanges(new int[]{-2147483648,-2147483647,2147483647}).stream().forEach(System.out::println);
        System.out.println();
    }

    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        int last = nums[0];
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - last != 1) {
                if (last == start) {
                    res.add(String.valueOf(start));
                } else {
                    res.add(String.format("%d->%d", start, last));
                }
                start = nums[i];
            }
            last = nums[i];
        }
        if (last == start) {
            res.add(String.valueOf(start));
        } else {
            res.add(String.format("%d->%d", start, last));
        }
        return res;
    }
}
