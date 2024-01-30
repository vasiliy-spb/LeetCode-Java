package matrix.workingPeoplesImitation.task_2336_Smallest_Number_in_Infinite_Set;

import java.util.Set;
import java.util.TreeSet;

public class SmallestInfiniteSet {

    Set<Integer> absentSet;
    public SmallestInfiniteSet() {
        this.absentSet = new TreeSet<>();
    }

    public int popSmallest() {
        int n = this.absentSet.size();
        for (int i = 1; i <= n; i++) {
            if (!this.absentSet.contains(i)) {
                this.absentSet.add(i);
                return i;
            }
        }
        this.absentSet.add(n + 1);
        return n + 1;
    }

    public void addBack(int num) {
        this.absentSet.remove(num);
    }
}


// from walkccc.me

/*
class SmallestInfiniteSet {
  public int popSmallest() {
    if (added.isEmpty())
      return curr++;
    final int min = added.first();
    added.remove(min);
    return min;
  }

  public void addBack(int num) {
    if (num < curr)
      added.add(num);
  }

  private int curr = 1;
  private TreeSet<Integer> added = new TreeSet<>();
}
 */


// from leetcode solutions

/*
class SmallestInfiniteSet {
    PriorityQueue<Integer> queue;
    int current;

    public SmallestInfiniteSet() {
        queue = new PriorityQueue<>();
        current = 1;
    }

    public int popSmallest() {
        int result = current;

        if (!queue.isEmpty() && queue.peek() < current)
            result = queue.poll();
        else
            current++;

        while (!queue.isEmpty() && queue.peek() == result)
            queue.poll();

        return result;
    }

    public void addBack(int num) {
        queue.add(num);
    }
}
 */