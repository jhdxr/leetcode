public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        for (int i : arr) {
            System.out.println(i + ": " + s.isUgly(i));
        }
    }

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
}
