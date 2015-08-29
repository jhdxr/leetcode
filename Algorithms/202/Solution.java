import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.isHappy(19)); //true
        System.out.println(s.isHappy(1)); //true;
        System.out.println(s.isHappy(101)); //false
        System.out.println(s.isHappy(18)); //fasle
    }

    public boolean isHappy(int n) {
        if(n <= 0) return false;
        List<Integer> list = new ArrayList<>();
        do {
            if (list.contains(n)) return false;
            list.add(n);
            char[] arr = String.valueOf(n).toCharArray();
            n = 0;
            for (char chr : arr) {
                n += (chr - 0x30) * (chr - 0x30);
            }
        } while (n != 1);
        return true;
    }
}
