package matrix.workingPeoplesImitation.task_745_Prefix_and_Suffix_Search;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// my solution
public class WordFilter {

    Trie prefixTrie;
    Trie suffixTrie;
    Map<String, Integer> cache;

    public WordFilter(String[] words) {
        this.prefixTrie = new Trie();
        this.suffixTrie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            prefixTrie.add(word, i);
            suffixTrie.add(new StringBuilder(word).reverse().toString(), i);
        }
        this.cache = new HashMap<>();
    }

    public int f(String pref, String suff) {
        suff = new StringBuilder(suff).reverse().toString();
        if (!prefixTrie.containsPrefix(pref) || !suffixTrie.containsPrefix(suff)) {
            return -1;
        }
        if (cache.containsKey(pref + "_" + suff)) {
            return cache.get(pref + "_" + suff);
        }
        Set<Integer> pIndexes = prefixTrie.getIndexesForLastNode(pref);
        Set<Integer> sIndexes = suffixTrie.getIndexesForLastNode(suff);
        int maxIndex = -1;
        for (int index : pIndexes) {
            if (sIndexes.contains(index)) {
                maxIndex = Math.max(maxIndex, index);
            }
        }
        if (maxIndex >= 0) {
            cache.put(pref + "_" + suff, maxIndex);
        }
        return maxIndex;
    }

    static class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(String word, int index) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode(ch);
                }
                current = current.letters[ch - 'a'];
                current.indexes.add(index);
            }
        }

        public boolean containsPrefix(String prefix) {
            TrieNode current = root;
            for (char ch : prefix.toCharArray()) {
                if (current.letters[ch - 'a'] == null) {
                    return false;
                }
                current = current.letters[ch - 'a'];
            }
            return true;
        }

        public Set<Integer> getIndexesForLastNode(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                current = current.letters[ch - 'a'];
            }
            return current.indexes;
        }

        static class TrieNode {
            char value;
            TrieNode[] letters;
            Set<Integer> indexes;

            public TrieNode(char value) {
                this.value = value;
                this.letters = new TrieNode[26];
                this.indexes = new HashSet<>();
            }
        }
    }
}
