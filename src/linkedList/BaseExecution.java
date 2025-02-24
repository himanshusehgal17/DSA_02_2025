package linkedList;


public abstract class BaseExecution {


    public static ListNode createLinkedList(int size) {
        ListNode head = new ListNode(1), current = head;
        for (int i = 2; i <= size; i++) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head;
    }

    public static ListNode createLinkedListInReverseOrder(int size) {
        ListNode head = new ListNode(size), current = head;
        for (int i = size - 1; i > 0; i--) {
            current.next = new ListNode(i);
            current = current.next;
        }

        return head;
    }



    public static void printLinkedList(ListNode head) {

        ListNode current = head;
        while (current != null) {
            if (current.next != null)
                System.out.print(current.val + " -> ");
            else System.out.println(current.val);
            current = current.next;
        }
    }
}
