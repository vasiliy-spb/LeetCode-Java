package matrix.workingPeoplesImitation.task_382_Linked_List_Random_Node;

import matrix.workingPeoplesImitation.linked_list_helper.ListNode;

import java.util.Random;

// from leetcode code sample (1)

//Steps to Resolve the Problem Count Nodes: Traverse the linked list to determine the number of nodes. Initialize Array: Create an array of size equal to the number of nodes and populate it with values from the linked list. Random Access: Implement a method to return a random element from the array.
//Data Structures Used Array: Used to store the values from the linked list. This allows for O(1) time complexity when retrieving a random value. Random: Provides a way to generate random indices for retrieving elements from the array
public class Solution3 {
    int[] arr; // Array to store values from the linked list
    Random random = new Random(); // Random number generator for picking random elements

    public Solution3(ListNode head) {
        int count = 0; // To count the number of nodes in the linked list
        // Traverse the linked list to count the number of nodes
        for (ListNode p = head; p != null; p = p.next) {
            ++count;
        }
        arr = new int[count]; // Initialize the array with the size of the number of nodes
        ListNode curr = head; // Pointer to traverse the linked list again
        // Traverse the linked list to fill the array with node values
        for (int i = 0; i < count; i++) {
            arr[i] = curr.val; // Store each node's value in the array
            curr = curr.next; // Move to the next node
        }
    }

    public int getRandom() {
        // Pick a random index in the array and return the value at that index
        return arr[random.nextInt(arr.length)];
    }
}
//Time Complexity: Constructor: O(n), where n is the number of nodes in the linked list, due to the need to traverse the list twice (once for counting and once for copying values). getRandom(): O(1), as it performs a constant-time operation to select a random index and retrieve the value.
//Space Complexity: O(n), where n is the number of nodes in the linked list, due to the storage required for the array.
//Algorithm Type Array Storage with Random Access: This approach involves storing all linked list values in an array to facilitate quick random access.
// Why This Approach Is Efficient Performance: This approach offers efficient random access (O(1) time complexity for getRandom()) because once the list is converted to an array, random access to any element is immediate. Trade-off: The trade-off is a higher space complexity (O(n)) due to storing all the list values in an array. This is acceptable if random access efficiency is a priority and space is not a constraint

