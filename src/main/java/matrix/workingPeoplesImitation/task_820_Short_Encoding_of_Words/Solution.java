package matrix.workingPeoplesImitation.task_820_Short_Encoding_of_Words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// my solution
public class Solution {
    public int minimumLengthEncoding(String[] words) {
        Trie dictionary = new Trie();
        for (String word : words) {
            dictionary.add(word);
        }
        List<String> wordList = new ArrayList<>();
        dictionary.findAllMaxWord(dictionary.root, wordList, new StringBuilder());
        return wordList.stream().mapToInt(String::length).sum() + wordList.size();
    }
    static final class Trie {
        TrieNode root = new TrieNode('\0');
        public void add(String word) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (current.letters.get(ch) == null) {
                    current.letters.put(ch, new TrieNode(ch));
                }
                current = current.letters.get(ch);
            }
        }
        public void findAllMaxWord(TrieNode current, List<String> ans, StringBuilder word) {
            if (current.letters.isEmpty()) {
                ans.add(word.toString());
                return;
            }
            for (TrieNode node : current.letters.values()) {
                findAllMaxWord(node, ans, new StringBuilder(word).append(node.value));
            }
        }
        static final class TrieNode {
            char value;
            Map<Character, TrieNode> letters;
            boolean isWord;
            public TrieNode(char value) {
                this.value = value;
                this.letters = new HashMap<>();;
            }
        }
    }
}
