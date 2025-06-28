package matrix.workingPeoplesImitation.task_904_Fruit_Into_Baskets;

// from leetcode code sample (1)
public class Solution3 {
    public int totalFruit(int[] fruits) {
        int ans = 0;
        int curr = 0;
        int prev = -1;
        int prev2 = -1;
        int prevCount = 0;

        for (int fruit : fruits) {
            if (fruit == prev || fruit == prev2) {
                curr++;
            } else {
                ans = Math.max(curr, ans);
                curr = prevCount + 1;
            }
            if (fruit == prev) {
                prevCount++;
            } else {
                prevCount = 1;
                prev2 = prev;
                prev = fruit;
            }
        }

        return Math.max(ans, curr);
    }
}
