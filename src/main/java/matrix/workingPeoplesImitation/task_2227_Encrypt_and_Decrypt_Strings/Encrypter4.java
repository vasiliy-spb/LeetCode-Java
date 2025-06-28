package matrix.workingPeoplesImitation.task_2227_Encrypt_and_Decrypt_Strings;

import java.util.HashMap;

// from leetcode code sample (1)
public class Encrypter4 {
    String[] encryptList = new String['z' + 1];
    HashMap<String, Integer> HM = new HashMap<>();

    public Encrypter4(char[] keys, String[] values, String[] dictionary) {
        for (int i = 0; i < keys.length; i++) {
            encryptList[keys[i]] = values[i];
        }
        for (String word : dictionary) {
            String str = encrypt(word);
            HM.put(str, HM.getOrDefault(str, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        char[] chrs = new char[word1.length() * 2];
        for (int i = 0; i < word1.length(); i++) {
            String str = encryptList[word1.charAt(i)];
            if (str == null)
                return "@";
            chrs[2 * i] = str.charAt(0);
            chrs[2 * i + 1] = str.charAt(1);
        }
        return new String(chrs);
    }

    public int decrypt(String word2) {
        return HM.getOrDefault(word2, 0);
    }
}
