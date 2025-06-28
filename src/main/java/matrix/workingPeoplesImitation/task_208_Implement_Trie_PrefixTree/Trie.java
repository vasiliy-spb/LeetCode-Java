package matrix.workingPeoplesImitation.task_208_Implement_Trie_PrefixTree;

public class Trie {

    TrieNode root;

    public Trie() {
        this.root = new TrieNode('\0');
    }

    public void insert(String word) {
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                current.children[ch - 'a'] = new TrieNode(ch);
            }

            current = current.children[ch - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        TrieNode current = find(word);
        return current != null && current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = find(prefix);
        return current != null;
    }

    private TrieNode find(String word) {
        if (word == null || word.length() == 0) return null;
        TrieNode current = this.root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return null;
            }

            current = current.children[ch - 'a'];
        }
        return current;
    }

}

class TrieNode {
    char ch;
    TrieNode[] children;
    boolean isWord;

    public TrieNode(char ch) {
        this.ch = ch;
        this.children = new TrieNode[26];
        this.isWord = false;
    }
}