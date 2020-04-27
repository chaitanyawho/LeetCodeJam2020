package LinkedList;

public class ReverseList {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public ListNode reverseList(ListNode head) {
        ListNode trail = null;
        ListNode curr = head;
        while(curr!=null){
            ListNode nextNode = curr.next;
            curr.next = trail;
            trail = curr;
            curr = nextNode;
        }
        head = trail;
        return head;

    }
}
