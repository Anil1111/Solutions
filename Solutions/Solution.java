import java.util.*;


public class Solution {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
	}
	
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public class TreeLinkNode {
    	      int val;
    	      TreeLinkNode left, right, next;
    	      TreeLinkNode(int x) { val = x; }
    }
	 
	public static void main(String[] args) {
		//Test_longestValidParentheses();
		//Test_wordBreak();
		//Test_atoi();
		Solution solution = new Solution();
		//solution.Test_sortList1();
		//solution.Test_removeDuplicates();
		//solution.Test_sortList();
		//solution.Test_isValidSudoku();
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

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {  	
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	if (root == null) return ret;
    	
    	ArrayList<TreeNode> list = new ArrayList<TreeNode>();
    	list.add(root);
    	while(list.size() > 0){
    		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
    		ArrayList<Integer> level = new ArrayList<Integer>();

    		for(TreeNode node : list){
    			level.add(node.val);
    			if (node.left != null) next.add(node.left);
    			if (node.right != null) next.add(node.right);
    		}
    		
    		list = next;
    		ret.add(level);
    	}
    	
    	return ret;
    }
    
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
    	ArrayList<Integer> ret = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node = root, lastpeek = null;
    	while(node != null || stack.size()>0){
    		if (node != null){
    			stack.push(node);
    			node = node.left;
    		}
    		else{
    			TreeNode peek = stack.peek();
    			if (peek.right != null && lastpeek != peek.right){
    				node = peek.right;
    			}
    			else{
    				stack.pop();
    				ret.add(peek.val);
    				lastpeek = peek;
    			}
    		}
    	}
    	
    	return ret;
    }
    
    public static void Test_atoi(){
    	Solution instance = new Solution();
    	String str = "2147483648";
    	System.out.printf("%s %d\r\n", str, instance.atoi(str));
    	str = "+1";
    	System.out.printf("%s %d\r\n", str, instance.atoi(str));
    	str = " 10522545459";
    	System.out.printf("%s %d\r\n", str, instance.atoi(str));
    }

    public int atoi(String str) {
        int ret = 0; 
        int sign = 1;
        str = str.trim();
        
        if (str.length()>0){
        	char c = str.charAt(0);
        	if (c == '-') sign = -1;
        	else if (c == '+') sign = +1;
        	else if (c >= '0' && c <= '9'){
        		ret = (int)(c - '0');
        	}
        	else return ret;
        	
        	for (int i=1;i<str.length();i++){
        		c = str.charAt(i);
        		if (c >= '0' && c <= '9'){
        			int last = ret;
        			int val = c - '0';
        			if (last > (Integer.MAX_VALUE - val)/ 10){
        				if (sign == 1) ret = Integer.MAX_VALUE;
        				else ret = Integer.MIN_VALUE;
        				return ret;
        			}
        			else ret = ret * 10 + val;
        		}
        		else break;
        	}
        }
        
        ret *= sign;
        
        return ret;
    }
    
   
    void Test_sortList1(){
    	ListNode node = new Solution.ListNode(3);
    	ListNode head = node;
    	for(int i : new int[]{4,1}){
    		ListNode next = new ListNode(i);
    		node.next = next;
    		node = next;
    	}
    	node = sortList(head);    	
    	while(node != null){
    		System.out.printf("%d ", node.val);
    		node = node.next;
    	}
    	System.out.println();
    	node = new Solution.ListNode(4);
    	head = node;
    	for(int i : new int[]{2,1,3}){
    		ListNode next = new ListNode(i);
    		node.next = next;
    		node = next;
    	}
    	node = sortList(head);    	
    	while(node != null){
    		System.out.printf("%d ", node.val);
    		node = node.next;
    	}
    	System.out.println();
    }
      
    public ListNode sortList1(ListNode head){ 
    	ListNode ret = head;
    	ListNode next = null;
    	if (head != null){ 
    		next = head.next;
    		head.next = null;
    	}
    	while(next != null){
    		System.out.printf("next %d\r\n", next.val);
    		ListNode node = ret, previous = null;
    		while(node != null && node.val < next.val){
    			previous = node;
    			node = node.next;
    		}
    		if (previous != null) {
    			//System.out.printf("previous %d\r\n", previous.val);

    			ListNode temp = next.next;
    			next.next = previous.next;
    			previous.next = next;
    			
    			next = temp;
    		}
    		else{
    			//System.out.printf("first %d\r\n", ret.val);
    			
    			//insert as first
    			ListNode temp = next.next;
    			
    			ret = next;
    			next.next = node;
    			
    			next = temp;
    		}
    	}
    	return ret;
    }
               
    public int removeDuplicates1(int[] A) {
        int offset = 0;
        
        for(int i=1;i<A.length;i++){
        	if (A[i] == A[i-1]){
        		offset ++;
        	}
        	if (offset > 0){
        		A[i-offset] = A[i];
        	}
        }
        
        return A.length - offset;
    }
    
    public void Test_removeDuplicates(){
    	int[] A = new int[]{1,1,2,2};
    	int len = removeDuplicates(A);
    	for(int i=0;i<len;i++){
    		System.out.printf("%d ", A[i]);
    	}
    	System.out.println();
    	A = new int[]{1,1,1,1,3,3};
    	len = removeDuplicates(A);
    	for(int i=0;i<len;i++){
    		System.out.printf("%d ", A[i]);
    	}
    	System.out.println();
    }
    
    /**
     * allow up to 2 duplicates
     * @param A
     * @return
     */
    public int removeDuplicates(int[] A) {
        int offset = 0, state = 0;
        
        for(int i=1;i<A.length;i++){
        	if (A[i] == A[i-1]){
        		state ++;
        		if (state > 1){
        			offset ++;
        		}
        	}
        	else{ 
        		state = 0;
        	}
        	
    		if (offset > 0){
        		A[i-offset] = A[i];
    		}
        }
        
        return A.length - offset;
    }
    
    public void Test_sortList(){
    	ListNode node = new Solution.ListNode(3);
    	ListNode head = node;
    	for(int i : new int[]{2,1}){
    		ListNode next = new ListNode(i);
    		node.next = next;
    		node = next;
    	}
    	node = sortList(head);    	
    	while(node != null){
    		System.out.printf("%d ", node.val);
    		node = node.next;
    	}
    	System.out.println();
    	node = new Solution.ListNode(4);
    	head = node;
    	for(int i : new int[]{2,3,1}){
    		ListNode next = new ListNode(i);
    		node.next = next;
    		node = next;
    	}
    	node = sortList(head);    	
    	while(node != null){
    		System.out.printf("%d ", node.val);
    		node = node.next;
    	}
    	System.out.println();
    }
    
    ListNode mergeSortedList(ListNode list1, ListNode list2){
    	ListNode ret = null, previous = null;
    	
    	if (list1 == null) ret = list2;
    	else if (list2 == null) ret = list1;
    	else if (list1.val < list2.val){
    		ret = list1;
    		previous = ret;
    		list1 = list1.next;
    	}
    	else{
    		ret = list2;
    		previous = ret;
    		list2 = list2.next;
    	}
    	
    	while(list1 != null && list2 != null){
    		if (list1.val < list2.val){
    			previous.next = list1;
    			
    			previous = list1;
    			list1 = list1.next;
    		}
    		else{
    			previous.next = list2;
    			
    			previous = list2;
    			list2 = list2.next;
    		}
    	}
    	
    	if (list1 != null) previous.next = list1;
    	else if (list2 != null) previous.next = list2;
    	
    	return ret;
    }
    
    //TODO: merge sort
    public ListNode sortList(ListNode head){
    	if (head == null || head.next == null) return head;
    	
    	ListNode ret = head;
    	int length = 0;
    	//find length
    	while(ret != null){
    		length ++;
    		ret = ret.next;
    	}
    	//System.out.printf("length %d \r\n", length);
    	//find middle node
    	ListNode middle = head, previous = null;
    	for(int i=0;i<length/2;i++){
    		previous = middle;
    		middle = middle.next;
    	}
    	//System.out.printf("middle %d \r\n", middle.val);
    	//break list
    	if (previous != null){ 
    		previous.next = null;
    		//System.out.printf("previous %d \r\n", previous.val);
    	}
    	
    	ListNode list1 = sortList(head);
    	ListNode list2 = sortList(middle);
    	
    	//merge sorted lists    	
    	return mergeSortedList(list1, list2);
    }
    
    public void Test_isValidSudoku(){
    	String[] lines = new String[]{".........",
    								  "4........",
    								  "......6..",
    								  "...38....",
    								  ".5...6..1",
    								  "8......6.",
    								  ".........",
    								  "..7.9....",
    								  "...6....."};
    	char[][] board = new char[9][9];
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			board[i][j] = lines[i].charAt(j);
    		}
    	}
    	System.out.printf("%b true\r\n", isValidSudoku(board));
    	
    	lines = new String[]{"..4...63.",
    						 ".........",
    						 "5......9.",
    						 "...56....",
    						 "4.3.....1",
    						 "...7.....",
    						 "...5.....",
    						 ".........",
    						 "........."};
    	for(int i=0;i<9;i++){
    		for(int j=0;j<9;j++){
    			board[i][j] = lines[i].charAt(j);
    		}
    	}
    	System.out.printf("%b false\r\n", isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
    	boolean[][] horizontal = new boolean[9][9];
    	boolean[][] vertical = new boolean[9][9];
    	boolean[][] squares = new boolean[9][9];
        for (int i=0;i<9;i++){
        	for (int j=0;j<9;j++){        		
        		char ch = board[i][j];
        		if (ch != '.'){
        			if (horizontal[i][ch-'1']) {
        				//System.out.printf("H %d %d\r\n", i, ch-'1');
        				return false;        			
        			}
        			else horizontal[i][ch-'1'] = true;
        		}
        		ch = board[j][i];
        		if (ch != '.'){
        			if (vertical[i][ch-'1']){
        				//System.out.printf("V %d %d\r\n", j, ch-'1');
        				return false;
        			}
        			else vertical[i][ch-'1'] = true;
        		}
        		
        		if (i%3==0&&j%3==0){
	        		for(int k=0;k<3;k++){
	        			for(int l=0;l<3;l++){
	        				ch = board[i+k][j+l];
                			//System.out.printf("%d %d %c\r\n", i+k, j+l, ch);
	                		if (ch != '.'){
		        				//System.out.printf("S %d %d %d %d\r\n", i/3+j, i+k, j+l, ch-'1');
	                			if (squares[i/3+j][ch-'1']){ 
	                				//System.out.printf("S %d %d\r\n", i/3+j, ch-'1');
	                				return false;	                			
	                			}
	                			else squares[i/3+j][ch-'1'] = true;
	                		}
	        			}
	        		}
        		}
        	}
        }       
       
        return true;
    }
    
    public int searchInsert(int[] A, int target) {
        for (int i=0;i<A.length;i++){
        	if (target<=A[i]) return i;
        }
        
        return A.length;
    }
}


