package matrix.workingPeoplesImitation.task_179_Largest_Number;

import java.util.*;

// my solution
public class Solution {

    public String largestNumber(int[] nums) {
        Set<String> set = new TreeSet<>((s1, s2) -> {
            if (s1.equals(s2)) {
                return 1;
            }
            if (Long.valueOf(s1 + s2, 10) > Long.valueOf(s2 + s1, 10)) {
                return -1;
            } else {
                return 1;
            }
        });
        long sum = 0;
        for (int num : nums) {
            set.add(num + "");
            sum += num;
        }
        if (sum == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (String num : set) {
            ans.append(num);
        }
        return ans.toString();
    }
    public String largestNumber0(int[] nums) {
        String[] arr = new String[nums.length];
        TreeMap<Character, TreeSet<String>> map = new TreeMap<>(Comparator.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            arr[i] = "" + nums[i];
            map.computeIfAbsent(arr[i].charAt(0), set -> new TreeSet<>(Comparator.reverseOrder())).add(arr[i]);
        }
        System.out.println("map = " + map);
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, TreeSet<String>> entry : map.entrySet()) {

        }
        return null;
    }

    public String largestNumber1(int[] nums) {
        Set<StringBuilder> set = new TreeSet<>((s1, s2) -> {
            for (int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
                if (s1.charAt(i) > s2.charAt(i)) {
                    return -1;
                }
                if (s1.charAt(i) < s2.charAt(i)) {
                    return 1;
                }
            }
            if (s1.length() < s2.length()) {
                int index = s1.length();
                while (index < s2.length()) {
                    for (int i = 0; i < Math.min(s1.length(), s2.length() - s1.length()); i++, index++) {
                        if (s1.charAt(i) > s2.charAt(index)) {
                            return -1;
                        }
                        if (s1.charAt(i) < s2.charAt(index)) {
                            return 1;
                        }
                    }
                }
                return -1;
            } else {
                int index = s2.length();
                while (index < s1.length()) {
                    for (int i = 0; i < Math.min(s2.length(), s1.length() - s2.length()); i++, index++) {
                        if (s2.charAt(i) > s1.charAt(index)) {
                            return 1;
                        }
                        if (s2.charAt(i) < s1.charAt(index)) {
                            return -1;
                        }
                    }
                }
                return 1;
            }
        });
        for (int num : nums) {
            set.add(new StringBuilder(num + ""));
        }
        StringBuilder ans = new StringBuilder();
        for (StringBuilder num : set) {
            ans.append(num);
        }
        return ans.toString();
    }
}
