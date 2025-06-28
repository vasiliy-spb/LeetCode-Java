package matrix.workingPeoplesImitation.task_2080_Range_Frequency_Queries;

import java.util.HashMap;
import java.util.Map;

// from leetcode code solutions
// https://leetcode.com/problems/range-frequency-queries/solutions/4325391/c-segment-tree-with-explanation-by-a_pen-nmfu/
public class RangeFreqQuery2 {
    private SegmentTree segmentTree;

    public RangeFreqQuery2(int[] arr) {
        segmentTree = new SegmentTree(arr);
    }

    public int query(int left, int right, int value) {
        return segmentTree.getsum(left, right + 1, value);
    }

    static class SegmentTree {
        private int n; // size
        HashMap<Integer, Integer>[] node;

        @SuppressWarnings("unchecked")
        SegmentTree(int[] arr) {
            int sz = 100000;
            n = 1;
            while (n < sz) { // n > sz
                n *= 2;
            }
            node = new HashMap[2 * n - 1]; // make binary tree
            for (int i = 0; i < 2 * n - 1; i++) {
                node[i] = new HashMap<>();
            }
            for (int i = 0; i < arr.length; i++) {
                node[i + n - 1].put(arr[i], node[i + n - 1].getOrDefault(arr[i], 0) + 1); // bottom layer
            }
            for (int i = n - 2; i >= 0; i--) { // node[i]=parent node
                for (Map.Entry<Integer, Integer> e : node[2 * i + 1].entrySet()) {
                    node[i].put(e.getKey(), node[i].getOrDefault(e.getKey(), 0) + e.getValue());
                }
                for (Map.Entry<Integer, Integer> e : node[2 * i + 2].entrySet()) {
                    node[i].put(e.getKey(), node[i].getOrDefault(e.getKey(), 0) + e.getValue());
                }
            }
        }

        // getsum(l,r) => frequencies [l,r)
        int getsum(int a, int b, int num, int k, int l, int r) {
            if (r <= a || b <= l) {
                return 0;
            }
            if (a <= l && r <= b) {
                return node[k].getOrDefault(num, 0);
            }
            int vl = getsum(a, b, num, 2 * k + 1, l, (l + r) / 2); // check[0,n/2)
            int vr = getsum(a, b, num, 2 * k + 2, (l + r) / 2, r); // check[n/2,n)
            return vl + vr;
        }

        int getsum(int a, int b, int num) {
            return getsum(a, b, num, 0, 0, n);
        }
    }
}
