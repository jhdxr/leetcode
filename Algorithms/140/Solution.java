import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        Set<String> ss = new HashSet<>();
        ss.add("cat");
        ss.add("cats");
        ss.add("and");
        ss.add("sand");
        ss.add("dog");
        List<String> list = s.wordBreak("catsanddog", ss);
        list.stream().forEach((x)->{
            System.out.println(x);
        });
    }

    private Map<String, List<String>> map = new HashMap<>();

    public List<String> wordBreak(String s, Set<String> wordDict) {
//        if (wordDict == null || wordDict.isEmpty() || s == null) return null;
        List<String> res;
        if(!map.containsKey(s)) {
            res = new ArrayList<>();
            map.put(s, res);
        }else{
            return map.get(s);
        }

        if(wordDict.contains(s)){
            res.add(s);
        }

        for (int i = 1; i < s.length(); i++) {
            String ss = s.substring(0, i);
            if (wordDict.contains(ss)) {
                List<String> list = wordBreak(s.substring(i), wordDict);
                res.addAll(list.stream().map((x) -> {
                    return ss + " " + x;
                }).collect(Collectors.toList()));
            }
        }
        return res;
    }


}
