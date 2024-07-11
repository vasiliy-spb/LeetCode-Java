package matrix.workingPeoplesImitation.task_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses;

import java.util.*;

public class Solution {

    // my solution
    public String reverseParentheses(String s) {
        int close = s.indexOf(")");
        if (close < 0) return s;
        int open = s.lastIndexOf("(", close);
        StringBuilder result = new StringBuilder();
        if (open > 0) result.append(s, 0, open);
        result.append(reverseSubstring(s.substring(open + 1, close)));
        if (close < s.length() - 1) result.append(s.substring(close + 1));
        return reverseParentheses(result.toString());
    }
    public String reverseSubstring(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    // from leetcode editorial (Approach 1: Straightforward Way)
    public String reverseParentheses2(String s) {
        Stack<Integer> openParenthesesIndices = new Stack<>();
        StringBuilder result = new StringBuilder();

        for (char currentChar : s.toCharArray()) {
            if (currentChar == '(') {
                // Store the current length as the start index for future reversal
                openParenthesesIndices.push(result.length());
            } else if (currentChar == ')') {
                int start = openParenthesesIndices.pop();
                // Reverse the substring between the matching parentheses
                reverse(result, start, result.length() - 1);
            } else {
                // Append non-parenthesis characters to the processed string
                result.append(currentChar);
            }
        }

        return result.toString();
    }

    private void reverse(StringBuilder sb, int start, int end) {
        while (start < end) {
            char temp = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }

    // from leetcode editorial (Approach 2: Wormhole Teleportation technique)
    public String reverseParentheses3(String s) {
        int n = s.length();
        Stack<Integer> openParenthesesIndices = new Stack<>();
        int[] pair = new int[n];

        // First pass: Pair up parentheses
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openParenthesesIndices.push(i);
            }
            if (s.charAt(i) == ')') {
                int j = openParenthesesIndices.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        // Second pass: Build the result string
        StringBuilder result = new StringBuilder();
        for (
                int currIndex = 0, direction = 1;
                currIndex < n;
                currIndex += direction
        ) {
            if (s.charAt(currIndex) == '(' || s.charAt(currIndex) == ')') {
                currIndex = pair[currIndex];
                direction = -direction;
            } else {
                result.append(s.charAt(currIndex));
            }
        }

        return result.toString();
    }

    // from walkccc.me (Approach 1: Brute Force)
    public String reverseParentheses4(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (final char c : s.toCharArray())
            if (c == '(') {
                stack.push(sb.length());
            } else if (c == ')') {
                // Reverse the corresponding substring between ().
                StringBuilder reversed = new StringBuilder();
                for (int sz = sb.length() - stack.pop(); sz > 0; --sz) {
                    reversed.append(sb.charAt(sb.length() - 1));
                    sb.deleteCharAt(sb.length() - 1);
                }
                sb.append(reversed);
            } else {
                sb.append(c);
            }

        return sb.toString();
    }

    // from walkccc.me (Approach 2: O(n)O(n))
    public String reverseParentheses5(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> pair = new HashMap<>();

        for (int i = 0; i < s.length(); ++i)
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                final int j = stack.pop();
                pair.put(i, j);
                pair.put(j, i);
            }

        for (int i = 0, d = 1; i < s.length(); i += d)
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = pair.get(i);
                d = -d;
            } else {
                sb.append(s.charAt(i));
            }

        return sb.toString();
    }

    // from leetcode code sample (1)
    int i = 0;
    public String reverseParentheses6(String s) {
        char[] ar = s.toCharArray();
        return helper(ar);
    }

    public String helper(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }else if(s[i] == '('){
                i++;
                String st  = helper(s);
                //System.out.println(st);
                sb.append(st);
            }else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();

    }

    // from leetcode code sample (2)
    public String reverseParentheses7(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        return dfs(s, 0, s.length() - 1, 0);
    }

    private String dfs(String s, int left, int right, int level) {
        if (left > right) {
            return "";
        }

        if (level % 2 == 0) {
            return leftToRight(s, left, right, level);
        }
        return rightToLeft(s, left, right, level);
    }

    private String leftToRight(String s, int left, int right, int level) {
        StringBuilder sb = new StringBuilder();
        for (int fast = left; fast <= right; fast++) {
            char ch = s.charAt(fast);
            if (ch != '(') {
                sb.append(ch);
                continue;
            }

            int end = getEndLeftToRight(s, fast);
            sb.append(dfs(s, fast + 1, end - 1, level + 1));
            fast = end;
        }

        return sb.toString();
    }

    private String rightToLeft(String s, int left, int right, int level) {
        StringBuilder sb = new StringBuilder();
        for (int fast = right; fast >= left; fast--) {
            char ch = s.charAt(fast);
            if (ch != ')') {
                sb.append(ch);
                continue;
            }

            int end = getEndRightToLeft(s, fast);
            sb.append(dfs(s, end + 1, fast - 1, level + 1));
            fast = end;
        }

        return sb.toString();
    }

    private int getEndRightToLeft(String s, int start) {
        int end = start;
        for (int cnt = 0; end >= 0; end--) {
            char ch = s.charAt(end);
            if (ch == ')') {
                cnt++;
            } else if (ch == '(' && --cnt == 0) {
                return end;
            }
        }

        return 0;
    }

    private int getEndLeftToRight(String s, int start) {
        int end = start;
        for (int cnt = 0; end < s.length(); end++) {
            char ch = s.charAt(end);
            if (ch == '(') {
                cnt++;
            } else if (ch == ')' && --cnt == 0) {
                return end;
            }
        }

        return s.length() - 1;
    }

}
