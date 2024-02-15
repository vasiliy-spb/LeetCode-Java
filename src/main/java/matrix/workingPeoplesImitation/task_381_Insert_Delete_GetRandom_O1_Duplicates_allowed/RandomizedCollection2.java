package matrix.workingPeoplesImitation.task_381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

public class RandomizedCollection2 {
    private Map<Integer, Set<Integer>> map;
    private List<Integer> list;
    public RandomizedCollection2() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i);
        }
        list.remove(list.size() - 1);
        list.remove(list.size() / 2);
    }

    public boolean insert(int val) {
        boolean ans = map.containsKey(val);
        map.computeIfAbsent(val, key -> new HashSet<>()).add(list.size());
        list.add(val);
        return !ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;

        int indexVal = map.get(val).iterator().next();

        map.get(val).remove(indexVal);
        if (map.get(val).isEmpty()) map.remove(val);

        if (indexVal != list.size() - 1) {

            map.get(list.get(list.size() - 1)).remove(list.size() - 1);
            map.get(list.get(list.size() - 1)).add(indexVal);

            list.set(indexVal, list.get(list.size() - 1));
        }
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int ind = random.nextInt(list.size());
        return list.get(ind);
    }
}
