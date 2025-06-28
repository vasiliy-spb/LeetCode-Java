package matrix.workingPeoplesImitation.task_3217_Delete_Nodes_From_Linked_List_Present_in_Array;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

// from leetcode code sample (2)
class Solution5 {
    public ListNode modifiedList(int[] nums, ListNode head) {
        int max = nums[0]; //intialize max

        for(int num: nums) { max = num>max ? num : max;} //find max of nums
        boolean[] frequency = new boolean[max+1]; //use max to intialize frequency array
        //if num is apart of frequency list, set to true at index
        for(int num: nums) {frequency[num]=true;}
        //create new node list, use temp and current nodes
        ListNode dummy = new ListNode();
        ListNode current = dummy;

        //while loop to go until head is null
        //check if head[0] is apart of nums, handle accordingly
        //increment head to head.next
        while(head != null) {
            if(head.val>=frequency.length || frequency[head.val]==false) {
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        //current.next is now null to signify end of linked list
        //return list

        current.next = null;
        return dummy.next;



    }
}
