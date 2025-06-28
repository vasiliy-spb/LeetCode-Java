package matrix.workingPeoplesImitation.task_1971_Find_if_Path_Exists_in_Graph;

import java.util.*;

class Solution {

    // my solution
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (edges == null || edges.length == 0) return source == destination;
        Map<Integer, Set<Integer>> contacts = new HashMap<>();
        for (int[] edge : edges) {
            contacts.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            contacts.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(source);
        while (!queue.isEmpty() && (visited.size() != n || !visited.contains(destination))) {
            int edge = queue.poll();
            if (visited.contains(edge)) continue;
            visited.add(edge);
            Set<Integer> set = contacts.get(edge);
            if (set.contains(destination)) return true;
            queue.addAll(set.stream().filter(e -> !visited.contains(e)).toList());
            if (visited.contains(destination)) return true;
        }
        return false;
    }

    // from walkccc.me
    public boolean validPath2(int n, int[][] edges, int source, int destination) {
        UnionFind uf = new UnionFind(n);

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            uf.unionByRank(u, v);
        }

        return uf.find(source) == uf.find(destination);
    }

    class UnionFind {
        public UnionFind(int n) {
            id = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; ++i)
                id[i] = i;
        }

        public void unionByRank(int u, int v) {
            final int i = find(u);
            final int j = find(v);
            if (i == j)
                return;
            if (rank[i] < rank[j]) {
                id[i] = j;
            } else if (rank[i] > rank[j]) {
                id[j] = i;
            } else {
                id[i] = j;
                ++rank[j];
            }
        }

        public int find(int u) {
            return id[u] == u ? u : (id[u] = find(id[u]));
        }

        private int[] id;
        private int[] rank;
    }

    // from leetcode codeSamples
    public boolean validPath3(int n, int[][] edges, int source, int destination) {
        if (edges.length == 0) return true;
        boolean[] visited = new boolean[n];
        boolean flag = true;
        visited[source] = true;
        while (flag) {
            flag = false;
            for (int[] edge : edges) {
                if (visited[edge[0]] != visited[edge[1]]) {
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if (visited[destination]) return true;
            }
        }
        return false;
    }

    // from leetcode codeSamples
    public boolean validPath4(int n, int[][] edges, int source, int destination) {
        /**
         * The edges are given in a map format so we can used it as
         */
        if (source == destination) {
            return true;
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        visited[source] = true;
        boolean done = false;

        while (!done) {
            done = true;

            for (int[] edge : edges) {
                if (visited[edge[0]] != visited[edge[1]]) {
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    done = false;
                }
                if (visited[destination]) {
                    return true;
                }
            }
        }
        return false;
    }

    // from leetcode codeSamples
    public boolean validPath5(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            graph.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
            graph.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            if (vertex == destination) {
                return true;
            }
            List<Integer> paths = graph.get(vertex);
            if (paths != null) {
                paths.stream()
                        .filter(v -> !visited[v])
                        .forEach(v -> {
                            visited[v] = true;
                            queue.add(v);
                        });
            }
        }

        return false;
    }

    // from leetcode codeSamples
    public boolean validPath6(int n, int[][] edges, int source, int destination) {

        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];
            graph.computeIfAbsent(vertex1, k -> new ArrayList<>()).add(vertex2);
            graph.computeIfAbsent(vertex2, k -> new ArrayList<>()).add(vertex1);
        }

        List<Integer> visited = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        while (!queue.isEmpty()) {
            Integer vertex = queue.remove();
            if (vertex == destination) {
                return true;
            }
            List<Integer> paths = graph.get(vertex);
            if (paths != null) {
                paths.stream()
                        .filter(v -> !visited.contains(v))
                        .forEach(v -> {
                            visited.add(v);
                            queue.add(v);
                        });
            }
        }

        return false;
    }

    // from leetcode codeSamples
    public boolean areConnected(int u, int v, int[] parent) {
        return find(u, parent) == find(v, parent);
    }

    public void union(int u, int v, int[] parent) {
        if (u != v) {
            int a = find(u, parent);
            int b = find(v, parent);
            parent[a] = b;
        }
    }

    private int find(int u, int[] parent) {
        int x = u;
        while (x != parent[x]) {
            x = parent[x];
        }
        parent[u] = x;

        return x;
    }

    public boolean validPath7(int n, int[][] edges, int start, int end) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            union(edge[0], edge[1], parent);
        }

        return areConnected(start, end, parent);
    }
}
