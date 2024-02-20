package matrix.workingPeoplesImitation.task_2055_Plates_Between_Candles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public int[] platesBetweenCandles(String s, int[][] queries) {
//        System.out.println("s = " + s);
        System.out.println("s.toCharArray = " + Arrays.toString(s.toCharArray()));
//        int[] prefixSum = new int[s.length() + 1];
        int[] prefixSum = new int[s.length()];
        int[] prefixSumReverse = new int[s.length()];
        int first = s.indexOf('|');
        int last = s.lastIndexOf('|');
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) == '*') {
                if (i - 1 < 0) prefixSum[i] = 1;
                else prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                if (i - 1 < 0) prefixSum[i] = 0;
                else prefixSum[i] = prefixSum[i - 1];
            }
            if (s.charAt(j) == '*') {
                if (j + 1 == s.length()) prefixSumReverse[j] = 1;
                else prefixSumReverse[j] = prefixSumReverse[j + 1] + 1;
            } else {
                if (j + 1 == s.length()) prefixSumReverse[j] = 0;
                else prefixSumReverse[j] = prefixSumReverse[j + 1];
            }
        }
        System.out.println("prefixSum = " + Arrays.toString(prefixSum));
        System.out.println("prefixSumReverse = " + Arrays.toString(prefixSumReverse));
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            if (s.charAt(start) != '|') start = binarySearchIndex(prefixSum, start, end, true);
            if (s.charAt(end) != '|') end = binarySearchIndex(prefixSum, queries[i][0], end, false);
            System.out.println("start = " + start);
            System.out.println("end = " + end);
            System.out.println();
            if (start < end) result[i] = prefixSum[end] - prefixSum[start];
            else result[i] = 0;
        }
        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
        return result;
    }

