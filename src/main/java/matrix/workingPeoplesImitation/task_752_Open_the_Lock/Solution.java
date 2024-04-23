package matrix.workingPeoplesImitation.task_752_Open_the_Lock;

import java.util.*;

public class Solution {
    // my solution
    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        Set<String> checked = new HashSet<>();
        Queue<String> queue = new ArrayDeque<>();
        queue.add("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String combination = queue.poll();
                if (combination.equals(target)) return count;
                if (deadendSet.contains(combination)) {
                    checked.add(combination);
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String current = incrementPosition(combination, j);
                    if (!deadendSet.contains(current) && !checked.contains(current)) {
                        checked.add(current);
                        queue.offer(current);
                    }
                    current = decrementPosition(combination, j);
                    if (!deadendSet.contains(current) && !checked.contains(current)) {
                        checked.add(current);
                        queue.offer(current);
                    }
                }
            }
            count++;
        }
        return -1;
    }

    private String decrementPosition(String combination, int j) {
        char[] nums = combination.toCharArray();
        nums[j] = (char) ((nums[j] - '0' + 9) % 10 + '0');
        return String.format("%s%s%s%s", nums[0], nums[1], nums[2], nums[3]);
    }

    private String incrementPosition(String combination, int j) {
        char[] nums = combination.toCharArray();
        nums[j] = (char) ((nums[j] - '0' + 1) % 10 + '0');
        return String.format("%s%s%s%s", nums[0], nums[1], nums[2], nums[3]);
    }

    // from walkccc.me
    public int openLock2(String[] deadends, String target) {
        Set<String> seen = new HashSet<>(Arrays.asList(deadends));
        if (seen.contains("0000"))
            return -1;
        if (target.equals("0000"))
            return 0;

        int ans = 0;
        Queue<String> q = new ArrayDeque<>(Arrays.asList("0000"));

        while (!q.isEmpty()) {
            ++ans;
            for (int sz = q.size(); sz > 0; --sz) {
                StringBuilder sb = new StringBuilder(q.poll());
                for (int i = 0; i < 4; ++i) {
                    final char cache = sb.charAt(i);
                    // Increase the i-th digit by 1.
                    sb.setCharAt(i, sb.charAt(i) == '9' ? '0' : (char) (sb.charAt(i) + 1));
                    String word = sb.toString();
                    if (word.equals(target))
                        return ans;
                    if (!seen.contains(word)) {
                        q.offer(word);
                        seen.add(word);
                    }
                    sb.setCharAt(i, cache);
                    // Decrease the i-th digit by 1.
                    sb.setCharAt(i, sb.charAt(i) == '0' ? '9' : (char) (sb.charAt(i) - 1));
                    word = sb.toString();
                    if (word.equals(target))
                        return ans;
                    if (!seen.contains(word)) {
                        q.offer(word);
                        seen.add(word);
                    }
                    sb.setCharAt(i, cache);
                }
            }
        }

        return -1;
    }

    // from leetcode editorial
    public int openLock3(String[] deadends, String target) {
        // Map the next slot digit for each current slot digit.
        Map<Character, Character> nextSlot = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );
        // Map the previous slot digit for each current slot digit.
        Map<Character, Character> prevSlot = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );

        // Set to store visited and dead-end combinations.
        Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        // Queue to store combinations generated after each turn.
        Queue<String> pendingCombinations = new LinkedList<String>();

        // Count the number of wheel turns made.
        int turns = 0;

        // If the starting combination is also a dead-end,
        // then we can't move from the starting combination.
        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        // Start with the initial combination '0000'.
        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {
            // Explore all the combinations of the current level.
            int currLevelNodesCount = pendingCombinations.size();
            for (int i = 0; i < currLevelNodesCount; i++) {
                // Get the current combination from the front of the queue.
                String currentCombination = pendingCombinations.poll();

                // If the current combination matches the target,
                // return the number of turns/level.
                if (currentCombination.equals(target)) {
                    return turns;
                }

                // Explore all possible new combinations by turning each wheel in both directions.
                for (int wheel = 0; wheel < 4; wheel += 1) {
                    // Generate the new combination by turning the wheel to the next digit.
                    StringBuilder newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, nextSlot.get(newCombination.charAt(wheel)));
                    // If the new combination is not a dead-end and was never visited,
                    // add it to the queue and mark it as visited.
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }

                    // Generate the new combination by turning the wheel to the previous digit.
                    newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, prevSlot.get(newCombination.charAt(wheel)));
                    // If the new combination is not a dead-end and is never visited,
                    // add it to the queue and mark it as visited.
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }
                }
            }
            // We will visit next-level combinations.
            turns += 1;
        }
        // We never reached the target combination.
        return -1;
    }
}