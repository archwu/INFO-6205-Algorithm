package Week2;

import utils.ListNode;

public class ReorderList143 {
  public void reorderList(ListNode head) {
    //find the middle node node
    ListNode dummy = head;
    ListNode middle = findMiddle(head);
    ListNode sndHlf = middle.next;

    mergeLists(head, reverseList(sndHlf));
  }

  private ListNode reverseList(ListNode head) {
    ListNode prev = null;
    while(head != null) {
      ListNode next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  private void mergeLists(ListNode o1, ListNode o2) {
    ListNode tmp;
    while (o2.next != null) {
      tmp = o1.next;
      o1.next = o2;
      o1 = tmp;
      tmp = o2.next;
      o2.next = o1;
      o2 = tmp;
    }
  }

  private ListNode findMiddle(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }
}
