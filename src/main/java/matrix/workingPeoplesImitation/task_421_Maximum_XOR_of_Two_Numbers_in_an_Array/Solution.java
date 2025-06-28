package matrix.workingPeoplesImitation.task_421_Maximum_XOR_of_Two_Numbers_in_an_Array;

// my solution
public class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie dict = new Trie();
        for (int num : nums) {
            dict.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans, dict.getMaxXoredInt(num));
        }
        return ans;
    }

    static final class Trie {
        TrieNode root = new TrieNode('\0');

        public void add(int n) {
            StringBuilder num = new StringBuilder(Integer.toBinaryString(n));
            while (num.length() < 32) {
                num.insert(0, "0");
            }
            TrieNode current = root;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (current.next[ch - '0'] == null) {
                    current.next[ch - '0'] = new TrieNode(ch);
                }
                current = current.next[ch - '0'];
            }
        }

        public int getMaxXoredInt(int n) {
            StringBuilder num = new StringBuilder(Integer.toBinaryString(n));
            while (num.length() < 32) {
                num.insert(0, "0");
            }
            StringBuilder ans = new StringBuilder();
            TrieNode current = root;
            for (int i = 0; i < num.length(); i++) {
                char ch = num.charAt(i);
                if (ch == '0') {
                    if (current.next[1] != null) {
                        ans.append(1);
                        current = current.next[1];
                    } else {
                        ans.append(0);
                        current = current.next[0];
                    }
                } else {
                    if (current.next[0] != null) {
                        ans.append(1);
                        current = current.next[0];
                    } else {
                        ans.append(0);
                        current = current.next[1];
                    }
                }
            }
            return Integer.parseInt(ans.toString(), 2);
        }

        static final class TrieNode {
            char value;
            TrieNode[] next;

            public TrieNode(char value) {
                this.value = value;
                this.next = new TrieNode[2];
            }
        }
    }
}
