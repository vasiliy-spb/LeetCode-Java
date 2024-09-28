package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// my solution
public class Solution {
    List<Integer> valueList;
    Random random;

    public Solution(ListNode head) {
        this.valueList = new ArrayList<>();
        while (head != null) {
            valueList.add(head.val);
            head = head.next;
        }
        this.random = new Random();
    }

    public int getRandom() {
        return valueList.get(random.nextInt(valueList.size()));
    }
}
