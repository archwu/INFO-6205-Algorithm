package Week2;

import utils.ListNode;

public class SwapPairs24 {
    public ListNode swapPairs(ListNode head) {
        // 1->2->3
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;

        while(head != null && head.next != null) {
            ListNode foreHead = head;
            ListNode backHead = head.next;

            prev.next = backHead;
            foreHead.next = backHead.next;
            backHead.next = foreHead;

            prev = foreHead;
            head = foreHead.next;
        }

        return dummy.next;
    }
}
