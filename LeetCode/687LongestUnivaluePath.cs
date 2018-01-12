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
    public int LongestUnivaluePath(TreeNode root) {
        int max = 0;
        if (root == null) return 0;
        
        int left = 0;
        if (root.left != null && root.left.val == root.val) left = Depth(root.left);
        int right = 0;
        if (root.right != null && root.right.val == root.val) right = Depth(root.right);
        
        if (left+right>max) max = left+right;
        
        if (root.left != null) left = LongestUnivaluePath(root.left);
        if (left > max) max = left;
        
        if (root.right != null) right = LongestUnivaluePath(root.right);
        if (right > max) max = right;
        
        return max;
    }
    
    public int Depth(TreeNode root){
        int left = 1;
        if (root.left != null && root.left.val == root.val) left += Depth(root.left);
        int right = 1;
        if (root.right != null && root.right.val == root.val) right += Depth(root.right);
        return left > right ? left : right;
    }
}
