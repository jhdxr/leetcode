//Count and Say
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countAndSay(1));
        System.out.println(s.countAndSay(2));
        System.out.println(s.countAndSay(3));
        System.out.println(s.countAndSay(4));
        System.out.println(s.countAndSay(5));
    }

    public String countAndSay(int n) {
        StringBuilder old = new StringBuilder("1");
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] arr = old.toString().toCharArray();
            char last = ' ';
            int count = 0;
            for (char chr : arr) {
                if (chr != last) {
                    if (count > 0) {
                        sb.append(count).append(last);
                    }
                    last = chr;
                    count = 1;
                } else {
                    count++;
                }
            }
            if (count > 0) {
                sb.append(count).append(last);
            }
            old = sb;
        }
        return old.toString();
    }

}
