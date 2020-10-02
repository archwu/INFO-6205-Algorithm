package Week2;

import utils.ListNode;

public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1, head);
        ListNode cur = dummyHead.next;
        ListNode pre = dummyHead;
        while(cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur.next = null;
                cur = pre.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummyHead.next;
    }
}
