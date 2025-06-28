package matrix.workingPeoplesImitation.task_2410_Maximum_Matching_of_Players_With_Trainers;

import java.util.Arrays;

// my solution
public class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int pIndex = 0;
        int tIndex = 0;
        while (pIndex < players.length && tIndex < trainers.length) {
            if (trainers[tIndex] >= players[pIndex]) {
                pIndex++;
            }
            tIndex++;
        }
        return pIndex;
    }
}
