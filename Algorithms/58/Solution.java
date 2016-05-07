//Length of Last Word
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        char[] arr = s.toCharArray();
        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == ' ') {
                if (count > 0) {
                    return count;
                }
            } else {
                count++;
            }
        }
        return count;
    }

}
