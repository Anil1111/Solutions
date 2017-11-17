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
    public int SumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        
        return SumOfLeftLeaves(root, false);
    }
    
    public int SumOfLeftLeaves(TreeNode node, bool left){
        if (left && node.left == null && node.right == null)
            return node.val;
        
        int sum = 0;
        if (node.left != null) sum+=SumOfLeftLeaves(node.left, true);
        if (node.right != null) sum+=SumOfLeftLeaves(node.right, false);
        
        return sum;
    }
}
