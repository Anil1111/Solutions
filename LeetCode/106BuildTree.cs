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
    public TreeNode BuildTree(int[] inorder, int[] postorder) {
        if (inorder.Length == 0 || postorder.Length == 0) return null;
        int ip = inorder.Length - 1;
        int pp = postorder.Length - 1;

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode prev = null;
        TreeNode root = new TreeNode(postorder[pp]);
        stack.Push(root);
        pp--;

        while (pp >= 0) {
            while (stack.Count > 0 && stack.Peek().val == inorder[ip]) {
                prev = stack.Pop();
                ip--;
            }
            TreeNode newNode = new TreeNode(postorder[pp]);
            if (prev != null) {
                prev.left = newNode;
            } else if (stack.Count > 0) {
                TreeNode currTop = stack.Peek();
                currTop.right = newNode;
            }
            stack.Push(newNode);
            prev = null;
            pp--;
        }

        return root;           
    }
}
