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
    
    public int evalRPN(String[] tokens) {
        int[] results = new int[tokens.length];
        int last = 0;
        for(int i=0;i<tokens.length;i++){
            switch(tokens[i]){
                case "+":
                    results[last-2]=results[last-2] + results[last-1];
                    last --;
                    break;
                case "-":
                    results[last-2]=results[last-2] - results[last-1];
                    last --;
                    break;
                case "*":
                    results[last-2]=results[last-2] * results[last-1];
                    last --;
                    break;
                case "/":
                    results[last-2]=results[last-2] / results[last-1];
                    last --;
                    break;
                default:
                    results[last] = Integer.parseInt(tokens[i]);
                    last++;
                    break;
            }
        }
        
        return results[last-1];
    }
    
    public boolean hasCycle(ListNode head) {
        ListNode one = head, two = head;
        while(one != null && two !=null){
            one = one.next;
            two = two.next;
            if (two != null){ 
                two = two.next;
                if (one !=null && two !=null && one == two) return true;
            }
            else return false;
        };
        
        return false;
    }
    
    //import java.util.Hashtable; 
    public int[] twoSum(int[] numbers, int target) {
        Hashtable<Integer,Integer> table = new Hashtable<Integer,Integer>();
        for(int i=0;i<numbers.length;i++){
            table.put(numbers[i], i);
        }
        for(int i=0;i<numbers.length;i++){
            Integer rest = target - numbers[i];
            if (table.containsKey(rest) && table.get(rest) != i){
                int[] ret = new int[2];
                ret[0] = i+1;
                ret[1] = table.get(rest)+1;
                return ret;
            }
        }
        return null;
    }
}
