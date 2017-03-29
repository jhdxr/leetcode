//Sum of Two Integers
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.getSum(1, 2)); //3
        System.out.println(s.getSum(-1, 2)); //1
    }

    public int getSum(int a, int b) {
        int and;
        int xor;
        do {
            xor = a ^ b;
            and = a & b;
            and <<= 1;
            a = xor;
            b = and;
        } while (and != 0);
        return xor;
    }

}
