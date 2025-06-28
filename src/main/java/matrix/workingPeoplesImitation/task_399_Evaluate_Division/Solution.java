package matrix.workingPeoplesImitation.task_399_Evaluate_Division;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<String>> contactsMap = new HashMap<>();
        Map<String, Map<String, Double>> multiplierMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            contactsMap.computeIfAbsent(a, list -> new ArrayList<>()).add(b);
            contactsMap.computeIfAbsent(b, list -> new ArrayList<>()).add(a);
            Map<String, Double> aMap = multiplierMap.getOrDefault(a, new HashMap<>());
            aMap.put(b, values[i]);
            multiplierMap.put(a, aMap);
            Map<String, Double> bMap = multiplierMap.getOrDefault(b, new HashMap<>());
            if (values[i] == 1) bMap.put(a, values[i]);
            else bMap.put(a, -values[i]);
            multiplierMap.put(b, bMap);
        }
//        System.out.println("contactsMap = " + contactsMap);
//        System.out.println("multiplierMap = " + multiplierMap);
//        System.out.println();

        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
//            System.out.println("queries = " + queries.get(i));
            Set<String> used = new HashSet<>();
            used.add(a);
            result[i] = calculateEquation(contactsMap, multiplierMap, a, b, used);
//            System.out.println("result[i] = " + result[i]);
//            System.out.println();
        }
//        System.out.println("result = " + Arrays.toString(result));
        return result;
    }

    private double calculateEquation(Map<String, List<String>> contactsMap, Map<String, Map<String, Double>> multiplierMap, String a, String b, Set<String> used) {
        if (!contactsMap.containsKey(a) || !contactsMap.containsKey(b)) return -1;
        if (a.equals(b)) return 1;
        if (multiplierMap.getOrDefault(a, new HashMap<>()).containsKey(b)) {
            double multiplier = multiplierMap.getOrDefault(a, new HashMap<>()).get(b);
            if (multiplier < 0) {
//                System.out.println("multiplier < 0");
                return 1 / -multiplierMap.get(a).get(b);
            } else {
                return multiplierMap.get(a).get(b);
            }
        }
        double ans = -1;
        for (String c : contactsMap.get(a)) {
            if (used.contains(c)) continue;
            double multiplier = multiplierMap.get(a).get(c);
            double currentAns;
            used.add(c);
            if (multiplier < 0) {
                currentAns = calculateEquation(contactsMap, multiplierMap, c, b, used) / -multiplier;
            } else {
                currentAns = multiplier * calculateEquation(contactsMap, multiplierMap, c, b, used);
            }
//            System.out.println("currentAns = " + currentAns);
            if (currentAns >= 0) ans = currentAns;
        }
        return ans;
    }

}
