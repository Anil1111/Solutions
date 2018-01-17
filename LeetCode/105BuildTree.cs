/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode BuildTree(int[] preorder, int[] inorder) {
        if (preorder.Length == 0) return null;
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode cur = root;
        int j = 0;
        for (int i = 1; i < preorder.Length; i++) {
            if (cur.val != inorder[j]) {
                cur.left = new TreeNode(preorder[i]);
                s.Push(cur);
                cur = cur.left;
            } else {
                j++;
                while (s.Count > 0 && s.Peek().val == inorder[j]) {
                    cur = s.Pop();
                    j++;
                }
                cur.right = new TreeNode(preorder[i]);
                cur = cur.right;
            }
        }
        return root;        
    }
}
