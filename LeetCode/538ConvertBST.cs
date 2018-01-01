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
    private int sum = 0;
    public TreeNode ConvertBST(TreeNode root) {
        if (root != null) {
            ConvertBST(root.right);
            sum += root.val;
            root.val = sum;
            ConvertBST(root.left);
        }
        return root;
    }
}
