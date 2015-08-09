import java.util.*;

public class Solution {
    public List<String> anagrams(String[] strs) {
        if (strs == null || strs.length <= 1) return new ArrayList<>();
        Map<String, String> map = new HashMap<>(); // record the relation from sorted string to original string
        Set<String> set = new HashSet<>(); // record the duplicate sorted strings
        List<String> result = new ArrayList<>();
        for (String str : strs) {
            char[] chrArr = str.toCharArray();
            Arrays.sort(chrArr);
            String sortedStr = new String(chrArr);
            if (map.containsKey(sortedStr)) {
                result.add(str);
                set.add(sortedStr);
            } else {
                map.put(sortedStr, str);
            }
        }

        for (String str : set) {
            result.add(map.get(str));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> anagrams;
        anagrams = s.anagrams(new String[]{"abc", "cab", "dsa", "asd", "sad", "bca"});
        for (String str : anagrams) {
            System.out.print(str + "\t");
        }
        System.out.println("===================");

        anagrams = s.anagrams(new String[]{"abc", "cab", "asa", "d", "asd", "bca", "asd"});
        for (String str : anagrams) {
            System.out.print(str + "\t");
        }
        System.out.println();
    }
}
