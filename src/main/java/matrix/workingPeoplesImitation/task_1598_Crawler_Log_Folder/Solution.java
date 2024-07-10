package matrix.workingPeoplesImitation.task_1598_Crawler_Log_Folder;

import java.util.Stack;

public class Solution {

    // my solution
    public int minOperations(String[] logs) {
        Stack<String> stack = new Stack<>();
        for (String log : logs) {
            switch (log) {
                case "../" -> {
                    if (!stack.empty()) stack.pop();
                }
                case "./" -> {}
                default -> stack.push(log);
            }
        }
        return stack.size();
    }

    // from leetcode editorial (Approach 1: Counter)
    public int minOperations2(String[] logs) {
        int folderDepth = 0;

        // Iterate through each log operation
        for (String currentOperation : logs) {
            // Go up one directory if "../" is encountered, but don't go above the root
            if (currentOperation.equals("../")) {
                folderDepth = Math.max(0, folderDepth - 1);
            }
            // Increase depth if the log is not 'stay in the current directory'
            else if (!currentOperation.equals("./")) {
                // Go down one directory
                folderDepth++;
            }
            // Ignore "./" operations as they don't change the current folder
        }

        return folderDepth;
    }

    // from leetcode editorial (Approach 2: Stack)
    public int minOperations3(String[] logs) {
        Stack<String> folderStack = new Stack<>();

        for (String currentOperation : logs) {
            if (currentOperation.equals("../")) {
                // Move up to parent directory if not already at main folder
                if (!folderStack.empty()) {
                    folderStack.pop();
                }
            } else if (!currentOperation.equals("./")) {
                // Enter a new folder
                folderStack.push(currentOperation);
            }
            // Ignore "./" operations as they don't change the current folder
        }

        // The stack size represents the number of folders deep we are
        return folderStack.size();
    }

    // from walkccc.me
    public int minOperations4(String[] logs) {
        int ans = 0;

        for (final String log : logs) {
            if (log.equals("./"))
                continue;
            if (log.equals("../"))
                ans = Math.max(0, ans - 1);
            else
                ++ans;
        }

        return ans;
    }

}
