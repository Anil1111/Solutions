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
    public int FindSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        
        int min = root.val;
        int ret = int.MaxValue;
        var list = new List<TreeNode>();
        list.Add(root);
        while(list.Count > 0){
            var newlist = new List<TreeNode>();
            foreach(var node in list){
                if(node.left != null){
                    if (node.left.val > min && node.left.val < ret) {
                        ret = node.left.val;
                    } 
                    if (node.right.val > min && node.right.val < ret) {
                        ret = node.right.val;
                    }
                    newlist.Add(node.left);
                    newlist.Add(node.right);
                }
            }
            list = newlist;
        }
        
        return ret == int.MaxValue ? -1 : ret;
    }
}
