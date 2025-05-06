package matrix.workingPeoplesImitation.task_3076_Shortest_Uncommon_Substring_in_an_Array;

// my solution
public class Solution {
    public String[] shortestSubstrings(String[] arr) {
        Trie trie = new Trie();
        buildTrie(arr, trie);
        String[] ans = findSubstrings(arr, trie);
        return ans;
    }

    private void buildTrie(String[] arr, Trie trie) {
        for (int wordIndex = 0; wordIndex < arr.length; wordIndex++) {
            String word = arr[wordIndex];
            for (int start = 0; start < word.length(); start++) {
                trie.add(word, start, wordIndex);
            }
        }
    }

    private String[] findSubstrings(String[] arr, Trie trie) {
        int n = arr.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            String word = arr[i];
            String best = "";
            for (int start = 0; start < word.length(); start++) {
                String current = trie.findMinUniqueSubstring(word, start);
                if (best.isEmpty()) {
                    best = current;
                }
                if (current.isEmpty()) {
                    continue;
                }
                if (current.length() < best.length() ||
                        (current.length() == best.length() && current.compareTo(best) < 0)) {
                    best = current;
                }
            }
            ans[i] = best;
        }
        return ans;
    }

    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode('\0');
        }

        public void add(String word, int start, int lastWordIndex) {
            TrieNode current = root;
            for (int i = start; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
                if (current.lastWordIndex != lastWordIndex) {
                    current.count++;
                    current.lastWordIndex = lastWordIndex;
                }
            }
        }

        public String findMinUniqueSubstring(String s, int start) {
            TrieNode current = root;
            for (int i = start; i < s.length(); i++) {
                char ch = s.charAt(i);
                current = current.letters[ch - 'a'];
                if (current.count == 1) {
                    return s.substring(start, i + 1);
                }
            }
            return current.count == 1 ? s : "";
        }

        static class TrieNode {
            char value;
            TrieNode[] letters;
            int count;
            int lastWordIndex;

            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
                this.count = 0;
                this.lastWordIndex = -1;
            }
        }
    }
}
