package matrix.workingPeoplesImitation.task_310_Minimum_Height_Trees;

import java.util.*;

public class Solution {

    // my solution
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        Map<Integer, Set<Integer>> contacts = new HashMap<>();
        for (int[] edge : edges) {
            contacts.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            contacts.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
        }

        Map<Integer, Set<Integer>> numberContactsForEdges = new HashMap<>(); // количество соседей / у этих узлов
        for (int i = 0; i < n; i++) {
            int count = contacts.get(i).size();
            numberContactsForEdges.computeIfAbsent(count, set -> new HashSet<>()).add(i);
        }

        while (numberContactsForEdges.size() > 1) {
            Set<Integer> leafs = numberContactsForEdges.remove(1); // взяли список листьев
            for (int leaf : leafs) {
                for (int neighbor : contacts.get(leaf)) { // проходим по соседям каждого листа
                    Set<Integer> neighborsSet = contacts.get(neighbor);

                    int count = neighborsSet.size();
                    Set<Integer> numberContactsForNeighbor = numberContactsForEdges.get(count);
                    numberContactsForNeighbor.remove(neighbor);
                    if (numberContactsForNeighbor.isEmpty()) numberContactsForEdges.remove(count);

                    neighborsSet.remove(leaf); // удаляем лист у его соседа

                    count = neighborsSet.size();
                    numberContactsForEdges.computeIfAbsent(count, set -> new HashSet<>()).add(neighbor);
                }
            }
        }
        return numberContactsForEdges.values().iterator().next().stream().toList();
    }


    // my solution (TLE — 56 / 71 testcases passed)
    public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
        if (n == 1) return List.of(0);
        Map<Integer, Set<Integer>> contacts = new HashMap<>();
        for (int[] edge : edges) {
            contacts.computeIfAbsent(edge[0], set -> new HashSet<>()).add(edge[1]);
            contacts.computeIfAbsent(edge[1], set -> new HashSet<>()).add(edge[0]);
        }
        Map<Integer, Set<Integer>> heights = new HashMap<>();
        int minHeight = n + 1;
        for (int i = 0; i < n; i++) {
            int currentHeight = calculateHeight(i, contacts);
            heights.computeIfAbsent(currentHeight, set -> new HashSet<>()).add(i);
            minHeight = Math.min(minHeight, currentHeight);
        }
        return heights.get(minHeight).stream().toList();
    }

    private int calculateHeight(int i, Map<Integer, Set<Integer>> contacts) {
        int height = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(i);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            height++;
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int current = queue.poll();
                if (visited.contains(current)) continue;
                visited.add(current);
                queue.addAll(contacts.get(current).stream().filter(c -> !visited.contains(c)).toList());
            }
        }
        return height;
    }

    // from walkccc.me
    public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
        if (n == 0 || edges.length == 0)
            return new ArrayList<>(Arrays.asList(0));

        List<Integer> ans = new ArrayList<>();
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; ++i)
            graph.put(i, new HashSet<>());

        for (int[] edge : edges) {
            final int u = edge[0];
            final int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            final int label = entry.getKey();
            Set<Integer> children = entry.getValue();
            if (children.size() == 1)
                ans.add(label);
        }

        while (n > 2) {
            n -= ans.size();
            List<Integer> nextLeaves = new ArrayList<>();
            for (final int leaf : ans) {
                final int u = (int) graph.get(leaf).iterator().next();
                graph.get(u).remove(leaf);
                if (graph.get(u).size() == 1)
                    nextLeaves.add(u);
            }
            ans = nextLeaves;
        }

        return ans;
    }
}
