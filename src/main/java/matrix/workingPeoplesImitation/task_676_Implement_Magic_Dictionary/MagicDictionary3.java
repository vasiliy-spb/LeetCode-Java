package matrix.workingPeoplesImitation.task_676_Implement_Magic_Dictionary;

import java.util.*;

// from leetcode editorial (Approach #2: Generalized Neighbors [Accepted])
public class MagicDictionary3 {
    Set<String> words;
    Map<String, Integer> count;

    public MagicDictionary3() {
        words = new HashSet();
        count = new HashMap();
    }

    private ArrayList<String> generalizedNeighbors(String word) {
        ArrayList<String> ans = new ArrayList();
        char[] ca = word.toCharArray();
        for (int i = 0; i < word.length(); ++i) {
            char letter = ca[i];
            ca[i] = '*';
            String magic = new String(ca);
            ans.add(magic);
            ca[i] = letter;
        }
        return ans;
    }

    public void buildDict(String[] words) {
        for (String word : words) {
            this.words.add(word);
            for (String nei : generalizedNeighbors(word)) {
                count.put(nei, count.getOrDefault(nei, 0) + 1);
            }
        }
    }

    public boolean search(String word) {
        for (String nei : generalizedNeighbors(word)) {
            int c = count.getOrDefault(nei, 0);
            if (c > 1 || c == 1 && !words.contains(word)) {
                return true;
            }
        }
        return false;
    }
}
