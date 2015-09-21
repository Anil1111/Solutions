import java.util.LinkedList;

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
public class InvertBinaryTree {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        while(list.size() > 0){
            LinkedList<TreeNode> newlist = new LinkedList<TreeNode>();
            while(list.size() > 0){
                TreeNode node = list.pop();
                if (node != null){
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;

                    newlist.add(node.left);
                    newlist.add(node.right);
                }
            }
            list = newlist;
        }
    }
}
