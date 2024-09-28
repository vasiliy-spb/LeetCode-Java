package matrix.workingPeoplesImitation.task_386_Lexicographical_Numbers;

import java.util.ArrayList;
import java.util.List;

// my solution (accepted)
public class Solution2 {
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
}
