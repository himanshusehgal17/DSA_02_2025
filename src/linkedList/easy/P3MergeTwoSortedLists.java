package linkedList.easy;

import linkedList.BaseExecution;
import linkedList.ListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 *
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/description/
 */

public class P3MergeTwoSortedLists extends BaseExecution {
    public static void main(String[] args) {
        ListNode head1 = createLinkedList(3);
        ListNode head2 = createLinkedList(4);

        printLinkedList(head1);
        printLinkedList(head2);
        printLinkedList(mergeSortedList(head1, head2));
    }

    public static ListNode mergeSortedList(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }

        if (head1.val <= head2.val) {
            head1.next = mergeSortedList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeSortedList(head1, head2.next);
            return head2;
        }
    }
}
