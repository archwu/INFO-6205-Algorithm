package Week2;

import utils.ListNode;

/*
Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list,
instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.
 */

public class DeleteNodeInLinkedList237 {
    public void deleteNode(ListNode node) {
        ListNode prev = null;
        while(node != null) {
            if (node.next != null) {
                node.val = node.next.val;
                prev = node;
            } else {
                prev.next = null;
            }
            node = node.next;
        }
    }
}
