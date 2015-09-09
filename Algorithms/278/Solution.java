public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        //tle: 2126753390 versions, 1702766719 is the first bad version.
        System.out.println(s.firstBadVersion(2126753390));
    }

    public int firstBadVersion(int n) {
        int l = 1;
        int r = n;
        do {
            boolean flag = false;
            int m = l / 2;
            if (l % 2 != 0) {
                flag = true;
            }
            m += r / 2;
            if(flag && r % 2 != 0) {
                m += 1;
            }
            if (isBadVersion(m)) {
                r = m;
            } else {
                l = m + 1;
            }
//            System.out.println(l+"\t"+r+"\t"+m);
        } while (l < r);
        return l;
    }

    int c = 1;

    public boolean isBadVersion(int version) {
//        System.out.println(c++ + " called: " + version);
        return version >= 1702766719;
    }
}
