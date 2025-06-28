package matrix.workingPeoplesImitation.task_1209_Remove_All_Adjacent_Duplicates_in_String_II;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {

    // my solution
    public String removeDuplicates0(String s, int k) {
        StringBuilder result = new StringBuilder();
        Stack<StringBuilder> stack = new Stack<>();
        for (int i = 0; i < s.length(); ) {
            StringBuilder subString = new StringBuilder();
            char currentChar = s.charAt(i);
            if (!stack.empty() && stack.peek().charAt(0) == currentChar) {
                subString.append(stack.pop());
            }
            while (subString.length() < k && i < s.length() && s.charAt(i) == currentChar) {
                subString.append(s.charAt(i++));
            }
            if (subString.length() == k) continue;
            stack.push(subString);
        }
        while (!stack.empty())
            result.insert(0, stack.pop());
        return result.toString();
    }

    // from walkccc.me
    public String removeDuplicates2(String s, int k) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Item> stack = new LinkedList<>();

        for (final char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().c == c)
                ++stack.peek().freq;
            else
                stack.push(new Item(c, 1));
            if (stack.peek().freq == k)
                stack.pop();
        }

        while (!stack.isEmpty()) {
            Item item = stack.pop();
            for (int i = 0; i < item.freq; ++i)
                sb.append(item.c);
        }

        return sb.reverse().toString();
    }

    class Item {
        char c;
        int freq;

        public Item(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    // from GPT
    public String removeDuplicates3(String s, int k) {
        Stack<Pair> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek().ch == ch) {
                stack.peek().count++;
                if (stack.peek().count == k) {
                    stack.pop();
                }
            } else {
                stack.push(new Pair(ch, 1));
            }
        }

        StringBuilder result = new StringBuilder();
        for (Pair pair : stack) {
            for (int i = 0; i < pair.count; i++) {
                result.append(pair.ch);
            }
        }

        return result.toString();
    }

    class Pair {
        char ch;
        int count;

        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }

    // from leetcode solutions
    public String removeDuplicates(String s, int k) {

        Stack<Character> charSt = new Stack<>();
        Stack<Integer> countSt = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (charSt.size() > 0 && charSt.peek() == ch)
                countSt.push(countSt.peek() + 1);
            else
                countSt.push(1);

            charSt.push(ch);
            if (countSt.peek() == k) {
                for (int i = 0; i < k; i++) {
                    charSt.pop();
                    countSt.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (charSt.size() > 0)
            sb.append(charSt.pop());
        return sb.reverse().toString();
    }
}
