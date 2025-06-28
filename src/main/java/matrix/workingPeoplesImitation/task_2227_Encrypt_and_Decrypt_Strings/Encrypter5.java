package matrix.workingPeoplesImitation.task_2227_Encrypt_and_Decrypt_Strings;

// from leetcode code sample (2)
public class Encrypter5 {

    private static final int ALPHABET_SIZE = 26;
    private static final String NOT_POSSIBLE_TO_ENCRYPT = "";

    private final Trie trie = new Trie();
    private final String[] keyToValue;

    public Encrypter5(char[] keys, String[] values, String[] dictionary) {
        keyToValue = new String[ALPHABET_SIZE];
        for (int i = 0; i < keys.length; ++i) {
            keyToValue[keys[i] - 'a'] = values[i];
        }

        for (String word : dictionary) {
            trie.addEncryptedWordToTrie(encrypt(word));
        }
    }

    public final String encrypt(String wordToEcrypt) {
        StringBuilder encryptedWord = new StringBuilder();
        for (char current : wordToEcrypt.toCharArray()) {
            if (keyToValue[current - 'a'] == null) {
                return NOT_POSSIBLE_TO_ENCRYPT;
            }
            encryptedWord.append(keyToValue[current - 'a']);
        }
        return encryptedWord.toString();
    }

    public int decrypt(String encryptedWord) {
        return trie.findNumberOfWordsInDictionaryWithCurrentEcryption(encryptedWord);
    }

    class Trie {

        private final class TrieNode {

            private static final int ALPHABET_SIZE = 26;
            TrieNode[] alphabet = new TrieNode[ALPHABET_SIZE];
            private int numberOfWordsInDictionaryWithCurrentEcryption;
        }

        private static final int NO_WORDS_IN_DICTIONARY_WITH_CURRENT_ECRYPTION = 0;
        private final TrieNode root = new TrieNode();

        public void addEncryptedWordToTrie(String encryptedWord) {
            TrieNode current = root;
            for (char letter : encryptedWord.toCharArray()) {
                int index = letter - 'a';
                if (current.alphabet[index] == null) {
                    current.alphabet[index] = new TrieNode();
                }
                current = current.alphabet[index];
            }
            ++current.numberOfWordsInDictionaryWithCurrentEcryption;
        }

        public int findNumberOfWordsInDictionaryWithCurrentEcryption(String encryptedWord) {
            TrieNode current = root;
            for (char letter : encryptedWord.toCharArray()) {
                int index = letter - 'a';
                if (current.alphabet[index] == null) {
                    return NO_WORDS_IN_DICTIONARY_WITH_CURRENT_ECRYPTION;
                }
                current = current.alphabet[index];
            }
            return current.numberOfWordsInDictionaryWithCurrentEcryption;
        }
    }
}

