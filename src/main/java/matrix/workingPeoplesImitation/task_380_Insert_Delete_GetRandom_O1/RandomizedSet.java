package matrix.workingPeoplesImitation.task_380_Insert_Delete_GetRandom_O1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomizedSet {
    private Set<Integer> set;
    public RandomizedSet() {
        this.set = new HashSet<>();
    }

    public boolean insert(int val) {
        return this.set.add(val);
    }

    public boolean remove(int val) {
        return this.set.remove(val);
    }

    public int getRandom() {
        Random random = new Random();
        return (int) set.toArray()[random.nextInt(set.size())];
    }
}
