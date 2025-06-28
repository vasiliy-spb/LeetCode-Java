package matrix.workingPeoplesImitation.task_138_Copy_List_with_Random_Pointer;

// from leetcode code sample (1)
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
public class Solution3 {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            Node new_node = new Node(curr.val, curr.next);
            curr.next = new_node;
            curr = new_node.next;
        }

        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next != null ? curr.next.next : null;
        }

        Node old_head = head;
        Node new_head = head.next;
        Node curr_old = old_head;
        Node curr_new = new_head;

        while (curr_old != null) {
            curr_old.next = curr_old.next.next;
            curr_new.next = curr_new.next != null ? curr_new.next.next : null;
            curr_old = curr_old.next;
            curr_new = curr_new.next;
        }

        return new_head;
    }
}
