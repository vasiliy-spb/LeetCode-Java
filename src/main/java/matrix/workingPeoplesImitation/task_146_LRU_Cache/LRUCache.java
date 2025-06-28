package matrix.workingPeoplesImitation.task_146_LRU_Cache;


import java.util.*;

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
public class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity, 0.75F, true);
    }

    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (!cache.containsKey(key) && cache.size() == capacity) {
            int k = -1;
            for (int i : cache.keySet())
                if (k < 0) {
                    k = i;
                    break;
                }
            cache.remove(k);
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LinkedHashMap<Integer, Integer> cache = new LinkedHashMap<>(3, 0.75F, true);
        cache.put(1, 2);
        cache.put(2, 3);
        cache.put(3, 4);
        cache.put(4, 5);
        cache.get(1);

        LRUCache lruCache = new LRUCache(3);
        lruCache.put(1, 2);
        lruCache.put(2, 3);
        lruCache.put(3, 4);
        lruCache.put(4, 5);
        lruCache.get(1);

        System.out.println("cache = " + cache);
        System.out.println("lruCache = " + lruCache.cache);
    }
}
