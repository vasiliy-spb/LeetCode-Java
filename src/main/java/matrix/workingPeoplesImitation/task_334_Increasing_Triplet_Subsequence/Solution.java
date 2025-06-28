package matrix.workingPeoplesImitation.task_334_Increasing_Triplet_Subsequence;

public class Solution {

    // my solution (после подглядывания)
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (middle < num) return true;
            if (num > min && num < middle) middle = num;
            else min = Math.min(min, num);
        }
        return false;
    }

    // from GPT
    public boolean increasingTriplet1(int[] nums) {
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int middle = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > middle) return true;
            if (num < min) {
                min = num;
            } else if (num > min && num < middle) {
                middle = num;
            }
        }
        return false;
    }

    // from walkccc.me
    public boolean increasingTriplet5(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (final int num : nums)
            if (num <= first)
                first = num;
            else if (num <= second) // first < num <= second
                second = num;
            else // first < second < num (third)
                return true;

        return false;
    }

    // my solution
    public boolean increasingTriplet4(int[] nums) {
        if (nums.length < 3) return false;
        int min = nums[0];
        int middle = nums[1];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > middle && middle > min) return true;
            if (min > middle) {
                min = nums[i];
                middle = nums[i];
            } else if (nums[i] > min && nums[i] < middle) {
                middle = nums[i];
            }
//            if (min > middle) {
//                if (nums[i] < middle) {
//                    min = nums[i];
//                    middle = nums[i];
//                } else {
//                    min = middle;
//                }
//            }
//            if (nums[i] > min) {
//                if (nums[i] > middle) {
//                    middle = nums[i];
//                }
//            }
        }
        return false;
    }

    // 8, 7, 9, 6, 5, 7, 3, 2, 4 // false

    // my solution
    public boolean increasingTriplet3(int[] nums) {
        if (nums.length < 3) return false;
        int min = nums[0];
        int indexMin = 0;
        int max = nums[0];
        int indexMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                indexMin = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                indexMax = i;
            }
        }

        int firstMin = nums[0];
        int secondMin = nums[1];
        for (int i = 2; i < indexMax; i++) {
            if (firstMin < secondMin) {
                return true;
            } else {
                firstMin = secondMin;
                secondMin = nums[i];
            }
        }

        if (indexMin < nums.length - 3) {
            int middleMax = nums[indexMin + 1];
            int totalMax = nums[indexMin + 2];
            for (int i = indexMin + 1; i < nums.length; i++) {
                if (middleMax < totalMax) {
                    return true;
                } else {
                    middleMax = totalMax;
                    totalMax = nums[i];
                }

            }
        }
        return false;
    }

    // my solution
    public boolean increasingTriplet2(int[] nums) {
        if (nums.length < 3) return false;
        int min = nums[0];
        int middle = nums[1];
        int max = nums[nums.length - 1];
        for (int i = 2; i < nums.length; i++) {
            if (min < middle && middle < max) return true;
            min = Math.min(min, middle);
            max = Math.max(max, nums[nums.length - i]);
            if (nums[i] > min) {
                if (nums[i] > middle) {
                    middle = nums[i];
                }
                if (nums[i] < middle) {
                    if (middle > min) {
                        return true;
                    } else {
                        if (nums[i] < max) {
                            middle = nums[i];
                        }
                    }
                }
            }
        }
//        System.out.println("——————");
//        System.out.println(min);
//        System.out.println(middle);
//        System.out.println(max);
//        System.out.println("——————");
        return false;
    }
}

//  {2, 1, 5, 0, 4, 6}