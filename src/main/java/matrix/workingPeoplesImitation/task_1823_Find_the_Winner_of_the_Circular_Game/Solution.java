package matrix.workingPeoplesImitation.task_1823_Find_the_Winner_of_the_Circular_Game;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    // my solution
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++)
            list.add(i);
        int start = 0;
        while (list.size() > 1) {
            start += k - 1;
            start %= list.size();
            list.remove(start);
        }
        return list.get(0);
    }

    // from leetcode editorial (Approach 1: Simulation with List)
    public int findTheWinner2(int n, int k) {
        // Initialize list of N friends, labeled from 1-N
        LinkedList<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Maintain the index of the friend to start the count on
        int startIndex = 0;

        // Perform eliminations while there is more than 1 friend left
        while (circle.size() > 1) {
            // Calculate the index of the friend to be removed
            int removalIndex = (startIndex + k - 1) % circle.size();

            // Erase the friend at removalIndex
            circle.remove(removalIndex);

            // Update startIndex for the next round
            startIndex = removalIndex;
        }

        return circle.getFirst();
    }

    // from leetcode editorial (Approach 2: Simulation with Queue)
    public int findTheWinner3(int n, int k) {
        // Initialize queue with n friends
        Queue<Integer> circle = new LinkedList<Integer>();
        for (int i = 1; i <= n; i++) {
            circle.add(i);
        }

        // Perform eliminations while more than 1 player remains
        while (circle.size() > 1) {
            // Process the first k-1 friends without eliminating them
            for (int i = 0; i < k - 1; i++) {
                circle.add(circle.remove());
            }
            // Eliminate the k-th friend
            circle.remove();
        }

        return circle.peek();
    }

    // from leetcode editorial (Approach 3: Recursion)
    public int findTheWinner4(int n, int k) {
        return winnerHelper(n, k) + 1;
    }

    private int winnerHelper(int n, int k) {
        if (n == 1) {
            return 0;
        }
        return (winnerHelper(n - 1, k) + k) % n;
    }

    // from leetcode editorial (Approach 4: Iterative)
    public int findTheWinner5(int n, int k) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + k) % i;
        }
        // add 1 to convert back to 1 indexing
        return ans + 1;
    }

    // from walkccc.me (Approach 1: Simulation)
    public int findTheWinner6(int n, int k) {
        // friends[i] := true if i-th friend is left
        boolean[] friends = new boolean[n];

        int friendCount = n;
        int fp = n; // friends' index

        while (friendCount > 1) {
            for (int i = 0; i < k; ++i, ++fp)
                while (friends[fp % n]) // The friend is not there.
                    ++fp;                 // Point to the next one.
            friends[(fp - 1) % n] = true;
            --friendCount;
        }

        for (fp = 0; friends[fp]; ++fp)
            ;
        return fp + 1;
    }

    // from walkccc.me (Approach 2: Recursive Josephus)
    public int findTheWinner7(int n, int k) {
        // Converts back to 1-indexed.
        return f(n, k) + 1;
    }

    // e.g. n = 4, k = 2.
    // By using 0-indexed notation, we have the following circle:
    //
    // 0 -> 1 -> 2 -> 3 -> 0
    //      x
    //           0 -> 1 -> 2 -> 0
    //
    // After the first round, 1 is removed.
    // So, 2 becomes 0, 3 becomes 1, and 0 becomes 2.
    // Let's denote that oldIndex = f(n, k) and newIndex = f(n - 1, k).
    // By observation, we know f(n, k) = (f(n - 1, k) + k) % n.
    private int f(int n, int k) {
        if (n == 1)
            return 0;
        return (f(n - 1, k) + k) % n;
    }

    // from walkccc.me (Approach 3: Iterative Josephus)
    public int findTheWinner8(int n, int k) {
        // Converts back to 1-indexed.
        return f2(n, k) + 1;
    }

    // e.g. n = 4, k = 2.
    // By using 0-indexed notation, we have the following circle:
    //
    // 0 -> 1 -> 2 -> 3 -> 0
    //      x
    //           0 -> 1 -> 2 -> 0
    //
    // After the first round, 1 is removed.
    // So, 2 becomes 0, 3 becomes 1, and 0 becomes 2.
    // Let's denote that oldIndex = f(n, k) and newIndex = f(n - 1, k).
    // By observation, we know f(n, k) = (f(n - 1, k) + k) % n.
    private int f2(int n, int k) {
        int ans = 0; // f(1, k)
        // Computes f(i, k) based on f(i - 1, k).
        for (int i = 2; i <= n; ++i)
            ans = (ans + k) % i;
        return ans;
    }

}
