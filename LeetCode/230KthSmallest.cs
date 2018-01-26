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
    public int KthSmallest(TreeNode root, int k) {        
        var ret = new List<int>();   
        Visit(root, ret, k);
        return ret[k-1];
    }
    
    void Visit(TreeNode root, List<int> ret, int k){
        if (ret.Count >= k) return;
        
        if (root.left != null) Visit(root.left, ret, k);
        ret.Add(root.val);
        if (root.right != null) Visit(root.right, ret, k);
    }
}
