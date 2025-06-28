package matrix.workingPeoplesImitation.task_904_Fruit_Into_Baskets;

// from leetcode code sample (2)
public class Solution4 {
    public int totalFruit(int[] tree) {
        int max = 0, count = 0;
        for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
            count++;
            if (tree[i] == tree[first]) {
                first = i;
            } else if (second == -1 || tree[i] == tree[second]) {
                second = i;
            } else {
                max = Math.max(count - 1, max);
                count = Math.abs(first - second) + 1;
                first = i - 1;
                second = i;
            }
        }
        return Math.max(count, max);
    }
}
