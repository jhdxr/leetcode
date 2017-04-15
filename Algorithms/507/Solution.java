//Perfect Number
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.checkPerfectNumber(1)); //false
        System.out.println(s.checkPerfectNumber(2)); //false
        System.out.println(s.checkPerfectNumber(3)); //false
        System.out.println(s.checkPerfectNumber(4)); //false
        System.out.println(s.checkPerfectNumber(5)); //false
        System.out.println(s.checkPerfectNumber(6)); //true
        System.out.println(s.checkPerfectNumber(28)); //true
    }

    public boolean checkPerfectNumber(int num) {
        if (num <= 1) return false;
        int sum = 1;
        int iMax = num - 1;
        for (int i = 2; i < iMax; i++) {
            if (num % i == 0) {
                int a = num / i;
                int b = num / a;
                sum += a;
                if (b != a) {
                    sum += b;
                }
                iMax = a;
            }
        }
        return sum == num;
    }

}
