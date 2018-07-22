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
    List<int> ret;
    public bool LeafSimilar(TreeNode root1, TreeNode root2) {
        ret = new List<int>();
        Visit(root1);
        string s1 = string.Join(",",ret);
        ret = new List<int>();
        Visit(root2);
        string s2 = string.Join(",",ret);      
        return s1==s2;
    }
    
    public void Visit(TreeNode root){
        if (root.left != null) Visit(root.left);
        if (root.right != null) Visit(root.right);
        if (root.left == null && root.right == null) ret.Add(root.val);
    }
}
