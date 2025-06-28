package matrix.workingPeoplesImitation.task_2364_Count_Number_of_Bad_Pairs;

import java.util.*;

// my attempts
public class SolutionDraft {
    // 43 / 65 testcases passed
    public long countBadPairs0(int[] nums) {
        long ans = 0;
        Map<Integer, Set<Integer>> diffIndexMap = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num1 = nums[i];
            int pairCount = nums.length - 1 - i;
            for (int num2 : diffIndexMap.keySet()) {
                if (diffIndexMap.get(num2).contains(num2 - num1 + i)) {
                    pairCount--;
                }
            }
            diffIndexMap.computeIfAbsent(num1, set -> new HashSet<>()).add(i);
            ans += pairCount;
        }
        return ans;
    }

    // 57 / 65 testcases passed
    public long countBadPairs1(int[] nums) {
        long ans = 0;
        int[] countGoodPair = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int pairCount = nums.length - 1 - i;
            int goodPair = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == i - j) {
                    goodPair += countGoodPair[j] + 1;
                    if (countGoodPair[j] > 0) {
                        break;
                    }
                }
            }
            countGoodPair[i] = goodPair;
            ans += pairCount - goodPair;
        }
        return ans;
    }

    // 8 / 65 testcases passed
    public long countBadPairs2(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] indexPrevGoodPair = new int[n];
        Arrays.fill(indexPrevGoodPair, -1);
        boolean[] hasGoodPair = new boolean[n];
        one:
        for (int i = n - 1; i >= 0; ) {
            int pairCount = n - 1 - i;
            int goodPair = 0;

            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == i - j) {
                    hasGoodPair[i] = true;
                    hasGoodPair[j] = true;
//                    indexPrevGoodPair[j] = 1;
                    indexPrevGoodPair[i] = j;
                    i = j;
                    continue one;
                }
            }
            i--;
        }

        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.out.println("Arrays.toString(hasGoodPair) = " + Arrays.toString(hasGoodPair));
        System.out.println("Arrays.toString(indexPrevGoodPair) = " + Arrays.toString(indexPrevGoodPair));

        // calculate max ans
        int count = n;
        while (count-- > 0) {
            ans += count;
        }
        System.out.println("max ans = " + ans);

        int prevHasGoodPairIndex = -1;
        for (int i = 0; i < n; i++) {
            if (hasGoodPair[i]) {
                if (prevHasGoodPairIndex >= 0) {
                    indexPrevGoodPair[i] += indexPrevGoodPair[prevHasGoodPairIndex];
                    ans -= indexPrevGoodPair[i];
                } else {
//                    indexPrevGoodPair[i] = 0;
                }
                prevHasGoodPairIndex = i;
            }
        }
        return ans;
    }

    public long countBadPairs3(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] indexPrevGoodPair = new int[n];
        Arrays.fill(indexPrevGoodPair, -1);
        boolean[] hasGoodPair = new boolean[n];
        one:
        for (int i = n - 1; i >= 0; ) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == i - j) {
                    hasGoodPair[i] = true;
                    hasGoodPair[j] = true;
                    indexPrevGoodPair[i] = j;
                    i = j;
                    continue one;
                }
            }
            i--;
        }

        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.out.println("Arrays.toString(hasGoodPair) = " + Arrays.toString(hasGoodPair));
        System.out.println("Arrays.toString(indexPrevGoodPair) = " + Arrays.toString(indexPrevGoodPair));

        // calculate max ans
        int count = n;
        while (count-- > 0) {
            ans += count;
        }
        System.out.println("max ans = " + ans);

        int prevHasGoodPairIndex = -1;
        int[] countGoodPair = new int[n];
        for (int i = 0; i < n; i++) {
            if (hasGoodPair[i]) {
                if (prevHasGoodPairIndex >= 0) {
//                    indexPrevGoodPair[i] += indexPrevGoodPair[prevHasGoodPairIndex];
//                    ans -= indexPrevGoodPair[i];
                    countGoodPair[i] += countGoodPair[prevHasGoodPairIndex] + 1;
                    ans -= countGoodPair[i];
                } else {
                    countGoodPair[i] = 0;
//                    indexPrevGoodPair[i] = 0;
                }
                prevHasGoodPairIndex = i;
            }
        }
        System.out.println("Arrays.toString(countGoodPair) = " + Arrays.toString(countGoodPair));
        return ans;
    }

    public long countBadPairs4(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int[] indexPrevGoodPair = new int[n];
        int[] indexNextGoodPair = new int[n];
        Arrays.fill(indexPrevGoodPair, -1);
        boolean[] hasGoodPair = new boolean[n];
        int firstTrue = -1;
        int secondTrue = -1;
        boolean change = false;
        for (int k = n - 1; k > secondTrue; k--) {
//            if (hasGoodPair[k]) {
//                System.out.println("hasGoodPair[k] " + k);
//                break;
//            }

            System.out.println("k = " + k);
            one:
            for (int i = k; i >= 0; ) {
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[i] - nums[j] == i - j) {
                        hasGoodPair[i] = true;
                        hasGoodPair[j] = true;
                        if (firstTrue < 0) {
                            firstTrue = i;
                            secondTrue = j;
                        }
                        indexPrevGoodPair[i] = j;
                        indexNextGoodPair[j] = i;
                        i = j;
                        continue one;
                    }
                }
                i--;
            }
            if (!change) {
                k = firstTrue + 1;
                change = true;
            }
        }

        System.out.println("firstTrue = " + firstTrue);
        System.out.println("secondTrue = " + secondTrue);
        one:
        for (int i = firstTrue - 1; i >= secondTrue; ) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] - nums[j] == i - j) {
                    hasGoodPair[i] = true;
                    hasGoodPair[j] = true;
//                    if (firstTrue < 0) {
//                        firstTrue = i;
//                        secondTrue = j;
//                    }
                    indexPrevGoodPair[i] = j;
                    indexNextGoodPair[j] = i;
//                    i = j;
//                    continue one;
                }
            }
            i--;
        }

        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
        System.out.println("Arrays.toString(hasGoodPair) = " + Arrays.toString(hasGoodPair));
        System.out.println("Arrays.toString(indexPrevGoodPair) = " + Arrays.toString(indexPrevGoodPair));
        System.out.println("Arrays.toString(indexNextGoodPair) = " + Arrays.toString(indexNextGoodPair));

        // calculate max ans
        int count = n;
        while (count-- > 0) {
            ans += count;
        }
        System.out.println("max ans = " + ans);

        int[] countGoodPair = new int[n];
        for (int i = 0; i < n; i++) {
            if (indexNextGoodPair[i] > 0) {
                int j = indexNextGoodPair[i];
                indexNextGoodPair[i] = 0;
                int prevIndex = i;
                while (indexNextGoodPair[j] > 0) {
                    countGoodPair[j] += countGoodPair[prevIndex];
                    prevIndex = j;
                    indexNextGoodPair[j] = 0;
                    j = indexNextGoodPair[j];
                    ans -= countGoodPair[j];
                }
            }
        }


//        int prevHasGoodPairIndex = -1;
////        int[] countGoodPair = new int[n];
//        for (int i = 0; i < n; i++) {
//            if (hasGoodPair[i]) {
//                if (prevHasGoodPairIndex >= 0) {
////                    indexPrevGoodPair[i] += indexPrevGoodPair[prevHasGoodPairIndex];
////                    ans -= indexPrevGoodPair[i];
//                    countGoodPair[i] += countGoodPair[prevHasGoodPairIndex] + 1;
//                    ans -= countGoodPair[i];
//                } else {
//                    countGoodPair[i] = 0;
////                    indexPrevGoodPair[i] = 0;
//                }
//                prevHasGoodPairIndex = i;
//            }
//        }
        System.out.println("Arrays.toString(countGoodPair) = " + Arrays.toString(countGoodPair));
        return ans;
    }
}
