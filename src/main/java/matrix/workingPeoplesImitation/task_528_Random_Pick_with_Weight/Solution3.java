package matrix.workingPeoplesImitation.task_528_Random_Pick_with_Weight;

// from leetcode code sample (1)
public class Solution3 {
    private int size;
    private int[] list;

    public Solution3(int[] w) {
        list = new int[1_000_0];
        int sum = 0, idx = 0, k = 0;
        for (int i : w)
            sum += i;
        for (int i : w) {
            int time = (i * 100) / sum;
            for (int j = 0; j <= time; j++)
                list[k++] = idx;
            idx++;
        }
        size = k;
    }

    public int pickIndex() {
        return list[(int) (Math.random() * size)];
    }
}
