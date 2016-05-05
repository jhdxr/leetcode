import java.util.*;
//Valid Parentheses
public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();
    }

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return false;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char chr : arr) {
            try {
                if (chr == '(' || chr == '[' || chr == '{') {
                    stack.push(chr);
                } else if (chr == ')' && stack.pop() == '(' ||
                        chr == ']' && stack.pop() == '[' ||
                        chr == '}' && stack.pop() == '{') {
                } else {
                    return false;
                }
            } catch (EmptyStackException e) {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
