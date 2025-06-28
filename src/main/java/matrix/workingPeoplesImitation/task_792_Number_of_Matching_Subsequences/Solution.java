package matrix.workingPeoplesImitation.task_792_Number_of_Matching_Subsequences;

// my solution (WA)
public class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        Trie dictionary = new Trie();
        for (String word : words) {
            dictionary.add(word);
        }
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder current = new StringBuilder();
            current.append(s.charAt(i));
            if (dictionary.hasPrefix(current)) {
                if (dictionary.find(current)) {
                    count++;
                }
                for (int j = i + 1; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    current.append(ch);
                    if (dictionary.hasPrefix(current)) {
                        if (dictionary.find(current)) {
                            count++;
                        }
                    } else {
                        current.deleteCharAt(current.length() - 1);
                    }
                }
            }
        }
        return count;
    }

    static final class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
            }
            current.isWord = true;
        }

        public boolean hasPrefix(StringBuilder prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    return false;
                }
                current = current.letters[ch - 'a'];
            }
            return true;
        }

        public boolean find(StringBuilder word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    return false;
                }
                current = current.letters[ch - 'a'];
            }
            return current.isWord;
        }

        static final class TrieNode {
            char value;
            TrieNode[] letters;
            boolean isWord;

            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
            }
        }
    }
}
