package matrix.workingPeoplesImitation.task_2506_Count_Pairs_Of_Similar_Strings;

// from walkccc.me
public class Solution2 {
    public int similarPairs(String[] words) {
        int ans = 0;
        int[] masks = new int[words.length];

        for (int i = 0; i < words.length; ++i)
            masks[i] = getMask(words[i]);

        for (int i = 0; i < masks.length; ++i)
            for (int j = i + 1; j < masks.length; ++j)
                if (masks[i] == masks[j])
                    ++ans;

        return ans;
    }

    private int getMask(final String word) {
        int mask = 0;
        for (final char c : word.toCharArray())
            mask |= 1 << c - 'a';
        return mask;
    }
}