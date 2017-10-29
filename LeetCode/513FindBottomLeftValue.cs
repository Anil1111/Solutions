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
    public int FindBottomLeftValue(TreeNode root) {
        var level = new List<TreeNode>();
        level.Add(root);
        while(level.Count() > 0){
            var next = new List<TreeNode>();
            foreach(var node in level){
                if (node.left != null) next.Add(node.left);
                if (node.right != null) next.Add(node.right);
            }
            if (next.Count()>0) level = next;
            else return level[0].val;
        }
        
        return 0;
    }
}
