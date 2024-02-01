package matrix.workingPeoplesImitation.task_739_Daily_Temperatures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class Solution {

    // my solution
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.empty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            if (stack.empty()) answer[i] = 0;
            else answer[i] = stack.peek() - i;
            stack.push(i);
        }
        return answer;
    }

    // my solution
    public int[] dailyTemperatures04(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{temperatures[temperatures.length - 1], 0});
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int t = temperatures[i];
            if (t >= stack.peek()[0]) {
                while (!stack.empty() && t >= stack.peek()[0]) {
                    stack.pop();
                }
                if (stack.empty()) temperatures[i] = 0;
                else temperatures[i] = stack.peek()[1] - i;
            } else {
                temperatures[i] = stack.peek()[1] - i;
            }
            stack.push(new int[]{t, i});
        }
        return temperatures;
    }

    // my solution
    public int[] dailyTemperatures0(int[] temperatures) {
        Stack<Integer> stackValues = new Stack<>();
        Stack<Integer> stackIndexes = new Stack<>();
        stackValues.push(temperatures[temperatures.length - 1]);
        stackIndexes.push(temperatures.length - 1);
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int t = temperatures[i];
            if (t >= stackValues.peek()) {
                while (!stackValues.empty() && t >= stackValues.peek()) {
                    stackValues.pop();
                    stackIndexes.pop();
                }
                if (stackValues.empty()) temperatures[i] = 0;
                else temperatures[i] = stackIndexes.peek() - i;
            } else {
                temperatures[i] = stackIndexes.peek() - i;
            }
            stackValues.push(t);
            stackIndexes.push(i);
        }
        return temperatures;
    }

    // my solution
    public int[] dailyTemperatures00(int[] temperatures) {
//        System.out.println(Arrays.toString(temperatures));
        Stack<Integer> stack = new Stack<>();
        int prevT = 101;
        int maxT = 0;
        for (int i = temperatures.length - 1; i >= 0; i--) {
            int currentT = temperatures[i];
//            System.out.println("temperatures[i] = " + currentT);
            if (currentT < prevT) {
                if (i == temperatures.length - 1) temperatures[i] = 0;
                else temperatures[i] = 1;
            } else if (currentT == prevT) {
                if (i < temperatures.length - 1) {
                    if (temperatures[i + 1] == 0) temperatures[i] = 0;
                    else temperatures[i] = temperatures[i + 1] + 1;
                }
            } else {
                if (currentT >= maxT) {
                    temperatures[i] = 0;
                } else {
                    Stack<Integer> tempStack = new Stack<>();
//                System.out.println("stack.size = " + stack.size());
                    while (!stack.empty()) {
                        int t = stack.pop();
//                    System.out.printf("currentT = %d, t = %d\n", currentT, t);
                        tempStack.push(t);
                        if (t > currentT) break;
                    }
                    if (stack.empty()) {
                        if (tempStack.peek() > currentT) temperatures[i] = tempStack.size();
                        else temperatures[i] = 0;
                    } else {
                        temperatures[i] = tempStack.size();
                    }
//                System.out.println("stack.size = " + stack.size());
//                System.out.println("tempStack.size = " + tempStack.size());
                    while (!tempStack.empty()) {
                        stack.push(tempStack.pop());
                    }
                }
            }
//            System.out.println("new temperatures[i] = " + temperatures[i]);
//            System.out.println();
            stack.push(currentT);
            prevT = currentT;
            maxT = Math.max(maxT, currentT);
        }
//        System.out.println(Arrays.toString(temperatures));
//        System.out.println();
        return temperatures;
    }

    // from walkccc.me
    public int[] dailyTemperatures2(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new ArrayDeque<>(); // a decreasing stack

        for (int i = 0; i < temperatures.length; ++i) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }

        return ans;
    }
}
