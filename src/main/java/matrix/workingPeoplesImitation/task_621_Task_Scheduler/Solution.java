package matrix.workingPeoplesImitation.task_621_Task_Scheduler;

import java.util.*;

public class Solution {
    public int leastInterval11(char[] tasks, int n) {
        int[] frequencies = new int[26];
        for (char task : tasks) {
            frequencies[task - 'A']++;
        }

        Arrays.sort(frequencies);
        int maxFrequency = frequencies[25];
        int idleTime = 0;

        for (int i = 24; i >= 0; i--) {
            if (frequencies[i] == maxFrequency) {
                idleTime += frequencies[i] - 1;
            }
        }

        return Math.max(tasks.length, (maxFrequency - 1) * (n + 1) + idleTime + 1);
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.merge(ch, 1, Integer::sum);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int countMax = 0;
        int max = -1;
        for (int i = 0; i < list.size(); i++) {
            if (max < 0) max = list.get(i).getValue();
            else if (max != list.get(i).getValue()) break;
            countMax++;
        }
        return Math.max(tasks.length, 1 + (n + 1) * (list.get(0).getValue() - 1) + (countMax - 1));
    }

    public int leastInterval2(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.merge(ch, 1, Integer::sum);
        System.out.println("map = " + map);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int[] indexes = new int[26];
        int count = 0;
        int index = 0;
        char prev = ' ';
        while (!list.isEmpty()) {
//            if (list.size() == 1) {
//                if (count - n < indexes[list.get(0).getKey() - 'A'])
//                    count += indexes[list.get(0).getKey() - 'A'] - Math.abs(count - n);
//                return count + 1 + (n + 1) * Math.max((list.get(0).getValue() - 1), 0);
//            }
            index = index % list.size();
            Map.Entry<Character, Integer> entry = list.get(index);
            System.out.println("entry = " + entry);
            if (indexes[entry.getKey() - 'A'] > 0) {
                if (count - n < indexes[entry.getKey() - 'A']) {
                    System.out.println("случай 1");
                    count += indexes[entry.getKey() - 'A'] - (count - n) + 1;
//                    if (prev != entry.getKey()) count++;
                } else {
                    System.out.println("случай 2");
                    count++;
                }
            } else {
                count++;
//                if (indexes[entry.getKey() - 'A'] == 0) {
//                    System.out.println("случай 3");
//                    count++;
//                } else {
//                    System.out.println("случай 4");
//                    count += indexes[entry.getKey() - 'A'] - (count - n) + 1;
//                }
            }
            indexes[entry.getKey() - 'A'] = count;
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() == 0) list.remove(entry);
            else index++;
            prev = entry.getKey();
            System.out.println("indexes = " + Arrays.toString(indexes));
        }
        return count;
    }

    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : tasks)
            map.merge(ch, 1, Integer::sum);
//        System.out.println("map = " + map);
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        int[] indexes = new int[26];
        int count = 0;
        int index = 0;
        char prev = ' ';
        if (list.size() == 1) return 1 + (n + 1) * (list.get(0).getValue() - 1);
        while (!list.isEmpty()) {
            index = index % list.size();
            Map.Entry<Character, Integer> entry = list.get(index);
//            System.out.println("entry = " + entry);
            if (indexes[entry.getKey() - 'A'] > 0) {
                if (count - n < indexes[entry.getKey() - 'A']) {
//                    System.out.println("случай 1");
                    if (entry.getKey() == prev) {
                        while (count - n < indexes[entry.getKey() - 'A']) {
                            count++;
                        }
                    } else {
                        while (count - n <= indexes[entry.getKey() - 'A']) {
                            count++;
                        }
                    }
                } else {
//                    System.out.println("случай 2");
                    count++;
                }
            } else {
                if (indexes[entry.getKey() - 'A'] == 0) {
//                    System.out.println("случай 3");
                    count++;
                } else {
//                    System.out.println("случай 4");
                    while (count - n <= indexes[entry.getKey() - 'A']) {
                        count++;
                    }
                }
            }
            indexes[entry.getKey() - 'A'] = count;
            entry.setValue(entry.getValue() - 1);
            if (entry.getValue() == 0) list.remove(entry);
            else index++;
            prev = entry.getKey();
//            System.out.println("indexes = " + Arrays.toString(indexes));
        }
        return count;
    }
}
