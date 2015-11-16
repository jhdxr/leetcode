import java.util.*;
import java.util.stream.*;

public class Solution {
    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.minDistance("abc", "abc")); //0
        System.out.println(s.minDistance("abcde", "acdbe")); //2
        System.out.println(s.minDistance("a", "abcde")); //4
        System.out.println(s.minDistance("abcde", "abbde")); //1

    }

    private Map<String, Integer> map = new HashMap<>();

    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null || word1.equals(word2)) return 0;

        int f[][] = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 0; i <= word1.length(); i++) {
            f[i][0] = i;
        }

        for (int i = 0; i <= word2.length(); i++) {
            f[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1];
                } else {
                    f[i][j] = Math.min(Math.min(f[i - 1][j - 1], //edit
                            f[i - 1][j] //insert
                    ), f[i][j - 1]);//remove
                    f[i][j]++;//one step for convert
                }
            }
        }

        return f[word1.length()][word2.length()];
    }

}
