package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// my solution (Solution2 with draft)
public class Solution3 {
    public static List<Integer> lexicalOrder(int n) {
        int largestNumWithZeros = getLargestNumWithZeros(n);
        List<Integer> ans = new ArrayList<>();
        if (n < 10) {
            for (int i = 1; i <= n; i++) {
                ans.add(i);
            }
            return ans;
        }

        // start part
        int largestNumWithoutZeros = removeZeros(largestNumWithZeros);
        while (largestNumWithoutZeros < largestNumWithZeros) {
            ans.add(largestNumWithoutZeros);
            largestNumWithoutZeros *= 10;
        }
        ans.add(largestNumWithZeros);

        // main part
        int[] target = getNumAsArray(n);
        int[] digits = getNumAsArray(largestNumWithZeros);
        int num = getNum(digits);
        while (num < getNum(target)) {
            incrementDigitArray(digits);
            num = getNum(digits);
            int numWithoutZeros = removeZeros(num);
            while (numWithoutZeros < num) {
                ans.add(numWithoutZeros);
                numWithoutZeros *= 10;
            }
            ans.add(num);
        }

        if (ans.size() == n) {
            return ans;
        }

        // last part
        target = getNumAsArray(largestNumWithZeros);
        decrementDigitArray(target);
        int newStart = ans.get(ans.size() - 1) / 10 + 1;
        int[] tempArr = getNumAsArray(newStart);
        digits = new int[target.length];
        for (int i = 0; i < tempArr.length; i++) {
            digits[i + 1] = tempArr[i];
        }
        num = getNum(digits);

        int numWithoutZeros = removeZeros(num);
        while (numWithoutZeros < num) {
            ans.add(numWithoutZeros);
            numWithoutZeros *= 10;
        }

        ans.add(getNum(digits));
        while (num < getNum(target)) {
            incrementDigitArray(digits);
            num = getNum(digits);
            numWithoutZeros = removeZeros(num);
            while (numWithoutZeros < num) {
                ans.add(numWithoutZeros);
                numWithoutZeros *= 10;
            }
            ans.add(num);
        }

        return ans;
    }

    private static int getNum(int[] digits) {
        int number = 0;
        for (int digit : digits) {
            number += digit;
            number *= 10;
        }
        return number / 10;
    }
    public static void decrementDigitArray(int[] digits) {
        int n = digits.length;
        digits[n - 1]--;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 0) {
                digits[i] = 9;
                digits[i - 1]--;
            }
        }
    }

    private static void incrementDigitArray(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 10) {
                digits[i]++;
                int ind = i;
                while (digits[ind] > 9) {
                    digits[ind--] = 0;
                    digits[ind]++;
                }
                for (int j = i + 1; j < n; j++) {
                    digits[j] = 0;
                }
                break;
            }
        }
    }
    private static int removeZeros(int num) {
        if (num == 0) {
            return 0;
        }
        while (num % 10 == 0) {
            num /= 10;
        }
        return num;
    }

    public static int[] getNumAsArray(int num) {
        int orderOfMagnitude = 0;
        int temp = num;
        while (temp > 0) {
            orderOfMagnitude++;
            temp /= 10;
        }
        int[] target = new int[orderOfMagnitude];
        temp = num;
        for (int i = orderOfMagnitude - 1; i >= 0; i--) {
            target[i] = temp % 10;
            temp /= 10;
        }
        return target;
    }
    private static int getLargestNumWithZeros(int n) {
        int countZeros = String.valueOf(n).length() - 1;
        int result = 1;
        while (countZeros-- > 0) {
            result *= 10;
        }
        return result;
    }

//    public static void main(String[] args) {
//
//        int n = 21430;
//        int largestNumWithZeros = getLargestNumWithZeros(n);
//        List<Integer> list = new ArrayList<>();
//        System.out.println("n = " + n);
//        System.out.println("largestNumWithZeros = " + largestNumWithZeros);
//
//        // first part
//        int largestNumWithoutZeros = removeZeros(largestNumWithZeros);
//        while (largestNumWithoutZeros < largestNumWithZeros) {
//            list.add(largestNumWithoutZeros);
//            largestNumWithoutZeros *= 10;
//        }
//        list.add(largestNumWithZeros);
//
////        System.out.println("list = " + list);
////
////        if (3 < 4) {
////            return;
////        }
//
//
////        largestNumWithZeros = 4532;
////        int[] tmpArray = getNumAsArray(largestNumWithZeros);
////        System.out.println("Arrays.toString(tmpArray) = " + Arrays.toString(tmpArray));
////        decrementDigitArray(tmpArray);
////        System.out.println("Arrays.toString(tmpArray) = " + Arrays.toString(tmpArray));
////
////        if (3 < 4) {
////            return;
////        }
//
//        int[] target = getNumAsArray(n);
//        int[] digits = getNumAsArray(largestNumWithZeros);
//        int num = 0;
//        while (num < getNum(target)) {
//            incrementDigitArray(digits);
//            num = getNum(digits);
//            int numWithoutZeros = removeZeros(num);
//            while (numWithoutZeros < num) {
//                list.add(numWithoutZeros);
//                numWithoutZeros *= 10;
//            }
//            list.add(num);
////            System.out.println(num);
//        }
////        System.out.println("list: ");
////        for (int number : list) {
////            System.out.println(number);
////        }
//        System.out.println("list.size = " + list.size());
//
//        // last part
//        largestNumWithZeros = 10000;
//        target = getNumAsArray(largestNumWithZeros);
//        decrementDigitArray(target);
//        System.out.println("new target = " + Arrays.toString(target));
////        digits = getNumAsArray(list.get(list.size() - 1) / 10 + 1);
//        int[] tempArr = getNumAsArray(list.get(list.size() - 1) / 10 + 1);
//        digits = new int[target.length];
//        for (int i = 0; i < tempArr.length; i++) {
//            digits[i + 1] = tempArr[i];
//        }
//        System.out.println("new digits = " + Arrays.toString(digits));
//        num = 0;
//        while (num < getNum(target)) {
//            incrementDigitArray(digits);
//            num = getNum(digits);
//            int numWithoutZeros = removeZeros(num);
//            while (numWithoutZeros < num) {
//                list.add(numWithoutZeros);
//                numWithoutZeros *= 10;
//            }
//            list.add(num);
////            System.out.println(num);
//        }
////        System.out.println("list: ");
////        for (int number : list) {
////            System.out.println(number);
////        }
//        System.out.println("list.size = " + list.size());
//
//
////        if (3 < 4) {
////            return;
////        }
////
////        digits = new int[]{1, 2, 3, 4};
////        System.out.println(getNum(digits));
////        digits = new int[]{0, 0, 2, 3};
////        System.out.println(getNum(digits));
////        digits = new int[]{0, 0, 2, 0};
////        System.out.println(getNum(digits));
////
////        if (3 < 4) {
////            return;
////        }
////
////        int number = 1430;
////        int orderOfMagnitude = 0;
////        int temp = number;
////        while (temp > 0) {
////            orderOfMagnitude++;
////            temp /= 10;
////        }
////        System.out.println("orderOfMagnitude = " + orderOfMagnitude);
////        target = new int[orderOfMagnitude];
////        temp = number;
////        for (int i = orderOfMagnitude - 1; i >= 0; i--) {
////            target[i] = temp % 10;
////            temp /= 10;
////        }
////        System.out.println("Arrays.toString(target) = " + Arrays.toString(target));
//
//    }

}
