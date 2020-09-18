package Week1;


import utils.ListNode;

//Given a node from a Circular Linked List which is sorted in ascending order, write a function to insert a value insertVal into the list such that it remains a sorted circular list. The given node can be a reference to any single node in the list, and may not be necessarily the smallest value in the circular list.
//
//        If there are multiple suitable places for insertion, you may choose any place to insert the new value. After the insertion, the circular list should remain sorted.
//
//        If the list is empty (i.e., given node is null), you should create a new single circular list and return the reference to that single node. Otherwise, you should return the original given node.
public class InsertIntoSortedCircularLinkedList708 {
    private ListNode insert(ListNode head, int insertVal) {
        ListNode insertNode = new ListNode(insertVal);
        ListNode dummyHead = new ListNode(-1, head);
        if (head == null) {
            insertNode.next = insertNode;
            return insertNode;
        }
        while (head.next != dummyHead.next) {
            if (insertVal > head.val && insertVal < head.next.val) {
                insertNode.next = head.next;
                head.next = insertNode;
                return dummyHead.next;
            }
            if (head.val > head.next.val && (insertVal < head.next.val || insertVal > head.val)) {
                insertNode.next = head.next;
                head.next = insertNode;
                return dummyHead.next;
            }
            if (insertVal == head.val){
                insertNode.next = head.next;
                head.next = insertNode;
                return dummyHead.next;
            }
            head = head.next;
        }
        insertNode.next = head.next;
        head.next = insertNode;
        return dummyHead.next;
    }
}
