package matrix.workingPeoplesImitation.task_3043_Find_the_Length_of_the_Longest_Common_Prefix;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie1 = new Trie();
        for (int num : arr1) {
            trie1.add(num);
        }
        Trie trie2 = new Trie();
        for (int num : arr2) {
            trie2.add(num);
        }
        int maxPrefixLength = 0;
        for (int num : arr1) {
            maxPrefixLength = Math.max(maxPrefixLength, trie2.getLengthOfMaxPrefix(num));
        }
        for (int num : arr2) {
            maxPrefixLength = Math.max(maxPrefixLength, trie1.getLengthOfMaxPrefix(num));
        }
        return maxPrefixLength;
    }
    static class Trie {
        TrieNode root = new TrieNode(-1);
        public void add(int num) {
            int[] nums = toIntArray(num);
            TrieNode current = root;
            for (int i : nums) {
                if (current.digits[i] == null) {
                    current.digits[i] = new TrieNode(i);
                }
                current = current.digits[i];
            }
            current.isDigit = true;
        }
        public int getLengthOfMaxPrefix(int num) {
            int[] nums = toIntArray(num);
            TrieNode current = root;
            int length = 0;
            for (int i : nums) {
                if (current.digits[i] == null) {
                    break;
                }
                length++;
                current = current.digits[i];
            }
            return length;
        }

        private int[] toIntArray(int num) {
            List<Integer> ints = new ArrayList<>();
            while (num > 0) {
                ints.add(num % 10);
                num /= 10;
            }
            int[] ans = new int[ints.size()];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = ints.get(ans.length - 1 - i);
            }
            return ans;
        }

        static class TrieNode {
            int value;
            TrieNode[] digits;
            boolean isDigit;

            public TrieNode(int value) {
                this.value = value;
                this.digits = new TrieNode[10];
            }
        }
    }
}
