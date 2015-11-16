import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Set<String> ss = new HashSet<>();
        ss.add("go");
        ss.add("goal");
        ss.add("goals");
        ss.add("special");
        System.out.println(s.wordBreak("goalspecial", ss));
    }

    private Set<String> failed = new HashSet<>();

    public boolean wordBreak(String s, Set<String> wordDict) {
        if (wordDict == null || wordDict.isEmpty() || s == null) return false;
        if (failed.contains(s)) return false;
        if (wordDict.contains(s)) return true;
        for (int i = 1; i < s.length(); i++) {
            if (wordDict.contains(s.substring(0, i))) {
                if (wordBreak(s.substring(i), wordDict)) {
                    return true;
                }
            }
        }
        failed.add(s);
        return false;
    }


}
