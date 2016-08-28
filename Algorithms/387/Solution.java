public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.firstUniqChar("leetcode"));
        System.out.println(s.firstUniqChar("loveleetcode"));
    }

    public int firstUniqChar(String s) {
        int[] map = new int[26];
        char[] chrArr = s.toCharArray();
        for (int i = 0; i < chrArr.length; i++) {
            map[chrArr[i] - 'a']++;
        }
        for (int i = 0; i < chrArr.length; i++) {
            if (map[chrArr[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

}
