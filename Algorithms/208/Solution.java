import java.util.List;

public class Solution {
    public static void main(String[] args) {
//        Solution s = new Solution();

        Trie tree = new Trie();
        tree.insert("test");
        System.out.println("search tes: " + tree.search("tes"));
        System.out.println("search test: " + tree.search("test"));
        System.out.println("search testt: " + tree.search("testt"));
        System.out.println("startsWith tes: " + tree.startsWith("tes"));
        System.out.println("startsWith test: " + tree.startsWith("test"));
        System.out.println("startsWith testt: " + tree.startsWith("testt"));

        tree.insert("testt");
        System.out.println("search tes: " + tree.search("tes"));
        System.out.println("search test: " + tree.search("test"));
        System.out.println("search testt: " + tree.search("testt"));
        System.out.println("startsWith tes: " + tree.startsWith("tes"));
        System.out.println("startsWith test: " + tree.startsWith("test"));
        System.out.println("startsWith testt: " + tree.startsWith("testt"));
    }
}
