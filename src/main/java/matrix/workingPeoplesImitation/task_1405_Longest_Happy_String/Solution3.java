package matrix.workingPeoplesImitation.task_1405_Longest_Happy_String;

// from leetcode editorial (Approach 2: Greedy Approach)
public class Solution3 {
    public String longestDiverseString(int a, int b, int c) {
        int curra = 0, currb = 0, currc = 0;
        // Maximum total iterations possible is given by the sum of a, b and c.
        int totalIterations = a + b + c;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < totalIterations; i++) {
            if (
                    (a >= b && a >= c && curra != 2) ||
                            (a > 0 && (currb == 2 || currc == 2))
            ) {
                // If 'a' is maximum and it's streak is less than 2, or if streak of 'b' or 'c' is 2, then 'a' will be the next character.
                ans.append('a');
                a--;
                curra++;
                currb = 0;
                currc = 0;
            } else if (
                    (b >= a && b >= c && currb != 2) ||
                            (b > 0 && (currc == 2 || curra == 2))
            ) {
                // If 'b' is maximum and it's streak is less than 2, or if streak of 'a' or 'c' is 2, then 'b' will be the next character.
                ans.append('b');
                b--;
                currb++;
                curra = 0;
                currc = 0;
            } else if (
                    (c >= a && c >= b && currc != 2) ||
                            (c > 0 && (curra == 2 || currb == 2))
            ) {
                // If 'c' is maximum and it's streak is less than 2, or if streak of 'a' or 'b' is 2, then 'c' will be the next character.
                ans.append('c');
                c--;
                currc++;
                curra = 0;
                currb = 0;
            }
        }
        return ans.toString();
    }
}

/*
Approach 2: Greedy Approach
Intuition

Since we need to track the counts of only three characters, we can use three counters instead of a priority queue.

As we build the string, we check which counter has the highest count. We also track how many times we add each letter in a row. We keep separate counters (curra, currb, and currc) for how many times we add 'a', 'b', or 'c' consecutively.

If one of these counters reaches 2, we stop adding that letter. Instead, we add a letter with a counter of 0. By repeating this process, we can create the longest possible string.
Algorithm

    Set curra, currb, and currc to 0. These integers will track the current count of consecutive 'a's, 'b's, and 'c's added to the result string.
    Calculate totalIterations as the sum of a, b, and c.
    Initialize an empty string ans to store the final result.
    Iterate Through Total Iterations:
        For each iteration from 0 to totalIterations - 1, determine which character to add to the result string:
            Condition for 'a':
                If 'a' has the highest count compared to 'b' and 'c' and its consecutive count curra is less than 2, or if 'a' has remaining characters and either currb or currc equals 2, then add 'a' to the string.
                Decrement the count of 'a' and increment curra. Reset currb and currc to 0.
            Condition for 'b':
                If 'b' has the highest count compared to 'a' and 'c' and its consecutive count currb is less than 2, or if 'b' has remaining characters and either curra or currc equals 2, then add 'b' to the string.
                Decrement the count of 'b' and increment currb. Reset curra and currc to 0.
            Condition for 'c':
                If 'c' has the highest count compared to 'a' and 'b' and its consecutive count currc is less than 2, or if 'c' has remaining characters and either curra or currb equals 2, then add 'c' to the string.
                Decrement the count of 'c' and increment currc. Reset curra and currb to 0.
    Return the ans string.

 */