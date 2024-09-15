package matrix.workingPeoplesImitation.task_1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.*;

// my solution
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> tables = new TreeMap<>();
        Set<String> foods = new TreeSet<>();
        for (List<String> order : orders) {
            tables.computeIfAbsent(Integer.parseInt(order.get(1)), table -> new TreeMap<>()).merge(order.get(2), 1, Integer::sum);
            foods.add(order.get(2));
        }
        List<List<String>> ans = new ArrayList<>();
        List<String> head = new ArrayList<>();
        head.add("Table");
        head.addAll(foods);
        ans.add(head);
        for (int table : tables.keySet()) {
            Map<String, Integer> order = tables.get(table);
            List<String> row = new ArrayList<>();
            row.add(String.valueOf(table));
            for (String food : foods) {
                row.add(String.valueOf(order.getOrDefault(food, 0)));
            }
            ans.add(row);
        }
        return ans;
    }
}
