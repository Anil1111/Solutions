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
    public IList<TreeNode> GenerateTrees(int n) {
        return GenerateSubTrees(1, n);
    }

    public IList<TreeNode> GenerateSubTrees(int start, int end){
        IList<TreeNode> ret = new List<TreeNode>();
        if (start>end){
            ret.Add(null);
            return ret;
        }
        if (start==end){
            TreeNode node = new TreeNode(start);
            ret.Add(node);
            return ret;
        }
        for(int i=start;i<=end;i++){
            IList<TreeNode> leftList = GenerateSubTrees(start, i-1),
            rightList = GenerateSubTrees(i+1, end);
            foreach(TreeNode leftNode in leftList){
                foreach(TreeNode rightNode in rightList){
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    node.right = rightNode;
                    ret.Add(node);
                }
            }
        }
        
        return ret;
    }
}
