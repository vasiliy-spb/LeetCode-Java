package matrix.workingPeoplesImitation.task_211_Design_Add_and_Search_Words_Data_Structure;


class WordDictionary {
    WordNode root;

    public WordDictionary() {
        this.root = new WordNode('\0');
    }

    public void addWord(String word) {
        WordNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (current.letters[ch - 'a'] == null) current.letters[ch - 'a'] = new WordNode(ch);
            current = current.letters[ch - 'a'];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return find(word, root);
    }

    private boolean find(String word, WordNode rootNode) {
        WordNode current = rootNode;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (current.letters[j] != null) {
                        if (i == word.length() - 1 && current.letters[j].isEnd) return true;
                        boolean found = find(word.substring(i + 1), current.letters[j]);
                        if (found) return true;
                    }
                }
                return false;
            } else {
                if (current.letters[ch - 'a'] == null) return false;
                current = current.letters[ch - 'a'];
            }
        }
        return current.isEnd;
    }

    private static class WordNode {
        char letter;
        WordNode[] letters;
        boolean isEnd;

        public WordNode(char letter) {
            this.letter = letter;
            this.letters = new WordNode[26];
            this.isEnd = false;
        }
    }
}

/*

Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]

Output (expected)
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


 */

/*

Example 2:

Input
["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]

Output (expected)
[null,null,null,null,null,false,false,null,true,true,false,false,true,false]


 */