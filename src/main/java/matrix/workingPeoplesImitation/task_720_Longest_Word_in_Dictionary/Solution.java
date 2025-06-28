package matrix.workingPeoplesImitation.task_720_Longest_Word_in_Dictionary;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// my solution
public class Solution {
    public String longestWord(String[] words) {
        for (String word : words) {
            add(word);
        }
        int maxLength = 0;
        for (TrieNode node : dictionary.letters) {
            if (node != null) {
                maxLength = Math.max(maxLength, findMaxConsecutiveLength(node));
            }
        }
        List<String> list = new ArrayList<>();
        findAllWordWithLength(dictionary, maxLength, list, new StringBuilder());
        list.sort(Comparator.naturalOrder());
        return list.isEmpty() ? "" : list.get(0);
    }

    private void findAllWordWithLength(TrieNode currentNode, int targetLength, List<String> list, StringBuilder current) {
        if (currentNode != dictionary && !currentNode.isWord) {
            return;
        }
        if (current.length() == targetLength) {
            list.add(current.toString());
            return;
        }
        for (int i = 0; i < currentNode.letters.length; i++) {
            if (currentNode.letters[i] != null) {
                findAllWordWithLength(currentNode.letters[i], targetLength, list, new StringBuilder().append(current).append((char) (i + 'a')));
            }
        }
    }

    private final TrieNode dictionary = new TrieNode('\0');

    private void add(String word) {
        TrieNode current = dictionary;
        for (char ch : word.toCharArray()) {
            if (current.letters[ch - 'a'] == null) {
                current.letters[ch - 'a'] = new TrieNode(ch);
            }
            current = current.letters[ch - 'a'];
        }
        current.isWord = true;
    }
    private int findMaxConsecutiveLength(TrieNode current) {
        if (!current.isWord) {
            return 0;
        }
        int tailLength = 0;
        for (TrieNode node : current.letters) {
            if (node != null) {
                tailLength = Math.max(tailLength, findMaxConsecutiveLength(node));
            }
        }
        return tailLength + 1;
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
