package linkedList.easy;

import linkedList.BaseExecution;
import linkedList.ListNode;

/**
 * Given the head of a singly linked list, return the middle node of the linked list.
 * <p>
 * If there are two middle nodes, return the second middle node.
 * <p>
 * Example 1:
 * Input: head = [1,2,3,4,5]
 * Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * <p>
 * Example 2:
 * Input: head = [1,2,3,4,5,6]
 * Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 *
 * Link: https://leetcode.com/problems/middle-of-the-linked-list/submissions/1550484697/
 */
public class P2MiddleOfLinkedList extends BaseExecution {


    public static void main(String[] args) {
        ListNode listNode = createLinkedList(6);
        printLinkedList(findMiddle(listNode));

    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
