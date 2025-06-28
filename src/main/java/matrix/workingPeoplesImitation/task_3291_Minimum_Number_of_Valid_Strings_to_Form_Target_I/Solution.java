package matrix.workingPeoplesImitation.task_3291_Minimum_Number_of_Valid_Strings_to_Form_Target_I;

// my solution
public class Solution {
    public int minValidStrings(String[] words, String target) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.add(word);
        }
        int count = 0;
        int index = 0;
        while (index < target.length()) {
            count++;
            int maxLength = trie.getMaxPrefixLength(target, index);
            int bestSum = index + maxLength;
            if (bestSum == target.length()) {
                break;
            }
            int bestLength = 0;
            for (int prefix = 1; prefix <= maxLength; prefix++) {
                int nextLength = trie.getMaxPrefixLength(target, index + prefix);
                if (index + prefix + nextLength >= bestSum) {
                    bestSum = index + prefix + nextLength;
                    bestLength = prefix;
                }
            }
            if (bestLength == 0) {
                return -1;
            }
            index += bestLength;
        }
        return count;
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode('\0');
        }

        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
            }
        }

        public int getMaxPrefixLength(String word, int start) {
            TrieNode current = root;
            int length = 0;
            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    break;
                }
                current = current.letters[ch - 'a'];
                length++;
            }
            return length;
        }

        static class TrieNode {
            char value;
            TrieNode[] letters;

            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
            }
        }
    }
}
