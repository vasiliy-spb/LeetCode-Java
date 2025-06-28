package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.*;

// my solution
public class AllOne {
    Map<String, Integer> frequencyStorage;
    TreeMap<Integer, Set<String>> stringStorage;

    public AllOne() {
        this.frequencyStorage = new HashMap<>();
        this.stringStorage = new TreeMap<>();
    }

    public void inc(String key) {
        int oldValue = frequencyStorage.getOrDefault(key, -1);
        if (oldValue >= 0) {
            stringStorage.get(oldValue).remove(key);
            if (stringStorage.get(oldValue).isEmpty()) {
                stringStorage.remove(oldValue);
            }
        }
        frequencyStorage.merge(key, 1, Integer::sum);
        stringStorage.computeIfAbsent(frequencyStorage.get(key), set -> new HashSet<>()).add(key);
    }

    public void dec(String key) {
        int oldValue = frequencyStorage.get(key);
        stringStorage.get(oldValue).remove(key);
        if (stringStorage.get(oldValue).isEmpty()) {
            stringStorage.remove(oldValue);
        }
        frequencyStorage.merge(key, -1, Integer::sum);
        int newValue = frequencyStorage.get(key);
        if (newValue > 0) {
            stringStorage.computeIfAbsent(newValue, set -> new HashSet<>()).add(key);
            if (stringStorage.get(newValue).isEmpty()) {
                stringStorage.remove(newValue);
            }
        }
        frequencyStorage.remove(key, 0);
    }

    public String getMaxKey() {
        return stringStorage.isEmpty() ? "" : stringStorage.lastEntry().getValue().iterator().next();
    }

    public String getMinKey() {
        return stringStorage.isEmpty() ? "" : stringStorage.firstEntry().getValue().iterator().next();
    }
}

/*

testcase 1
Input
["AllOne","inc","inc","getMaxKey","getMinKey","inc","getMaxKey","getMinKey"]
[[],["hello"],["hello"],[],[],["leet"],[],[]]
Output
[null,null,null,"hello","hello",null,"hello","leet"]
Expected
[null,null,null,"hello","hello",null,"hello","leet"]

testcase 2
Input
["AllOne","inc","inc","inc","inc","getMaxKey","inc","inc","inc","dec","inc","inc","inc","getMaxKey"]
[[],["hello"],["goodbye"],["hello"],["hello"],[],["leet"],["code"],["leet"],["hello"],["leet"],["code"],["code"],[]]
Output
[null,null,null,null,null,"hello",null,null,null,null,null,null,null,"code"]
Expected
[null,null,null,null,null,"hello",null,null,null,null,null,null,null,"leet"]

testcase 3
Input
["AllOne","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","inc","getMinKey"]
[[],["a"],["b"],["c"],["d"],["a"],["b"],["c"],["d"],["c"],["d"],["d"],["a"],[]]
Output
[null,null,null,null,null,null,null,null,null,null,null,null,null,"b"]
Expected
[null,null,null,null,null,null,null,null,null,null,null,null,null,"b"]

testcase 4
Input
["AllOne","inc","inc","inc","inc","inc","inc","dec", "dec","getMinKey","dec","getMaxKey","getMinKey"]
[[],["a"],["b"],["b"],["c"],["c"],["c"],["b"],["b"],[],["a"],[],[]]
Output
[null,null,null,null,null,null,null,null,null,"a",null,"c","c"]
Expected
[null,null,null,null,null,null,null,null,null,"a",null,"c","c"]

 */