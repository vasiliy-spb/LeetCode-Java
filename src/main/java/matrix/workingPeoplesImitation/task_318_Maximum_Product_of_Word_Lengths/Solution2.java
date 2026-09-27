package matrix.workingPeoplesImitation.task_318_Maximum_Product_of_Word_Lengths;

// my solution (2)
public class Solution2 {
    public int maxProduct(String[] words) {
        int n = words.length;
        Word[] allWords = new Word[n];
        for (int i = 0; i < n; i++) {
            allWords[i] = new Word(words[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (allWords[i].hasCommonLetters(allWords[j])) {
                    continue;
                }
                ans = Math.max(ans, allWords[i].getLength() * allWords[j].getLength());
            }
        }
        return ans;
    }

    private static class Word {
        private final char[] chars;
        private int binary = 0;

        public Word(String value) {
            this.chars = value.toCharArray();
            initBinary();
        }

        private void initBinary() {
            for (char ch : chars) {
                int position = ch - 'a';
                binary |= (1 << position);
            }
        }

        public boolean hasCommonLetters(Word otherWord) {
            return (getBinary() & otherWord.getBinary()) > 0;
        }

        public int getBinary() {
            return binary;
        }

        public int getLength() {
            return chars.length;
        }
    }
}
