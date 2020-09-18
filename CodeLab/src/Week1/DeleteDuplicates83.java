package Week1;
import utils.ListNode;
//Given a sorted linked list, delete all duplicates such that each element appear only once.
//
//        Example 1:
//
//        Input: 1->1->2
//        Output: 1->2
//        Example 2:
//
//        Input: 1->1->2->3->3
//        Output: 1->2->3

public class DeleteDuplicates83 {
    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummyHead = new ListNode(-1, head);
        while (head != null){
            while (head.next != null && head.next.val == head.val){
                head.next = head.next.next;
            }
            head = head.next;
        }
        return dummyHead.next;
    }
}
