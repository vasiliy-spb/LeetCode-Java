package matrix.workingPeoplesImitation.task_636_Exclusive_Time_of_Functions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class Solution {

    // my solution
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Func> stack = new Stack<>();
        int[] ans = new int[n];
        for (String log : logs) {
            String[] parts = log.split(":");
            int funcNumber = Integer.parseInt(parts[0]);
            int time = Integer.parseInt(parts[2]);
            if (parts[1].equals("start")) {
                if (!stack.empty()) {
                    stack.peek().setTotalTime(stack.peek().getTotalTime() + time - stack.peek().getTimeStart());
                }
                stack.push(new Func(funcNumber, time));
            } else {
                Func func = stack.pop();
                ans[func.getNumber()] += func.getTotalTime() + time - func.getTimeStart() + 1;
                if (!stack.empty()) {
                    stack.peek().setTimeStart(time + 1);
                }
            }
        }
        return ans;
    }
    private static class Func {
        final private int number;
        private int timeStart;
        private int totalTime;
        public Func(int number, int timeStart) {
            this.number = number;
            this.timeStart = timeStart;
            this.totalTime = 0;
        }

        public int getNumber() {
            return number;
        }

        public int getTimeStart() {
            return timeStart;
        }

        public void setTimeStart(int timeStart) {
            this.timeStart = timeStart;
        }

        public int getTotalTime() {
            return totalTime;
        }

        public void setTotalTime(int totalTime) {
            this.totalTime = totalTime;
        }
    }

    // from walkccc.me
    public int[] exclusiveTime2(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // [oldest_id, ..., latest_id]
        int prevTime = -1;

        for (final String log : logs) {
            final String[] splits = log.split(":");
            // Get the function_id, the label, and the timestamp.
            final int id = Integer.parseInt(splits[0]);        // {function_id}
            final char label = splits[1].charAt(0);            // {"s" ("start") | "e" ("end") }
            final int timestamp = Integer.parseInt(splits[2]); // {timestamp}
            if (label == 's') {
                if (!stack.isEmpty())
                    ans[stack.peek()] += timestamp - prevTime;
                stack.push(id);
                prevTime = timestamp;
            } else {
                ans[stack.pop()] += timestamp - prevTime + 1;
                prevTime = timestamp + 1;
            }
        }

        return ans;
    }

}
