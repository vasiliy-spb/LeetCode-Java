package matrix.workingPeoplesImitation.task_1935_Maximum_Number_of_Words_You_Can_Type;

// from walkccc.me
public class Solution2 {
    public int canBeTypedWords(String text, String brokenLetters) {
        int ans = 0;
        boolean[] broken = new boolean[26];

        for (final char c : brokenLetters.toCharArray())
            broken[c - 'a'] = true;

        for (final String word : text.split(" "))
            ans += canBeTyped(word, broken);

        return ans;
    }

    private int canBeTyped(final String word, boolean[] broken) {
        for (final char c : word.toCharArray())
            if (broken[c - 'a'])
                return 0;
        return 1;
    }
}
