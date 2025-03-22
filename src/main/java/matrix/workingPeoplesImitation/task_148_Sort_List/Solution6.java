package matrix.workingPeoplesImitation.task_148_Sort_List;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (3)
public class Solution6 {
    public ListNode sortList(ListNode head) {
        ListNode ans = new ListNode(0);
        if (head == null || head.next == null) {
            return head;
        }
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            size++;
            temp = temp.next;
        }

        temp = head;

        int[] arr = new int[size];
        int i = 0;

        while (temp != null) {
            arr[i++] = temp.val;
            temp = temp.next;
        }

        countSort(arr);

        temp = head;
        for (int k = 0; k < arr.length; k++) {
            temp.val = arr[k];
            temp = temp.next;
        }

        return head;
    }

    private static void countSort(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }

        int[] count = new int[max - min + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        int[] temp = new int[nums.length];
        for (int i = 0; i < temp.length; i++) {
            temp[--count[nums[i] - min]] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
