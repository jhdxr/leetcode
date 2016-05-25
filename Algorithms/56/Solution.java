import java.util.*;
//Merge Intervals
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        s.merge(Arrays.asList(new Interval[]{new Interval(1, 3), new Interval(2, 6), new Interval(8, 10),
                new Interval(15, 18), new Interval(101, 103), new Interval(103, 105)}))
                .stream().forEach(System.out::println);
    }

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) return intervals;
        Interval[] arr = intervals.stream().sorted((o1, o2) -> o1.start - o2.start).toArray(Interval[]::new);
        int start = arr[0].start;
        int end = arr[0].end;
        List<Interval> ret = new ArrayList<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].start > end) {
                ret.add(new Interval(start, end));
                start = arr[i].start;
                end = arr[i].end;
            } else {
                end = Math.max(end, arr[i].end);
            }
        }
        ret.add(new Interval(start, end));
        return ret;
    }
}
