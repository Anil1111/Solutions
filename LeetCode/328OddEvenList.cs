/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode OddEvenList(ListNode head) {
        int count = 1;
        ListNode odd = new ListNode(-1), even = new ListNode(-1);
        ListNode curr = head, oddroot = odd, evenroot = even;
        while(curr != null){
            if (count %2 == 0){
                even.next = curr;
                even = even.next;
            }
            else{
                odd.next = curr;
                odd = odd.next;
            }
            count++;
            curr = curr.next;
        }
        odd.next = evenroot.next;
        even.next = null;
        
        return oddroot.next;
    }
}
