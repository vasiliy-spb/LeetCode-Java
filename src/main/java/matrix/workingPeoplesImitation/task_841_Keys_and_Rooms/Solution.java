package matrix.workingPeoplesImitation.task_841_Keys_and_Rooms;

import java.util.*;

public class Solution {

    // my solution
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(rooms.get(0));
        while (!queue.isEmpty()) {
            List<Integer> keyList = queue.poll();
            for (int key : keyList) {
                if (!visited.contains(key)) {
                    queue.offer(rooms.get(key));
                    visited.add(key);
                }
            }
        }
        return visited.size() == rooms.size();
    }

    // from walkccc.me
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int[] seen = new int[rooms.size()];
        dfs(rooms, 0, seen);
        return Arrays.stream(seen).allMatch(a -> a == 1);
    }

    private void dfs(List<List<Integer>> rooms, int node, int[] seen) {
        seen[node] = 1;
        for (final int child : rooms.get(node))
            if (seen[child] == 0)
                dfs(rooms, child, seen);
    }

    // from leetcode editorial (Approach #1: Depth-First Search)
    //
    // When visiting a room for the first time, look at all the keys in that room. For any key that hasn't been used yet, add it to the todo list (stack) for it to be used.
    // See the comments of the code for more details.
    public boolean canVisitAllRooms3(List<List<Integer>> rooms) {
        boolean[] seen = new boolean[rooms.size()];
        seen[0] = true;
        Stack<Integer> stack = new Stack();
        stack.push(0);

        //At the beginning, we have a todo list "stack" of keys to use.
        //'seen' represents at some point we have entered this room.
        while (!stack.isEmpty()) { // While we have keys...
            int node = stack.pop(); // Get the next key 'node'
            for (int nei: rooms.get(node)) // For every key in room # 'node'...
                if (!seen[nei]) { // ...that hasn't been used yet
                    seen[nei] = true; // mark that we've entered the room
                    stack.push(nei); // add the key to the todo list
                }
        }

        for (boolean v: seen)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

}
