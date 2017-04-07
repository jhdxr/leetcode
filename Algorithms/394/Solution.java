//Decode String
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.decodeString("3[a]2[bc]")); //aaabcbc
        System.out.println(s.decodeString("3[a2[c]]")); //accaccacc
        System.out.println(s.decodeString("2[abc]3[cd]ef")); //abcabccdcdcdef
        System.out.println(s.decodeString("abcdef")); //abcdef
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int k = 0;
        int index_start = -2;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '[') {
                depth++;
            } else if (c == ']') {
                depth--;
            }
            if (index_start == -2) {
                if (c >= '0' && c <= '9') {
                    k = k * 10 + s.charAt(i) - '0';
                } else if (c == '[') {
                    index_start = i;
                } else {
                    sb.append(c);
                }
            } else if (c == ']' && depth == 0) {
                String res = this.decodeString(s.substring(index_start + 1, i));
                for (int j = 0; j < k; j++) {
                    sb.append(res);
                }
                k = 0;
                index_start = -2;
            }
        }
        return sb.toString();
    }

}
