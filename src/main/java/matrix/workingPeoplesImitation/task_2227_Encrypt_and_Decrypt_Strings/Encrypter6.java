package matrix.workingPeoplesImitation.task_2227_Encrypt_and_Decrypt_Strings;

import java.util.*;

// from leetcode code sample (3)
class Encrypter6 {
    public String map[];
    public HashMap<String, List<Character>> hm;
    public HashSet<String> dict;
    public HashMap<String, Integer> dp;
    public HashMap<String, Integer> eDict;
    public Encrypter6(char[] keys, String[] values, String[] dictionary) {
        map = new String[26];
        hm = new HashMap<>();
        dict = new HashSet<>();
        dp = new HashMap<>();
        eDict = new HashMap<>();
        Arrays.fill(map, "-1");
        for(int i=0;i<keys.length;i++) {
            map[keys[i] - 'a'] = values[i]; // mapping of char
        }

        for(int i=0;i<values.length;i++) {
            if(!hm.containsKey(values[i])) {
                hm.put(values[i], new ArrayList<>());
            }

            hm.get(values[i]).add(keys[i]);
        }

        for(String s: dictionary) {
            dict.add(s);
            String ed = encrypt(s);
            eDict.put(ed, eDict.getOrDefault(ed, 0)+1);
        }

    }

    public String encrypt(String word1) {
        StringBuffer bf = new StringBuffer("");

        for(char ch: word1.toCharArray()) {
            if(map[ch-'a']=="-1") return "";
            bf.append(map[ch-'a']);
        }

        return bf.toString();
    }

    public int decrypt(String word2) {
        return eDict.getOrDefault(word2, 0);
    }

    public int backtrack(String word2, int i, String bf) {
        int n = word2.length();
        //System.out.println(i+" "+bf);
        if(i==n) {
            if(bf.length()!=0) {
                if(dict.contains(bf)) return 1;
            }
            return 0;
        }
        String key = bf + "" + i;
        if(dp.containsKey(key)) return dp.get(key);

        int ans = 0;

        String sub = word2.substring(i, i+2);
        if(!hm.containsKey(sub)) return 0;
        //System.out.println(hm.get(sub).toString());
        for(char op: hm.get(sub)) {
            ans = ans + backtrack(word2, i+2, bf+""+op);
        }

        dp.put(key, ans);

        return ans;

    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
// backtracking onf decrtypt I think;
