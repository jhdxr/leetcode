//Median of Two Sorted Arrays   

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})); //2.5
        System.out.println(s.findMedianSortedArrays(new int[]{1}, new int[]{2, 3})); //2.0
        System.out.println(s.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4})); //2.5
        System.out.println(s.findMedianSortedArrays(new int[]{1}, new int[]{2, 3, 4, 5})); //3.0
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{4})); //2.5

        System.out.println(s.findMedianSortedArrays(new int[]{1, 2, 3, 4}, new int[]{})); //2.5
        System.out.println(s.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 3, 4, 5})); //3.0

        System.out.println(s.findMedianSortedArrays(new int[]{1, 2, 3}, new int[]{1, 2})); //2.0
        System.out.println(s.findMedianSortedArrays(new int[]{1, 2}, new int[]{1, 3, 4})); //2.0

        System.out.println(s.findMedianSortedArrays(new int[]{2}, new int[]{1})); //1.5
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1 == null || nums1.length <= 0) && (nums2 == null || nums2.length <= 0)) return 0;
        if (nums1 == null || nums1.length <= 0) {
            return nums2.length % 2 == 0 ? (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0 : nums2[nums2.length / 2];
        }
        if (nums2 == null || nums2.length <= 0) {
            return nums1.length % 2 == 0 ? (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0 : nums1[nums1.length / 2];
        }
        return this.solve(nums1, (nums1.length - 1) / 2, nums2,
                (nums1.length + nums2.length + 1) / 2 - (nums1.length - 1) / 2 - 2);
    }

    private double solve(int[] xArr, int xPos, int[] yArr, int yPos) { //xPos and yPos belongs to the left part
        int xLeft, yLeft, xRight, yRight;
        int leftLen = 0;
        if (xPos < 0) {
            xLeft = Integer.MIN_VALUE;
            yLeft = yArr[yPos];
            leftLen = yPos + 1;
        } else if (yPos < 0) {
            xLeft = xArr[xPos];
            yLeft = Integer.MIN_VALUE;
            leftLen = xPos + 1;
        } else {
            xLeft = xArr[xPos];
            yLeft = yArr[yPos];
            leftLen = xPos + yPos + 2;
        }
        if (xPos >= xArr.length - 1) {
            xRight = Integer.MAX_VALUE;
            yRight = yArr[yPos + 1];
        } else if (yPos >= yArr.length - 1) {
            xRight = xArr[xPos + 1];
            yRight = Integer.MAX_VALUE;
        } else {
            xRight = xArr[xPos + 1];
            yRight = yArr[yPos + 1];
        }

        if (Math.max(xLeft, yLeft) <= Math.min(xRight, yRight)) {
            if ((xArr.length + yArr.length) % 2 == 0) {
                return (Math.max(xLeft, yLeft) + Math.min(xRight, yRight)) / 2.0;
            } else {
                if (leftLen > xArr.length + yArr.length - leftLen) {
                    return Math.max(xLeft, yLeft);
                } else {
                    return Math.min(xRight, yRight);
                }
            }
        }
        if (xLeft > yLeft) {
            return solve(xArr, xPos - 1, yArr, yPos + 1);
        } else {
            return solve(xArr, xPos + 1, yArr, yPos - 1);
        }
    }
}

