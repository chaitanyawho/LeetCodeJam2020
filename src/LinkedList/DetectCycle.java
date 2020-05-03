package LinkedList;

import java.util.HashMap;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
}
public class DetectCycle {
    public boolean hasCycle(ListNode head){
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode ptr = head;
        int i = 0;
        while(!map.containsKey(ptr) && ptr!=null){
            map.put(ptr, i++);
            ptr = ptr.next;
        }
        if(ptr==null) return false;
        return true;
    }
    public boolean hasCycleSPACEO1(ListNode head){
        //we use two pointers, one fast(2x) and one slow, if they meet return true
        if(head==null || head.next ==null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(slow!=fast){
            if(fast == null || fast.next == null) return false; //if either reach null there is no cycle
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;

    }

    public static void main(String[] args) {
        ListNode t = new ListNode(1);
        ListNode t2 = new ListNode(2);
        t.next = t2;
        ListNode t3 = new ListNode(3);
        t2.next = t3;
        t3. next = t2;
        DetectCycle dt = new DetectCycle();
        System.out.println(dt.hasCycle(t));

    }

}
