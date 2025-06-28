package matrix.workingPeoplesImitation.task_2349_Design_a_Number_Container_System;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

// my solution
public class NumberContainers {
    Map<Integer, TreeSet<Integer>> storage;
    Map<Integer, Integer> indexNumberMap;

    public NumberContainers() {
        this.storage = new HashMap<>();
        this.indexNumberMap = new HashMap<>();
    }

    public void change(int index, int number) {
        int prevNumber = indexNumberMap.getOrDefault(index, -1);
        storage.getOrDefault(prevNumber, new TreeSet<>()).remove(index);
        storage.remove(prevNumber, new TreeSet<Integer>());

        storage.computeIfAbsent(number, set -> new TreeSet<>()).add(index);
        indexNumberMap.put(index, number);
    }

    public int find(int number) {
        if (storage.containsKey(number)) {
            return storage.get(number).first();
        }
        return -1;
    }
}
