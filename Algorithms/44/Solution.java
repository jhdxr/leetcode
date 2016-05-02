//Wildcard Matching
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isMatch("a", "aa")); //false
        System.out.println(s.isMatch("aa", "*a*a***")); //true
        System.out.println(s.isMatch("aa", "a")); //false
        System.out.println(s.isMatch("aa", "*")); //true
        System.out.println(s.isMatch("aa", "aa")); //true
        System.out.println(s.isMatch("aaa", "aa")); //false
        System.out.println(s.isMatch("aa", "*")); //true
        System.out.println(s.isMatch("aa", "a*")); //true
        System.out.println(s.isMatch("aa", "?*")); //true
        System.out.println(s.isMatch("aab", "c*a*b")); //false
    }

    public boolean isMatch(String s, String p) {
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();
        boolean[][] flag = new boolean[sArr.length + 1][pArr.length + 1];
        flag[0][0] = true;
        for (int j = 1; j <= pArr.length; j++) {
            switch (pArr[j - 1]) {
                case '*':
                    for (int i = 0; i <= sArr.length; i++) {
                        flag[i][j] = i > 0 && flag[i - 1][j] || i > 0 && flag[i - 1][j - 1] || flag[i][j - 1];
                    }
                    break;
                case '?':
                    for (int i = 1; i <= sArr.length; i++) {
                        flag[i][j] = flag[i - 1][j - 1];
                    }
                    break;
                default:
                    for (int i = 1; i <= sArr.length; i++) {
                        flag[i][j] = flag[i - 1][j - 1] && sArr[i - 1] == pArr[j - 1];
                    }
                    break;
            }
        }
        return flag[sArr.length][pArr.length];
    }

}
