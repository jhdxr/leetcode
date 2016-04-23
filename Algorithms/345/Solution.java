public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseVowels("HellO"));
        System.out.println(s.reverseVowels("leetcode"));
        System.out.println(s.reverseVowels("aboccce"));
    }

    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] arr = s.toCharArray();
        int i = 0;
        int j = arr.length - 1;
        char t;

        while (i < j && i < arr.length && j > 0) {
            while (i < arr.length && !isVowel(arr[i])) {
                i++;
            }
            while (j > 0 && !isVowel(arr[j])) {
                j--;
            }

            if (i < j) {
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                i++;
                j--;
            }
        }

        return new String(arr);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
