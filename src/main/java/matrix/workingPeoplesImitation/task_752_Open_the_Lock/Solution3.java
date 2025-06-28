package matrix.workingPeoplesImitation.task_752_Open_the_Lock;

import java.util.*;

// Wgong way
public class Solution3 {
    public int openLock(String[] deadends, String target) {
        Set<Integer>[] charSet = new Set[4];
        for (String deadend : deadends) {
            for (int i = 0; i < 4; i++) {
                if (charSet[i] == null) charSet[i] = new HashSet<>();
                charSet[i].add(deadend.charAt(0) - '0');
            }
        }
        int count = 50;
        boolean posibleOpen = false;
        boolean canMove = false;
        int[] numCount = new int[4];
        for (int i = 0; i < 4; i++) {
            int num = target.charAt(i) - '0';
            int prev = (num + 9) % 10;
            int next = (num + 1) % 10;
//            System.out.println("num = " + num);
//            System.out.println("prev = " + prev);
//            System.out.println("next = " + next);
//            System.out.println();
            Set<Integer> set = charSet[i];
//            System.out.println("set.size() = " + set.size());
            boolean mayBeLast = canMayByLast(num, set);
            boolean movable = canMove(num, set);
            posibleOpen |= mayBeLast;
            canMove |= movable;
            int currentCount = 0;
            if (mayBeLast) {
                if (!set.contains(prev) && !set.contains(next)) {
                    currentCount += Math.min(num, 10 - num);
                    numCount[i] += Math.min(num, 10 - num);
                } else if (!set.contains(prev)) {
                    currentCount += num;
                    numCount[i]+= num;
                } else {
                    currentCount += 10 - num;
                    numCount[i] += 10 - num;
                }
            } else {
                currentCount += Math.min(num, 10 - num);
            }
            numCount[i] = Math.min(num, 10 - num);
            currentCount += calculateMinOtherCount(i, target);
            count = Math.min(count, currentCount);
        }
        System.out.println("numCount = " + Arrays.toString(numCount));
        System.out.println("canMove = " + canMove);
        if (!canMove) return -1;
        System.out.println("count = " + count);
        System.out.println("numCount = " + Arrays.stream(numCount).sum());
        return posibleOpen ? Arrays.stream(numCount).sum() : -1;
    }

    private int calculateMinOtherCount(int i, String target) {
        int count = 0;
        for (int j = 0; j < 4; j++) {
            if (j == i) continue;
            int num = target.charAt(i) - '0';
//            count += Math.min(Math.max(0, num), Math.max(0, 10 - num));
            count += Math.min(num, 10 - num);
        }
        return count;
    }

    private boolean canMove(int num, Set<Integer> set) {
        int prev = (num + 9) % 10;
        int next = (num + 1) % 10;
        return (!set.contains(prev) || !set.contains(next)) || !set.contains(num);
    }

    private boolean canMayByLast(int num, Set<Integer> set) {
        int prev = (num + 9) % 10;
        int next = (num + 1) % 10;
        return !set.contains(prev) || !set.contains(next);
    }

}
