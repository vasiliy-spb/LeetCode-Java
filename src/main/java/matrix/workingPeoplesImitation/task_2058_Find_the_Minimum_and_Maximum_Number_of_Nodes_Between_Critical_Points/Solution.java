package matrix.workingPeoplesImitation.task_2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points;

public class Solution {

    // my solution
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int totalStep = 0;
        int currentStep = 0;
        int min = Integer.MAX_VALUE;
        int max = -1;
        boolean findOne = false;
        ListNode prev = null;
        while (head.next != null) {
            if (prev != null) {
                if (head.val > prev.val && head.val > head.next.val || head.val < prev.val && head.val < head.next.val) {
                    if (findOne) {
                        min = Math.min(min, currentStep);
                        currentStep = 0;
                        max = totalStep;
                    }
                    findOne = true;
                }
            }
            if (findOne) {
                totalStep++;
                currentStep++;
            }
            prev = head;
            head = head.next;
        }
        return min == Integer.MAX_VALUE ? new int[]{-1, -1} : new int[] {min, max};
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // from leetcode editorial
    public int[] nodesBetweenCriticalPoints2(ListNode head) {
        int[] result = { -1, -1 };

        // Initialize minimum distance to the maximum possible value
        int minDistance = Integer.MAX_VALUE;

        // Pointers to track the previous node, current node, and indices
        ListNode previousNode = head;
        ListNode currentNode = head.next;
        int currentIndex = 1;
        int previousCriticalIndex = 0;
        int firstCriticalIndex = 0;

        while (currentNode.next != null) {
            // Check if the current node is a local maxima or minima
            if (
                    (currentNode.val < previousNode.val &&
                            currentNode.val < currentNode.next.val) ||
                            (currentNode.val > previousNode.val &&
                                    currentNode.val > currentNode.next.val)
            ) {
                // If this is the first critical point found
                if (previousCriticalIndex == 0) {
                    previousCriticalIndex = currentIndex;
                    firstCriticalIndex = currentIndex;
                } else {
                    // Calculate the minimum distance between critical points
                    minDistance = Math.min(
                            minDistance,
                            currentIndex - previousCriticalIndex
                    );
                    previousCriticalIndex = currentIndex;
                }
            }

            // Move to the next node and update indices
            currentIndex++;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        // If at least two critical points were found
        if (minDistance != Integer.MAX_VALUE) {
            int maxDistance = previousCriticalIndex - firstCriticalIndex;
            result = new int[] { minDistance, maxDistance };
        }

        return result;
    }

    // from walkccc.me
    public int[] nodesBetweenCriticalPoints3(ListNode head) {
        int minDistance = Integer.MAX_VALUE;
        int firstMaIndex = -1;
        int prevMaIndex = -1;
        int index = 1;
        ListNode prev = head;      // Point to the index 0.
        ListNode curr = head.next; // Point to the index 1.

        while (curr.next != null) {
            if (curr.val > prev.val && curr.val > curr.next.val ||
                    curr.val < prev.val && curr.val < curr.next.val) {
                if (firstMaIndex == -1) // Only assign once.
                    firstMaIndex = index;
                if (prevMaIndex != -1)
                    minDistance = Math.min(minDistance, index - prevMaIndex);
                prevMaIndex = index;
            }
            prev = curr;
            curr = curr.next;
            ++index;
        }

        if (minDistance == Integer.MAX_VALUE)
            return new int[] {-1, -1};
        return new int[] {minDistance, prevMaIndex - firstMaIndex};
    }
}
