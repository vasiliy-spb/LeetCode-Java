package matrix.workingPeoplesImitation.task_506_Relative_Ranks;

import java.util.*;

public class Solution {

    // my solution
    public String[] findRelativeRanks(int[] score) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        Arrays.stream(score).forEach(queue::add);
        int[] places = new int[score.length];
        int ind = 0;
        while (!queue.isEmpty())
            places[ind++] = queue.poll();
        String[] result = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int index = binarySearch(places, score[i]);
            switch (index) {
                case 0 -> result[i] = "Gold Medal";
                case 1 -> result[i] = "Silver Medal";
                case 2 -> result[i] = "Bronze Medal";
                default -> result[i] = String.valueOf(index + 1);
            }
        }
        return result;
    }

    private int binarySearch(int[] places, int target) {
        int left = 0;
        int right = places.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            int current = places[middle];
            if (current == target) return middle;
            if (current < target) right = middle;
            else left = middle + 1;
        }
        return left;
    }

    // from leetcode code sample
    private int findMax(int[] score) {
        int maxScore = 0;
        for (int s : score) {
            if (s > maxScore) {
                maxScore = s;
            }
        }
        return maxScore;
    }

    public String[] findRelativeRanks2(int[] score) {
        int N = score.length;

        // Add the original index of each score to the array
        // Where the score is the key
        int M = findMax(score);
        int[] scoreToIndex = new int[M + 1];
        for (int i = 0; i < N; i++) {
            scoreToIndex[score[i]] = i + 1;
        }

        final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};

        // Assign ranks to athletes
        String[] rank = new String[N];
        int place = 1;
        for (int i = M; i >= 0; i--) {
            if (scoreToIndex[i] != 0) {
                int originalIndex = scoreToIndex[i] - 1;
                if (place < 4) {
                    rank[originalIndex] = MEDALS[place - 1];
                } else {
                    rank[originalIndex] = String.valueOf(place);
                }
                place++;
            }
        }
        return rank;
    }

    // from leetcode code sample
    public String[] findRelativeRanks3(int[] score) {
        int n = score.length;
        int[] sortedScore = score.clone();
        Arrays.sort(sortedScore);
        String[] ranks = new String[n];

        for (int i = 0; i < n; i++) {
            int rank = Arrays.binarySearch(sortedScore, score[i]);
            if (rank == n - 1) {
                ranks[i] = "Gold Medal";
            } else if (rank == n - 2) {
                ranks[i] = "Silver Medal";
            } else if (rank == n - 3) {
                ranks[i] = "Bronze Medal";
            } else {
                ranks[i] = String.valueOf(n - rank);
            }
        }

        return ranks;
    }

    // from walkccc.me
    public String[] findRelativeRanks4(int[] nums) {
        final int n = nums.length;
        String[] ans = new String[n];
        List<Integer> indices = new ArrayList<>();

        for (int i = 0; i < n; ++i)
            indices.add(i);

        Collections.sort(indices, (a, b) -> nums[b] - nums[a]);

        for (int i = 0; i < n; ++i)
            if (i == 0)
                ans[indices.get(0)] = "Gold Medal";
            else if (i == 1)
                ans[indices.get(1)] = "Silver Medal";
            else if (i == 2)
                ans[indices.get(2)] = "Bronze Medal";
            else
                ans[indices.get(i)] = String.valueOf(i + 1);

        return ans;
    }

}
