package matrix.workingPeoplesImitation.task_224_Basic_Calculator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        StringBuilder clearString = new StringBuilder(s.trim());
        while (clearString.indexOf(")") >= 0) {
            int closeBracket = clearString.indexOf(")");
            int openBracket = clearString.lastIndexOf("(", closeBracket);
            StringBuilder tempString = new StringBuilder();
            if (openBracket > 0) tempString.append(clearString.substring(0, openBracket).trim());
            tempString.append(calculate(clearString.substring(openBracket + 1, closeBracket).trim()));
            if (closeBracket + 1 < clearString.length())
                tempString.append(clearString.substring(closeBracket + 1).trim());
            clearString = tempString;
        }

        Stack<Integer> numberStack = new Stack<>();
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < clearString.length(); i++) {
            char ch = clearString.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                number.append(ch);
            } else {
                if (!number.isEmpty()) {
                    numberStack.push(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }
            if (ch == '-') {
                if (i < clearString.length() - 1 && clearString.charAt(i + 1) != ch) {
                    number.append(ch);
                } else {
                    i++;
                }
            }
        }
        if (!number.isEmpty()) numberStack.push(Integer.parseInt(number.toString()));
        while (numberStack.size() > 1) {
            int b = numberStack.pop();
            int a = numberStack.pop();
            numberStack.push(a + b);
        }
        return numberStack.pop();
    }

    // from walkccc.me
    public int calculate2(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;
        // stack.peek() := the current environment's sign
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(sign);

        for (final char c : s.toCharArray())
            if (Character.isDigit(c))
                num = num * 10 + (c - '0');
            else if (c == '(')
                stack.push(sign);
            else if (c == ')')
                stack.pop();
            else if (c == '+' || c == '-') {
                ans += sign * num;
                sign = (c == '+' ? 1 : -1) * stack.peek();
                num = 0;
            }

        return ans + sign * num;
    }

    // from leetcode solutions
    public static int calculate3(String s) {
        int len = s.length(), sign = 1, result = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < len; i++) {
            if (Character.isDigit(s.charAt(i))) {
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                result += sum * sign;
            } else if (s.charAt(i) == '+')
                sign = 1;
            else if (s.charAt(i) == '-')
                sign = -1;
            else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result = result * stack.pop() + stack.pop();
            }

        }
        return result;
    }

    // from leetcode solutions
    // Here is the version that always keeps the most recent sum at the top of stack without variable result.
    public int calculate4(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);                          // Always keep most recent sum at top
        for (int i = 0, sign = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';    // Be aware of outer loop boundary and i++
                for (; i < s.length() - 1 && Character.isDigit(s.charAt(i + 1)); i++) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                }
                stack.push(stack.pop() + sign * num);
            } else if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            } else if (s.charAt(i) == '(') {
                stack.push(sign);
                stack.push(0);
                sign = 1;
            } else if (s.charAt(i) == ')') {    // Update last sum = current sum * sign
                stack.push(stack.pop() * stack.pop() + stack.pop());
            } /* else whitespace*/
        }
        return stack.pop();
    }

    // from leetcode solutions
    public int calculate5(String s) {
        if (s.length() == 0) return 0;
        s = "(" + s + ")";
        int[] p = {0};
        return eval(s, p);
    }
    // calculate value between parentheses
    private int eval(String s, int[] p){
        int val = 0;
        int i = p[0];
        int oper = 1; //1:+ -1:-
        int num = 0;
        while(i < s.length()){
            char c = s.charAt(i);
            switch(c){
                case '+': val = val + oper * num; num = 0; oper = 1; i++; break;// end of number and set operator
                case '-': val = val + oper * num; num = 0; oper = -1; i++; break;// end of number and set operator
                case '(': p[0] = i + 1; val = val + oper * eval(s, p); i = p[0]; break; // start a new eval
                case ')': p[0] = i + 1; return val + oper * num; // end current eval and return. Note that we need to deal with the last num
                case ' ': i++; continue;
                default : num = num * 10 + c - '0'; i++;
            }
        }
        return val;
    }

}
