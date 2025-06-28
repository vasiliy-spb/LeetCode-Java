package matrix.workingPeoplesImitation.task_299_Bulls_and_Cows;

import java.util.Arrays;

public class Solution {

    // my solution
    public String getHint(String secret, String guess) {
        int aCount = 0;
        int bCount = 0;
        int[] counter = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            int num = Character.digit(secret.charAt(i), 10);
            if (secret.charAt(i) == guess.charAt(i)) {
                aCount++;
            } else {
                counter[num]++;
            }
        }
        for (int i = 0; i < secret.length(); i++) {
            int num = Character.digit(guess.charAt(i), 10);
            if (secret.charAt(i) != guess.charAt(i)) {
                if (counter[num] > 0) {
                    bCount++;
                    counter[num]--;
                }
            }
        }
        return aCount + "A" + bCount + "B";
    }

    // from walkccc.me
    public String getHint2(String secret, String guess) {
        int A = 0;
        int B = 0;
        int[] count1 = new int[10];
        int[] count2 = new int[10];

        for (int i = 0; i < secret.length(); ++i)
            if (secret.charAt(i) == guess.charAt(i))
                ++A;
            else {
                ++count1[secret.charAt(i) - '0'];
                ++count2[guess.charAt(i) - '0'];
            }

        for (int i = 0; i < 10; ++i)
            B += Math.min(count1[i], count2[i]);

        return String.valueOf(A) + "A" + String.valueOf(B) + "B";
    }

    // from leetcode code sample
    public String getHint3(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        // to store count of potential of digits
        int[] secretCount = new int[10];
        int[] guessCount = new int[10];
        // secret.length because we only care about the digits matching to secret
        for(int i = 0 ; i < secret.length() ; i++){
            if(secret.charAt(i) == guess.charAt(i)) bulls++;
            else { // maintaining count for potential
                secretCount[secret.charAt(i)-'0']++;
                guessCount[guess.charAt(i)-'0']++;
            }
        }

        for(int i = 0; i < secretCount.length; i++){
            // this is a neat trick because only end up choosing the balance, of how much should actually exist
            cows += Math.min(secretCount[i], guessCount[i]);
        }
        return bulls + "A" + cows + "B";
    }

}