//    public int[] platesBetweenCandles(String s, int[][] queries) {
////        System.out.println("s = " + s);
//        System.out.println("s.toCharArray = " + Arrays.toString(s.toCharArray()));
////        int[] prefixSum = new int[s.length() + 1];
//        int[] prefixSum = new int[s.length()];
//        int[] prefixSumReverse = new int[s.length()];
//        int first = s.indexOf('|');
//        int last = s.lastIndexOf('|');
//        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
//            if (i >= first && i <= last) {
//                if (s.charAt(i) == '*') {
//                    prefixSum[i + 1] = prefixSum[i] + 1;
//                } else {
//                    prefixSum[i + 1] = prefixSum[i];
//                }
//            } else {
//                prefixSum[i + 1] = -1;
//            }
//        }
//        System.out.println("prefixSum = " + Arrays.toString(prefixSum));
//        int[] result = new int[queries.length];
//        for (int i = 0; i < queries.length; i++) {
//            int start = queries[i][0];
//            int end = queries[i][1];
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
//            if (s.charAt(start) != '|') start = binarySearchIndex(prefixSum, start + 1, end + 1, true);
//            if (s.charAt(end) != '|') end = binarySearchIndex(prefixSum, queries[i][0] + 1, end + 1, false);
//            System.out.println("start = " + start);
//            System.out.println("end = " + end);
//            System.out.println();
//            if (start < end) result[i] = prefixSum[end] - prefixSum[start];
//            else result[i] = 0;
//        }
//        System.out.println("Arrays.toString(result) = " + Arrays.toString(result));
//        return result;
//    }

    private int binarySearchIndex(int[] prefixSum, int start, int end, boolean findFirst) {
        int l = start;
        int r = end;
        while (l < r) {
            int mid = (l + r) / 2;
            if (findFirst) {
                if (prefixSum[mid] > prefixSum[start]) {
                    if (prefixSum[mid - 1] == prefixSum[start]) return mid - 1;
                    else r = mid;
                } else {
                    l = mid + 1;
                }
            } else {
                if (prefixSum[mid] < prefixSum[end]) {
                    if (prefixSum[mid + 1] == prefixSum[end]) return mid;
                    else l = mid + 1;
                } else {
                    r = mid;
                }
            }
        }
        return l;
//        return findFirst ? l : l - 1;
    }

    // my solution 2 (binary search)
    public int[] platesBetweenCandles0(String s, int[][] queries) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '|') indexList.add(i);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int firstListIndex = binarySearch(indexList, queries[i][0], true);
            int lastListIndex = binarySearch(indexList, queries[i][1], false);
            if (firstListIndex < lastListIndex) {
                int count = lastListIndex - firstListIndex;
                result[i] = indexList.get(lastListIndex) - indexList.get(firstListIndex) - count;
            } else {
                result[i] = 0;
            }
        }
        return result;
    }

    private int binarySearch(List<Integer> indexList, int target, boolean findFirst) {
        int l = 0;
        int r = indexList.size();
        while (l < r) {
            int mid = (l + r) / 2;
            if (indexList.get(mid) == target) return mid;
            if (indexList.get(mid) < target) l = mid + 1;
            else r = mid;
        }
        return findFirst ? l : l - 1;
    }

    // my solution 1
    public int[] platesBetweenCandles1(String s, int[][] queries) {
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int first;
            int last;
            int[] indexes = findIndexes(queries[i][0], queries[i][1], s);
            first = indexes[0];
            last = indexes[1];
            int count = 0;
            if (first != last && (first >= 0 && last > 0)) {
                for (int j = first + 1; j < last; j++) {
                    if (s.charAt(j) == '*') count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    private int[] findIndexes(int from, int to, String s) {
        int[] res = new int[]{-1, -1};
        for (int i = from, j = to; i < j; i++, j--) {
            if (s.charAt(i) == '|' && res[0] == -1) res[0] = i;
            if (s.charAt(j) == '|' && res[1] == -1) res[1] = j;
        }
        return res;
    }

    // from walkccc.me (Approach 1: Binary Search)
    public int[] platesBetweenCandles2(String s, int[][] queries) {
        int[] ans = new int[queries.length];
        List<Integer> indices = new ArrayList<>(); // indices of '|'

        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '|')
                indices.add(i);

        for (int i = 0; i < queries.length; ++i) {
            final int left = queries[i][0];
            final int right = queries[i][1];
            final int l = firstGreaterEqual(indices, left);
            final int r = firstGreaterEqual(indices, right + 1) - 1;
            if (l < r) {
                final int lengthBetweenCandles = indices.get(r) - indices.get(l) + 1;
                final int numCandles = r - l + 1;
                ans[i] = lengthBetweenCandles - numCandles;
            }
        }

        return ans;
    }

    private int firstGreaterEqual(List<Integer> indices, int target) {
        final int i = Collections.binarySearch(indices, target);
        return i < 0 ? -i - 1 : i;
    }

    // from walkccc.me (Approach 2: Linear)
    public int[] platesBetweenCandles3(String s, int[][] queries) {
        final int n = s.length();
        int[] ans = new int[queries.length];
        int[] closestLeftCandle = new int[n];
        int[] closestRightCandle = new int[n];
        int[] candleCount = new int[n]; // candleCount[i] := the number of candles in s[0..i]
        int candle = -1;
        int count = 0;

        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '|') {
                candle = i;
                ++count;
            }
            closestLeftCandle[i] = candle;
            candleCount[i] = count;
        }

        candle = -1;
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '|')
                candle = i;
            closestRightCandle[i] = candle;
        }

        for (int i = 0; i < queries.length; ++i) {
            final int left = queries[i][0];
            final int right = queries[i][1];
            final int l = closestRightCandle[left];
            final int r = closestLeftCandle[right];
            if (i == -1 || r == -1 || l > r)
                continue;
            final int lengthBetweenCandles = r - l + 1;
            final int numCandles = candleCount[r] - candleCount[l] + 1;
            ans[i] = lengthBetweenCandles - numCandles;
        }

        return ans;
    }

    // from leetcode.ca
    public int[] platesBetweenCandles4(String s, int[][] queries) {
        int n = s.length();
        int[] presum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }
        System.out.println("presum = " + Arrays.toString(presum));
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0, l = -1; i < n; ++i) {
            if (s.charAt(i) == '|') {
                l = i;
            }
            left[i] = l;
        }
        for (int i = n - 1, r = -1; i >= 0; --i) {
            if (s.charAt(i) == '|') {
                r = i;
            }
            right[i] = r;
        }
        System.out.println("left = " + Arrays.toString(left));
        System.out.println("right = " + Arrays.toString(right));
        int[] ans = new int[queries.length];
        for (int k = 0; k < queries.length; ++k) {
            int i = right[queries[k][0]];
            int j = left[queries[k][1]];
            if (i >= 0 && j >= 0 && i < j) {
                ans[k] = presum[j] - presum[i + 1];
            }
        }
        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
        System.out.println();
        return ans;
    }

}
