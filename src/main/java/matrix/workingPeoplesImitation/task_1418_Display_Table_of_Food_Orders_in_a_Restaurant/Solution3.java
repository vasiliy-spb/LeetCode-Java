package matrix.workingPeoplesImitation.task_1418_Display_Table_of_Food_Orders_in_a_Restaurant;

import java.util.*;

// from leetcode code sample (2)
public class Solution3 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        // Step 1: Collect unique food items and prepare food indexing
        Set<String> foodItemsSet = new HashSet<>();
        for (List<String> order : orders) {
            foodItemsSet.add(order.get(2));
        }

        // Step 2: Sort the food items and map them to indices
        List<String> foodItems = new ArrayList<>(foodItemsSet);
        Collections.sort(foodItems);
        Map<String, Integer> foodIndexMap = new HashMap<>();
        for (int i = 0; i < foodItems.size(); i++) {
            foodIndexMap.put(foodItems.get(i), i);
        }

        // Step 3: Prepare tableFoodCounts array (501 tables max, foodItems.size() food items max)
        int[][] tableFoodCounts = new int[501][foodItems.size()];

        // Step 4: Track which tables are used
        boolean[] tableUsed = new boolean[501];

        // Step 5: Populate the tableFoodCounts array
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            int foodIndex = foodIndexMap.get(foodItem);
            tableFoodCounts[tableNumber][foodIndex]++;
            tableUsed[tableNumber] = true; // Mark this table as used
        }

        // Step 6: Prepare the result list
        List<List<String>> result = new ArrayList<>();

        // Add the header row
        List<String> headerRow = new ArrayList<>();
        headerRow.add("Table");
        headerRow.addAll(foodItems);
        result.add(headerRow);

        // Add the rows for each table
        for (int i = 1; i <= 500; i++) { // Only iterate over valid table numbers
            if (tableUsed[i]) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(i));
                for (int j = 0; j < foodItems.size(); j++) {
                    row.add(String.valueOf(tableFoodCounts[i][j]));
                }
                result.add(row);
            }
        }
        return result;
    }
}
