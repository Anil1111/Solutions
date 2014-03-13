public class Solution {
    public boolean isPalindrome(String s) {
        char[] list = new char[s.length()];
        int size = 0;
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if ((c>='a' && c<='z') || (c>='0' && c<='9')){
                list[size] = c;
                size ++;
            }
        }
        
        if(size == 0) return true;

        int i=0, j=size-1;
        while(i<j){
            if (list[i] != list[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    public int singleNumber(int[] A) {
        if (A.length==0) return 0;
        for(int i=1;i<A.length;i++){
            A[0] ^= A[i];
        }
        return A[0];
    }
    
    /**
     * Definition for binary tree
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p != null && q != null) 
        {
            if (p.val != q.val) return false;
            else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else return false;
    }
    
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, int min, int max){
        if (node == null) return true;
        else if (node.left!=null && (node.left.val >= node.val || node.left.val <= min)) return false;
        else if (node.right !=null && (node.right.val <= node.val || node.right.val >= max)) return false;
        else{
            return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
        }
    }
    
    public String reverseWords(String s) {
        String[] list = s.split(" ");
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=list.length-1;i>=0;i--){
            if (list[i].trim().length() ==0)continue;
            sb.append(list[i]);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
