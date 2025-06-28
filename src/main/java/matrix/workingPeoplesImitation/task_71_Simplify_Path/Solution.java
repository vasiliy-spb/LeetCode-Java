package matrix.workingPeoplesImitation.task_71_Simplify_Path;

import java.util.Stack;

public class Solution {

    // my solution
    public String simplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String directory : directories) {
            if (directory.isEmpty() || directory.equals(".")) continue;
            if (directory.equals("..")) {
                if (!stack.empty()) stack.pop();
                continue;
            }
            stack.push(directory);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            result.insert(0,stack.pop()).insert(0,"/");
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    // from walkccc.me
    public String simplifyPath2(String path) {
        final String[] dirs = path.split("/");
        Stack<String> stack = new Stack<>();

        for (final String dir : dirs) {
            if (dir.isEmpty() || dir.equals("."))
                continue;
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }

        return "/" + String.join("/", stack);
    }
}
