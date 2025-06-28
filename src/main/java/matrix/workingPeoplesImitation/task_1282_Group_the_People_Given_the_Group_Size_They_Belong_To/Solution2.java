package matrix.workingPeoplesImitation.task_1282_Group_the_People_Given_the_Group_Size_They_Belong_To;

import java.util.ArrayList;
import java.util.List;

// from leetcode code sample (1)
public class Solution2 extends java.util.AbstractList<List<Integer>> {
    int[] gs;
    List<List<Integer>> ans;

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        this.gs = groupSizes;
        return this;
    }

    @Override
    public List<Integer> get(int index) {
        if (ans == null)
            this.size();
        return ans.get(index);
    }

    @Override
    public int size() {
        if (ans == null) {
            ans = new ArrayList<>();
            var map = new java.util.HashMap<Integer, List<Integer>>();
            for (int i = 0; i < gs.length; i++) {
                List<Integer> g = map.computeIfAbsent(gs[i], z -> new ArrayList<>());
                g.add(i);
                if (g.size() == gs[i])
                    ans.add(map.remove(gs[i]));
            }
        }
        return this.ans.size();
    }
}