//Nim Game
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.canWinNim(1));
        System.out.println(s.canWinNim(3));
        System.out.println(s.canWinNim(4));
        System.out.println(s.canWinNim(8));
        System.out.println(s.canWinNim(5));
    }

    public boolean canWinNim(int n) {
        return (n & 3) > 0;
    }

}
