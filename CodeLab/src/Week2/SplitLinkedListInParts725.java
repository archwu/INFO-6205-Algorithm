package Week2;

import utils.ListNode;

public class SplitLinkedListInParts725 {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int[] sizes = new int[k];
        ListNode dummy = head;
        int length = 0;
        while(head != null) {
            length++;
            head = head.next;
        }

        int avg = length / k;
        int residue = length % k;
        for (int i = 0; i < k; i++) {
            sizes[i] += avg;
            if (i < residue) {
                sizes[i]++;
            }
        }

        ListNode[] result = new ListNode[k];
        head = dummy;
        int counter = 0;
        ListNode prev = null;
        for (int steps : sizes) {
            for(int j = 0; j < steps; j++) {
                if (j == 0) {
                    result[counter] = head;
                }
                if (head != null) {
                    prev = head;
                    head = head.next;
                }
            }
            if (prev != null) prev.next = null;
            counter++;
        }
        return result;
    }
}
