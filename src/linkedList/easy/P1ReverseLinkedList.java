package linkedList.easy;

import linkedList.ListNode;



public class P1ReverseLinkedList {
    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode current = head;

        for (int i = 2; i <= 5; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        printLinkedList(head);
        printLinkedList(reverseList(head));

    }

    private static void printLinkedList(ListNode listNode) {

        while (listNode != null) {
            if (listNode.next != null)
                System.out.print(listNode.val + " -> ");
            else System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode reverseList(ListNode head) {

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


}
