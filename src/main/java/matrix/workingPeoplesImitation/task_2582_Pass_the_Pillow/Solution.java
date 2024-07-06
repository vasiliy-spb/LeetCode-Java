package matrix.workingPeoplesImitation.task_2582_Pass_the_Pillow;

public class Solution {

    // my solution
    public int passThePillow(int n, int time) {
        time = time % ((n - 1) * 2);
        if (time <= n - 1) return time + 1;
        else return n  - (time % (n - 1));
    }

    // from walkccc.me
    public int passThePillow2(int n, int time) {
        // Repeat every (n - 1) * 2 seconds.
        time %= (n - 1) * 2;
        if (time < n) // Go forward from 1.
            return 1 + time;
        return n - (time - (n - 1)); // Go backward from n.
    }

    // from leetcode editorial (Approach 1: Simulation)
    public int passThePillow3(int n, int time) {
        int currentPillowPosition = 1;
        int currentTime = 0;
        int direction = 1;
        while (currentTime < time) {
            if (
                    0 < currentPillowPosition + direction &&
                            currentPillowPosition + direction <= n
            ) {
                currentPillowPosition += direction;
                currentTime++;
            } else {
                // Reverse the direction if the next position is out of bounds
                direction *= -1;
            }
        }
        return currentPillowPosition;
    }

    // from leetcode editorial (Approach 2: Math)
    public int passThePillow4(int n, int time) {
        // Calculate the number of complete rounds of pillow passing
        int fullRounds = time / (n - 1);

        // Calculate the remaining time after complete rounds
        int extraTime = time % (n - 1);

        // Determine the position of the person holding the pillow
        // If fullRounds is even, the pillow is moving forward.
        // If fullRounds is odd, the pillow is moving backward.
        if (fullRounds % 2 == 0) {
            return extraTime + 1; // Position when moving forward
        } else {
            return n - extraTime; // Position when moving backward
        }
    }

}
