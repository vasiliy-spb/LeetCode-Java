package matrix.workingPeoplesImitation.task_138_Copy_List_with_Random_Pointer;

// from leetcode code sample (2)
/*
    Implements these two hints:

    Hint 3
    We can avoid using extra space for old_node ---> new_node mapping by tweaking the original linked list.
    Simply interweave the nodes of the old and copied list.
    For example: Old List: A --> B --> C --> D InterWeaved List: A --> A' --> B --> B' --> C --> C' --> D --> D'

    Hint 4
    The interweaving is done using next pointers and we can make use of interweaved structure
    to get the correct reference nodes for random pointers.

 */
public class Solution4 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        Node dummy = new Node(0);
        Node copyTail = dummy;
        curr = head;
        while (curr != null) {
            Node next = curr.next.next;
            copyTail.next = curr.next;
            copyTail = copyTail.next;
            curr.next = next;
            curr = next;
        }
        return dummy.next;
    }
}
