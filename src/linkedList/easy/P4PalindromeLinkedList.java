package linkedList.easy;

import linkedList.BaseExecution;
import linkedList.ListNode;

import java.util.List;
import java.util.Stack;

public class P4PalindromeLinkedList extends BaseExecution {
    public static void main(String[] args) {

        ListNode head = createLinkedList(5);
//        ListNode reverseHead = reverseLinkedList(head);
//        ListNode headNew = createLinkedList(5);
//        ListNode currentNode = headNew;
//        while (currentNode.next != null) {
//            currentNode = currentNode.next;
//        }
//        currentNode.next = reverseHead;
        printLinkedList(head);

        System.out.println(isPalindrome(head));
    }

    public static ListNode reverseLinkedList(ListNode head) {

        ListNode previousPointer = null;
        ListNode currentPointer = head;
        ListNode nextPointer = null;

        while (currentPointer != null) {
            nextPointer = currentPointer.next;
            currentPointer.next = previousPointer;

            previousPointer = currentPointer;
            currentPointer = nextPointer;
        }

        return previousPointer;
    }

    public static ListNode middleNode(ListNode head) {

        ListNode slowPointer = head, fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }

    public static boolean isPalindrome(ListNode head) {

        ListNode middleNode = middleNode(head);
        ListNode reverseMiddleNode = reverseLinkedList(middleNode);
        ListNode pointerOne = head;
        ListNode pointerTwo = reverseMiddleNode;

        while (pointerTwo != null) {
            if (pointerTwo.val != pointerOne.val) {
                reverseLinkedList(pointerTwo);
                return false;
            }
            pointerTwo = pointerTwo.next;
            pointerOne = pointerOne.next;
        }

        return true;
    }

//    public static boolean isPalindrome(ListNode listNode) {
//        Stack<Integer> stack = new Stack<>();
//        ListNode currentNode = listNode;
//        while (currentNode != null) {
//            stack.add(currentNode.val);
//            currentNode = currentNode.next;
//        }
//        currentNode = listNode;
//        while (currentNode != null) {
//            if (stack.pop() != currentNode.val) return false;
//            currentNode = currentNode.next;
//        }
//
//        return true;
//    }
}
