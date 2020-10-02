package Week2;

import utils.ListNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLL1019 {
    public int[] nextLargerNodes1(ListNode head) {
        //brute force: for each node in LL, iterate to end and find a minimum larger, time complexity would be O(n^2)
        if (head == null) return new int[0];
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }

        int[] result = new int[len];
        for (int i = 0; i < len; i++) {
            cur = head.next;
            int minLargest = 0;
            while(cur != null) {
                if (cur.val > head.val && (minLargest == 0)) {
                    minLargest = cur.val;
                }
                cur = cur.next;
            }
            result[i] = minLargest;
            head = head.next;
        }
        return result;
    }

    public int[] nextLargerNodes(ListNode head) {

        // Keeps track of indices of values in nums
        Deque<Integer> stack = new ArrayDeque<>();

        // Store node values as we go,
        // updates to output value ("next greatest") within while loop as we see them
        List<Integer> nums = new ArrayList<>();


        // For generating the corresponding index in nums as we step through LinkedList
        int index = 0;

        while (head != null) {

            nums.add(head.val);

            // Process anything that is less than current node value
            // i.e. current node value is the "next"greatest for elements (index-referenced) in the stack
            while (!stack.isEmpty() && nums.get(stack.peek()) < head.val) {
                nums.set(stack.pop(), head.val);
            }

            // Set up for next iteration.
            // Note: Every node gets into the stack.
            stack.push(index);
            head = head.next;
            index++;
        }

        // Handle remaining items in stack / write in 0 (no "next greatest" found for these)
        while (!stack.isEmpty()) {
            nums.set(stack.pop(), 0);
        }

        // Format output
        int[] result = new int[nums.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums.get(i);
        }

        return result;
    }


    public int[] nextLargerNodes2(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        for (ListNode node = head; node != null; node = node.next)
            list.add(node.val);
        int[] res = new int[list.size()];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < list.size(); ++i) {
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i))
                res[stack.pop()] = list.get(i);
            stack.push(i);
        }
        return res;
    }
}
