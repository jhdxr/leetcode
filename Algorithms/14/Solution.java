public class Solution {
	
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestCommonPrefix(new String[]{
                "apple", "app"
        }));
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        all: for(int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for(String str : strs) {
                if(i >= str.length() || str.charAt(i) != c) {
                    break all;
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
