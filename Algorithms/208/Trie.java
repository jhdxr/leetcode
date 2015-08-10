
public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null) return;
        char[] chrArr = word.toCharArray();
        TrieNode current = root;
        for(char chr : chrArr) {
            current = current.getOrCreateNodeByChar(chr);
        }
        current.getOrCreateNodeByChar((char) 0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        if(word == null) return false;
        char[] chrArr = word.toCharArray();
        TrieNode current = root;
        for(char chr : chrArr) {
            current = current.getNodeByChar(chr);
            if(current == null) return false;
        }
        return current.getNodeByChar((char) 0) != null;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        if(prefix == null) return false;
        char[] chrArr = prefix.toCharArray();
        TrieNode current = root;
        for(char chr : chrArr) {
            current = current.getNodeByChar(chr);
            if(current == null) return false;
        }
        return true;
    }
}
