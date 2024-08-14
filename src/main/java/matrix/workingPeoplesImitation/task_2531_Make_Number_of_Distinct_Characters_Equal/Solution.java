package matrix.workingPeoplesImitation.task_2531_Make_Number_of_Distinct_Characters_Equal;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    // my solution (TLE)
    public boolean isItPossible0(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char ch : word1.toCharArray()) {
            map1.merge(ch, 1, Integer::sum);
        }
        for (char ch : word2.toCharArray()) {
            map2.merge(ch, 1, Integer::sum);
        }
        for (char ch1 : word1.toCharArray()) {
            for (char ch2 : word2.toCharArray()) {

                map1.merge(ch1, -1, Integer::sum);
                if (map1.get(ch1) == 0) {
                    map1.remove(ch1);
                }
                map1.merge(ch2, 1, Integer::sum);

                map2.merge(ch2, -1, Integer::sum);
                if (map2.get(ch2) == 0) {
                    map2.remove(ch2);
                }
                map2.merge(ch1, 1, Integer::sum);

                if (map1.size() == map2.size()) {
                    return true;
                }

                map1.merge(ch1, 1, Integer::sum);
                map1.merge(ch2, -1, Integer::sum);
                if (map1.get(ch2) == 0) {
                    map1.remove(ch2);
                }

                map2.merge(ch2, 1, Integer::sum);
                map2.merge(ch1, -1, Integer::sum);
                if (map2.get(ch1) == 0) {
                    map2.remove(ch1);
                }
            }
        }
        return false;
    }

    // my solution
    public boolean isItPossible(String word1, String word2) {
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];
        for (char ch : word1.toCharArray()) {
            frequency1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            frequency2[ch - 'a']++;
        }

        int count1 = (int) Arrays.stream(frequency1).filter(num -> num > 0).count();
        int count2 = (int) Arrays.stream(frequency2).filter(num -> num > 0).count();

        for (int i = 0; i < frequency1.length; i++) {
            if (frequency1[i] == 0) {
                continue;
            }
            for (int j = 0; j < frequency2.length; j++) {
                if (frequency2[j] == 0) {
                    continue;
                }
                if (i == j) {
                    if (count1 == count2) {
                        return true;
                    }
                } else {
                    if ((count1
                            - ((frequency1[i] - 1) == 0 ? 1 : 0)
                            + (frequency1[j] == 0 ? 1 : 0))
                            ==
                            (count2
                                    - ((frequency2[j] - 1) == 0 ? 1 : 0)
                                    + (frequency2[i] == 0 ? 1 : 0))
                    ) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

    // from walkccc.me
    public boolean isItPossible2(String word1, String word2) {
        final int[] count1 = getCount(word1);
        final int[] count2 = getCount(word2);
        final int distinct1 = getDistinct(count1);
        final int distinct2 = getDistinct(count2);

        for (int i = 0; i < 26; ++i)
            for (int j = 0; j < 26; ++j) {
                if (count1[i] == 0 || count2[j] == 0)
                    continue;
                if (i == j) {
                    // Swapping the same letters won't change the number of distinct
                    // letters in each string, so just check if `distinct1 == distinct2`.
                    if (distinct1 == distinct2)
                        return true;
                    continue;
                }
                // The calculation is meaningful only when i != j.
                // Swap ('a' + i) in word1 with ('a' + j) in word2.
                final int distinctAfterSwap1 =
                        distinct1 - (count1[i] == 1 ? 1 : 0) + (count1[j] == 0 ? 1 : 0);
                final int distinctAfterSwap2 =
                        distinct2 - (count2[j] == 1 ? 1 : 0) + (count2[i] == 0 ? 1 : 0);
                if (distinctAfterSwap1 == distinctAfterSwap2)
                    return true;
            }

        return false;
    }

    private int[] getCount(final String s) {
        int[] count = new int[26];
        for (final char c : s.toCharArray())
            ++count[c - 'a'];
        return count;
    }

    private int getDistinct(int[] count) {
        return (int) Arrays.stream(count).filter(c -> c > 0).count();
    }

}
