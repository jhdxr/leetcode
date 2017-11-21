//Longest Palindromic Substring 
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.longestPalindrome("babad"));
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("aaaaa"));
        System.out.println(s.longestPalindrome("abcde"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 0) return "";
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i)).append('#');
        }
        char[] chars = sb.toString().toCharArray();
        int maxLen = -1;
        int maxStart = -1;
        int maxEnd = -1;
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i - j < 0 || i + j >= chars.length) {
                    break;
                }
                if (chars[i + j] == chars[i - j]) {
                    if (1 + 2 * j > maxLen) {
                        maxLen = 1 + 2 * j;
                        maxStart = i - j;
                        maxEnd = i + j;
                    }
                } else {
                    break;
                }
            }
        }
        sb = new StringBuilder();
        for (int i = maxStart; i <= maxEnd; i++) {
            if (chars[i] == '#') {
                continue;
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
