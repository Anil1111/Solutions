/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public bool IsPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        int i=0;
        while(fast != null){
            fast = fast.next;
            if (fast != null) fast = fast.next;
            slow = slow.next;
        }
        
        ListNode rev = reverse(slow);
        
        while(rev != null){
            if (head.val != rev.val) return false;
            rev = rev.next;
            head = head.next;
        }
        
        return true;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

