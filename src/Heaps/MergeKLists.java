package Heaps;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class MergeKLists {


    public ListNode mergeKLists(ListNode[] lists) {
        Comparator<ListNode> cmp = new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        };
        Queue<ListNode> heap = new PriorityQueue<>(cmp);
        for(ListNode l : lists)
            if(l!=null) heap.offer(l);

        ListNode ptr = new ListNode(0);
        ListNode head = ptr;
        while(!heap.isEmpty()) {
            ptr.next = heap.poll();
            ptr = ptr.next;
            if(ptr.next!=null) heap.add(ptr.next);
        }
        return ptr.next;


    }
}
