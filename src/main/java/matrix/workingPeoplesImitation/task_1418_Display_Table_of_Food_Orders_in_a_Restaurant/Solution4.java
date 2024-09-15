package matrix.workingPeoplesImitation.task_1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.*;

// from leetcode code sample (3)
public class Solution4 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // Step 1: Use TreeSet to automatically keep food items and table numbers sorted
        TreeSet<String> foodItems = new TreeSet<>();
        TreeSet<Integer> tables = new TreeSet<>();
        for (List<String> order : orders) {
            foodItems.add(order.get(2));
            tables.add(Integer.parseInt(order.get(1)));
        }

        // Step 2: Initialize the result table with the header row
        List<List<String>> result = new ArrayList<>();
        List<String> headerRow = new ArrayList<>();
        headerRow.add("Table");
        headerRow.addAll(foodItems);
        result.add(headerRow);

        // Step 3: Prepare a map for table rows and initialize counts
        Map<Integer, List<String>> tableData = new HashMap<>();
        for (int table : tables) {
            List<String> row = new ArrayList<>(Collections.nCopies(foodItems.size() + 1, "0"));
            row.set(0, String.valueOf(table)); // Set the table number
            tableData.put(table, row);
        }

        // Step 4: Map food items to their column index
        Map<String, Integer> foodIndex = new HashMap<>();
        int index = 1;
        for (String food : foodItems) {
            foodIndex.put(food, index++);
        }

        // Step 5: Process orders and update table data
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            List<String> row = tableData.get(tableNumber);
            int columnIndex = foodIndex.get(foodItem);
            int currentCount = Integer.parseInt(row.get(columnIndex));
            row.set(columnIndex, String.valueOf(currentCount + 1));
        }

        // Step 6: Build the final result by adding table rows in sorted order
        for (int table : tables) {
            result.add(tableData.get(table));
        }

        return result;
    }
}
