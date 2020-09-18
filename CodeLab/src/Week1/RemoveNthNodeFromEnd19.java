package Week1;

import utils.ListNode;

public class RemoveNthNodeFromEnd19 {
    private static ListNode removeNthNode(ListNode head, int k) {
        // find length of LinkedList
        int length = 0;
        ListNode dummy = head;
        while (dummy != null) {
            length++;
            dummy = dummy.next;
        }
        // corner case: invalid k
        if (k > length || k <= 0){
            return null;
        }
        if (k == length){
            head = head.next;
            return head;
        }
        // find N-1th from end
        dummy = head;
        for (int i = 1; i < length - k; i++) {
            dummy = dummy.next;
        }
        // remove the Nth node
        if (k != 1){
            dummy.next = dummy.next.next;
        } else {
            dummy.next = null;
        }
        return head;
    }
}
