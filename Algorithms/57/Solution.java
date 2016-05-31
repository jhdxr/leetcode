import java.util.*;
//Insert Interval
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.insert(Arrays.asList(new Interval[]{new Interval(1, 3), new Interval(6, 9)}), new Interval(2, 5))
                .stream().forEach(System.out::println);
        System.out.println();
        s.insert(Arrays.asList(new Interval[]{new Interval(1, 2), new Interval(3, 5), new Interval(6, 7),
                new Interval(8, 10), new Interval(12, 16)}), new Interval(4, 9))
                .stream().forEach(System.out::println);
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<>();
        Interval[] arr = intervals.toArray(new Interval[0]);
        int start = newInterval.start;
        int end = newInterval.end;
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].end < newInterval.start) {
                ret.add(arr[i]);
            } else if (arr[i].start > newInterval.end) {
                if (flag) {
                    ret.add(new Interval(start, end));
                }
                flag = false;
                ret.add(arr[i]);
            } else {
                start = Math.min(start, arr[i].start);
                end = Math.max(end, arr[i].end);
            }
        }
        if (flag) {
            ret.add(new Interval(start, end));
        }
        return ret;
    }
}
