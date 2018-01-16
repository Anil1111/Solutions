/**
 * Definition for binary tree
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<int> stack = new Stack<int>();

    public BSTIterator(TreeNode root) {
        pushItem(root);
    }

    /** @return whether we have a next smallest number */
    public bool HasNext() {
        return stack.Count > 0;
    }

    /** @return the next smallest number */
    public int Next() {
        return stack.Pop();
    }
    
    private void pushItem(TreeNode node){
        if(node != null){
            pushItem(node.right);
            stack.Push(node.val);
            pushItem(node.left);
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.HasNext()) v[f()] = i.Next();
 */
