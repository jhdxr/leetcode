public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minPatches(new int[]{1, 2, 3, 4, 5}, 10));
        System.out.println(s.minPatches(new int[]{1, 2, 3, 4, 500}, 1));
        System.out.println(s.minPatches(new int[]{10}, 10));
        System.out.println(s.minPatches(new int[]{1, 3}, 6));
        System.out.println(s.minPatches(new int[]{1, 5, 10}, 20));
        System.out.println(s.minPatches(new int[]{1, 2, 2}, 5));
        System.out.println(s.minPatches(new int[]{}, 200));
    }

    public int minPatches(int[] nums, int n) {
        int patch = 0;
        long sum = 0;
        for (int i : nums) {
            while (i > sum + 1) {
                if (sum >= n) return patch;
                patch++;
                sum += sum + 1;
            }
            if (sum >= n) return patch;
            sum += i;
        }
        while (sum < n) {
            patch++;
            sum += sum + 1;
        }
        return patch;
    }
}
