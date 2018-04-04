/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     public int val;
 *     public ListNode next;
 *     public ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode root;
    int count;
    Random rand = new Random();
    
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        root = head;
        while(head != null){
            count ++;
            head = head.next;
        }
    }
    
    /** Returns a random node's value. */
    public int GetRandom() {
        int index = rand.Next(count);
        ListNode head = root;
        for(int i=0;i<index;i++) head = head.next;
        return head.val;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.GetRandom();
 */
