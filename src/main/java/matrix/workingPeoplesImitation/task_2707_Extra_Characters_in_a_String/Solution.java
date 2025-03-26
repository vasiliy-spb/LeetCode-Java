package matrix.workingPeoplesImitation.task_2707_Extra_Characters_in_a_String;

import java.util.Arrays;

// my solution
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Trie wordTree = new Trie();
        for (String word : dictionary) {
            wordTree.add(word);
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            boolean found = false;
            StringBuilder current = new StringBuilder();
            for (int j = i; j < n; j++) {
                current.append(s.charAt(j));
                if (wordTree.find(current + "")) {
                    found = true;
                    dp[j + 1] = Math.min(dp[j + 1], dp[i]);
                } else if (!wordTree.hasPrefix(current + "")) {
                    dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                    break;
                }
            }
            if (!found) {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            }
        }
        return dp[n];
    }

    static class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (current.letters[letter - 'a'] == null) {
                    current.letters[letter - 'a'] = new TrieNode(letter);
                }
                current = current.letters[letter - 'a'];
            }
            current.isWord = true;
        }

        public boolean find(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (current.letters[letter - 'a'] == null) {
                    return false;
                }
                current = current.letters[letter - 'a'];
            }
            return current.isWord;
        }

        public boolean hasPrefix(String prefix) {
            TrieNode current = root;
            for (int i = 0; i < prefix.length(); i++) {
                char letter = prefix.charAt(i);
                if (current.letters[letter - 'a'] == null) {
                    return false;
                }
                current = current.letters[letter - 'a'];
            }
            return true;
        }

        static class TrieNode {
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
