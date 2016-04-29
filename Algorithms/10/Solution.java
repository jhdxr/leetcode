import java.util.HashMap;
import java.util.Map;

//Regular Expression Matching
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isMatch("aaa", "aaaa")); //false
        System.out.println(s.isMatch("aa", "a")); //false
        System.out.println(s.isMatch("aa", "aa")); //true
        System.out.println(s.isMatch("aaa", "aa")); //false
        System.out.println(s.isMatch("aa", "a*")); //true
        System.out.println(s.isMatch("aa", ".*")); //true
        System.out.println(s.isMatch("ab", ".*")); //true
    }

    char[] s;
    char[] p;
    Map<String, Boolean> map;

    private boolean isMatch(int si, int pi) {
        String key = String.valueOf(si) + "|" + String.valueOf(pi);
        if (map.get(key) != null) return map.get(key);

        boolean result = false;
        try {
            if (pi >= p.length) {
                result = si >= s.length;
                return result;
            }
            if (ifNextIsStar(pi)) {
                for (int i = si; i < s.length; i++) {
                    if (p[pi] == '.' || s[i] == p[pi]) {
                        if (isMatch(i + 1, pi + 2)) {
                            result = true;
                            return result;
                        }
                    } else {
                        break;
                    }
                }
                result = isMatch(si, pi + 2);
            } else {
                if (si >= s.length || p[pi] != '.' && s[si] != p[pi]) {
                    result = false;
                } else {
                    result = isMatch(si + 1, pi + 1);
                }
            }
        } finally {
            map.put(key, result);
        }
        return result;
    }

    public boolean isMatch(String s, String p) {
        this.s = s.toCharArray();
        this.p = p.toCharArray();
        map = new HashMap<>();
        return isMatch(0, 0);
    }

    private boolean ifNextIsStar(int index) {
        return index < p.length - 1 && p[index + 1] == '*';
    }

}
