package matrix.workingPeoplesImitation.task_2462_Total_Cost_to_Hire_K_Workers;

import java.util.*;

public class Solution {

    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0;
        int left = 0;
        int right = costs.length - 1;
        PriorityQueue<Integer> leftQueue = new PriorityQueue<>();
        PriorityQueue<Integer> rightQueue = new PriorityQueue<>();
        int size = candidates;
        while (left <= right && size > 0) {
            leftQueue.offer(costs[left++]);
            if (left <= right) rightQueue.offer(costs[right--]);
            size--;
        }
        if (leftQueue.isEmpty()) return cost;
        for (int i = 0; i < k; i++) {
            if ((leftQueue == null || leftQueue.isEmpty()) && (rightQueue == null || rightQueue.isEmpty())) break;
            if (leftQueue == null || leftQueue.isEmpty()) {
                cost += rightQueue.poll();
                if (left <= right) rightQueue.offer(costs[right--]);
            } else if (rightQueue == null || rightQueue.isEmpty()) {
                cost += leftQueue.poll();
                if (left <= right) leftQueue.offer(costs[left++]);
            } else {
                if (leftQueue.peek() <= rightQueue.peek()) {
                    cost += leftQueue.poll();
                    if (left <= right) leftQueue.offer(costs[left++]);
                } else {
                    cost += rightQueue.poll();
                    if (left <= right) rightQueue.offer(costs[right--]);
                }
            }
        }
        return cost;
    }

    // from leetcode editorial
    public long totalCost2(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();

        // headWorkers stores the first k workers.
        // tailWorkers stores at most last k workers without any workers from the first k workers.
        for (int i = 0; i < candidates; i++) {
            headWorkers.add(costs[i]);
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            tailWorkers.add(costs[i]);
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            if (tailWorkers.isEmpty() || !headWorkers.isEmpty() && headWorkers.peek() <= tailWorkers.peek()) {
                answer += headWorkers.poll();

                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    headWorkers.add(costs[nextHead]);
                    nextHead++;
                }
            }

            else {
                answer += tailWorkers.poll();

                // Only refill the queue if there are workers outside the two queues.
                if (nextHead <= nextTail) {
                    tailWorkers.add(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return answer;
    }

    // from leetcode editorial
    public long totalCost3(int[] costs, int k, int candidates) {
        // The worker with the lowest cost has the highest priority, if two players has the
        // same cost, break the tie by their indices (0 or 1).
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];});

        // Add the first k workers with section id of 0 and
        // the last k workers with section id of 1 (without duplication) to pq.
        for (int i = 0; i < candidates; i++) {
            pq.offer(new int[] {costs[i], 0});
        }
        for (int i = Math.max(candidates, costs.length - candidates); i < costs.length; i++) {
            pq.offer(new int[] {costs[i], 1});
        }

        long answer = 0;
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;

        for (int i = 0; i < k; i++) {
            int[] curWorker = pq.poll();
            int curCost = curWorker[0], curSectionId = curWorker[1];
            answer += curCost;

            // Only refill pq if there are workers outside.
            if (nextHead <= nextTail) {
                if (curSectionId == 0) {
                    pq.offer(new int[]{costs[nextHead], 0});
                    nextHead++;
                } else {
                    pq.offer(new int[]{costs[nextTail], 1});
                    nextTail--;
                }
            }
        }

        return answer;
    }

}
