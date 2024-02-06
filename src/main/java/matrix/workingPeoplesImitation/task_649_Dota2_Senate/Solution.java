package matrix.workingPeoplesImitation.task_649_Dota2_Senate;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    // my solution
    public String predictPartyVictory(String senate) {
        if (senate.length() == 1) return senate.charAt(0) == 'R' ? "Radiant" : "Dire";
        int outRadiantCount = 0;
        int outDireCount = 0;
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : senate.toCharArray())
            queue.offer(ch);
        boolean hasR;
        boolean hasD;
        while (queue.size() != 0) {
            int length = queue.size();
            hasR = false;
            hasD = false;
            for (int i = 0; i < length; i++) {
                char currentSenator = queue.poll();
                if (currentSenator == 'R') {
                    if (outRadiantCount < 0) {
                        outRadiantCount++;
                    } else {
                        hasR = true;
                        outDireCount--;
                        queue.offer(currentSenator);
                    }
                } else {
                    if (outDireCount < 0) {
                        outDireCount++;
                    } else {
                        hasD = true;
                        outRadiantCount--;
                        queue.offer(currentSenator);
                    }
                }
            }
            if (!hasR || !hasD) break;
        }
        return queue.poll() == 'R' ? "Radiant" : "Dire";
    }

    // from walkccc.me (rewritten from C++ to Java using GPT)
    public static String predictPartyVictory2(String senate) {
        int n = senate.length();
        Queue<Integer> qR = new LinkedList<>();
        Queue<Integer> qD = new LinkedList<>();

        // Initialize queues with senator indices based on their party
        for (int i = 0; i < n; ++i) {
            if (senate.charAt(i) == 'R') {
                qR.offer(i);
            } else {
                qD.offer(i);
            }
        }

        // Continue the banning process until one party's queue is empty
        while (!qR.isEmpty() && !qD.isEmpty()) {
            int indexR = qR.poll();
            int indexD = qD.poll();

            // Compare the indices to determine which senator gets banned
            if (indexR < indexD) {
                qR.offer(indexR + n); // Add Radiant senator back to the queue for the next round
            } else {
                qD.offer(indexD + n); // Add Dire senator back to the queue for the next round
            }
        }

        // Return the result based on which party's queue is non-empty
        return qR.isEmpty() ? "Dire" : "Radiant";
    }

    // from GPT (greedy approach)
    public static String predictPartyVictory3(String senate) {
        int n = senate.length();

        // Array to keep track of bans on senators (-1 for Dire, 0 for not banned, 1 for Radiant)
        int[] bans = new int[n];
        int radiantBans = 0, direBans = 0; // Counters for the number of bans on each party

        // Continue the banning process until one party's senators are all banned
        while (radiantBans < n && direBans < n) {
            // Iterate through the senators and simulate the banning process
            for (int i = 0; i < n; i++) {
                char party = senate.charAt(i);

                // If the senator still has rights to vote
                if (bans[i] == 0) {
                    if (party == 'R') {
                        // Radiant senator bans the next Dire senator's right
                        if (direBans > 0) {
                            direBans--;
                            bans[i] = 1;
                        } else {
                            radiantBans++; // No Dire senator to ban, Radiant senator loses rights
                        }
                    } else if (party == 'D') {
                        // Dire senator bans the next Radiant senator's right
                        if (radiantBans > 0) {
                            radiantBans--;
                            bans[i] = -1;
                        } else {
                            direBans++; // No Radiant senator to ban, Dire senator loses rights
                        }
                    }
                }
            }
        }

        // Return the result based on which party has more remaining senators
        return (radiantBans > direBans) ? "Radiant" : "Dire";
    }

    // from GPT (using queue)
    public static String predictPartyVictory4(String senate) {
        int n = senate.length();

        // Create queues for Radiant and Dire parties to store the indices of senators
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();

        // Initialize queues with senator indices based on their party
        for (int i = 0; i < n; i++) {
            char party = senate.charAt(i);
            if (party == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }

        // Continue the banning process until one party's queue is empty
        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            int radiantIndex = radiantQueue.poll(); // Get the index of the next Radiant senator
            int direIndex = direQueue.poll();       // Get the index of the next Dire senator

            // Compare the indices to determine which senator gets banned
            if (radiantIndex < direIndex) {
                radiantQueue.offer(radiantIndex + n); // Add Radiant senator back to the queue for the next round
            } else {
                direQueue.offer(direIndex + n);       // Add Dire senator back to the queue for the next round
            }
        }

        // Return the result based on which party's queue is non-empty
        return radiantQueue.isEmpty() ? "Dire" : "Radiant";
    }

}
