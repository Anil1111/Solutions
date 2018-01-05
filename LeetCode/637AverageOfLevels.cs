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
    public IList<double> AverageOfLevels(TreeNode root) {
        var ret = new List<double>();
        var list = new List<TreeNode>();
        if (root != null) list.Add(root);
        while(list.Count()>0){
            double sum = 0;
            var newlist = new List<TreeNode>();
            foreach(var node in list){
                sum+=node.val;
                if (node.left != null) newlist.Add(node.left);
                if (node.right != null) newlist.Add(node.right);
            }
            ret.Add(sum/list.Count());
            list = newlist;
        }
        
        return ret;
    }
}
