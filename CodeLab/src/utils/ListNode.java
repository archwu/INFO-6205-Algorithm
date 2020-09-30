package utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.next = next;
        this.val = val;
    }

    public ListNode() {

    }

    public void printNode(){
        System.out.println(this.val);
        if (this.next != null) {
            this.next.printNode();
        }
    }
}
