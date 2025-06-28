package matrix.workingPeoplesImitation.task_2116_Check_if_a_Parentheses_String_Can_Be_Valid;

import java.util.Stack;

public class Solution {

    // my solution
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) return false;
        Stack<Integer> stack = new Stack<>();
        int countLockedOpen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '1') {
                if (s.charAt(i) == '(') {
                    stack.push(-1);
                    countLockedOpen++;
                } else {
                    if (stack.empty()) return false;
                    if (countLockedOpen > 0) {
                        int n = stack.pop();
                        if (n > 0) {
                            stack.pop();
                            stack.push(n);
                        }
                        countLockedOpen--;
                    } else {
                        int count = stack.pop() - 1;
                        if (count > 0) stack.push(count);
                    }
                }
            } else {
                if (stack.empty() || stack.peek() == -1) {
                    stack.push(1);
                } else {
                    stack.push(stack.pop() + 1);
                }
            }
        }
        int countFree = 0;
        while (!stack.empty()) {
            int n = stack.pop();
            if (n > 0) countFree += n;
            else {
                countFree--;
                if (countFree < 0) return false;
            }
        }
        return countFree >= 0;
    }

//    public boolean canBeValid2(String s, String locked) {
//        if (s.length() % 2 != 0) return false;
//        Stack<Integer> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (locked.charAt(i) == '1') {
//                if (s.charAt(i) == '(') {
//                    stack.push(-1);
//                } else {
//                    if (stack.empty()) return false;
//                    if (stack.peek() == -1) {
//                        stack.pop();
//                    } else {
//                        int count = stack.pop() - 1;
//                        if (count > 0) stack.push(count);
//                    }
//                }
//            } else {
//                if (stack.empty() || stack.peek() == -1) {
//                    stack.push(1);
//                } else {
//                    stack.push(stack.pop() + 1);
//                }
//            }
//        }
//        int countFree = 0;
//        System.out.println("stack = " + stack);
//        while (!stack.empty()) { // -1, -1, 5, -1, 2, -1, -1, 6, -1, -1, 3, -1
//            int n = stack.pop();
//            if (n > 0) countFree += n;
//            else {
//                countFree--;
//                if (countFree < 0) return false;
//            }
//        }
//        return countFree >= 0;
//    }
//
//
//    public boolean canBeValid1(String s, String locked) {
//        if (s.length() % 2 != 0) return false;
//        Stack<Character> stack = new Stack<>();
//        int lockedBalance = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (locked.charAt(i) == '1' && s.charAt(i) == ')') {
//                if (stack.peek() == null) return false;
//                if (s.charAt(i) == '(') lockedBalance++;
//                else lockedBalance--;
//                if (lockedBalance < 0) {
//                    if (stack.peek() == null) return false;
//                    else stack.pop();
//                }
//            }
//            if (lockedBalance == 0) stack.push(s.charAt(i));
//        }
//        return true;
//    }
//
//    public boolean canBeValid0(String s, String locked) {
//        if (s.length() % 2 == 1) return false;
//        int lockedBalance = 0;
//        int lockedCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (locked.charAt(i) == '1') {
//                lockedCount++;
//                if (s.charAt(i) == '(') lockedBalance++;
//                else lockedBalance--;
//                if (lockedBalance < 0) return false;
//            }
//        }
//        if (lockedBalance != 0) return Math.abs(lockedBalance - (s.length() - lockedCount)) >= 0;
//        return true;
//    }

    // from walkccc.me
    public boolean canBeValid2(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;

        return check(s, locked, true) && check(new StringBuilder(s).reverse().toString(),
                new StringBuilder(locked).reverse().toString(), false);
    }

    private boolean check(final String s, final String locked, boolean isForward) {
        int changeable = 0;
        int l = 0;
        int r = 0;

        for (int i = 0; i < s.length(); ++i) {
            final char c = s.charAt(i);
            final char lock = locked.charAt(i);
            if (lock == '0')
                ++changeable;
            else if (c == '(')
                ++l;
            else // c == ')'
                ++r;
            if (isForward && changeable + l - r < 0)
                return false;
            if (!isForward && changeable + r - l < 0)
                return false;
        }

        return true;
    }

    // from GPT (wrong answer)
    public static boolean canBeValid3(String s, String locked) {
        int balance = 0;
        int wildcardCount = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                if (balance > 0) {
                    balance--;
                } else if (wildcardCount > 0) {
                    wildcardCount--;
                } else if (locked.charAt(i) == '1') {
                    return false;
                }
            }

            if (locked.charAt(i) == '0') {
                wildcardCount++;
            }
        }

        balance = 0;
        wildcardCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == ')') {
                balance++;
            } else if (c == '(') {
                if (balance > 0) {
                    balance--;
                } else if (wildcardCount > 0) {
                    wildcardCount--;
                } else if (locked.charAt(i) == '1') {
                    return false;
                }
            }

            if (locked.charAt(i) == '0') {
                wildcardCount++;
            }
        }

        return true;
    }

}
