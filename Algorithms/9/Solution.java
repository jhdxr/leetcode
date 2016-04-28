public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("-111: " + s.isPalindrome(-111));
        System.out.println("0: " + s.isPalindrome(0));
        System.out.println("111: " + s.isPalindrome(111));
        System.out.println("12344321: " + s.isPalindrome(12344321));
        System.out.println("12346321: " + s.isPalindrome(12346321));
        System.out.println("1000021: " + s.isPalindrome(1000021));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int xx = x;
        int l;
        int r = 0;
        int len = 1;
        while (xx >= 10) {
            r = r * 10 + x / len % 10;
            len *= 10;
            xx /= 100;
        }
        l = x / len;
        if (l / len > 0) {
            l /= 10;
        }
        return l == r;
    }
}
