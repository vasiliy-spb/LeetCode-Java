package matrix.workingPeoplesImitation.task_1732_Find_the_Highest_Altitude;

public class Solution {

    // my solution
    public int largestAltitude1(int[] gain) {
        int[] prefixSumArray = new int[gain.length + 1];
        prefixSumArray[0] = 0;
        int maxAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            prefixSumArray[i + 1] = prefixSumArray[i] + gain[i];
            if (prefixSumArray[i + 1] > maxAltitude) maxAltitude = prefixSumArray[i + 1];
        }
        return maxAltitude;
    }

    // from GPT
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0;
        int highestAltitude = 0;

        for (int g : gain) {
            currentAltitude += g;
            highestAltitude = Math.max(highestAltitude, currentAltitude);
        }

        return highestAltitude;
    }

}
