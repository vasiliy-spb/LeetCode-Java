package matrix.workingPeoplesImitation.task_1466_Reorder_Routes_to_Make_All_Paths_Lead_to_the_City_Zero;

import java.util.*;

public class Solution {

    // my solution
    public int minReorder(int n, int[][] connections) {
        Map<Integer, Set<Integer>> connectiviryMap = new HashMap<>();
        Map<Integer, Set<Integer>> reverseMap = new HashMap<>();
        Set<Integer> targetNode = new HashSet<>();
        targetNode.add(0);
        for (int[] connect : connections) {
            if (targetNode.contains(connect[1])) targetNode.add(connect[0]);
            connectiviryMap.computeIfAbsent(connect[0], set -> new HashSet<>()).add(connect[1]);
            connectiviryMap.computeIfAbsent(connect[1], set -> new HashSet<>()).add(connect[0]);
            reverseMap.computeIfAbsent(connect[1], set -> new HashSet<>()).add(connect[0]);
        }
        int reorderCount = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int i : reverseMap.getOrDefault(currentNode, new HashSet<>())) {
                targetNode.add(i);
                queue.offer(i);
            }
        }
        if (targetNode.size() == n) return reorderCount;
        Set<Integer> wasInQueue = new HashSet<>();
        queue.offer(0);
        wasInQueue.add(0);
        while (targetNode.size() != n) {
            int currentNode = queue.poll();
            for (int node : connectiviryMap.get(currentNode).stream().sorted((a, b) -> reverseMap.getOrDefault(b, new HashSet<>()).size() - reverseMap.getOrDefault(a, new HashSet<>()).size()).toList()) {
                if (!targetNode.contains(node)) {
                    targetNode.add(node);
                    reorderCount++;
                    targetNode.addAll(reverseMap.getOrDefault(node, new HashSet<>()));
                    Queue<Integer> tempQueue = new ArrayDeque<>(reverseMap.getOrDefault(node, new HashSet<>()));
                    while (!tempQueue.isEmpty()) {
                        int current = tempQueue.poll();
                        targetNode.addAll(reverseMap.getOrDefault(current, new HashSet<>()));
                        tempQueue.addAll(reverseMap.getOrDefault(current, new HashSet<>()));
                    }
                    if (targetNode.size() == n) break;
                }
                if (!wasInQueue.contains(node)) {
                    queue.offer(node);
                    wasInQueue.add(node);
                }
            }
        }
        return reorderCount;
    }


    // my solution (Wrong Answer)
    public int minReorder2(int n, int[][] connections) {
        int reorderCount = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Map<Integer, List<Integer>> reverseMap = new HashMap<>();
        for (int[] connect : connections) {
            List<Integer> list = map.getOrDefault(connect[0], new ArrayList<>());
            list.add(connect[1]);
            map.put(connect[0], list);
            List<Integer> reverseList = reverseMap.getOrDefault(connect[1], new ArrayList<>());
            reverseList.add(connect[0]);
            reverseMap.put(connect[1], reverseList);
        }
        List<Integer> ends = reverseMap.get(0);
        ends.addAll(map.get(0));
        reorderCount += map.get(0).size();
        for (int i : reverseMap.remove(0)) {
            map.get(i).remove(Integer.valueOf(0));
        }


        int prev = 0;
        // [[0,1],[2,1],[3,2],[0,4],[5,1],[2,6],[5,7],[3,8],[8,9]]
        if (connections[0][0] != 0 && connections[0][1] != 0) {
            for (int i = 0; i < connections.length / 2; i++) {
                int[] temp = connections[i];
                connections[i] = connections[connections.length - 1 - i];
                connections[connections.length - 1 - i] = temp;
            }
        }
        for (int[] connect : connections) {
            if (connect[0] == 0 || connect[1] == 0) prev = 0;
            if (connect[0] == prev) {
                reorderCount++;
                prev = connect[1];
            } else {
                prev = connect[0];
            }
        }
        return reorderCount;
    }

    // from walkccc.me (with comments from GPT)
    public int minReorder3(int n, int[][] connections) {
        // Create an adjacency list representation of the graph using an array of lists
        List<Integer>[] graph = new List[n];

        // Initialize each element in the array with an empty ArrayList
        for (int i = 0; i < n; ++i)
            graph[i] = new ArrayList<>();

        // Populate the graph with directed and reversed edges based on the given connections
        for (int[] connection : connections) {
            final int u = connection[0];
            final int v = connection[1];
            // Directed edge: u -> v
            graph[u].add(v);
            // Reversed edge: v -> u (represented by -u in the list)
            graph[v].add(-u); // - := u -> v
        }

        // Perform DFS starting from the root node (0) and the parent as -1
        return dfs(graph, 0, -1);
    }

    // DFS function to traverse the graph and count the number of edges to be changed
    private int dfs(List<Integer>[] graph, int u, int parent) {
        // Counter to keep track of the number of edges to be changed
        int change = 0;

        // Iterate through the neighbors of the current node
        for (final int v : graph[u]) {
            // Skip if the neighbor is the parent node
            if (Math.abs(v) == parent)
                continue;

            // If the edge is positive, it means it is a directed edge (u -> v)
            if (v > 0)
                ++change;

            // Recursively call DFS on the neighbor with its absolute value as the new current node
            // and the current node (u) as the parent
            change += dfs(graph, Math.abs(v), u);
        }

        // Return the total count of edges to be changed
        return change;
    }

    // from GPT
    // Main function to find the minimum number of edges to be changed
    public int minReorder4(int n, int[][] connections) {
        // Build an adjacency list representation of the graph
        Map<Integer, List<int[]>> graph = buildGraph(n, connections);
        // Boolean array to track visited nodes during DFS
        boolean[] visited = new boolean[n];
        // Perform DFS and return the count of edges to be changed
        return dfs(graph, visited, 0);
    }

    // Helper function to build an adjacency list representation of the graph
    private Map<Integer, List<int[]>> buildGraph(int n, int[][] connections) {
        // Map to store the graph, where each node maps to a list of its neighbors and edge type
        Map<Integer, List<int[]>> graph = new HashMap<>();
        // Iterate through connections and populate the graph
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];

            // Directed edge: from -> to with edge type 1
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(new int[]{to, 1});
            // Reversed edge: to -> from with edge type 0
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(new int[]{from, 0});
        }
        return graph;
    }

    // DFS function to traverse the graph and count the number of edges to be changed
    private int dfs(Map<Integer, List<int[]>> graph, boolean[] visited, int current) {
        // Mark the current node as visited
        visited[current] = true;
        // Counter to keep track of the number of edges to be changed
        int count = 0;

        // Iterate through the neighbors of the current node
        for (int[] neighbor : graph.getOrDefault(current, Collections.emptyList())) {
            int nextCity = neighbor[0];
            int edgeType = neighbor[1];

            // If the neighbor has not been visited, recursively call DFS
            if (!visited[nextCity]) {
                // Increment the count based on the edge type
                count += edgeType;
                // Recursively call DFS on the neighbor
                count += dfs(graph, visited, nextCity);
            }
        }

        // Return the total count of edges to be changed
        return count;
    }

}

/*

// [[0,1],[2,1],[3,2],[0,4],[5,1],[2,6],[5,7],[3,8],[8,9]]

0:1,4
2:1,6
3:2,8
5:1,7
8:9

0 - 1 - 2 - 3 - 8 - 9
|   |   |
4   5   6
    |
    7

0 - 4
|
1 - 2 - 6
|   |
|   3 - 8 - 9
|
5 - 7

 */