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
    public IList<IList<int>> ZigzagLevelOrder(TreeNode root) {
        var ret = new List<IList<int>>();
        if (root == null) return ret;
        
        var list = new List<TreeNode>();
        list.Add(root);
        bool desc = false;
        while(list.Count > 0){
            var newlist = new List<TreeNode>();
            var sublist = new List<int>();
            foreach(var node in list){
                sublist.Add(node.val);
                if (node.left != null) newlist.Add(node.left);
                if (node.right != null) newlist.Add(node.right);
            }
            if (desc){
                sublist.Reverse();
            }
            desc = !desc;
            
            ret.Add(sublist);
            list = newlist;
        }        
        return ret;
    }
}
