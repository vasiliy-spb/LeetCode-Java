package matrix.workingPeoplesImitation.task_134_Gas_Station;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    // my solution
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 1 && gas[0] >= cost[0]) return 0;
        Set<Integer> starts = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (cost[i] > gas[i]) {
                starts.add((i + 1) % n);
                starts.add((i + n - 1) % n);
            }
        }
        for (int start : starts) {
            int currentGas = 0;
            boolean aroundWorld = true;
            for (int j = start; j < start + n; j++) {
                int index = j % n;
                if (currentGas == 0 && gas[index] == 0 || gas[index] + currentGas < cost[index]) {
                    aroundWorld = false;
                    break;
                }
                currentGas = gas[index] + currentGas - cost[index];
            }
            if (aroundWorld) return start;
        }
        return -1;
    }

    // my solution (Time Limit Exceeded)
    public int canCompleteCircuit0(int[] gas, int[] cost) {
        int n = gas.length;
        int start = -1;
        for (int i = 0; i < n; i++) {
            if (cost[i] > gas[i]) start = i;
        }
        start++;
        start %= n;
        for (int i = start; i < start + n; i++) {
            int ii = i % n;
            int currentGas = 0;
            boolean aroundWorld = true;
            for (int j = ii; j < ii + n; j++) {
                int index = j % n;
                if (currentGas == 0 && gas[index] == 0 || gas[index] + currentGas < cost[index]) {
                    aroundWorld = false;
                    break;
                }
                currentGas = gas[index] + currentGas - cost[index];
            }
            if (aroundWorld) return ii;
        }
        return -1;
    }

    // from walkccc.me
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        final int gasSum = Arrays.stream(gas).sum();
        final int costSum = Arrays.stream(cost).sum();
        if (gasSum - costSum < 0)
            return -1;

        int ans = 0;
        int sum = 0;

        // Try to start from each index.
        for (int i = 0; i < gas.length; ++i) {
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                ans = i + 1; // Start from the next index.
            }
        }

        return ans;
    }
}
