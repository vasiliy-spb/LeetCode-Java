package matrix.workingPeoplesImitation.task_676_Implement_Magic_Dictionary;

import java.util.Arrays;

// my solution (accepted)
public class MagicDictionary {
    DictionaryNode root;

    public MagicDictionary() {
        this.root = new DictionaryNode('\0');
    }

    public void buildDict(String[] dictionary) {
        Arrays.stream(dictionary).forEach(this::addWordToDictionary);
    }

    private void addWordToDictionary(String word) {
        DictionaryNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.letters[ch - 'a'] == null) {
                current.letters[ch - 'a'] = new DictionaryNode(ch);
            }
            current = current.letters[ch - 'a'];
        }
        current.isWord = true;
    }

    public boolean search(String searchWord) {
        return searchMagicWord(root, searchWord, 0, true);
    }

    private boolean searchMagicWord(DictionaryNode head, String word, int i, boolean canReplace) {
        if (i >= word.length()) {
            return head.isWord && !canReplace;
        }
        boolean found = false;
        int index = word.charAt(i) - 'a';
        if (!canReplace) {
            if (head.letters[index] != null) {
                found = searchMagicWord(head.letters[index], word, i + 1, false);
            }
        } else {
            for (int j = 0; j < 26; j++) {
                if (head.letters[j] != null) {
                    if (j == index) {
                        found |= searchMagicWord(head.letters[j], word, i + 1, true);
                    } else {
                        found |= searchMagicWord(head.letters[j], word, i + 1, false);
                    }
                }
            }
        }
        return found;
    }

    static class DictionaryNode {
        char value;
        DictionaryNode[] letters;
        boolean isWord;

        public DictionaryNode(char value) {
            this.value = value;
            this.letters = new DictionaryNode[26];
        }
    }
}
