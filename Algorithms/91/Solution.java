import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.numDecodings("123"));
        System.out.println(s.numDecodings("120"));
    }

    private Map<String, Integer> map = new HashMap<>();

    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.startsWith("0")) return 0;
        //from A to K
        if (s.length() == 1) return 1;

        if (s.length() == 2) {
            if (s.charAt(0) == '1') {
                return s.charAt(1) == '0' ? 1 : 2;
            } else if (s.charAt(0) == '2') {
                return s.charAt(1) <= '6' && s.charAt(1) > '0' ? 2 : 1;
            } else {
                return numDecodings(s.substring(1));
            }
        }

        if (map.containsKey(s)) {
            return map.get(s);
        }
        int sum = 0;
        sum += numDecodings(s.substring(1));
        if (s.charAt(0) == '1' || s.charAt(0) == '2' && s.charAt(1) <= '6') {
            sum += numDecodings(s.substring(2));
        }
        map.put(s, sum);
        return sum;
    }


}
