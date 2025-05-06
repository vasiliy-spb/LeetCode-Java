package matrix.workingPeoplesImitation.task_3076_Shortest_Uncommon_Substring_in_an_Array;

// from leetcode code sample (1)
public class Solution4 {
    // TrieNode represents a single node in the Trie.
    class TrieNode {
        TrieNode[] children = new TrieNode[26];  // 26 possible characters (a-z)
        int index;  // Index of the string this node is part of. -1 means this node is not part of a unique string substring.

        public TrieNode(int index) {
            this.index = index;
        }
    }

    // Root node for the Trie
    TrieNode root = new TrieNode(-1);

    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;

        // Step 1: Insert all substrings of each string into the Trie
        for (int i = 0; i < n; i++) {
            insert(arr[i], i);
        }

        // Step 2: For each string, find the shortest unique substring
        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = search(arr[i], i);
        }

        return result;
    }

    // Method to insert all substrings of a string into the Trie
    public void insert(String s, int index) {
        char[] chars = s.toCharArray();

        // Loop over every possible starting point of a substring in the string `s`
        for (int i = 0; i < chars.length; i++) {
            TrieNode node = root;

            // For each starting point, loop through the remaining characters to form substrings
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                // Find the index of the current character in the Trie
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode(index);
                }
                node = node.children[c - 'a'];

                // If this node is visited by a substring from a different string, mark it as shared.
                if (node.index != index) {
                    node.index = -1;  // Indicating that this node is part of more than one string
                }
            }
        }
    }

    // Method to find the shortest unique substring of a string `s` for its index `index`
    public String search(String s, int index) {
        String shortest = null;  // Will hold the shortest unique substring found

        char[] chars = s.toCharArray();

        // Loop over every possible starting point of a substring in the string `s`
        for (int i = 0; i < chars.length; i++) {
            TrieNode node = root;

            // For each starting point, loop through the remaining characters to form substrings
            for (int j = i; j < chars.length; j++) {
                char c = chars[j];
                node = node.children[c - 'a'];

                // If the current node is uniquely associated with the current string, it means we found a valid substring
                if (node.index == index) {
                    String temp = s.substring(i, j + 1);

                    // If this substring is the shortest or lexicographically smallest, update the result
                    if (shortest == null || temp.length() < shortest.length() || (temp.length() == shortest.length() && temp.compareTo(shortest) < 0)) {
                        shortest = temp;
                    }
                    break;  // Early termination: once we find a valid substring, no need to check further
                }
            }
        }

        return (shortest == null) ? "" : shortest;  // If no substring found, return empty string
    }
}
