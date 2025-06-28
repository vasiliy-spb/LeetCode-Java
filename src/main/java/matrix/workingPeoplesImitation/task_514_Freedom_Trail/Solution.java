package matrix.workingPeoplesImitation.task_514_Freedom_Trail;

import java.util.*;

public class Solution {

    // my solution
    public int findRotateSteps(String ring, String key) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        for (int i = 0; i < key.length(); i++) {
            char k = key.charAt(i);
            int size = queue.size();
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < size; j++) {
                int[] current = queue.poll();
                int count = current[0];
                int startIndex = current[1];

                int right = 0;
                int rightIndex = ring.indexOf(k, startIndex);
                if (rightIndex < 0) {
                    right += ring.length() - startIndex;
                    rightIndex = ring.indexOf(k);
                    right += rightIndex;
                } else if (rightIndex > startIndex) {
                    right = Math.abs(rightIndex - startIndex);
                }
                right++;

                int left = 0;
                int leftIndex = ring.lastIndexOf(k, startIndex);
                if (leftIndex < 0) {
                    left += startIndex;
                    leftIndex = ring.lastIndexOf(k);
                    left += ring.length() - leftIndex;
                } else if (leftIndex < startIndex) {
                    left = Math.abs(leftIndex - startIndex);
                }
                left++;

                map.merge(leftIndex, count + left, Integer::min);
                map.merge(rightIndex, count + right, Integer::min);
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet())
                queue.offer(new int[]{entry.getValue(), entry.getKey()});
        }
        return queue.stream().map(a -> a[0]).min(Integer::compareTo).get();
    }

    // from walkccc.me
    public int findRotateSteps2(String ring, String key) {
        Map<String, Integer> mem = new HashMap<>();
        return dfs(ring, key, 0, mem) + key.length();
    }

    // Returns the number of rotates of ring to match key[index..n).
    private int dfs(final String ring, final String key, int index, Map<String, Integer> mem) {
        if (index == key.length())
            return 0;
        // Add the index to prevent duplication.
        final String hashKey = ring + index;
        if (mem.containsKey(hashKey))
            return mem.get(hashKey);

        int ans = Integer.MAX_VALUE;

        // For each ring[i] == key[index], we rotate the ring to match the ring[i]
        // with the key[index], then recursively match the newRing with the
        // key[index + 1..n).
        for (int i = 0; i < ring.length(); ++i)
            if (ring.charAt(i) == key.charAt(index)) {
                final int minRotates = Math.min(i, ring.length() - i);
                final String newRing = ring.substring(i) + ring.substring(0, i);
                final int remainingRotates = dfs(newRing, key, index + 1, mem);
                ans = Math.min(ans, minRotates + remainingRotates);
            }

        mem.put(hashKey, ans);
        return ans;
    }

}
