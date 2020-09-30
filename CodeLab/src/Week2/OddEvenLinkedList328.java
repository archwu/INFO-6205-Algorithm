package Week2;
/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

 */

import utils.ListNode;

public class OddEvenLinkedList328 {
    private static ListNode oddEven(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode dummy = new ListNode(0, even);

        // 1 -> 2 -> 3 -> 4 -> 5 ->NULL
        while (even != null && even.next != null) {  // ensure that no NPE happens
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = dummy.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0, new ListNode(1,new ListNode(2, new ListNode(3))));
        ListNode ln = oddEven(head);
        ln.printNode();
    }
}
