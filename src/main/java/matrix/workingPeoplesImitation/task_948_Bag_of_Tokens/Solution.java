package matrix.workingPeoplesImitation.task_948_Bag_of_Tokens;

import java.util.Arrays;

public class Solution {

    // my solution
    public int bagOfTokensScore(int[] tokens, int power) {
        if (tokens.length == 0) return 0;
        Arrays.sort(tokens);
        int score = 0;
        int left = 0;
        int right = tokens.length - 1;
        while (left < right) {
            if (power >= tokens[left]) {
                power -= tokens[left++];
                score++;
            } else {
                if (score > 0 && power + tokens[right] >= tokens[left]) {
                    power += tokens[right--];
                    score--;
                } else break;
            }
        }
        if (power >= tokens[left]) score++;
        return score;
    }

    // from walkccc.me
    public int bagOfTokensScore2(int[] tokens, int power) {
        int ans = 0;
        int score = 0;
        int i = 0;                 // the index of the smallest token
        int j = tokens.length - 1; // the index of the largest token

        Arrays.sort(tokens);

        while (i <= j && (power >= tokens[i] || score > 0)) {
            while (i <= j && power >= tokens[i]) {
                // Play the smallest face up.
                power -= tokens[i++];
                ++score;
            }
            ans = Math.max(ans, score);
            if (i <= j && score > 0) {
                // Play the largest face down.
                power += tokens[j--];
                --score;
            }
        }

        return ans;
    }
}
