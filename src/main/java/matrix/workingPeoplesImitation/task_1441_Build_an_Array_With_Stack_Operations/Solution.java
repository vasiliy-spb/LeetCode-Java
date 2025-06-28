package matrix.workingPeoplesImitation.task_1441_Build_an_Array_With_Stack_Operations;

import java.util.ArrayList;
import java.util.List;

// my solution
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> stack = new ArrayList<>();
        int num = 1;
        int index = 0;
        while (index < target.length) {
            stack.add("Push");
            if (num < target[index]) {
                stack.add("Pop");
            } else {
                index++;
            }
            num++;
        }
        return stack;
    }
}
