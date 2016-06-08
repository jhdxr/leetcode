//Search for a Range
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Arrays.stream(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(s.searchRange(new int[]{1, 1, 1}, 1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(s.searchRange(new int[]{1, 1, 1}, 0)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(s.searchRange(new int[]{1, 1}, 1)).forEach(System.out::println);
        System.out.println();
        Arrays.stream(s.searchRange(new int[]{1}, 1)).forEach(System.out::println);
        System.out.println();
    }

    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;

        if (nums != null && nums.length > 0) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid =  left + (right - left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    start = mid;
                    while (--start >= 0 && nums[start] == target) ;
                    if (start < 0 || nums[start] != target) start++;
                    end = mid;
                    while (++end < nums.length && nums[end] == target) ;
                    if (end >= nums.length || nums[end] != target) end--;
                    break;
                }
            }
        }

        return new int[]{start, end};
    }

}
