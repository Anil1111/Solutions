/**
 * Definition for binary tree
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public IList<int> RightSideView(TreeNode root) {
        IList<int> ret = new List<int>();
        List<TreeNode> list = new List<TreeNode>();
        if (root != null) list.Add(root);
        while(list.Count>0){
            List<TreeNode> newlist = new List<TreeNode>();
            TreeNode node=null;
            for(int i=0;i<list.Count;i++){
                node = list[i];
                if (node.left!=null) newlist.Add(node.left);
                if (node.right!=null) newlist.Add(node.right);
            }
            ret.Add(node.val);
            list = newlist;
        }
        
        return ret;
    }
}
