package matrix.workingPeoplesImitation.task_2416_Sum_of_Prefix_Scores_of_Strings;

// my solution
public class Solution {
    public int[] sumPrefixScores(String[] words) {
        Trie dictionary = new Trie();
        for (String word : words) {
            dictionary.add(word);
        }
        int n = words.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = dictionary.calculateScoreForPrefix(words[i]);
        }
        return ans;
    }
    static final class Trie {
        TrieNode root = new TrieNode('\0');
        public void add(String word) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
                current.score++;
            }
        }
        public int calculateScoreForPrefix(String word) {
            int totalScore = 0;
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.letters[ch - 'a'];
                totalScore += current.score;
            }
            return totalScore;
        }
        static final class TrieNode {
            char value;
            TrieNode[] letters;
            int score;
            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
            }
        }
    }
}
