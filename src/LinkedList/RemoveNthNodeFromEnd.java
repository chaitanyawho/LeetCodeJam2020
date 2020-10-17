/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ret = head;
        ListNode ref = head;
        int i;
        for (i=0;i<n;i++)
        {  head = ref;
            ref = ref.next;
        }
        if (ref == null)
        {
            //System.out.println ("here");
            head.next = null;
            return ret;
        }
        head = ret;
        while (ref.next!=null)
        {
            ref = ref.next;
            head = head.next;
            
        }
        head.next = head.next.next;
        return ret;
    }
}