public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseString("HellO"));
        System.out.println(s.reverseString("leetcode"));
        System.out.println(s.reverseString("aboccce"));
        System.out.println(s.reverseString("qq"));
    }

    public String reverseString(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        while(i<j) {
            char t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
            i++;
            j--;
        }
        return new String(arr);
    }
}
