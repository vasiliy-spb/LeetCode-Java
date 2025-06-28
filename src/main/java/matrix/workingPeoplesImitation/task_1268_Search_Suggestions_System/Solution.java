package matrix.workingPeoplesImitation.task_1268_Search_Suggestions_System;

import java.util.*;

public class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products)
            trie.insert(product);

        List<List<String>> result = new ArrayList<>();
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < searchWord.length(); i++) {
            prefix.append(searchWord.charAt(i));
            result.add(trie.prefix(prefix.toString()));
        }

        return result;
    }

    class TrieNode {
        char ch;
        Map<Character, TrieNode> children;
        boolean isWord;

        public TrieNode(char ch) {
            this.ch = ch;
            this.children = new HashMap<>();
            this.isWord = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode('\0');
        }

        public void insert(String word) {
            TrieNode current = this.root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if (current.children.get(ch) == null) {
                    current.children.put(ch, new TrieNode(ch));
                }

                current = current.children.get(ch);
            }
            current.isWord = true;
        }

        public List<String> prefix(String prefix) {
            List<String> words = new ArrayList<>();

            TrieNode current = this.root;

            for (int i = 0; i < prefix.length(); i++) {
                char ch = prefix.charAt(i);

                TrieNode node = current.children.get(ch);

                if (node == null) {
                    return words;
                }

                current = node;
            }

            dfs(current, prefix, words);

            return words.stream().sorted(Comparator.naturalOrder()).limit(3).toList();
        }

        private void dfs(TrieNode node, String word, List<String> words) {
            if (node.isWord) words.add(word);

            Map<Character, TrieNode> children = node.children;

            for (Map.Entry<Character, TrieNode> entry : children.entrySet()) {
                char ch = entry.getKey();

                TrieNode child = entry.getValue();

                dfs(child, word + ch, words);
            }
        }
    }

}
