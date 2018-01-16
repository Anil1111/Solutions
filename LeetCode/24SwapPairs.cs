/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode SwapPairs(ListNode head) {
        ListNode ret = head;
        if (head == null) return head;
        if (head.next != null) ret = head.next;
        ListNode node = head, prev = null;
        while(node != null){
            ListNode next = node.next;
            if (next !=null){
                if (prev != null) prev.next = next;
                node.next = next.next;
                next.next = node;
                prev = node;
                node = node.next;
            }
            else break;
        }
        return ret;
    }
}
