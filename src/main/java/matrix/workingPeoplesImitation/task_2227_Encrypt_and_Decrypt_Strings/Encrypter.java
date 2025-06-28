package matrix.workingPeoplesImitation.task_2227_Encrypt_and_Decrypt_Strings;

import java.util.*;

// my solution
public class Encrypter {
    Map<Character, String> encryptMap;
    Map<String, Set<Character>> decryptMap;
    Trie dict;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.encryptMap = new HashMap<>();
        this.decryptMap = new HashMap<>();
        for (int i = 0; i < keys.length; i++) {
            encryptMap.put(keys[i], values[i]);
            decryptMap.computeIfAbsent(values[i], set -> new HashSet<>()).add(keys[i]);
        }
        this.dict = new Trie();
        for (String word : dictionary) {
            dict.add(word);
        }
    }

    public String encrypt(String word1) {
        StringBuilder ans = new StringBuilder();
        for (char ch : word1.toCharArray()) {
            String s = encryptMap.getOrDefault(ch, "");
            if (s.equals("")) {
                return s;
            }
            ans.append(s);
        }
        return ans.toString();
    }

    public int decrypt(String word2) {
        int n = word2.length();
        List<Set<Character>> list = new ArrayList<>();
        for (int i = 0; i < n; i += 2) {
            Set<Character> set = decryptMap.getOrDefault(word2.substring(i, i + 2), new HashSet<>());
            if (set.isEmpty()) {
                return 0;
            }
            list.add(set);
        }

        int count = 0;
        Queue<Trie.TrieNode> queue = new ArrayDeque<>();
        queue.offer(dict.root);
        for (int i = 0; i < list.size(); i++) {
            Set<Character> set = list.get(i);
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Trie.TrieNode current = queue.poll();
                for (char ch : set) {
                    if (current.letters[ch - 'a'] != null) {
                        queue.offer(current.letters[ch - 'a']);
                    }
                }
            }
        }

        int size = queue.size();
        for (int j = 0; j < size; j++) {
            Trie.TrieNode current = queue.poll();
            if (current.isWord) {
                count++;
            }
        }
        return count;
    }
    static final class Trie {
        TrieNode root = new TrieNode();
        public void add(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.letters[ch - 'a'] == null) {
                    current.letters[ch - 'a'] = new TrieNode();
                }
                current = current.letters[ch - 'a'];
            }
            current.isWord = true;
        }
        public boolean find(String word) {
            TrieNode current = root;
            for (char ch : word.toCharArray()) {
                if (current.letters[ch - 'a'] == null) {
                    return false;
                }
                current = current.letters[ch - 'a'];
            }
            return current.isWord;
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
        static final class TrieNode {
            TrieNode[] letters;
            boolean isWord;
            public TrieNode() {
                this.letters = new TrieNode[26];
            }
        }
    }
}
