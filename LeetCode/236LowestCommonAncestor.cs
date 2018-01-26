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
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        bool fp, fq;
        return Visit(root, p, q, out fp, out fq);
    }
    
    TreeNode Visit(TreeNode root, TreeNode p, TreeNode q, out bool fp, out bool fq) {
        fp = false;
        fq = false;

        bool sfp, sfq;
        if (root.left != null) {
            var node = Visit(root.left, p, q, out sfp, out sfq);
            if (node != null) return node;
            if (sfp) fp = true;
            if (sfq) fq = true;
        }
        
        if (root.right != null) {
            var node = Visit(root.right, p, q, out sfp, out sfq);
            if (node != null) return node;
            if (sfp) fp = true;
            if (sfq) fq = true;
        }

        if (root == p) fp = true;
        if (root == q) fq = true;
        
        return fp && fq ? root : null;
    }
}
