package matrix.workingPeoplesImitation.task_3093_Longest_Common_Suffix_Queries;

import java.util.*;

// my solution
public class Solution {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie dictionary = new Trie();
        for (int i = 0; i < wordsContainer.length; i++) {
            dictionary.add(wordsContainer[i], i);
        }
        Map<String, Integer> cache = new HashMap<>();
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            String query = wordsQuery[i];
            if (cache.containsKey(query)) {
                ans[i] = cache.get(query);
            } else {
                ans[i] = dictionary.getIndexOfMaxSuffix(query);
                cache.put(query, ans[i]);
            }
        }
        return ans;
    }

    static class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(String word, int index) {
            TrieNode current = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
            }
            current.isWord = true;
            current.addIndex(index);
        }

        public int getIndexOfMaxSuffix(String word) {
            TrieNode current = root;
            int length = 0;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (current.letters[ch - 'a'] == null) {
                    break;
                }
                length++;
                current = current.letters[ch - 'a'];
            }
            if (current.isWord) {
                return current.getMinIndex();
            }
            Queue<TrieNode> queue = new ArrayDeque<>();
            for (int i = 0; i < 26; i++) {
                if (current.letters[i] != null) {
                    queue.offer(current.letters[i]);
                }
            }
            List<TrieNode> wordNode = new ArrayList<>();
            one: while (!queue.isEmpty() && wordNode.isEmpty()) {
                length++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TrieNode node = queue.poll();
                    if (node.isWord) {
                        wordNode.add(node);
                    } else {
                        for (int j = 0; j < 26; j++) {
                            if (node.letters[j] != null) {
                                queue.offer(node.letters[j]);
                            }
                        }
                    }
                }
            }
            int minIndex = Integer.MAX_VALUE;
            for (TrieNode node : wordNode) {
                for (int index : node.indexes) {
                    minIndex = Math.min(minIndex, index);
                }
            }
            return minIndex;
        }

        static final class TrieNode {
            char value;
            TrieNode[] letters;
            boolean isWord;
            List<Integer> indexes;

            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
                this.indexes = new ArrayList<>();
            }

            private void addIndex(int index) {
                if (this.indexes.isEmpty()) {
                    this.indexes.add(index);
                } else {
                    if (this.indexes.get(this.indexes.size() - 1) < index) {
                        this.indexes.add(this.indexes.size() - 1, index);
                    } else {
                        this.indexes.add(index);
                    }
                }
            }

            private int getMinIndex() {
                return this.indexes.get(this.indexes.size() - 1);
            }
        }
    }
}
