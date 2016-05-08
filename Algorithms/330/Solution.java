public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minPatches(new int[]{1, 3}, 6));
        System.out.println(s.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(s.minPatches(new int[]{1, 2, 2}, 5));
        System.out.println(s.minPatches(new int[]{}, 3));
    }

    public int minPatches(int[] nums, int n) {
        int patch = 0;
        int cur = 1;
        int index = 0;
        do {
            int num;
            if (index >= nums.length || cur < nums[index]) { //missing number, need patch
                num = cur;
                patch++;
            } else {
                num = nums[index];
                index++;
            }
            cur += num;
        } while (cur <= n);
        return patch;
    }
}
