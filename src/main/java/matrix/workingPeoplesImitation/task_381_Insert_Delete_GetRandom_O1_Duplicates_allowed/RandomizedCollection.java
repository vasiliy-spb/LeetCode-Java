package matrix.workingPeoplesImitation.task_381_Insert_Delete_GetRandom_O1_Duplicates_allowed;

import java.util.*;

public class RandomizedCollection {

    // my solution
    private Map<Integer, Integer> map;
    private List<Integer> list;
    public RandomizedCollection() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    public boolean insert(int val) {
        boolean ans = map.containsKey(val);
        map.merge(val, 1, Integer::sum);
        list.add(val);
        return !ans;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        map.merge(val, -1, Integer::sum);
        if (map.get(val) == 0) map.remove(val);
        list.remove(Integer.valueOf(val));
        return true;
    }

    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    // from walkccc.me

//    public boolean insert(int val) {
//        valToIndices.putIfAbsent(val, new ArrayList<>());
//        valToIndices.get(val).add(items.size());
//        items.add(new Item(val, valToIndices.get(val).size() - 1));
//        return valToIndices.get(val).size() == 1;
//    }
//
//    /**
//     * Removes a value from the collection. Returns true if the collection contained the specified
//     * element.
//     */
//    public boolean remove(int val) {
//        if (!valToIndices.containsKey(val))
//            return false;
//
//        final int index = lastIndex(valToIndices.get(val));
//        valToIndices.get(last(items).val).set(last(items).indexInMap, index);
//        final int indicesSize = valToIndices.get(val).size();
//        valToIndices.get(val).remove(indicesSize - 1);
//        if (valToIndices.get(val).isEmpty())
//            valToIndices.remove(val);
//        items.set(index, last(items));
//        items.remove(items.size() - 1);
//        return true;
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        final int index = rand.nextInt(items.size());
//        return items.get(index).val;
//    }
//
//    private Map<Integer, List<Integer>> valToIndices = new HashMap<>();
//    private List<Item> items = new ArrayList<>();
//    private Random rand = new Random();
//
//    private int lastIndex(List<Integer> indices) {
//        return indices.get(indices.size() - 1);
//    }
//
//    private Item last(List<Item> items) {
//        return items.get(items.size() - 1);
//    }
//    class Item {
//        public int val;
//        public int indexInMap;
//        public Item(int val, int indexInMap) {
//            this.val = val;
//            this.indexInMap = indexInMap;
//        }
//    }

    // from leetcode solutions
//    ArrayList<Integer> lst;
//    HashMap<Integer, Set<Integer>> idx;
//    java.util.Random rand = new java.util.Random();
//    /** Initialize your data structure here. */
//
//    public RandomizedCollection() {
//        lst = new ArrayList<Integer>();
//        idx = new HashMap<Integer, Set<Integer>>();
//    }
//
//    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
//    public boolean insert(int val) {
//        if (!idx.containsKey(val)) idx.put(val, new LinkedHashSet<Integer>());
//        idx.get(val).add(lst.size());
//        lst.add(val);
//        return idx.get(val).size() == 1;
//    }
//
//    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
//    public boolean remove(int val) {
//        if (!idx.containsKey(val) || idx.get(val).size() == 0) return false;
//        int remove_idx = idx.get(val).iterator().next();
//        idx.get(val).remove(remove_idx);
//        int last = lst.get(lst.size() - 1);
//        lst.set(remove_idx, last);
//        idx.get(last).add(remove_idx);
//        idx.get(last).remove(lst.size() - 1);
//
//        lst.remove(lst.size() - 1);
//        return true;
//    }
//
//    /** Get a random element from the collection. */
//    public int getRandom() {
//        return lst.get(rand.nextInt(lst.size()));
//    }
}
