/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: Inorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        
        if (root == null) return ret;
        
        TreeNode node = root;
        while(!nodes.isEmpty() || node != null){
            if (node != null){
                nodes.push(node);
                node = node.left;
            }
            else{
                TreeNode temp = nodes.pop();
                ret.add(temp.val);
                node = temp.right;
            }
        }
        return ret;
    }
}
