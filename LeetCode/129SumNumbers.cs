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
    public int SumNumbers(TreeNode root) {
        if (root==null) return 0;
        List<List<int>> results = Sums(root);
        int total = 0;
        foreach(List<int> result in results){
            int sum=0, factor = 1;
            foreach(int r in result){
                sum+=factor*r;
                factor*=10;
            }
            total += sum;
        }
        return total;
    }
    
    public List<List<int>> Sums(TreeNode root){
        List<List<int>> ret = new List<List<int>>();
        if (root.left == null && root.right == null){
            List<int> current = new List<int>();
            current.Add(root.val);
            ret.Add(current);
            return ret;
        }
        if (root.left != null){
            List<List<int>> left = Sums(root.left);
            foreach(List<int> l in left){
                l.Add(root.val);
                ret.Add(l);
            }
        }
        if (root.right != null){
            List<List<int>> right = Sums(root.right);
            foreach(List<int> r in right){
                r.Add(root.val);
                ret.Add(r);
            }
        }
        return ret;
    }
}
