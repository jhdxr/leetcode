public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.missingNumber(new int[]{0, 2}));
        System.out.println(s.missingNumber(new int[]{0, 1, 2}));
        System.out.println(s.missingNumber(new int[]{0, 1, 3}));
        System.out.println(s.missingNumber(new int[]{0, 2, 3}));
        System.out.println(s.missingNumber(new int[]{1, 2, 3}));
        System.out.println(s.missingNumber(new int[]{1, 2, 4, 0}));
    }

    public int missingNumber(int[] nums) {
        if (nums == null || nums.length < 1) return 0;
        int min = nums[0];
        int max = nums[0];
        int sum = 0;
        for (int i : nums) {
            min = min > i ? i : min;
            max = max < i ? i : max;
            sum += i;
        }
        if (min != 0) return 0;
        if(nums.length == 2) {
            return max == 1 ? 2 : 1;
        }
        int sum2 = (0 + max) * (nums.length + 1);
        if (sum2 == sum * 2 + max) return max + 1;
        return sum2 / 2 - sum;
    }
}
