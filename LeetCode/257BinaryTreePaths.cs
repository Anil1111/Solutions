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
    public IList<string> BinaryTreePaths(TreeNode root) {
        var list = new List<string>();
        if (root == null) return list;
        list.Add(root.val.ToString());
        return TreePaths(root, list);
    }
    
    private List<string> TreePaths(TreeNode node, List<string> list){
        if (node.left == null && node.right == null){
            return list;
        }
             
        List<string> list1 = null;
        if (node.left != null){
            list1 = TreePaths(node.left, list.Select(s => s+"->"+node.left.val).ToList()); 
        }
        List<string> list2 = null;
        if (node.right != null){
            list2 = TreePaths(node.right, list.Select(s => s+"->"+node.right.val).ToList()); 
        }
        
        if (list1 != null){
            list = list1;
            if (list2 != null) list.AddRange(list2);
        }
        else if (list2 != null){
            list = list2;
        }
        
        return list;
    }
}
