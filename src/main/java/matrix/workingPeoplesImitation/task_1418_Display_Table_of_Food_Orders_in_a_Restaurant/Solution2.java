package matrix.workingPeoplesImitation.task_1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.*;

// from leetcode code sample (1)
public class Solution2 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<String, Integer> index = new HashMap<>();
        List<String> header = new ArrayList<>();
        for (List<String> o : orders) {
            String food = o.get(2);
            if (!index.containsKey(food)) {
                index.put(food, 0);
                header.add(food);
            }
        }
        Collections.sort(header);
        header.add(0, "Table");
        List<List<String>> res = new ArrayList<>();
        res.add(header);
        for (int i = 0; i < header.size(); i++)
            index.put(header.get(i), i);
        Map<String, Integer>[] tableOrders = new HashMap[501];
        for (List<String> order : orders) {
            int table = Integer.parseInt(order.get(1));
            String food = order.get(2);
            if (tableOrders[table] == null) tableOrders[table] = new HashMap<>();
            if (tableOrders[table].get(food) == null) tableOrders[table].put(food, 1);
            else tableOrders[table].put(food, tableOrders[table].get(food) + 1);
        }
        for (int i = 1; i < 501; i++) {
            if (tableOrders[i] == null) continue;
            List<String> currTable = new ArrayList<>();
            currTable.add(i + "");
            while (currTable.size() < header.size()) currTable.add("0");
            for (Map.Entry<String, Integer> e : tableOrders[i].entrySet()) {
                int idx = index.get(e.getKey());
                currTable.set(idx, e.getValue() + "");
            }
            res.add(currTable);
        }
        return res;
    }
}
