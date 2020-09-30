package Week2;

import utils.ListNode;

import java.util.List;

/*
Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:

Start with the head as the current node.
Keep the first m nodes starting with the current node.
Remove the next n nodes
Keep repeating steps 2 and 3 until you reach the end of the list.
Return the head of the modified list after removing the mentioned nodes.

Follow up question: How can you solve this problem by modifying the list in-place?
 */


// 1->2->3->4
public class DeleteNNodesAfterMNodes1474 {


    private static ListNode ver2(ListNode head, int m , int n) {
        ListNode cur = head, pre = null;
        while (cur != null) {
            int i = m, j = n;

            while (cur != null && i-- > 0) {
                pre = cur;
                cur = cur.next;
            }

            while (cur != null && j-- > 0) {
                cur = cur.next;
            }
            pre.next = cur;
        }
        return head;
    }

    public static void main(String[] args) {

    }
}
