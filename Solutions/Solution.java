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
    
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        else {
        	int left = 0;
        	if (root.left != null) left = maxDepth(root.left);
        	int right = 0;
        	if (root.right != null) right = maxDepth(root.right);
        	return left > right ? left + 1 : right + 1;
        }
    }
    
    public int reverse(int x) {
        //overflow? ending with 0?
    	int ret = 0;
    	while(x != 0){
    		int digit = x % 10;
    		x = x / 10;
    		ret = ret * 10 + digit;
    	}
    	
    	return ret;
    }
    
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> list = new Stack<TreeNode>();
        
        if (root != null) list.add(root);
        while(list.size()>0){
        	TreeNode node = list.pop();
        	ret.add(node.val);
        	
        	if (node.right != null) list.push(node.right);
        	if (node.left != null) list.push(node.left);
        }
        
        return ret;
    }    

    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> list = new Stack<TreeNode>();
        
        TreeNode node = root;
        while(node != null || list.size()>0){
        	if (node != null) {
        		list.push(node);
        		node = node.left;
        	}
        	else{
        		node = list.pop();
        		ret.add(node.val);
        		node = node.right;
        	}
        }
        
        return ret;
    }    
    
    public ArrayList<String> generateParenthesis(int n) {
        HashSet<String> ret = new HashSet<String>();
    	
    	if (n == 1) ret.add("()");
    	else{
    		ArrayList<String> sublist = generateParenthesis(n - 1);
    		for(String sub : sublist){
    			ret.add("("+sub+")");
    			ret.add("()"+sub);
    			ret.add(sub+"()");
    		}
    		for (int i=2;i<=n/2;i++){
    			sublist = generateParenthesis(n - i);
    			ArrayList<String> restlist = generateParenthesis(i);
    			for(String sub : sublist){
    				for(String rest : restlist){
    					ret.add(sub+rest);
    					ret.add(rest+sub);
    				}
    			}
    		}
    	}
    	
    	return new ArrayList<String>(ret);
    }    

    public static void Test_longestValidParentheses(){
		Solution instance = new Solution();
		String[] testcases = new String[] {"()())", "", ")(", "()", "(()", "())", "(", ")", "()()", "())()", "()(()","(((())))((()))", "))))((((",
				"((()))())", "(()(((()", "(()(((("};
		int[] answers = new int[]{4, 0, 0, 2, 2, 2, 0, 0, 4, 2, 2, 14, 0, 8, 2, 2};
		for (int i=0;i<testcases.length;i++){
			int answer = instance.longestValidParentheses(testcases[i]);
			if (answers[i] != answer) System.out.printf("%s -> %d WRONG %d\r\n", testcases[i], answers[i], answer);
			else System.out.printf("%s -> %d \r\n", testcases[i], answer);
		}
    }

    public int longestValidParentheses(String s) {
   	int balance = 0, len = 0, maxlen = 0;
    	
    	for(int i=0;i<s.length();i++){
    		if (s.charAt(i) == '(') balance ++;
    		else balance --;

    		len ++;
    		if (balance < 0){
    			len = 0;
    			balance = 0;
    		}
    		else if (balance == 0){
    			maxlen = len > maxlen ? len : maxlen;
    		}

    	}
    	
    	int leftmax = maxlen;
    	
    	balance = 0;
    	len = 0; 
    	maxlen = 0;
    	
    	for(int i=s.length()-1;i>=0;i--){
    		if (s.charAt(i) == ')') balance ++;
    		else balance --;
    		
			len ++;
    		if (balance < 0){
    			len = 0;
    			balance = 0;
    		}
    		else if (balance == 0){  			
    			maxlen = len > maxlen ? len : maxlen;
    		}

    	}
  	
    	return maxlen > leftmax ? maxlen : leftmax;
    }
    
    public static void Test_wordBreak(){
    	Solution instance = new Solution();
    	String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
    	HashSet<String> dict  = new HashSet<String>();
    	for (String word : new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})
    	{
    		dict.add(word);
    	}
    	System.out.printf("%s %b\r\n", input, instance.wordBreak(input, dict));
    }
    
    /**
     * recursive, too slow
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak1(String s, Set<String> dict) {
		for(String word : dict){
	    	System.out.printf("%s %s\r\n", s, word);
			if (s.startsWith(word)){
				String temp = s.substring(word.length());
				if (wordBreak(temp, dict)) return true;
			}
		}

		return false;
    }
    
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || dict == null) return false;
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++)
            for(int k = 0; k < i; k++)
                if(dp[k] && dict.contains(s.substring(k, i))) dp[i] = true;
        return dp[s.length()];
    }    
    
}
