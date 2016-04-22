public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(s.computeArea(0, 0, 5, 5, 0, 0, 1, 1));
    }

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        long area = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || G <= A || H <= B || D <= F) {
            return (int) area;
        } else {
            return (int) (area - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F)));
        }
    }
}
