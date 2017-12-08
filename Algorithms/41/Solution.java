//First Missing Positive
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(s.firstMissingPositive(new int[]{3, 4, -1, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length <= 0) return 1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (i <= 0) continue;
            set.add(i);
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                return i;
            }
            i++;
        }
    }

}

