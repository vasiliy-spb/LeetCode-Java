package matrix.workingPeoplesImitation.task_432_All_O_one_Data_Structure;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// from leetcode code sample (10)
public class AllOne13 {
    private ConcurrentSkipListMap<Integer, Set<String>> freqMap;
    private ConcurrentHashMap<String, Integer> keyMap;
    private final Lock[] stripedLocks;
    private static final int NUM_LOCKS = 16; // Define a number of locks for striped locking
    private volatile int maxFreq;
    private volatile int minFreq;

    public AllOne13() {
        this.freqMap = new ConcurrentSkipListMap<>();
        this.keyMap = new ConcurrentHashMap<>();
        this.minFreq = Integer.MAX_VALUE;
        this.maxFreq = 0;
        this.stripedLocks = new ReentrantLock[NUM_LOCKS];
        for (int i = 0; i < NUM_LOCKS; i++) {
            stripedLocks[i] = new ReentrantLock();
        }
    }

    private Lock getLock(String key) {
        int lockIndex = (key.hashCode() & 0x7FFFFFFF) % NUM_LOCKS;
        return stripedLocks[lockIndex];
    }

    public void inc(String key) {
        Lock lock = getLock(key);
        lock.lock();
        try {
            int freq = 0;
            if (keyMap.containsKey(key)) {
                freq = keyMap.get(key);
                freqMap.get(freq).remove(key);

                if (freqMap.get(freq).size() == 0) {
                    freqMap.remove(freq);
                    minFreq = (minFreq == freq) ? freq + 1: minFreq;
                }
            }

            minFreq = Math.min(minFreq, freq + 1);
            maxFreq = Math.max(maxFreq, freq + 1);
            freqMap.putIfAbsent(freq + 1, new HashSet<>());
            freqMap.get(freq + 1).add(key);
            keyMap.put(key, freq + 1);
        } finally {
            lock.unlock();
        }
    }

    public void dec(String key) {
        int freq = keyMap.get(key);
        freqMap.get(freq).remove(key);
        keyMap.remove(key);

        if (freqMap.get(freq).size() == 0) {
            freqMap.remove(freq);
            minFreq = (minFreq == freq) ? minFreq - 1: minFreq;
            maxFreq = (maxFreq == freq) ? maxFreq - 1: maxFreq;
        }

        if (freq - 1 > 0) {
            keyMap.put(key, freq - 1);
            freqMap.putIfAbsent(freq - 1, new HashSet<>());
            freqMap.get(freq - 1).add(key);
        }
    }

    public String getMaxKey() {
        if (maxFreq == 0) {
            return "";
        }
        return freqMap.get(maxFreq).iterator().next();
    }

    public String getMinKey() {
        if (maxFreq == 0) {
            return "";
        }

        if (minFreq == 0) {
            minFreq = Integer.MAX_VALUE;
            for (int freq: freqMap.keySet()) {
                minFreq = Math.min(minFreq, freq);
            }
        }
        return freqMap.get(minFreq).iterator().next();
    }
}
