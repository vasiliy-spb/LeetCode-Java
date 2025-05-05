package matrix.workingPeoplesImitation.task_1032_Stream_of_Characters;

// my solution
public class StreamChecker {
    private final TrieNode root;
    private final StringBuilder stream;

    public StreamChecker(String[] words) {
        this.root = new TrieNode('\0');
        this.stream = new StringBuilder();
        for (String word : words) {
            add(word);
        }
    }

    public boolean query(char letter) {
        stream.append(letter);
        return find(stream);
    }

    private void add(String word) {
        TrieNode current = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (current.letters[ch - 'a'] == null) {
                current.letters[ch - 'a'] = new TrieNode(ch);
            }
            current = current.letters[ch - 'a'];
        }
        current.isWord = true;
    }

    private boolean find(StringBuilder word) {
        TrieNode current = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            if (current.letters[ch - 'a'] == null) {
                return false;
            }
            current = current.letters[ch - 'a'];
            if (current.isWord) {
                return true;
            }
        }
        return false;
    }

    static class TrieNode {
        char value;
        TrieNode[] letters;
        boolean isWord;

        public TrieNode(char value) {
            this.value = value;
            this.letters = new TrieNode[26];
            this.isWord = false;
        }
    }
}
