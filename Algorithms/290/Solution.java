import java.util.*;
//Word Pattern
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.wordPattern("abba", "dog cat cat dog"));
        System.out.println(s.wordPattern("abba", "dog cat cat fish"));
        System.out.println(s.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(s.wordPattern("abba", "dog dog dog dog"));
    }

    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> reversed = new HashSet<>();
        char[] patternArr = pattern.toCharArray();
        int index = 0;
        try {
            for (char chr : patternArr) {
                int start = index;
                while (index < str.length() && str.charAt(index) != ' ') {
                    index++;
                }
                String cur = str.substring(start, index);
                index++;
                if (map.get(chr) == null) {
                    if (reversed.contains(cur)) {
                        return false;
                    }
                    map.put(chr, cur);
                    reversed.add(cur);
                } else {
                    if (!map.get(chr).equals(cur)) {
                        return false;
                    }
                }
            }
        } catch (StringIndexOutOfBoundsException e) {
            //means the size of pattern and the size of words not match, e.g. "abba" vs "dog cat dog"
            return false;
        }
        return index > str.length();
    }

}
