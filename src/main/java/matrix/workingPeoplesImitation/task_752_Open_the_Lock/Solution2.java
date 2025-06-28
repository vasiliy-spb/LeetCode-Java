package matrix.workingPeoplesImitation.task_752_Open_the_Lock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Wgong way
public class Solution2 {
    public int openLock(String[] deadends, String target) {
        Set<String> breakCombinations = new HashSet<>(Arrays.asList(deadends));
        Set<Integer> swaps = new HashSet<>();
        if (breakCombinations.contains(target)) return -1;
        calculateMinSwap(breakCombinations, target, new int[]{0, 0, 0, 0}, true, 0, swaps, 0, 0, 0, 0);
        calculateMinSwap(breakCombinations, target, new int[]{0, 0, 0, 0}, false, 0, swaps, 0, 0, 0, 0);
        System.out.println("swaps = " + swaps);
        if (swaps.size() == 1) return swaps.stream().distinct().findFirst().get();
        return swaps.stream().min(Integer::compareTo).get();
    }

    private void calculateMinSwap(Set<String> breakCombinations, String target, int[] combination, boolean up, int count, Set<Integer> swaps, int aStart, int bStart, int cStart, int dStart) {
//        String current = String.format("%d%d%d%d", combination[0], combination[1], combination[2], combination[3]);
//        if (breakCombinations.contains(current)) {
//            swaps.add(-1);
//            return;
//        }
//        if (current.equals(target)) {
//            swaps.add(count);
//            return;
//        }
        for (int a = aStart; a < 10; a++) {
            for (int b = bStart; b < 10; b++) {
                for (int c = cStart; c < 10; c++) {
                    for (int d = dStart; d < 10; d++) {
                        int[] arr = {a, b, c, d};
                        int currentCount = up ? a + b + c + d : 40 - (a + b + c + d);
                        String current = String.format("%d%d%d%d", arr[0], arr[1], arr[2], arr[3]);
                        if (breakCombinations.contains(current)) {
                            swaps.add(-1);
                        } else if (current.equals(target)) {
                            swaps.add(currentCount);
                        }
//                        calculateMinSwap(breakCombinations, target, arr, up, currentCount, swaps, a, b, c, d + 1);
                    }
                }
            }
        }
    }
}
