package Week1;


import utils.ListNode;

//Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//
//        You should preserve the original relative order of the nodes in each of the two partitions.
//Example:
//
//        Input: head = 1->4->3->2->5->2, x = 3
//        Output: 1->2->2->4->3->5
public class PartitionList86 {
    private ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode();
        ListNode smallDummy = new ListNode(-1, smallHead);
        ListNode bigHead = new ListNode();
        ListNode bigDummy = new ListNode(-1, bigHead);

        while (head != null) {
            if (head.val < x) {
                smallHead.next = head;
                ListNode temp = head.next;
                head.next = null;
                head = temp;
                smallHead = smallHead.next;
            } else {
                bigHead.next = head;
                ListNode listNode = head.next;
                head.next = null;
                head = listNode;
                bigHead = bigHead.next;
            }
        }
        smallHead.next = bigDummy.next.next;
        return smallDummy.next.next;
    }
}
