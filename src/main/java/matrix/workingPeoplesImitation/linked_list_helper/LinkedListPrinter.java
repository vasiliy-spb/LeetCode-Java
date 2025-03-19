package matrix.workingPeoplesImitation.linked_list_helper;

public class LinkedListPrinter {
    public static void printLinkedList(ListNode current) {
        printLinkedList(current, " — ");
    }
    public static void printLinkedList(ListNode current, String delimiter) {
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
            if (current != null) {
                System.out.print(delimiter);
            }
        }
        System.out.println();
    }
}
