/**
 * Created by xiami on 2015/8/10.
 */
class TrieNode {
    private TrieNode[] next = new TrieNode[27]; // 'a'-'z' \0

    public TrieNode() {

    }

    TrieNode getNodeByChar(char chr) {
        return next[convertCharToIndex(chr)];
    }

    TrieNode getOrCreateNodeByChar(char chr) {
        int index = convertCharToIndex(chr);
        if(next[index] == null) {
            next[index] = new TrieNode();
        }
        return next[index];
    }

    private int convertCharToIndex(char chr) {
        return chr == 0 ? 26 : chr - 'a';
    }
}

