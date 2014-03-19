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
		//solution.Test_threeSum();
		//solution.Test_addBinary();
		//solution.Test_fourSum();
		//solution.Test_pow();
		solution.Test_isValid();
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
    	    	
    	if (previous != null){
        	if (list1 != null) previous.next = list1;
        	else if (list2 != null) previous.next = list2;
    	}    	
    	
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
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int sum = (l1.val + l2.val) % 10, carry = (l1.val + l2.val) / 10;
    	ListNode ret = new ListNode(sum), node = ret;
    	while(l1 != null || l2 != null){
    		sum = carry;
    		if (l1 != null){
    			l1 = l1.next;
    			if (l1 != null) sum += l1.val;
    		}
    		if (l2 != null){
    			l2 = l2.next;
    			if (l2 != null) sum += l2.val;
    		}
    		
    		if (l1 != null || l2 != null){
	    		carry = sum / 10;
	    		sum = sum % 10;
	    		ListNode newnode = new ListNode(sum);
	    		node.next = newnode;
	    		node = newnode;
    		}
    	}
    	
    	if (carry > 0){
    		ListNode newnode = new ListNode(carry);
    		node.next = newnode;
    		node = newnode;
    	}
    	node.next = null;
    	
    	return ret;
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
	     int ret = -1, remaining = 0, min = Integer.MAX_VALUE;
	     for (int i=0;i<gas.length;i++){
	    	 remaining += gas[i] - cost[i];
	    	 if (remaining < min){
	    		 min = remaining;
	    		 ret = i;
	    	 }
	     }
	     
	     if (remaining < 0) return -1;
	     
	     ret = (ret+1)%gas.length;	     
	     
	     return ret;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    	
    	if (previous != null){
        	if (list1 != null) previous.next = list1;
        	else if (list2 != null) previous.next = list2;
    	}
    	
    	return ret;        
    }

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode node, previous=head;
    	while(previous != null){
    		node = previous.next;
    		if (node != null && node.val == previous.val){
    			previous.next = node.next;
    		}
    		else{
    			previous = previous.next;
    		}
    	}
    	
    	return head;        
    }       

    public ListNode insertionSortList(ListNode head){ 
    	ListNode ret = head;
    	ListNode next = null;
    	if (head != null){ 
    		next = head.next;
    		head.next = null;
    	}
    	while(next != null){
    		ListNode node = ret, previous = null;
    		while(node != null && node.val < next.val){
    			previous = node;
    			node = node.next;
    		}
    		if (previous != null) {
    			ListNode temp = next.next;
    			next.next = previous.next;
    			previous.next = next;
    			
    			next = temp;
    		}
    		else{
    			//insert as first
    			ListNode temp = next.next;
    			
    			ret = next;
    			next.next = node;
    			
    			next = temp;
    		}
    	}
    	return ret;
    }
    
    public void merge(int A[], int m, int B[], int n) {
        int indexa = m, indexb = n;
        while(indexa > 0 && indexb > 0){
        	if (A[indexa-1] < B[indexb-1]) {
        		A[indexa+indexb-1] = B[indexb-1];
        		indexb--;
        	}
        	else{
        		A[indexa+indexb-1] = A[indexa-1];
        		indexa--;
        	}        	
        }
        
        while(indexa>0){
        	A[indexa+indexb-1] = A[indexa-1];
    		indexa--;
        }
        
        while(indexb>0){
    		A[indexa+indexb-1] = B[indexb-1];
    		indexb--;
        }
    }
    
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) return "";        	
    	int length = 0;
        
        while(strs[0].length() > length){
        	char ch = strs[0].charAt(length);
	        for(int i=1;i<strs.length;i++){
	        	if (length >= strs[i].length() || strs[i].charAt(length) != ch)
	        	{
	        		return strs[0].substring(0, length);
	        	}	        	
	        }
	        length ++;
        }
        return strs[0].substring(0, length);
    }    
    
    public void Test_threeSum(){
    	int[] num = new int[]{-1, 0, 1};
    	ArrayList<ArrayList<Integer>> ret = threeSum(num);
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    }

    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {    	
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();   	
    	if (num == null || num.length == 0) return ret;
    	
        Arrays.sort(num);
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<num.length;i++){
        	if (map.containsKey(num[i])) map.put(num[i], map.get(num[i]) + 1);
        	else map.put(num[i], 1);
        }
        
        HashMap<Integer, HashSet<Integer>> firstmap = new HashMap<Integer, HashSet<Integer>>();
        for(int i=0;i<num.length;i++){
        	if (firstmap.containsKey(num[i])) continue;
        	int first = num[i];
        	//System.out.printf("first %d \r\n", first);
        	firstmap.put(first, new HashSet<Integer>());
        	
    		for (int j=0;j<num.length;j++){
    			if (num[j] == first){
    				int count = map.get(num[j]);
    				if (count < 2) continue;//we already used this one as first
    			}
    			
    			//System.out.printf("first %d second %d\r\n", first, num[i]);
    			
    			int target = - num[j] - first;
    			if (map.containsKey(target)){
    				int count = map.get(target);
    				if (first == target) count --;
    				if (num[j] == target) count--;
    				if (count < 1) continue;
    				
    				//we found an answer
    				int[] results = new int[3];
    				results[0] = first;
    				results[1] = num[j];
    				results[2] = target;
    				Arrays.sort(results);
    				
    				if (firstmap.containsKey(results[0])){
    					HashSet<Integer> set = firstmap.get(results[0]);
    					if (!set.contains(results[1])){
    						ArrayList<Integer> list = new ArrayList<Integer>();
    						for(int result : results) list.add(result);
    						ret.add(list);
    						
    						set.add(results[1]);
    					}
    				}
    			}
    		}
        }
        
        return ret;
    }
    
    public void Test_addBinary(){
    	System.out.printf("%s \r\n", addBinary("1", "1"));
    }
    
    public String addBinary(String a, String b) {
    	StringBuilder builder = new StringBuilder();
    	
    	int offset = 1, sum = 0, carry = 0;
    	while(a.length() >= offset && b.length() >= offset){
    		int va = a.charAt(a.length() - offset) - '0';
    		int vb = b.charAt(b.length() - offset) - '0';
    		
    		sum = (va + vb + carry) % 2;
    		carry = (va + vb + carry) / 2; 
    		builder.insert(0,  sum);
    		
    		//System.out.printf("ab %d %d %d %s \r\n", offset, sum, carry, builder.toString());
    		offset ++;
    	}
    	while(a.length() >= offset){
    		int va = a.charAt(a.length() - offset) - '0';
    		
    		sum = (va + carry) % 2;
    		carry = (va + carry) / 2; 
    		builder.insert(0,  sum);
    		
    		//System.out.printf("a %d %s \r\n", offset, builder.toString());
    		offset ++;
    	}
    	while(b.length() >= offset){
    		int vb = b.charAt(b.length() - offset) - '0';
    		
    		sum = (vb + carry) % 2;
    		carry = (vb + carry) / 2; 
    		builder.insert(0,  sum);
    		
    		//System.out.printf("b %d %s \r\n", offset, builder.toString());
    		offset ++;
    	}
    	if (carry > 0) builder.insert(0, carry);
    	
    	return builder.toString();
    }
       
    /*
    public void Test_fourSum(){
    	int[] num = new int[]{0,0,0,0};
    	ArrayList<ArrayList<Integer>> ret = fourSum(num,0);
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    	num = new int[]{2,1,0,-1};
    	ret = fourSum(num,2);
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    	num = new int[]{-497,-473,-465,-462,-450,-445,-411,-398,-398,-392,-382,-376,-361,-359,-353,-347,-329,-328,-317,-307,-273,-230,-228,-227,-217,-199,-190,-175,-155,-151,-122,-102,-97,-96,-95,-87,-85,-84,-73,-71,-51,-50,-39,-24,-19,-1,-1,7,22,25,27,37,40,43,45,51,72,91,97,108,119,121,122,123,127,156,166,171,175,180,203,211,217,218,224,231,245,293,297,299,300,318,326,336,353,358,376,391,405,423,445,451,459,464,471,486,487,488};
    	ret = fourSum(num,2251);
    	System.out.println("2251");
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    	num = new int[]{1, 0, -1, 0, -2, 2};
    	ret = fourSum(num,0);
    	System.out.println("0");
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    	System.out.println("END");
    }    
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num, int goal, HashMap<Integer, Integer> map) {    	
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();   	
    	if (num == null || num.length == 0) return ret;
    	       
        HashMap<Integer, HashSet<Integer>> firstmap = new HashMap<Integer, HashSet<Integer>>();
        for(int i=0;i<num.length;i++){
        	if (firstmap.containsKey(num[i])) continue;
        	int first = num[i];
        	//System.out.printf("first %d \r\n", first);
        	firstmap.put(first, new HashSet<Integer>());
        	
    		for (int j=0;j<num.length;j++){
    			if (num[j] == first){
    				int count = map.get(num[j]);
    				if (count < 2) continue;//we already used this one as first
    			}
    			
    			//System.out.printf("first %d second %d\r\n", first, num[i]);
    			
    			int target = goal - num[j] - first;
    			if (map.containsKey(target)){
    				int count = map.get(target);
    				if (first == target) count --;
    				if (num[j] == target) count--;
    				if (count < 1) continue;
    				
    				//we found an answer
    				int[] results = new int[3];
    				results[0] = first;
    				results[1] = num[j];
    				results[2] = target;
    				//Arrays.sort(results);
    				
    				if (firstmap.containsKey(results[0])){
    					HashSet<Integer> set = firstmap.get(results[0]);
    					if (!set.contains(results[1])){
    						ArrayList<Integer> list = new ArrayList<Integer>();
    						for(int result : results) list.add(result);
    						ret.add(list);
    						
    						set.add(results[1]);
    					}
    				}
    			}
    		}
        }
        
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	if (num.length < 4) return ret;
        HashSet<String> resultAsString = new HashSet<String>();
        HashSet<Integer> firstset = new HashSet<Integer>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> threesummap = new HashMap<Integer, ArrayList<ArrayList<Integer>>>(); 

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0;i<num.length;i++){
        	if (map.containsKey(num[i])) map.put(num[i], map.get(num[i]) + 1);
        	else map.put(num[i], 1);
        }

        for(int i=0;i<num.length;i++){
        	int first = num[i];        	
        	if (firstset.contains(first)) continue;        	
        	firstset.add(first);
        	
        	//3 sum issue        	        	
        	ArrayList<ArrayList<Integer>> results;
        	if (!threesummap.containsKey(target - first)){
        		results = threeSum(num, target - first, map);
        	}
        	else{
        		results = threesummap.get(target - first);
        	}
        	for(int j=0;j<results.size();j++){
        		//ASSERT: 3 numbers in result
        		ArrayList<Integer> result = results.get(j);
        		//TODO: remove bad results 
        		
        		result.add(first);
        		
        		Collections.sort(result);

        		String str = String.format("%d %d %d %d", result.get(0), result.get(1), result.get(2), result.get(3));
        		if (!resultAsString.contains(str)){
        			resultAsString.add(str);
        			ret.add(result);
        		}
        	}
        }
        
        return ret;
    }
    */
    
    public void Test_pow(){
    	System.out.printf("%f \r\n", pow(0.00001, 2147483647));
    	System.out.printf("%f \r\n", pow(8.88023, 3));
    	System.out.printf("%f \r\n", pow(-1.00000, -2147483648));
    }

    public double pow(double x, int n) {
        double ret = 1, val;
        int i;
        if (n < 0) {
        	i = -n;
        	val = 1/x;
        }
        else {
        	i = n;
        	val = x;
        }
        while(i > 0){
        	//System.out.printf("%d %d %f %d\r\n", i, n, val, i % 2);
        	
        	if ((i % 2) == 1){
        		ret *= val;
        	}
        	val = val * val;
        	i = i / 2;
        }  
        return ret;
    }
    
    public void Test_isValid(){
    	System.out.printf("%b \r\n", isValid("([)]"));
    	System.out.printf("%b \r\n", isValid("([])"));
    }
    
    public boolean isValid(String s) {
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0;i<s.length();i++){
    		switch(s.charAt(i)){
	    		case '(':
	    		case '[':
	    		case '{':
	    			stack.push(s.charAt(i));
	    			break;
	    		case ')':
	    			if (stack.isEmpty()) return false;
	    			char ch = stack.pop();
	    			if (ch != '(') return false;
	    			break;
	    		case ']':
	    			if (stack.isEmpty()) return false;
	    			ch = stack.pop();
	    			if (ch != '[') return false;
	    			break;
	    		case '}':
	    			if (stack.isEmpty()) return false;
	    			ch = stack.pop();
	    			if (ch != '{') return false;
	    			break;
    		}
    	}
    	if (!stack.isEmpty()) return false;
    	else return true;
    }
    
}


