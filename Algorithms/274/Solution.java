//H-Index
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.hIndex(new int[]{}));
        System.out.println(s.hIndex(new int[]{1}));
        System.out.println(s.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(s.hIndex(new int[]{0, 1, 2, 3, 4}));
        System.out.println(s.hIndex(new int[]{2, 2, 2, 2, 2}));
    }

    public int hIndex(int[] citations) {
        if (citations == null || citations.length <= 0) return 0;
        int[] arr = new int[citations.length];
        for (int i : citations) {
            if (i > 0) {
                arr[Math.min(arr.length, i) - 1]++;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            arr[i] += arr[i + 1];
        }
        for (int i = 0; i < arr.length; i++) {
            if (i >= arr[i]) return i;
        }
        return arr.length;
    }
}
