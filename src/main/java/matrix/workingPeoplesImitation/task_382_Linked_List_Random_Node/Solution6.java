package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Random;

// from leetcode code sample (4)
public class Solution6 {
    private ListNode head;
    private Random random = new Random();

    public Solution6(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int ans = 0, n = 0;
        for (ListNode node = head; node != null; node = node.next) {
            ++n;
            int x = 1 + random.nextInt(n);
            if (n == x) {
                ans = node.val;
            }
        }
        return ans;
    }
}
