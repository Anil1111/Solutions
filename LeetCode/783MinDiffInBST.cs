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
    public int MinDiffInBST(TreeNode root) {
        var list = new List<TreeNode>();
        list.Add(root);
        int min = int.MaxValue;
        var vals = new List<int>();
        while(list.Count > 0){
            var node = list.First();
            list.RemoveAt(0);
            vals.Add(node.val);
            if (node.left != null) list.Add(node.left);
            if (node.right != null) list.Add(node.right);
        }
        vals = vals.OrderBy(v => v).ToList();
        for(int i=1;i<vals.Count;i++){
            var diff = vals[i] - vals[i-1];
            if (diff < min) min = diff;
        }
        return min;
    }
}
