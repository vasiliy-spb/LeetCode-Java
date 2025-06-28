package matrix.workingPeoplesImitation.task_677_Map_Sum_Pairs;

// my solution
public class MapSum {
    private final TrieNode root;
    public MapSum() {
        this.root = new TrieNode('\0');
    }

    public void insert(String key, int val) {
        int prevVal = Math.max(0, getPrevValue(key));
        TrieNode current = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (current.letters[ch - 'a'] == null) {
                current.letters[ch - 'a'] = new TrieNode(ch);
            }
            current = current.letters[ch - 'a'];
            current.value += val - prevVal;
        }
        current.isWord = true;
        current.wordValue = val;
    }

    private int getPrevValue(String key) {
        TrieNode current = this.root;
        for (int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if (current.letters[ch - 'a'] == null) {
                return -1;
            }
            current = current.letters[ch - 'a'];
        }
        return current.isWord ? current.wordValue : 0;
    }

    public int sum(String prefix) {
        if (getPrevValue(prefix) < 0) {
            return 0;
        }
        TrieNode current = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            current = current.letters[ch - 'a'];
        }
        return current.value;
    }


    static final class TrieNode {
        char letter;
        TrieNode[] letters;
        boolean isWord;
        int value;
        int wordValue;

        public TrieNode(char letter) {
            this.letter = letter;
            this.letters = new TrieNode[26];
        }
    }
}
