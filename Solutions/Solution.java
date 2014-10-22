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
		Solution solution = new Solution();
		//solution.Test_longestValidParentheses();
		//solution.Test_wordBreak();
		//solution.Test_atoi();
		//solution.Test_sortList1();
		//solution.Test_removeDuplicates();
		//solution.Test_sortList();
		//solution.Test_isValidSudoku();
		//solution.Test_threeSum();
		//solution.Test_addBinary();
		//solution.Test_fourSum();
		//solution.Test_pow();
		//solution.Test_isValid();
		//solution.Test_solveSudoku();
		//solution.Test_divide();
		//solution.Test_isSymmetric();
		//solution.Test_combine();
		//solution.test_removeNthFromEnd();
		//solution.test_strStr();
		//solution.test_sortedListToBST();
		//solution.Test_divide();
		//solution.test_singleNumber();
		//solution.test_tryCombinationSum2();
		//solution.test_firstMissingPositive();
		//solution.test_nextPermutation();
		//solution.test_simplifyPath();
		//solution.test_reverseBetween();
		//solution.test_minPathSum();
		//solution.test_isNumber();
		//solution.test_longestConsecutive();
		//solution.test_lengthOfLongestSubstring();
		//solution.trest_ladderLength();
		//solution.trest_findLadders();
		//solution.test_numTrees();
		//solution.test_getRow();
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
    
    public void Test_longestValidParentheses(){
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
    
    public void Test_wordBreak(){
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
				if (wordBreak1(temp, dict)) return true;
			}
		}

		return false;
    }
    
    public boolean wordBreak2(String s, Set<String> dict) {
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
    
    public void Test_atoi(){
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
        		if (ch != '.'){
        			if (vertical[j][ch-'1']){
        				//System.out.printf("V %d %d\r\n", j, ch-'1');
        				return false;
        			}
        			else vertical[j][ch-'1'] = true;
        		}
       	        if (ch != '.'){
       	        	if (squares[j/3+3*(i/3)][ch-'1']) return false;
       	        	else squares[j/3+3*(i/3)][ch-'1'] = true;
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

    public ListNode deleteDuplicates1(ListNode head) {
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

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode node, previous=head;
    	HashSet<Integer> hasDup = new HashSet<Integer>();
    	while(previous != null){
    		node = previous.next;
    		if (node != null && node.val == previous.val){
    			previous.next = node.next;
    			hasDup.add(previous.val);
    		}
    		else{
    			previous = previous.next;
    		}
    	}

    	while(head != null && hasDup.contains(head.val)){
   			head = head.next;
    	}
    	previous = head;
    	while(previous != null){
    		node = previous.next;
    		if (node != null && hasDup.contains(node.val)){
    			previous.next = node.next;
    		}
    		else previous = previous.next;
    	}
    	
    	return head;        
    }
    
    public void Test_solveSudoku(){
    	String[] lines;
    	char[][] board = new char[9][9];
    	
    	lines = new String[]{".........",
				  "4........",
				  "......6..",
				  "...38....",
				  ".5...6..1",
				  "8......6.",
				  ".........",
				  "..7.9....",
				  "...6....."};
	
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = lines[i].charAt(j);
			}
		}
		solveSudoku(board);
		printSudoku(board);
		System.out.println("END");

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
		solveSudoku(board);
		printSudoku(board);
		System.out.println("END");
		
		lines = new String[]{"..9748...","7........",".2.1.9...","..7...24.",".64.1.59.",".98...3..","...8.3.2.","........6","...2759.."};
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = lines[i].charAt(j);
			}
		}
		solveSudoku(board);
		printSudoku(board);
		System.out.println("END");
		    	
    	lines = new String[]{".....7..9",
    			             ".4..812..",
    						 "...9...1.",
    						 "..53...72",
    						 "293....5.",
    						 ".....53..",
    						 "8...23...",
    						 "7...5..4.",
    						 "531.7...."};
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				board[i][j] = lines[i].charAt(j);
			}
		}
		solveSudoku(board);
		printSudoku(board);
		System.out.println("END");
    }
    
    private void printSudoku(char[][] board){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				System.out.printf("%c ", board[i][j]);
			}
			System.out.println();
		}    	
    }
    
    public void solveSudoku(char[][] board) {
    	boolean[][] horizontal = new boolean[9][9];
    	boolean[][] vertical = new boolean[9][9];
    	boolean[][] squares = new boolean[9][9];
        for (int i=0;i<9;i++){
        	for (int j=0;j<9;j++){        		
        		char ch = board[i][j];
        		if (ch != '.'){
        			horizontal[i][ch-'1'] = true;
        		}
        		if (ch != '.'){
        			vertical[j][ch-'1'] = true;
        		}
       	        if (ch != '.'){
       	        	squares[j/3+3*(i/3)][ch-'1'] = true;
       	        }
        	}
        }       
        
    	trySolveSudoku(board, horizontal, vertical, squares);
    }
    
    public boolean trySolveSudoku(char[][] board, boolean[][] horizontal, boolean[][] vertical, boolean[][] squares) {
        for(int i=0;i<9;i++){
        	for(int j=0;j<9;j++){
        		if (board[i][j]=='.'){
        			for(char ch='1';ch<='9';ch++){
        				if (!horizontal[i][ch-'1'] && !vertical[j][ch-'1'] && !squares[j/3+3*(i/3)][ch-'1']){       					
	        				board[i][j] = ch;
	        				horizontal[i][ch-'1'] = true;
	        				vertical[j][ch-'1'] = true;
	        				squares[j/3+3*(i/3)][ch-'1'] = true;
	        				
        					if (trySolveSudoku(board, horizontal, vertical, squares)) return true;
        					
	        				horizontal[i][ch-'1'] = false;
	        				vertical[j][ch-'1'] = false;
	        				squares[j/3+3*(i/3)][ch-'1'] = false;
        				}
        			}    
    				return false;
        		}
        	}
        }
        
        return true;
    }
    
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
    	num = new int[]{91277418,66271374,38763793,4092006,11415077,60468277,1122637,72398035,-62267800,22082642,60359529,-16540633,92671879,-64462734,-55855043,-40899846,88007957,-57387813,-49552230,-96789394,18318594,-3246760,-44346548,-21370279,42493875,25185969,83216261,-70078020,-53687927,-76072023,-65863359,-61708176,-29175835,85675811,-80575807,-92211746,44755622,-23368379,23619674,-749263,-40707953,-68966953,72694581,-52328726,-78618474,40958224,-2921736,-55902268,-74278762,63342010,29076029,58781716,56045007,-67966567,-79405127,-45778231,-47167435,1586413,-58822903,-51277270,87348634,-86955956,-47418266,74884315,-36952674,-29067969,-98812826,-44893101,-22516153,-34522513,34091871,-79583480,47562301,6154068,87601405,-48859327,-2183204,17736781,31189878,-23814871,-35880166,39204002,93248899,-42067196,-49473145,-75235452,-61923200,64824322,-88505198,20903451,-80926102,56089387,-58094433,37743524,-71480010,-14975982,19473982,47085913,-90793462,-33520678,70775566,-76347995,-16091435,94700640,17183454,85735982,90399615,-86251609,-68167910,-95327478,90586275,-99524469,16999817,27815883,-88279865,53092631,75125438,44270568,-23129316,-846252,-59608044,90938699,80923976,3534451,6218186,41256179,-9165388,-11897463,92423776,-38991231,-6082654,92275443,74040861,77457712,-80549965,-42515693,69918944,-95198414,15677446,-52451179,-50111167,-23732840,39520751,-90474508,-27860023,65164540,26582346,-20183515,99018741,-2826130,-28461563,-24759460,-83828963,-1739800,71207113,26434787,52931083,-33111208,38314304,-29429107,-5567826,-5149750,9582750,85289753,75490866,-93202942,-85974081,7365682,-42953023,21825824,68329208,-87994788,3460985,18744871,-49724457,-12982362,-47800372,39958829,-95981751,-71017359,-18397211,27941418,-34699076,74174334,96928957,44328607,49293516,-39034828,5945763,-47046163,10986423,63478877,30677010,-21202664,-86235407,3164123,8956697,-9003909,-18929014,-73824245};
    	ret = fourSum(num,-236727523);
    	System.out.println("-236727523");
    	for(ArrayList<Integer> result : ret){
    		for(Integer i : result){
    			System.out.printf("%d ", i);
    		}
    		System.out.println();
    	}
    	System.out.println("END");
    } 
    
    public ArrayList<ArrayList<Integer>> fourSum2(int[] num, int target) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	if (num.length < 4) return ret;
        HashSet<ArrayList<Integer>> resultset = new HashSet<ArrayList<Integer>>();
        Arrays.sort(num);
        Hashtable<Integer, Integer> map = new Hashtable<Integer, Integer>();
        for(int i : num){
        	if (map.containsKey(i)) map.put(i, map.get(i) + 1);
        	else map.put(i,  1);
        }
                
        for(int i=0;i<num.length;i++){
        	for(int j=i+1;j<num.length;j++){
        		for(int k=j+1;k<num.length;k++){
        			int last = target - num[i] - num[j] - num[k];
        			if (map.containsKey(last)){
        				int count = map.get(last);
        				if (num[i] == last) count --;
        				if (num[j] == last) count --;
        				if (num[k] == last) count --;
        				if (count > 0){
        					ArrayList<Integer> result = new ArrayList<Integer>();
        					result.add(num[i]);
        					result.add(num[j]);
        					result.add(num[k]);
        					if (last<num[i]) result.add(0, last);
        					else if (last<num[j]) result.add(1, last);
        					else if (last<num[k]) result.add(2, last);
        					else result.add(last);
        					if (!resultset.contains(result)) {
        						ret.add(result);
        						resultset.add(result);
        					}
        				}
        			}
        		}
        	}
        }
        
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
	 	Arrays.sort(num);
	 
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < num.length; i++) {
			for (int j = i + 1; j < num.length; j++) {
				int k = j + 1;
				int l = num.length - 1;
	 
				while (k < l) {
					int sum = num[i] + num[j] + num[k] + num[l];
	 
					if (sum > target) {
						l--;
					} else if (sum < target) {
						k++;
					} else if (sum == target) {
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);
	 
						if (!hashSet.contains(temp)) {
							hashSet.add(temp);
							result.add(temp);
						}
	 
						k++;
						l--;
					}
				}
			}
		}
	 
		return result;
	}
        
    public int removeElement(int[] A, int elem) {
      int offset = 0;
      for(int i=0;i<A.length;i++){
    	  if (A[i]==elem) offset ++;    	  
    	  else if (offset > 0) A[i-offset]=A[i];
      }
      return A.length - offset;
    }
        
    public int minDepth(TreeNode root) {
        int ret = 0;
        if (root != null){
            if (root.left == null) return minDepth(root.right) + 1;
            else if (root.right == null) return minDepth(root.left) + 1;
            else{
                int left = 0, right = 0;
                left = minDepth(root.left);
                right = minDepth(root.right);
                if (left < right) return left + 1;
                else return right + 1;
            }
        }
        return ret;
    }
    
    private ArrayList<String[]> trySolveNQueens(int i, int[] board, boolean[] cols, boolean[] crls, boolean[] crrs){
        ArrayList<String[]> ret = new ArrayList<String[]>();
        int n = board.length;
    	
		for (int j=0;j<n;j++){
			if (!cols[j] && !crls[n+i-j-1] && !crrs[j+i]){
    			cols[j] = true;
    			crls[n+i-j-1] = true;
    			crrs[j+i] = true;
    			board[i] = j;
    			
    			if (i<n-1){
    			    for(String[] result : trySolveNQueens(i+1, board, cols, crls, crrs)){
	    			 ret.add(result);
    			    }
    			}
    			else{
    				String[] result = new String[n];
    				for(int k=0;k<n;k++){
    					StringBuilder builder = new StringBuilder();
    					for(int l=0;l<n;l++){	    						
    						if (board[k]==l) builder.append('Q');
    						else builder.append('.');
    					}
    					result[k]=builder.toString();
    				}
    				ret.add(result);
    			}

    			cols[j] = false;
    			crls[n+i-j-1] = false;
    			crrs[j+i] = false;
			}
		
    	}
    	return ret;
    }
    
    public ArrayList<String[]> solveNQueens(int n) {
    	boolean[] cols = new boolean[n];
    	boolean[] crls = new boolean[2*n-1];
    	boolean[] crrs = new boolean[2*n-1];
    	int[] board = new int[n];
    	
    	return trySolveNQueens(0, board, cols, crls, crrs);       
    }
    
    private int tryTotalNQueens(int i, int[] board, boolean[] cols, boolean[] crls, boolean[] crrs){
        int ret = 0;
        int n = board.length;
    	
		for (int j=0;j<n;j++){
			if (!cols[j] && !crls[n+i-j-1] && !crrs[j+i]){
    			cols[j] = true;
    			crls[n+i-j-1] = true;
    			crrs[j+i] = true;
    			board[i] = j;
    			
    			if (i<n-1){
    			    ret += tryTotalNQueens(i+1, board, cols, crls, crrs);
    			}
    			else{
    			    ret ++;
    			}

    			cols[j] = false;
    			crls[n+i-j-1] = false;
    			crrs[j+i] = false;
			}
		
    	}
    	return ret;
    }
    
    public int totalNQueens(int n) {
    	boolean[] cols = new boolean[n];
    	boolean[] crls = new boolean[2*n-1];
    	boolean[] crrs = new boolean[2*n-1];
    	int[] board = new int[n];
    	
    	return tryTotalNQueens(0, board, cols, crls, crrs);       
    }    

   private ArrayList<ArrayList<Integer>> tryPermute(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (list.size() == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(list.get(0));
            ret.add(result);
            return ret;
        }
        for(int i=0;i<list.size();i++){
            int n = list.get(i);
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            for(Integer val : list) if (val != n) sublist.add(val);
            
            ArrayList<ArrayList<Integer>> results = tryPermute(sublist);
            for(int j=0;j<results.size();j++){
                ArrayList<Integer> result = results.get(j);
                result.add(n);
                ret.add(result);
            }
        }
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n : num) list.add(n);
        ArrayList<ArrayList<Integer>> set = tryPermute(list);
        
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>(set);
        
        return new ArrayList<ArrayList<Integer>>(ret);
    }        
    
   
    public void Test_isSymmetric(){
    	TreeNode root = new TreeNode(9);
    	TreeNode node = new TreeNode(-42);
    	root.left = node;
    	TreeNode node1 = new TreeNode(76);
    	node.right = node1;
    	node = node.right;
    	node1 = new TreeNode(13);
    	node.right = node1;
    	node = new TreeNode(-42);
    	root.right = node;
    	node1 = new TreeNode(76);
    	node.left = node1;
    	node = node.left;
    	node1 = new TreeNode(13);
    	node.right = node1;
    	
    	System.out.printf("%b \r\n", isSymmetric(root));
    }
    
    private boolean symmetricNodes(TreeNode left, TreeNode right)
    {
    	if (left.val != right.val) return false;
    	
    	boolean ret = true;
    	
    	if (left.left == null && right.right == null) ret = true;
    	else if (left.left == null && right.right != null) return false;
    	else if (left.left != null && right.right == null) return false;  	
    	else ret = symmetricNodes(left.left, right.right);
    	
    	if (ret){
	    	if (left.right == null && right.left == null) ret = true;
	    	else if (left.right == null && right.left != null) return false;
	    	else if (left.right != null && right.left == null) return false;
	    	else ret = symmetricNodes(left.right, right.left);;
    	}
    	
    	return ret;
    }
    
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        if (root.left != null && root.right == null) return false;
        if (root.left == null && root.right != null) return false;
        
        return symmetricNodes(root.left, root.right);
    }

    public int maxSubArray(int[] A) {
        int max = Integer.MIN_VALUE, val = 0;
        for(int i : A){        	
        	if (i > max) max = i;
        	val += i;
        	if (val > max) max = val;
        	if (val < 0) val = 0;
        }
        
        return max;
    }
    
    private ArrayList<ArrayList<Integer>> tryPermuteUnique(ArrayList<Integer> list){
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (list.size() == 1){
            ArrayList<Integer> result = new ArrayList<Integer>();
            result.add(list.get(0));
            ret.add(result);
            return ret;
        }
        HashSet<Integer> used = new HashSet<Integer>();
        for(int i=0;i<list.size();i++){
        	if (used.contains(list.get(i))) continue;
            int n = list.get(i);
            used.add(n);
            ArrayList<Integer> sublist = new ArrayList<Integer>();
            for(int j=0;j<list.size();j++) if (j != i) sublist.add(list.get(j));
            
            ArrayList<ArrayList<Integer>> results = tryPermute(sublist);
            for(int j=0;j<results.size();j++){
                ArrayList<Integer> result = results.get(j);
                result.add(n);
                ret.add(result);
            }
        }
        return ret;
    }
    
    public ArrayList<ArrayList<Integer>> tryPermuteUnique(int[] num) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n : num) list.add(n);
        ArrayList<ArrayList<Integer>> set = tryPermuteUnique(list);
        
        HashSet<ArrayList<Integer>> ret = new HashSet<ArrayList<Integer>>(set);
        
        return new ArrayList<ArrayList<Integer>>(ret);
    }        

    public int[] plusOne(int[] digits) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        if (digits.length > 0){
	        int sum = 0, carry = 1;
	        for(int i=digits.length-1;i>=0;i--){
	        	sum = digits[i] + carry;
	        	carry = sum / 10;
	        	sum = sum % 10;
	        	list.add(sum);
	        }
	        if (carry>0) list.add(carry);
        }
        int[] ret = new int[list.size()];
        for(int i=0;i<ret.length;i++) ret[i] = list.get(ret.length-1-i);
        return ret;
    }
    
    public void Test_combine(){
    	ArrayList<ArrayList<Integer>> results = combine(7,7);
    	for(ArrayList<Integer> result : results){
    		for(Integer val : result) System.out.printf("%d ", val);
    		System.out.println();    		
    	}
    	results = combine(10,7);
    	for(ArrayList<Integer> result : results){
    		for(Integer val : result) System.out.printf("%d ", val);
    		System.out.println();    		
    	}
    	results = combine(10,5);
    	for(ArrayList<Integer> result : results){
    		for(Integer val : result) System.out.printf("%d ", val);
    		System.out.println();    		
    	}
    }
    
    private ArrayList<ArrayList<Integer>> tryCombine(int n, int k, boolean[] usage, int min) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0;i<=n-k;i++){
    		if (usage[i]) continue;
    		if (min > i) continue;
    		usage[i] = true;
    		min = i;
    		if (k > 1){
    			ArrayList<ArrayList<Integer>> results = tryCombine(n, k-1, usage, min);
    			for(int j=0;j<results.size();j++){
    				ArrayList<Integer> result = results.get(j);
    				result.add(0, i+1);
    				ret.add(result);
    			}
    		}
    		else{
    			ArrayList<Integer> result = new ArrayList<Integer>();
    			result.add(i+1);
    			ret.add(result);
    		}
    		usage[i] = false;
    	}

    	return ret;
    }
    
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
    	 boolean[] usage = new boolean[n];
    	 return tryCombine(n,k,usage, 0);
    }

    public void test_removeNthFromEnd(){
    	ListNode root = new ListNode(1);
    	root = removeNthFromEnd(root, 1);
    	System.out.printf("List ");
    	while(root != null){
    		System.out.printf("%d ", root.val);
    		root = root.next;
    	}
    	
    	System.out.println();
    	root = new ListNode(1);
    	ListNode node = new ListNode(2);
    	root.next = node;
    	root = removeNthFromEnd(root, 1);
    	System.out.printf("List ");
    	while(root != null){
    		System.out.printf("%d ", root.val);
    		root = root.next;
    	}
    	System.out.println();
    	
    	root = new ListNode(1);
    	node = new ListNode(2);
    	root.next = node;
    	root = removeNthFromEnd(root, 2);
    	System.out.printf("List ");
    	while(root != null){
    		System.out.printf("%d ", root.val);
    		root = root.next;
    	}
    	System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode previous = head;
        for(int i=1;i<n;i++){
        	first = first.next;
        }
        while(first.next != null){
        	first = first.next;
        	previous = second;
        	second = second.next;
        	//System.out.printf("first %d second %d previous %d\r\n", first.val, second.val, previous.val);
        }        
        if (second == head){ 
        	head = head.next;        
        }
        else if (second != null) previous.next = second.next;
        
        return head;
    }
    
    public int lengthOfLastWord(String s) {
    	if (s.length() < 1) return 0;
    	
        int ret=s.length()-1;
        for(;ret>=0;ret--){
        	if (s.charAt(ret) != ' ') break;
        }
        int trailing = ret+1;
        
        for(;ret>=0;ret--){
        	if (s.charAt(ret) == ' ') break;
        }
        
        if (ret < 0) return trailing;
        else return trailing - ret -1;
    }
    
    public int threeSumClosest(int[] num, int target) {
    	int ret = num[0]+num[1]+num[2];
    	
    	Arrays.sort(num);
    	for (int i=0;i<num.length;i++){
    		int k=i+1, l = num.length - 1;
    		while(k < l){
    			int sum = num[i] + num[k] + num[l];
    			if (Math.abs(ret - target) > Math.abs(sum - target)) ret = sum;
    			
    			if (sum < target) k++;
    			else if (sum == target) return sum;
    			else l--;
    		}
    	}
    	
    	return ret;
    }
    
    ListNode merge2List(ListNode list1, ListNode list2){
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
        
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
    	if (lists.size() == 0) return null;
    	else if (lists.size() == 1) return lists.get(0);
    	else {
    		ListNode ret = lists.get(0);
    		for(int i=1;i<lists.size();i++){
    			ret = merge2List(ret, lists.get(i));
    		}
    		
    		return ret;
    	}    	
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {  	
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
    		ret.add(0,level);
    	}
    	
    	return ret;
    }    
    
    class RandomListNode {
    	 int label;
    	 RandomListNode next, random;
    	 RandomListNode(int x) { this.label = x; }
    }
    	 
    public RandomListNode copyRandomList(RandomListNode head) {
        Hashtable<RandomListNode, RandomListNode> map = new Hashtable<RandomListNode, RandomListNode>();
        
        RandomListNode list = head, ret = null, previous = null, newhead = null;
        while(list != null){        	
        	ret = new RandomListNode(list.label);
        	map.put(list, ret);        	
        	list = list.next;
        	if (previous == null){
        		newhead = ret;
        		previous = ret;
        	}
        	else{
        		previous.next = ret;
        		previous = ret;
        	}
        }
        
        list = head;
        ret = newhead;
        while(list != null){
        	if (list.random != null){
        		RandomListNode random = map.get(list.random);
        		RandomListNode newparent = map.get(list);
        		newparent.random = random;
        	}
        	list = list.next;
        	ret = ret.next;
        }
        
        return newhead;
    }
        
    public void test_strStr(){
    	System.out.printf("%s\r\n", strStr("a", "a"));
    }
    
    /**
     * "", "" return "" instead of null?
     * @param haystack
     * @param needle
     * @return
     */
    public String strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return null;
        else if (haystack == "" && needle == "") return "";
        int index = -1;       
        
        for (int i=0;i<haystack.length() - needle.length() + 1;i++){
        	boolean match = true;
        	for(int j=0;j<needle.length();j++){
        		if (haystack.charAt(i+j) != needle.charAt(j)) {
        			match = false;
        			break;
        		}
        	}
        	if (match){
        		index = i;
        		break;
        	}
        }
        
        if (index >= 0) return haystack.substring(index);
        else return null;
    }    
   
    private int balancedNodes(TreeNode left, TreeNode right){
    	int leftheight = 0, rightheight = 0;
    	
    	if (left != null) leftheight = balancedNodes(left.left, left.right);    	
    	if (leftheight >= 0 && right != null) rightheight = balancedNodes(right.left, right.right);
    	
    	if (leftheight >= 0 && rightheight >= 0){
    		if (Math.abs(leftheight - rightheight) <= 1){
    			return Math.max(leftheight, rightheight) + 1;
    		}
    		else return -1;
    	}
    	
    	//not balanced nodes
    	return -1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        else return balancedNodes(root.left, root.right) > 0;
    }
 
    public void flatten(TreeNode root) {
    	ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (root != null) stack.add(root);
        while(!stack.isEmpty()){
        	TreeNode node = stack.pop();
        	ret.add(node);
        	
        	if (node.right != null) stack.push(node.right);
        	if (node.left != null) stack.push(node.left);
        }
        
        TreeNode previous = null;
        for(int i=0;i<ret.size();i++){
        	TreeNode node = ret.get(i);
        	node.left = null;
        	if (previous != null){
        		previous.right = node;
        	}
        	previous = node;
        }
    }
    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	ArrayList<Interval> ret = new ArrayList<Interval>();
    	for(Interval interval : intervals){
    		if (newInterval == null || interval.end < newInterval.start){
    			ret.add(interval);
    		}
    		else if (interval.start > newInterval.end){
    			ret.add(newInterval);
    			newInterval = null;
    			ret.add(interval);
    		}
    		else if (interval.start <= newInterval.start && interval.end >=newInterval.end){
    			newInterval = null;
    			ret.add(interval);
    		}
    		else if (interval.start < newInterval.start){
    			newInterval.start = interval.start;
    		}
    		else if (interval.end > newInterval.end){
    			newInterval.end = interval.end;
    			ret.add(newInterval);
    			newInterval = null;
    		}
    	}
    	if (newInterval != null) ret.add(newInterval);
    	
    	return ret;
    }
    
    public void reorderList(ListNode head) {
        ArrayList<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while(node != null){
        	list.add(node);
        	node = node.next;
        }

        ListNode previous = null;
        int start = 0, end = list.size() - 1;
        while(start < end){
        	ListNode first = list.get(start);
        	ListNode second = list.get(end);
        	if (previous != null) previous.next = first;
        	first.next = second;
        	previous = second;
        	start ++;
        	end --;
        }
        if (start == end && previous != null){
        	previous.next = list.get(start);
        	previous.next.next = null;
        }
        else if (previous != null) previous.next = null;
    }
    
    public void test_sortedListToBST(){
    	ListNode node = new ListNode(0);
    	
    	ListNode next = new ListNode(1);
    	node.next = next;
    	ListNode next1 = new ListNode(2);
    	next.next = next1;
    	next = next1;
    	
    	next1 = new ListNode(3);
    	next.next = next1;
    	next = next1;
    	next1 = new ListNode(4);
    	next.next = next1;
    	next = next1;
    	next1 = new ListNode(5);
    	next.next = next1;
    	next = next1;
    	next1 = new ListNode(6);
    	next.next = next1;
    	next = next1;
    	
    	TreeNode treenode = sortedListToBST(node);        	
    }
    
    /**
     * recursively create BST from sorted list
     * @param list
     * @return
     */
    private TreeNode sortedListToBST(ArrayList<TreeNode> treelist, int start, int length){
    	TreeNode treehead = null;
    	
    	int middle = length / 2 + start;
        if (length > 0 && middle - start < length){
            //System.out.printf("%d %d %d\r\n", start, middle, length);
        	treehead = treelist.get(middle);
        	TreeNode subnode = sortedListToBST(treelist, start, middle - start); 
        	if (subnode != null) treehead.left = subnode;
        	subnode = sortedListToBST(treelist, middle + 1, length - middle + start - 1);
        	if (subnode != null) treehead.right = subnode;
        }
    	return treehead;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        ListNode listnode = head;
        ArrayList<TreeNode> treelist = new ArrayList<TreeNode>();
        
        while(listnode != null){
        	TreeNode treenode = new TreeNode(listnode.val);
        	listnode = listnode.next;        	
        	treelist.add(treenode);
        }
       
        return sortedListToBST(treelist, 0, treelist.size());
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        ArrayList<TreeNode> treelist = new ArrayList<TreeNode>();
        
        for(int i : num){
        	TreeNode treenode = new TreeNode(i);
        	treelist.add(treenode);
        }
        
        return sortedListToBST(treelist, 0, treelist.size());        
    }
    
    
    public void Test_divide(){
    	System.out.printf("%d \r\n", divide(8, 3));
    	System.out.printf("%d \r\n", divide(600000000, 3));
    	System.out.printf("%d \r\n", divide(2147483647,2));
    	System.out.printf("%d \r\n", divide(-2147483648,1));
    	System.out.printf("%d \r\n", divide(-1010369383, -2147483648));
    }
        
    public int divide(int dividend, int divisor) {
        if (divisor == 0) return -1;
        boolean neg1 = false, neg2 = false;
        long div = dividend, dis = divisor;
        if (div < 0){ 
            neg1 = true;
            div = -div;
        }
        if (divisor < 0){
            neg2 = true;
            dis = -dis;
        }
        
        long pow = 1, val = dis, temp = div; 
        while(dis < temp){
        	pow = pow << 1;
        	temp = temp >> 1;
        	val = val << 1;
        }
        
        while(val > div){
        	val = val >> 1;
        	pow = pow >> 1;
        }
        
        long remain = div - val;
        long count = pow;
        while(remain > dis){
        	if (val < remain){
	            remain -= val;
	            count += pow;
        	}
        	pow = pow >> 1;
			val = val >> 1;
        }
        if (remain == dis) count ++;

        if ((!neg1 && neg2) || (neg1 && !neg2)) count *= -1;
        
        return (int)count;
    }    
   
    /**
     * TODO: not constant extra space
     * @param root
     */
    public void connect1(TreeLinkNode root) {
    	ArrayList<ArrayList<TreeLinkNode>> ret = new ArrayList<ArrayList<TreeLinkNode>>();
    	if (root == null) return;
    	
    	ArrayList<TreeLinkNode> list = new ArrayList<TreeLinkNode>();
    	list.add(root);
    	while(list.size() > 0){
    		ArrayList<TreeLinkNode> next = new ArrayList<TreeLinkNode>();

    		for(TreeLinkNode node : list){
    			if (node.left != null) next.add(node.left);
    			if (node.right != null) next.add(node.right);
    		}
    		
    		ret.add(list);
    		list = next;
    	}
    	
    	for(ArrayList<TreeLinkNode> level : ret){
    		TreeLinkNode node = level.get(0);
    		for(int i=0;i<level.size();i++){
    			TreeLinkNode next = level.get(i);
    			node.next = next;
    			node = next;
    		}
    	}   
    }
    
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        
        TreeLinkNode head = new TreeLinkNode(-1);
        for(TreeLinkNode current = root, previous = head; current != null ; current = current.next){
        	if (current.left != null){
        		previous.next = current.left;
        		previous = previous.next;
        	}
        	if (current.right != null){
        		previous.next = current.right;
        		previous = previous.next;
        	}
        }
    	connect(head.next);
    }
    
	public class LRUCache {
		class DoubleLinkNode {
			public int Key, Value;
			public DoubleLinkNode prev, next;

			public DoubleLinkNode(int key, int val) {
				Key = key;
				Value = val;
			}
		}

		Hashtable<Integer, DoubleLinkNode> hashtable;
		DoubleLinkNode head = null, tail = null;
		int maxsize;

		public LRUCache(int capacity) {
			hashtable = new Hashtable<Integer, DoubleLinkNode>(capacity);
			maxsize = capacity;
		}

		public int get(int key) {
			DoubleLinkNode node = hashtable.get(key);
			if (node == null)
				return -1;
			else {// move just used item to the head
				if (node != head) {
					node.prev.next = node.next;
					if (node.next != null)
						node.next.prev = node.prev;
					if (tail == node)
						tail = node.prev;
					node.next = head;
					node.prev = null;
					head.prev = node;
					head = node;
				}
				return node.Value;
			}
		}

		public void set(int key, int value) {
			DoubleLinkNode node = null;
			if (!hashtable.containsKey(key)) {
				if (hashtable.size() == maxsize) {
					hashtable.remove(tail.Key);
					if (tail.prev != null) {
						tail.prev.next = null;
						tail = tail.prev;
					} else {// size 1
						head = null;
						tail = null;
					}
				}
				node = new DoubleLinkNode(key, value);
				hashtable.put(key, node);
				node.next = head;
				if (head != null)
					head.prev = node;
				head = node;
				if (tail == null)
					tail = node;
				else if (tail == node)
					tail = node.prev;
			} else {
				node = hashtable.get(key);
				node.Value = value;
				if (node != head) {
					node.prev.next = node.next;
					if (node.next != null)
						node.next.prev = node.prev;
					if (tail == node)
						tail = node.prev;
					node.next = head;
					node.prev = null;
					head.prev = node;
					head = node;
				}
			}
		}
	}
    
    public ArrayList<String> anagrams(String[] strs) {
    	Hashtable<String, ArrayList<String>> map = new Hashtable<String, ArrayList<String>>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String sorted = new String(chars);
			ArrayList<String> list;
			if (map.containsKey(sorted)) list = map.get(sorted);
			else{
				list = new ArrayList<String>();
			}
			list.add(str);
			map.put(sorted, list);
		}
		
		ArrayList<String> ret = new ArrayList<String>();
		for(ArrayList<String> list : map.values()){
			if (list.size() > 1){
				for(String str : list) ret.add(str);
			}
		}
		
		return ret;
    }
    
    /**
     * f(n)=f(n-1)+f(n-2) 1 or 2 steps
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        int prev = 0, cur = 1;
        for(int i=0;i<n;i++){
        	int temp = cur;
        	cur += prev;
        	prev = temp;
        }
        return cur;
    }
    
    private ArrayList<String> genPath(String s, int k, Hashtable<Integer, ArrayList<Integer>> map){
    	ArrayList<String> ret = new ArrayList<String>();
    	if (map.containsKey(k)){
    		for(Integer i : map.get(k)){
    			String str = s.substring(k, i);
    			if (i == s.length()){
    				ret.add(str);
    			}
    			else{
    				ArrayList<String> list = genPath(s, i, map);
        			for(String result : list){
        				ret.add(str + " " + result);
        			}
    			}
    		}
    	}
    	return ret;
    }
    
	public ArrayList<String> wordBreak(String s, Set<String> dict) {
		ArrayList<String> ret = new ArrayList<String>();
		if (s == null || dict == null) return ret;
		
		boolean[] dp = new boolean[s.length() + 1];
		Hashtable<Integer, ArrayList<Integer>> map = new Hashtable<Integer, ArrayList<Integer>>();
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++){
			for (int k = 0; k < i; k++){
				if (dp[k] && dict.contains(s.substring(k, i))){
					dp[i] = true;
					ArrayList<Integer> list;
					if (map.containsKey(k)) list = map.get(k);
					else list = new ArrayList<Integer>();
					list.add(i);
					map.put(k, list);
				}
			}
		}
		
		if (dp[s.length()]){
			ret = genPath(s, 0, map);
		}

		return ret;
	}
    
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() < 1) return ret;
        
    	for(int i=0;i<intervals.size(); i++){
    		Interval newInterval = intervals.get(i);
    		
    		ArrayList<Interval> newret = new ArrayList<Interval>();
    		for(Interval interval : ret){
	    		if (newInterval == null || interval.end < newInterval.start){
	    			newret.add(interval);
	    		}
	    		else if (interval.start > newInterval.end){
	    			newret.add(newInterval);
	    			newInterval = null;
	    			newret.add(interval);
	    		}
	    		else if (interval.start <= newInterval.start && interval.end >=newInterval.end){
	    			newInterval = null;
	    			newret.add(interval);
	    		}
	    		else if (interval.start < newInterval.start){
	    			newInterval.start = interval.start;
	    		}
	    		else if (interval.end > newInterval.end){
	    			newInterval.end = interval.end;
	    			newret.add(newInterval);
	    			newInterval = null;
	    		}
    		}
        	if (newInterval != null) newret.add(newInterval);
        	ret = newret;
    	}
    	
    	return ret;    
    }
    
    public void test_singleNumber(){
    	System.out.printf("%d\r\n", singleNumber(new int[]{1}));
    }

    public int singleNumber(int[] A) {
        int ret = 0;
        int width = Integer.SIZE;
        int[] bits = new int[width];
        
        for (int a : A){
        	int b = a;
        	for (int i=0;i<bits.length;i++){
        		if ((b & 1) == 1){
        			bits[i] += 1;
        			bits[i] %= 3;
        		}
        		b = b >> 1;
        	}
        }
        
        for(int i=0;i<bits.length;i++){
        	ret += bits[i] << i;
        }
        
        return ret;
    }
    
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (root == null) return false;
    	//only leaf node
    	if (sum == root.val && (root.left == null && root.right == null)) return true;

    	boolean ret = false;  

    	ret = hasPathSum(root.left, sum - root.val);
    	
    	if (!ret) ret = hasPathSum(root.right, sum - root.val);
    	
    	return ret;
    }
    
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	if (root == null) return ret;

    	if (sum == root.val && (root.left == null && root.right == null)){
    		ArrayList<Integer> result = new ArrayList<Integer>();
    		result.add(root.val);
    		ret.add(result);
    		return ret;
    	}

    	ArrayList<ArrayList<Integer>> results1 = pathSum(root.left, sum - root.val);
    	for(int i=0;i<results1.size();i++){
    		ArrayList<Integer> result = results1.get(i);
    		result.add(0, root.val);
    		ret.add(result);
    	}
    	
    	ArrayList<ArrayList<Integer>> results2 = pathSum(root.right, sum - root.val);
    	for(int i=0;i<results2.size();i++){
    		ArrayList<Integer> result = results2.get(i);
    		result.add(0, root.val);
    		ret.add(result);
    	}
    	
    	return ret;
    }
    
    public ArrayList<ArrayList<Integer>> tryCombinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	for(int candidate : candidates){
    		if (candidate == target){
    			ArrayList<Integer> result = new ArrayList<Integer>();
    			result.add(candidate);
    			ret.add(result);
    		}
    		else if (candidate < target){
    			ArrayList<ArrayList<Integer>> results = tryCombinationSum(candidates, target - candidate);
    			for(int i=0;i<results.size();i++){    				
    				ArrayList<Integer> result = results.get(i);
    				result.add(candidate);
    				
    				ret.add(result);
    			}
    		}
    	}
    	
    	return ret;
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
    	ArrayList<ArrayList<Integer>> results = tryCombinationSum(candidates, target);
    	HashSet<ArrayList<Integer>> sets = new HashSet<ArrayList<Integer>>();
    	
    	for(int i=0;i<results.size();i++){
    		ArrayList<Integer> result = results.get(i);
    		
    		Collections.sort(result);
    		sets.add(result);
    	}
    	
    	return new ArrayList<ArrayList<Integer>>(sets);
    }
    
    
    
    
    public ArrayList<ArrayList<Integer>> tryCombinationSum2(ArrayList<Integer> candidates, int target) {
    	ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
    	
    	for(int i=0;i<candidates.size();i++){
    		Integer candidate = candidates.get(i);
    		//System.out.printf("i %d c %d t %d\r\n", i, candidate, target);
    		if (candidate == target){
    			ArrayList<Integer> result = new ArrayList<Integer>();
    			result.add(candidate);
    			ret.add(result);
    		}
    		else if (candidate < target){
    			candidates.remove(i);
    			ArrayList<ArrayList<Integer>> results = tryCombinationSum2(candidates, target - candidate);
    			for(int j=0;j<results.size();j++){    				
    				ArrayList<Integer> result = results.get(j);
    				result.add(candidate);
    				
    				ret.add(result);
    			}
    			candidates.add(i, candidate);
    		}
    		else{
    			break;//skip rest
    		}
    	}
    	
    	return ret;
    }
    
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
    	ArrayList<Integer> candidates = new ArrayList<Integer>();    	
    	for(int n : num) candidates.add(n);
    	Collections.sort(candidates);
    	
    	ArrayList<ArrayList<Integer>> results = tryCombinationSum2(candidates, target);
    	HashSet<ArrayList<Integer>> sets = new HashSet<ArrayList<Integer>>();
    	
    	for(int i=0;i<results.size();i++){
    		ArrayList<Integer> result = results.get(i);
    		
    		Collections.sort(result);
    		sets.add(result);
    	}
    	
    	return new ArrayList<ArrayList<Integer>>(sets);
    }
     
    public void test_tryCombinationSum2(){
    	ArrayList<ArrayList<Integer>> results = combinationSum2(new int[]{1,2}, 2);
    	for(ArrayList<Integer> result: results){
    		for(Integer r : result) System.out.printf("%d ", r);
    		System.out.println();
    	}
    }
    
    public void test_firstMissingPositive(){
    	System.out.printf("%d\r\n", firstMissingPositive(new int[]{1,2,0}));
    	System.out.printf("%d\r\n", firstMissingPositive(new int[]{3,4,-1,1}));
    	System.out.printf("%d\r\n", firstMissingPositive(new int[]{-1,4,2,1,9,10}));
    	System.out.printf("%d\r\n", firstMissingPositive(new int[]{4,3,2,1}));
    }
    
    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
        	//System.out.printf("i %d - ", i);
        	//for(int a : A) System.out.printf("%d ", a);
        	//System.out.println();
        	if (A[i] > 0 && A[i] < A.length){
                if (A[A[i]-1] != A[i]){  
                    int temp = A[A[i]-1];
                    A[A[i]-1] = A[i];
                    A[i] = temp;
                    i--;  
                }  
        	}
        }
        
        for (int i=0; i<A.length; i++){  
            if (A[i]-1 != i){  
                return i+1;  
            }
        }
  
        return A.length+1; 
    }
    
    public void test_nextPermutation(){
    	int[] num = new int[]{1,3,2};
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.printf("-> ");
    	nextPermutation(num);
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.println();
    	num = new int[]{3,2,1};
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.printf("-> ");
    	nextPermutation(num);
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.println();
    	num = new int[]{1,1,5};
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.printf("-> ");
    	nextPermutation(num);
    	for(int n : num) System.out.printf("%d ", n);
    	System.out.println();
    }
    
    public void nextPermutation(int[] num) {
    	if (num == null || num.length < 2) return;
    	
    	boolean reverseFlag = true;
        for(int i=num.length-1;i>0;i--){
        	if (num[i] > num[i-1]){
        		reverseFlag = false;
        		int firstlarger = i;
        		for(int j=num.length-1;j>i;j--){
        			if (num[j]>num[i-1]){
        				firstlarger = j;
        				break;
        			}
        		}
        		
        		int temp = num[i-1];
        		num[i-1] = num[firstlarger];
        		num[firstlarger] = temp;
        		
        		int start = i, stop = num.length - 1;
        		while(start < stop){
        			temp = num[start];
        			num[start] = num[stop];
        			num[stop] = temp;
        			start++;
        			stop--;
        		}
        		
        		break;
        	}
        }
        
        if (reverseFlag){//reverse the array
    		int start = 0, stop = num.length - 1;
    		while(start < stop){
    			int temp = num[start];
    			num[start] = num[stop];
    			num[stop] = temp;
    			start++;
    			stop--;
    		}
        }
    }
    
    public ListNode detectCycle(ListNode head) {
        ListNode one = head, two = head;
        while(two !=null){
            one = one.next;
            two = two.next;
            if (two != null){ 
                two = two.next;
                if (one != null && two != null && one == two)
                {
                	ListNode three = head;
                	while (one != three){
                		one = one.next;
                		three = three.next;
                	}
                	return one;
                }
            }
            else return null;
        };
        
        return null;
    }
    
    public void test_simplifyPath(){
    	System.out.printf("%s\r\n", simplifyPath("//."));
    }
    
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        StringBuilder builder = new StringBuilder();
        Stack<String> stack = new Stack<String>();
        for(String p : paths){
        	//System.out.printf("p %s\r\n", p);
        	if (p.length() > 0 && !p.equals(".")) stack.push(p);
        }
        int level = 0;
        while(!stack.isEmpty()){
        	String p = stack.pop();
        	//System.out.printf("s %s\r\n", p);
        	if (p.equals("..")) level ++;
        	else if (level == 0){
        			builder.insert(0, "/" + p);
        		}
        	else if (level > 0) level --;        	
        }
        if (builder.length() == 0) return "/";
        return builder.toString();
    }
    
    public void test_reverseBetween(){
    	ListNode node = new ListNode(3);
    	ListNode node1 = new ListNode(5);
    	node.next = node1;
    	ListNode head = reverseBetween(node, 1, 2);
    	while(head != null){
    		System.out.printf("%d ", head.val);
    		head = head.next;
    	}
    	System.out.println();
    }
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode holder = new ListNode(0);
    	holder.next = head;
    	
        ListNode prev = holder; 
        int index = 1;
        while(index < m && prev != null){
        	prev = prev.next;
        	index ++;
        }
       
        ListNode head2 = prev;
        prev = head2.next;
        if (prev == null || prev.next == null) return head;        

        ListNode next = prev.next;
        while(next != null && index < n){
            prev.next = next.next;
            next.next = head2.next;
            head2.next = next;
            next = prev.next;
            index ++;
        }
        
        return holder.next;
    }
    
    public int tryMinPathSum(int[][] grid, int x, int y) {
    	int m = grid.length;
    	int n = grid[0].length;
    	
    	if (m == x + 1 && n == y + 1) return grid[x][y];
    	
    	int right = Integer.MAX_VALUE;
    	if (x + 1 < m) right =  tryMinPathSum(grid, x + 1, y);
    	int down = Integer.MAX_VALUE;
    	if (y + 1 < n) down = tryMinPathSum(grid, x, y + 1);
    	
    	if (right < down) return grid[x][y] + right;
    	else return grid[x][y] + down;
    }
    
    public int minPathSum1(int[][] grid) {
    	if (grid == null) return 0;
    	
        return tryMinPathSum(grid, 0, 0);
    }  
    
    public void test_minPathSum(){
    	int[][] grid = new int[][]{new int[]{1,2,5},new int[]{3,2,1}};
    	
    	System.out.printf("%d\r\n", minPathSum(grid));
    }
    
    public int minPathSum(int[][] grid) {
    	if (grid == null) return 0;
    	
    	int[][] dp = new int[grid.length][grid[0].length];
    	dp[0][0] = grid[0][0];
    	
    	for(int i=0;i<grid.length;i++){
    		for(int j=0;j<grid[0].length;j++){
    			int left = i>0 ? dp[i-1][j] : Integer.MAX_VALUE;
    			int up = j>0 ? dp[i][j-1] : Integer.MAX_VALUE;
    			if (i>0 || j>0) dp[i][j] = left < up ? left + grid[i][j] : up + grid[i][j];
    			//System.out.printf("i %d j %d %d\r\n", i, j, dp[i][j]);    			
    		}
    	}
    	
    	return dp[grid.length-1][grid[0].length-1];
    }    
    
    public void test_isNumber(){
    	System.out.printf("%b \r\n", isNumber("e"));
    	System.out.printf("%b \r\n", isNumber("."));
    	System.out.printf("%b \r\n", isNumber(" "));
    	System.out.printf("%b \r\n", isNumber("0"));
    	System.out.printf("%b \r\n", isNumber(" 0.1 "));
    	System.out.printf("%b \r\n", isNumber("abc"));
    	System.out.printf("%b \r\n", isNumber("1 a"));
    	System.out.printf("%b \r\n", isNumber("2e10"));
    	System.out.printf("%b \r\n", isNumber(" 005047e+6"));
    	System.out.printf("%b \r\n", isNumber(" 6ee69"));
    }
    
    public boolean isNumber(String s) {
    	s = s.trim();
    	
    	if (s.startsWith("+") || s.startsWith("-")) s = s.substring(1);
    	
    	boolean dot = false, e = false, number = false, numberaftere = false, previouse = false;
    	for(char ch : s.toCharArray()){
    		if (!e && !dot && ch == '.'){
    			dot = true;
    			if (previouse) previouse = false;
    		}
    		else if (ch < '0' || ch > '9'){
    			if (number && !e && ch == 'e'){
    				e = true;
    				previouse = true;
    			}
    			else if (previouse){
    				if (ch == '-' || ch == '+'){
        				previouse = false;
    					continue;
    				}
    				else return false;
    			}
    			else return false;
    		}
    		else {
    			number = true;
    			if (e) numberaftere = true;
        		if (previouse) previouse = false;
    		}
    	}
    	
    	if (e && !numberaftere) return false;
    	if (!number) return false;
    	
        return true;
    }
       
    public int longestConsecutive1(int[] num) {
    	int ret = 1;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n : num){
        	if (map.containsKey(n)) continue;
        	
            boolean found = false;
        	if (map.containsKey(n-1)){
	        		//merge n to n-1
	        		int end = map.get(n-1);
	        		
	        		if (end < n){        		
	        		map.remove(n-1);
	        		map.remove(end);
	        		map.put(n, end);
	        		map.put(end,  n);
	        		
	        		int max = n - end + 1;
	        		if (max > ret) ret = max;
	        		
	        		found = true;
	        		//System.out.printf("a %d %d %d\r\n", n, end, max);
        		}
        	}
        	if (map.containsKey(n+1)){
        		if (found){
        		    //merge both
        			int start = map.get(n+1);
        		    int end = map.get(n);
        		    map.remove(n+1);
        		    map.remove(n);
        		    map.remove(start);
        		    map.remove(end);
        		    map.put(start, end);
        		    map.put(end,  start);
        		    int max = start - end + 1;
        		    if (max > ret) ret = max;
        		    
        		    found = true;        		    
        		    //System.out.printf("b %d %d %d\r\n", start, end, max);
        		}
        		else{
	            		int end = map.get(n+1);
	            		if (end > n){
		            		map.remove(n+1);
		            		map.remove(end);
		            		map.put(n, end);
		            		map.put(end, n);
		            		
		            		int max = end - n + 1;
		            		if (max > ret) ret = max;            		
		        		    found = true;        		    
		            		//System.out.printf("c %d %d %d\r\n", n, end, max);
            		}
        		}
        	}
        	if (!found)
        	{
        		map.put(n, n);
        		//System.out.printf("d %d %d\r\n", n, n);
        	}
        }
        
        return ret;    
    }
    
    //public ArrayList<Integer> largeArray = new ArrayList<Integer>(new int[]{-339,711,-497,-940,867,-703,654,-852,116,963,15,822,588,925,-501,-431,-412,191,77,-581,781,421,387,-458,-961,-886,915,-29,283,19,-967,-982,-270,-391,-923,-330,-95,803,-109,-905,839,978,916,428,903,-512,-930,-435,678,146,56,533,-359,-556,-925,-321,-443,-937,649,840,154,755,857,883,-636,933,-373,268,736,590,362,575,641,351,76,618,838,146,-817,517,-635,238,123,5,681,197,683,-688,259,406,-848,-513,234,-991,-630,597,-985,69,-62,823,-268,-626,471,-626,724,-379,991,636,839,-753,226,-796,557,-651,282,239,545,38,550,-123,-483,774,363,750,855,806,347,942,-52,-714,765,753,-341,309,-873,-544,929,-809,-908,768,-563,317,-954,993,665,400,305,283,-562,-72,-766,-45,-225,669,-295,-370,475,-874,-428,-503,-516,-590,-750,215,719,-551,670,721,-361,835,490,148,152,608,214,-109,8,-480,-753,445,520,-520,-527,-704,-850,178,-2,697,376,570,-733,859,979,-484,74,771,-36,-256,493,675,-421,-17,-177,804,-409,-962,-305,598,-370,-59,116,-777,494,589,-482,643,-160,589,413,-784,159,680,-925,211,-731,148,-17,233,964,-524,-19,-383,531,877,-579,-805,987,188,865,-383,-798,54,-88,695,-357,503,411,555,92,-175,770,-749,-422,917,534,-154,138,-483,-921,103,65,133,792,-331,10,-787,-137,-3,473,-199,686,674,855,-402,370,-429,-899,-146,-873,192,678,896,515,-744,814,50,102,25,639,253,-872,-295,-541,919,446,468,-795,-617,-462,677,183,-776,352,38,-105,-205,609,-5,648,808,-739,400,704,775,728,591,-102,-170,-383,-462,-843,-183,315,-385,-190,-239,-843,14,143,-306,-235,-600,-9,-810,510,885,-16,192,-47,-295,0,213,-895,-295,62,833,-631,-967,-264,-15,-430,-35,875,957,580,-315,-208,809,771,934,-497,-464,-666,493,-202,844,451,781,36,-595,-440,-890,690,-336,-186,-175,-430,255,-142,379,-759,427,-656,-811,458,996,-127,-750,805,-283,-816,-618,326,-409,947,-876,-492,399,978,616,803,-462,725,566,274,-388,-608,917,867,249,296,-819,-251,639,-631,-793,709,314,-544,514,-969,-287,895,356,376,843,553,956,315,531,572,191,-931,371,-243,415,-944,148,332,922,-530,-372,-824,219,-659,-383,498,-950,930,954,636,-965,-260,532,390,-884,448,16,-928,-237,-453,716,953,-312,160,-290,-896,216,931,435,211,-526,-863,460,692,-523,-923,264,-401,-992,291,-765,-958,-969,839,504,-781,287,-479,-637,-877,140,-921,-924,828,312,-141,-995,-399,-137,439,811,336,648,271,102,-802,421,-634,-204,501,656,104,542,686,-57,119,904,-769,712,-733,-647,-147,-582,-498,-246,729,360,-242,-670,-704,-730,-785,631,918,558,-267,-811,52,98,-15,-447,-246,-838,-905,-487,104,287,-510,407,72,-171,833,997,320,-665,-249,122,767,581,525,-937,851,812,766,842,370,-500,-969,-577,670,88,-25,-502,322,143,10,-573,-497,573,833,574,-525,739,572,794,-853,-604,-10,986,977,-485,-878,901,-673,888,816,769,-612,919,-735,-869,8,313,-372,-670,-471,711,-171,31,357,-264,-322,831,-525,-677,699,-305,-281,-311,-319,-231,276,-197,-257,602,-236,-441,444,224,-522,782,354,558,95,982,961,696,766,-210,-273,123,598,477,-46,-853,800,-347,-159,-408,414,521,360,-310,-603,-897,-635,160,-266,882,-543,211,664,811,-230,-241,866,-269,-545,632,593,254,-245,192,-196,781,338,-396,-492,-821,268,921,772,-299,-315,-757,-124,49,475,609,4,932,-106,-332,816,663,499,682,-533,-973,314,-940,353,-858,324,-842,922,-338,-166,-497,-87,-897,-502,-241,-124,182,1,752,-696,-524,434,308,-519,-672,975,-703,990,548,978,-470,574,365,-410,-72,579,913,85,575,-351,918,-922,561,-906,-425,-680,-30,756,393,-205,-866,942,-771,441,-577,-443,489,-280,-380,37,-229,150,-388,-790,812,539,788,798,-303,363,-553,-312,441,-918,-145,-984,-526,897,845,867,-308,978,809,-7,492,-695,549,-19,97,-757,-908,868,392,-224,-922,277,-612,865,75,84,229,595,844,-257,676,-301,-242,-777,-404,-324,-837,360,-346,-955,-646,-781,-650,902,273,446,-855,364,387,609,-860,537,-114,-473,403,-965,683,-295,629,527,447,378,-700,-722,600,-32,27,763,-671,680,807,-318,972,-770,-343,245,676,-125,-318,136,-443,-179,-326,443,420,-850,477,176,-146,179,-224,-626,-443,75,-276,-843,-883,750,992,-555,504,873,199,476,-897,855,-206,851,-197,475,-12,360,-631,661,-124,788,810,-647,37,-263,531,812,183,-839,-39,906,-683,77,730,-617,594,307,-744,-207,-217,-642,-279,649,-790,524,124,197,-116,492,-69,759,353,-186,-815,-610,550,788,-725,-194,948,235,-215,-662,-615,-485,-207,978,821,48,-156,-323,406,565,-674,688,89,449,-42,-954,14,888,877,-560,-225,-865,-171,-602,995,104,203,-983,-588,987,-646,-203,-497,147,-152,-603,-732,692,74,673,330,472,434,-581,-5,-608,-463,-991,-647,-513,-551,127,-379,350,524,-384,-473,-273,-368,12,-212,58,881,363,-722,-271,759,-454,-506,-94,-708,823,-548,726,-685,446,-882,-149,527,-456,337,-951,670,-969,399,195,-354,998,994,350,10,-218,-518,-109,-782,-241,693,-949,377,-813,-44,669,-989,480,468,-602,-74,658,249,-546,-798,-341,-425,872,-237,973,140,481,-954,207,-168,55,-937,313,-980,-720,-855,712,-670,522,898,359,264,981,-161,-268,-620,765,-610,701,-708,-408,-567,-134,-463,195,-87,676,-323,-42,-117,581,-914,-55,-33,-895,225,111,816,627,-294,788,-14,969,769,898,-299,-778,736,91,922,-972,755,-644,-34,-708,623,951,967,-700,-18,-77,953,68,941,-80,172,239,-895,62,-134,-190,-150,925,-220,-308,823,480,-86,632,-356,-164,732,-528,264,-302,-237,-112,-350,-197,260,704,726,214,-228,667,-866,-982,-94,-689,79,844,121,928,769,973,-307,665,526,606,297,-829,-484,29,-358,779,800,478,-260,-477,-719,-999,-773,-920,214,-1,746,420,16,-275,731,-832,-430,-75,-904,-588,-102,-139,-849,-576,-532,447,-333,56,-450,382,-92,-650,-140,648,-55,140,721,171,220,-65,-757,39,-572,331,837,-768,498,-520,156,666,-109,-873,-472,41,-376,-5,-438,290,-876,111,-328,31,533,604,-321,-522,-255,-600,721,-962,407,-962,149,908,368,59,-860,-133,538,369,-467,-570,495,60,543,-881,-872,-895,482,-749,288,-773,282,-106,831,-966,444,-351,-566,166,-241,913,276,907,821,-356,-33,961,510,-495,403,-883,7,-29,249,-376,163,377,-272,-355,700,-910,-129,55,56,-298,162,-499,423,595,739,-818,508,15,-910,403,658,129,364,242,706,-160,358,-213,810,-393,410,-27,-943,-789,690,830,-627,-365,-42,429,409,-880,929,-167,714,741,14,296,-244,176,-301,-513,-622,-864,728,-915,48,159,-56,-142,766,-646,904,895,-436,667,725,-63,-625,-316,-561,784,-197,-632,-310,-409,-891,703,886,-63,-47,-342,423,330,-134,225,487,913,-616,-569,-156,-777,-143,-179,-881,494,-511,843,-496,-137,-400,-58,-280,403,382,409,993,490,186,952,-500,-861,-317,995,541,621,220,102,607,677,605,-549,899,-537,272,-982,956,833,861,-467,-231,-539,474,562,936,-144,-29,-997,-581,-843,954,-82,-632,-290,-14,982,-669,-793,84,937,883,-311,-538,782,224,806,873,180,712,807,712,-519,-659,259,-957,-722,-885,87,-720,-467,316,-692,523,757,90,-490,739,421,-211,-104,431,-255,584,965,-473,-191,771,-527,-938,556,-720,847,-889,-379,106,-774,-102,294,312,250,899,-298,557,423,-541,-279,-994,-802,-858,-206,93,645,538,-250,684,-862,631,455,-316,766,85,-37,613,195,583,-208,420,-446,-914,-267,804,985,434,434,481,965,-845,559,-764,-631,-574,401,-912,963,-849,771,-826,855,299,-70,621,-616,893,234,578,476,-974,-1,-896,-815,804,907,-757,311,414,723,276,569,282,511,-989,707,-88,-902,743,135,868,989,-10,241,-80,-389,624,-114,917,276,-565,-983,-652,-462,-799,-848,-482,-484,535,932,-761,-189,574,593,-605,584,373,379,682,189,-413,623,251,577,-136,-756,-739,-438,129,-748,837,564,-732,-742,-825,-459,-591,-307,56,943,-375,367,-173,-801,33,294,782,-521,-327,537,667,259,234,-9,-91,-902,235,243,-268,-563,494,-358,-926,834,-101,-751,-625,380,14,503,323,711,-130,-777,909,975,516,764,-546,-738,375,-879,594,-391,184,-497,-221,-508,818,511,-71,312,-847,75,219,125,396,593,-495,-590,169,901,-879,-961,-876,-897,-986,713,940,-460,-952,315,-340,641,996,917,-782,-225,-591,-891,-641,410,494,-415,-514,-287,709,881,-620,-713,-708,548,-812,-515,660,-615,-412,746,-829,-472,-713,-782,915,19,932,984,-64,-777,-241,345,-669,191,-245,824,775,313,-462,557,195,-83,843,559,-535,-968,-956,-802,-511,-369,944,-341,231,-769,-124,219,249,-192,203,-814,30,-964,603,434,299,-569,258,74,744,795,-296,-61,-215,-380,-502,323,-276,-459,520,212,245,464,870,-451,694,-180,768,17,700,44,275,-196,79,-122,-762,-622,381,495,524,125,364,-699,-863,-851,-79,-366,471,644,248,-8,-143,-434,-544,-200,114,-776,619,-45,240,320,999,-412,-876,151,538,-639,602,-81,928,199,-955,292,500,-819,441,-579,-112,-88,-862,-791,976,67,-153,-494,867,-966,-271,486,-11,-958,-121,61,-371,2,-715,-833,435,886,158,364,86,202,-344,-414,456,-830,79,-583,155,216,-302,131,-643,544,636,-776,577,-562,782,-361,-448,-265,772,253,736,-942,419,245,943,-422,-391,29,852,337,687,381,507,-161,870,-265,-871,-432,865,-515,-815,575,-219,835,-914,-437,-526,-362,297,-753,890,107,-623,383,-575,-680,-966,106,422,958,-557,109,413,-977,948,283,-243,-850,851,-304,-366,-891,-656,414,943,-498,-950,-509,212,347,-190,103,-473,186,-441,-49,578,-335,-943,0,-377,-428,-817,-964,-332,-796,392,497,-647,316,-807,-14,424,-391,-527,441,111,-478,931,-677,941,-186,498,-532,-927,-870,491,650,-206,620,-349,490,-734,-94,598,-67,109,63,-570,461,-621,-304,-480,803,304,-8,244,-512,586,248,-116,528,-865,-545,-931,-793,-342,633,856,524,253,-420,87,518,485,-314,-476,-406,748,-46,-872,-799,649,-280,-996,26,784,320,587,371,-359,-456,-28,-225,71,40,-19,728,-254,-90,253,999,490,-660,590,48,98,-885,715,-80,141,915,120,-210,-364,196,888,-580,-411,548,863,229,-908,-165,-923,163,948,130,-36,-306,-960,-710,-234,602,-297,-643,-276,800,-456,-561,-207,757,-646,985,-380,-11,181,-492,482,769,-943,345,71,-779,-746,147,456,-798,-723,-506,-105,-610,-217,661,-935,485,-909,-212,359,-293,226,-775,-536,580,-789,83,-358,464,663,-876,307,792,542,-622,-913,795,598,542,996,874,-891,-36,-663,-108,-375,-598,-550,-212,189,881,494,-584,-893,-969,-931,-610,186,-290,853,-150,-93,160,-285,-478,538,-199,-610,209,-583,-614,83,-475,422,420,489,-952,821,-987,-92,83,893,-524,498,999,-421,566,-611,765,-650,-684,-312,329,475,402,923,86,-723,-687,-705,-234,-229,451,290,-807,-56,-147,-687,-162,-135,221,920,-242,696,419,-169,-725,58,292,-887,480,607,-200,-118,156,-724,-195,-685,-448,117,-317,390,887,-866,-247,-846,77,605,-534,914,-457,686,834,374,455,326,-795,803,-542,569,915,937,250,-211,-107,-594,137,697,-280,761,-112,402,151,-152,608,903,1,-242,509,467,-255,-948,226,-420,498,-245,978,702,-442,-564,345,-454,-553,-405,407,339,0,-456,109,792,-695,-930,268,455,-82,-51,432,991,707,-59,458,-548,65,-242,104,-436,512,156,-661,-857,664,683,-239,-889,-722,-831,522,350,-215,-295,216,90,-226,-443,-382,691,505,-950,683,285,63,214,737,-798,971,-86,-162,556,-930,249,698,734,6,-540,917,356,-299,440,-220,485,-855,995,-352,-82,-448,339,-317,-870,461,-634,415,-402,579,225,-128,624,-861,709,180,-791,31,-48,-984,-963,484,932,393,-742,372,-754,742,589,-759,-536,-419,-135,875,263,-6,336,628,-518,-993,280,706,-122,-23,845,-340,-769,-873,691,182,-858,800,-261,-853,266,-4,592,511,-189,181,751,274,761,-311,222,97,756,-441,-202,-762,-435,-921,-982,516,128,935,-824,358,-938,939,-387,-724,740,351,-578,6,-580,-986,-482,231,268,-658,-422,29,104,800,-800,-140,-568,-3,170,69,148,187,-415,-723,122,-166,707,256,-227,-679,531,-487,744,953,592,-835,-960,-817,395,307,-403,-954,-590,700,918,-391,-367,-650,678,803,419,-173,63,-923,176,-814,-90,-117,441,756,203,46,-731,21,72,860,185,111,-957,-347,-508,-287,-229,-26,-587,-310,582,46,39,260,-78,-469,-840,984,-319,335,-757,663,-781,684,419,494,-197,761,-412,874,621,772,58,737,-502,622,-550,269,-404,-65,-968,-749,980,70,584,-25,674,743,-40,-572,152,202,-909,370,-41,510,-63,761,344,525,708,-35,370,-160,-225,941,-538,297,283,131,-694,314,381,-714,-543,-35,334,-869,-218,-706,-369,933,495,-278,376,-472,-695,-687,-638,648,910,-929,-314,354,-17,534,295,517,-96,-422,-352,209,891,-970,568,-579,67,-98,-375,848,195,255,854,-237,976,230,363,-646,616,725,-998,599,795,-239,-47,-149,-705,-752,-632,271,-102,16,-519,-211,118,-951,210,-815,-50,834,-893,-782,162,-966,-20,139,337,-656,565,-47,-858,640,-375,936,-599,578,-140,-232,898,227,-961,-203,-757,-481,658,433,-360,-59,618,589,-152,797,806,-989,830,-140,149,167,276,-213,-807,417,-573,-182,426,-100,-531,-714,667,-560,585,779,236,901,-702,-105,334,-62,835,25,-400,-316,-178,-520,-306,-274,412,915,892,-312,-225,-841,-822,202,49,676,-898,517,-965,842,956,619,621,266,520,991,-766,-145,2,-858,879,602,-175,-225,-918,591,500,566,579,465,-746,-572,623,-496,629,-328,-820,730,-738,-786,645,-708,832,266,557,426,258,790,-646,-740,931,-767,934,-170,80,-911,-506,-420,654,-853,-954,980,-426,668,-516,-797,-586,-337,-994,-325,-51,651,-34,-145,-10,-477,-719,-752,-614,-366,-419,-609,-61,-412,220,-980,-323,786,-328,-596,932,-210,-615,-494,-468,-132,-219,-55,604,-140,619,-374,-416,-341,480,573,254,760,894,713,-533,-452,-896,479,135,323,498,884,109,-757,-711,115,33,-254,693,564,686,-525,-491,290,407,-799,989,-936,-68,469,636,-740,230,603,972,769,-776,-924,248,432,398,-181,316,-420,62,677,694,-832,-577,388,731,-890,935,-687,472,342,-414,461,405,518,4,114,777,-693,-209,822,-924,87,897,324,-481,295,-857,908,947,277,585,642,444,-918,103,248,-736,38,560,808,-547,-853,343,930,737,-653,117,587,-347,980,409,-272,68,379,-875,659,-326,-659,567,-306,617,226,-591,135,307,511,-617,570,-378,-983,451,147,-764,-206,150,-954,140,-659,632,865,-679,114,-406,461,-434,-209,121,312,131,-239,-994,-178,986,-585,-970,366,998,-588,9,-379,-499,-539,840,-264,254,-9,-219,-532,331,-514,-667,724,672,-1,259,-762,863,-547,549,67,213,555,888,273,969,990,-361,-959,-524,648,-339,-24,-818,-425,712,508,638,-507,975,-31,-21,-618,-234,-349,380,-975,-38,243,-450,-489,-689,763,-934,-728,109,-892,-664,747,-851,-189,468,-118,859,722,456,571,231,94,-862,279,-864,189,660,-98,912,114,-1,-126,-643,549,385,-260,385,523,85,-506,631,420,-686,779,-696,855,-339,-837,577,-809,807,-119,284,944,-839,493,206,820,-605,191,-66,466,-934,364,88,523,-823,-527,46,261,39,-250,-246,353,-398,130,281,263,293,-142,526,100,739,-117,117,972,-624,-604,792,-157,586,-200,-690,724,-763,470,320,-587,943,-560,747,55,189,-499,-592,791,631,688,127,-3,-380,-347,-830,-568,535,359,-596,984,754,-731,-173,413,68,136,211,304,-320,-469,790,-377,-30,537,677,-767,-889,-841,-903,814,919,223,-116,-388,948,53,43,556,-588,519,540,-761,788,-632,725,-71,576,-64,-693,-744,539,-903,-49,-417,706,-298,-112,816,-67,-16,704,-148,-793,-412,537,-772,641,-420,783,-874,-827,397,-562,-966,837,-764,-38,486,244,268,815,-217,437,-234,438,143,540,-674,33,-527,309,-263,398,588,397,-65,888,111,587,672,310,759,142,820,865,-21,-944,-172,-462,299,-831,-647,-845,606,192,593,-178,-268,991,927,278,374,-263,-324,-38,-865,683,-149,245,270,-404,-445,103,810,-625,-32,-138,-497,868,399,801,-962,752,-970,716,-56,695,-389,748,686,-461,26,60,275,774,-904,409,457,19,-272,-199,687,355,976,497,803,17,-641,-694,-41,830,-819,-4,655,-790,-215,-328,904,395,-579,590,-993,519,-276,282,294,-108,-236,-176,910,564,697,597,-80,673,167,-204,-236,598,101,722,428,281,-209,157,563,575,828,467,43,-678,131,123,841,927,-595,208,-181,241,-968,-271,-121,802,-601,798,475,565,-406,-688,236,767,-966,-263,122,-176,893,-315,-528,722,-774,588,-956,429,-289,957,356,188,165,-825,-571,270,-24,380,72,374,178,-380,12,844,-68,-679,685,38,57,-193,862,24,564,-593,-254,789,994,-138,218,-295,-107,-353,892,-869,-179,-605,400,869,774,-455,243,-47,238,-672,-130,-830,-279,-445,207,778,434,142,-198,-1,549,620,-139,543,-445,-920,-751,447,-274,-859,578,620,-392,51,489,-617,596,-194,408,-93,206,-722,76,927,-94,-644,778,-587,571,-347,411,193,-654,-654,-264,-100,-502,57,-652,296,271,998,-84,878,49,-521,-739,-282,357,668,624,-437,-980,-227,-437,-2,202,-586,410,-154,66,-105,-961,411,240,-153,-615,810,904,-195,106,248,-197,-904,126,924,-426,460,-357,930,201,-660,-434,293,186,202,-709,-539,615,774,306,-318,-258,344,-834,981,-809,-450,864,-832,354,-30,415,-770,65,-385,-845,711,-852,-130,641,348,209,-719,-285,-532,482,5,-72,97,-148,-766,851,593,650,-909,647,841,-287,511,-918,-932,-518,497,-630,619,-815,-476,331,-668,393,45,752,-324,325,-533,143,-120,545,-928,-949,-530,-695,901,-936,955,-935,710,869,-222,295,950,-82,776,520,287,468,704,811,-201,-964,204,844,861,879,242,-599,23,-804,-981,167,-754,-511,471,-780,-448,499,-715,-665,441,62,702,392,979,551,-88,266,20,-310,150,818,-202,-645,735,-341,-693,51,60,402,246,151,-431,491,639,-886,783,-736,685,-932,-328,127,129,-626,-408,181,925,503,-552,-55,-807,670,-164,-9,-975,-428,722,-595,695,-145,879,-59,-993,-478,-495,645,-365,-712,982,-607,-571,-346,519,557,27,-816,-188,-48,687,332,896,952,2,-267,16,100,377,-261,504,72,593,383,-914,672,904,-410,318,-388,-50,373,78,378,-973,-330,9,53,-146,820,-994,-459,152,974,-434,-773,-293,582,326,-843,-606,-97,228,986,-713,313,732,-736,975,123,-51,-74,-504,-973,-623,-478,-304,385,574,549,278,652,-837,-497,627,-198,-270,-593,-616,-871,-436,-150,32,864,-91,391,251,-359,727,226,763,-324,-775,-741,-225,-398,-220,544,-940,-645,166,338,-920,329,913,706,-796,-284,-886,-340,-155,-250,509,876,-386,-582,267,864,59,-6,164,-178,743,461,154,-409,-937,933,-865,-804,-639,301,606,-559,-297,519,-780,-94,-764,-594,565,80,155,74,29,842,491,-631,779,-377,435,-57,518,178,-595,-328,842,-460,-395,976,-192,39,277,-586,479,979,-993,771,-42,-685,-822,-477,467,332,669,-504,247,234,-63,27,856,-628,-957,374,623,-480,-881,465,60,-203,441,867,835,-208,-645,387,-229,-639,158,802,-252,408,-675,-785,-259,994,-290,-939,228,646,87,157,-909,130,-395,713,649,-277,251,-218,592,-307,-277,427,484,150,-113,-672,510,-881,-870,-742,526,-472,-455,-660,-405,327,-599,822,46,560,52,136,-237,656,-77,-514,-547,-826,267,-955,-134,-937,545,-577,212,-568,-176,-205,-377,26,125,-850,626,669,-511,-779,-4,-111,-884,-958,-477,168,178,285,-103,-826,770,422,-653,111,467,286,173,85,781,-614,589,-322,253,-787,704,-621,-638,403,-952,-77,624,44,885,739,158,-592,-20,-591,692,877,-418,536,299,-71,-353,-161,-785,819,996,995,-722,586,-326,531,798,-549,909,-767,853,-970,155,550,146,113,363,-695,520,-657,-287,286,-707,368,-178,665,-703,468,-423,-416,360,-426,-348,638,-767,398,242,-896,848,224,-664,775,253,563,325,-527,-323,-239,-223,-730,104,562,555,469,-70,-623,134,299,844,711,882,278,-642,-465,-11,-410,932,-769,-307,854,527,28,629,-147,-336,27,325,413,861,-898,683,-35,737,238,-566,-333,615,641,966,532,352,848,-117,709,-544,871,-628,-538,-898,64,-684,628,-835,-982,-518,-172,117,806,-758,-22,981,997,-984,718,235,-550,-542,-77,-909,-576,-471,515,-654,411,297,-126,283,668,335,457,-268,650,159,-31,667,713,796,-142,519,-889,835,573,-819,851,364,416,-626,822,-588,-463,-681,-60,-948,-336,-648,421,611,707,89,-54,164,893,-403,-677,-138,-663,-964,-269,194,628,-85,103,274,95,-46,-361,-416,400,-466,-4,936,-148,935,-939,589,-640,481,200,-933,-430,-854,304,-464,-185,626,397,152,735,-799,-581,436,115,521,-290,-716,-452,348,-133,947,881,862,956,-193,871,-983,-604,-769,497,595,-629,-860,813,747,-325,-371,446,-855,853,181,-654,-728,-383,460,866,400,816,-586,-252,-316,-565,-297,-381,-536,509,-510,-519,977,-206,-949,645,237,-809,458,-16,-62,-913,-570,83,939,684,428,-715,-699,-39,-849,773,-222,-363,-478,534,144,297,-847,608,-121,-284,-838,-144,509,-715,-426,-181,-452,-968,802,486,-808,-695,-431,-869,988,-930,-512,-637,103,-362,-864,953,348,-270,487,-508,-900,713,-827,-22,-571,-593,906,-989,-308,-520,-171,239,-488,-296,-202,-224,8,439,-21,70,508,467,505,-315,-822,640,-362,525,-556,-801,-909,-457,984,-737,521,-587,-330,500,-504,434,980,397,-254,-435,-899,544,340,181,-17,-681,-749,-435,858,828,249,-963,469,959,561,985,-769,651,-472,-785,987,-878,-300,-270,622,195,-836,675,-408,-91,-687,-235,-547,652,946,509,-956,-730,-926,902,-828,322,938,640,354,572,625,585,224,-774,799,211,-652,-500,-986,-957,767,-823,717,-640,158,-970,197,684,754,216,193,870,559,266,845,730,-339,783,443,-985,429,141,672,-347,366,472,936,786,-955,949,828,811,-801,545,-756,356,647,441,40,474,-343,-767,345,-784,571,190,-981,-695,47,461,-607,-524,-398,-935,201,968,536,137,827,580,159,656,465,357,274,708,-214,-78,149,826,-604,879,-868,813,-832,776,4,-813,-919,-949,720,-527,-401,-677,-462,799,-636,-853,9,-809,800,-832,919,265,597,194,46,-617,-884,-731,-718,-416,-852,-513,-602,-612,-737,474,-353,-657,524,-632,-111,-804,-237,426,994,199,645,76,462,518,243,382,-217,-87,-424,902,368,-236,-829,650,347,-609,-863,817,-149,-601,291,498,-186,-112,938,702,83,-226,201,150,-954,-80,-774,507,-562,541,-38,294,-473,537,196,895,-626,439,545,794,829,754,611,-320,-774,-24,-749,39,936,-738,-185,20,35,-984,-757,153,8,-458,-339,446,-844,622,-187,-317,233,-991,-422,679,447,-804,473,349,949,158,-898,-825,-866,-647,286,-930,-313,-899,162,795,-810,478,-52,197,-907,608,-284,-752,304,528,-70,-390,609,580,-711,129,775,762,-522,797,-7,-420,971,126,5,258,268,764,431,-496,559,620,-945,-492,-109,-853,-811,606,-606,492,208,397,-825,-183,-23,-536,946,-174,-774,-503,-377,291,149,-332,-583,-773,998,757,991,429,-666,550,123,-612,-869,-913,-393,-680,765,1,884,-27,-529,-940,863,447,-477,882,-654,-179,-621,-31,-888,528,636,-399,827,634,-569,818,136,-162,442,-668,225,572,-582,905,964,-816,-94,922,156,449,981,92,-104,-423,-26,242,470,353,-716,654,-46,992,-745,-219,699,-242,-327,-165,595,-812,167,-106,832,657,-201,797,840,777,719,70,226,773,-838,-805,-650,136,509,892,-438,792,546,588,784,873,-631,556,-369,114,-608,-700,301,631,193,134,361,-935,-69,202,841,-277,-655,140,-431,-421,334,-82,714,-156,-117,-651,-291,-571,936,-433,-698,-621,-877,5,492,-413,377,-206,-709,-357,-999,652,-293,4,-73,-379,726,271,760,-705,849,168,285,637,-915,-832,-941,-207,-331,995,432,43,-553,628,-952,938,-785,498,-195,-421,-859,-195,-769,-152,808,230,541,607,-499,302,974,-577,-457,332,-940,-373,572,-808,492,-759,-813,-75,283,-367,-374,404,-356,-87,-98,449,491,42,-673,794,962,-791,24,577,888,597,-48,863,-979,494,268,-847,-879,-159,-656,685,154,-397,-317,-562,308,308,914,952,-778,-111,474,785,-996,873,580,966,-918,-323,616,970,-725,-432,906,-632,-938,174,-480,-745,-912,-63,939,242,612,-304,752,-79,-996,666,-54,-702,-445,-580,-916,-442,-634,736,-403,-479,-587,-787,-436,-313,-220,-530,54,-86,716,647,168,804,-343,181,119,-731,876,-129,262,952,-463,-792,-749,164,-300,-593,721,66,-857,-608,586,-445,-323,-850,242,530,-308,-631,-556,-519,-911,685,-642,-182,-61,476,87,-112,-653,-578,-160,-44,-370,90,-880,402,569,914,-459,711,-694,-800,-733,55,-578,581,-415,113,949,102,667,-888,-140,-975,-71,871,574,-911,-241,920,-489,598,-123,213,-238,69,-385,-669,-17,156,-957,361,355,-618,-583,777,962,74,-37,984,-751,-370,-904,181,-272,98,52,-698,259,810,-705,769,482,244,55,-683,-686,743,-280,369,-101,-238,-269,-673,216,220,-823,178,-633,213,236,-384,915,331,796,-357,-498,-78,17,761,-268,312,603,-713,-371,-268,-397,-58,-525,323,-615,446,-842,115,845,374,-592,-977,-375,-226,235,860,462,150,265,332,866,766,-746,-117,600,58,-732,277,345,-103,-918,947,911,-444,343,-704,-998,501,483,846,-52,963,941,572,-262,249,433,-727,-527,-229,604,-661,-463,857,294,-789,-11,635,560,-666,-395,641,-719,-484,-730,697,-115,-729,198,-559,-810,-854,-595,-795,790,215,453,296,487,998,-933,165,-590,-323,95,704,-40,-916,339,-480,-583,943,-766,-229,-468,-497,-532,489,-154,738,930,108,956,-665,312,746,549,-161,43,109,-90,109,-653,320,858,442,24,-182,598,-564,337,-984,-548,643,-141,56,-854,399,-454,-9,137,-524,-827,93,-117,557,-88,-495,-531,954,686,379,137,-966,-301,-5,475,795,813,73,-696,223,161,-172,-133,-907,883,85,491,-498,-850,-372,50,-678,793,932,878,-294,-563,-652,-267,-876,799,942,-770,-502,-62,777,-707,-176,-77,-404,-880,-915,496,59,-750,379,-855,741,954,-633,-558,4,-312,-691,-63,-361,14,446,59,819,642,-142,762,871,428,-227,721,720,596,-355,-611,788,-198,884,-152,51,337,65,-135,291,431,380,-705,-808,688,304,-97,-225,-176,962,-406,-461,-107,-644,-516,-678,128,-795,-885,-203,-151,-423,-414,650,-466,506,-298,870,-356,639,234,-925,19,602,-661,-293,-94,241,554,802,276,-851,-658,-757,-423,-175,-436,778,29,-249,-352,951,327,306,601,861,-188,-624,804,528,-984,39,602,107,-359,-986,887,619,328,441,422,-396,662,836,-154,-760,-339,482,-909,762,-766,-262,713,633,-955,388,567,-71,836,372,-542,924,-516,-867,32,197,-780,-81,-184,547,-567,-689,-776,-904,-780,70,-665,-47,-375,-502,-284,-69,235,-498,-362,352,962,-795,-645,799,576,-115,796,-867,17,-172,329,236,819,-781,-144,-747,-398,80,-652,-178,-777,-245,774,-153,325,-437,851,-440,138,-511,985,173,-307,-660,45,-657,224,-158,-525,-686,742,877,623,562,-904,-521,887,-303,558,-692,518,853,62,366,-299,-540,928,-375,92,139,113,77,-687,878,489,357,-706,-214,-801,-231,173,941,-354,-204,576,-186,347,463,510,-21,843,29,-168,-22,-605,605,437,-604,-770,-471,535,342,606,847,294,168,277,587,954,476,-571,200,490,147,995,139,960,415,-325,471,-606,-482,-427,226,495,40,-169,-68,435,61,460,43,-524,139,-110,842,-619,-759,430,-592,716,931,607,279,79,675,-582,39,90,92,-417,484,682,155,-217,177,-805,613,-818,703,-253,714,-254,296,-146,709,138,307,949,-359,714,738,-354,321,17,724,-4,434,-164,-841,-401,419,642,-719,-353,-575,530,-158,-888,711,-455,-69,425,363,-700,-648,72,438,658,21,-848,372,-241,-203,-234,775,-406,834,282,430,993,953,-78,635,-766,568,-866,763,-517,-682,547,27,248,-27,-536,548,397,535,59,56,-370,283,-499,388,-846,267,237,-253,101,-408,-750,94,-454,244,-197,-148,-187,-64,-311,295,326,-691,-604,-353,281,-141,-805,-248,-533,326,807,96,-317,-692,-442,-164,647,867,655,-178,-541,978,915,77,222,-209,-997,-892,799,-236,476,125,72,944,772,-573,-124,-960,178,342,439,58,-488,-878,438,69,30,159,-64,-242,980,467,-191,968,-382,-895,-240,-380,-715,-441,456,760,757,-399,704,529,100,-347,641,-722,995,80,408,-493,274,-153,648,-623,-994,-416,208,-941,-876,-983,-973,-259,-806,-214,433,-521,418,-38,-688,175,563,-910,-223,-337,-258,-582,14,-190,571,-578,389,-155,341,37,295,419,693,-497,477,817,-408,577,-369,-141,-564,-935,410,853,26,721,101,-338,883,877,325,-301,-704,-588,508,866,-167,-102,-216,-752,-992,-848,739,701,-273,290,591,392,-133,-778,-676,375,-641,733,229,458,527,-670,-880,411,-792,517,-817,-424,928,690,-485,-165,-339,371,155,-331,596,-106,-557,-677,-743,-966,787,196,-745,-889,-428,-313,843,800,-855,444,-797,-663,-72,-517,927,110,58,855,-200,645,-237,534,17,917,-797,-387,-115,-282,8,214,-249,-204,-589,78,-94,-18,764,-177,-145,981,-733,57,-608,194,540,-681,-623,-329,-753,249,-683,10,-217,406,0,58,-908,957,775,99,172,-474,967,655,677,-53,-363,514,842,491,496,-891,-379,960,375,-766,-648,751,-22,-402,0,367,680,856,-227,-246,-86,-63,-216,-310,-891,955,288,-923,610,-35,96,-680,-520,-62,883,-951,119,-495,-918,-506,-189,-567,-682,788,30,390,155,-216,246,-999,537,-766,-63,-679,-77,46,-650,-716,195,-967,322,-636,-647,874,301,-764,995,-580,-187,-923,-14,624,-491,376,485,611,-234,-359,-605,-914,-286,-995,-681,651,-601,314,-230,-252,670,-962,-220,-8,-599,205,-134,774,514,-66,-733,-600,10,325,-903,591,-299,582,203,539,-704,670,697,9,748,-984,-267,-853,402,575,-106,73,685,746,-862,-841,25,77,932,-461,-989,-728,-62,21,596,35,-388,-703,-310,887,909,-15,631,606,-933,379,695,-127,525,97,-552,-508,-757,-866,-689,-546,-708,335,530,-702,873,540,-431,-115,-366,-834,992,319,-465,-318,279,-556,739,-90,-876,878,-638,818,-249,959,-85,199,-549,231,405,-238,684,769,-903,287,-933,-956,-100,-291,1,534,-53,-7,-74,481,747,-795,998,486,188,-878,364,549,939,-884,509,-73,387,-967,-769,-208,-133,987,-439,37,274,-299,80,-825,482,-919,708,-571,146,-293,982,-107,-89,980,-548,-828,-825,815,721,-813,-996,303,187,463,335,417,-745,-724,478,-111,312,-248,662,-608,-74,144,-455,-293,572,763,486,554,-344,-602,608,107,-431,855,-5,-637,-884,72,738,302,-465,147,-208,-137,422,-730,751,-266,95,413,198,-906,-443,815,-199,-798,578,-713,828,-693,-243,436,413,399,365,-519,834,480,625,573,-218,-766,-207,646,96,-785,916,-80,21,84,-594,-781,177,35,-966,977,236,611,-662,64,917,167,-426,403,-361,938,956,-526,418,655,-880,-727,888,-88,918,57,199,907,976,-780,-9,-545,-562,-831,562,-456,-781,-129,-772,-371,934,-782,869,-419,693,-492,-408,722,-19,-917,377,173,-645,265,-915,-653,-605,283,-746,-556,502,318,-102,-987,486,-540,-444,777,330,-144,-520,338,73,-651,991,-234,-144,-416,-511,910,-334,865,83,94,204,241,440,671,-476,766,-884,-900,84,86,-815,-357,619,-186,-579,22,669,-27,-640,-257,321,-575,508,-750,81,-930,-840,819,-991,243,-87,285,-443,-647,-44,153,-880,71,252,276,-769,510,919,849,-676,-587,-129,992,385,304,-265,-294,728,-683,-45,-118,-541,188,-299,-533,-496,614,751,60,-960,-219,-787,-768,924,538,508,-845,48,500,-996,371,912,-125,363,370,-821,-828,-851,979,-439,176,-139,19,-636,561,559,-133,248,310,999,361,-836,-787,592,-911,750,173,-757,-129,-327,-753,-758,-342,194,677,-972,445,921,-824,424,-445,352,-642,574,715,991,133,-344,313,-484,-345,-326,-247,-133,-734,-159,-310,512,83,560,-815,402,874,-84,-404,625,-57,-886,619,119,537,-825,-456,967,821,-741,-967,27,-13,345,615,642,-981,-632,-418,-643,208,345,941,-708,-22,-800,766,-74,115,-564,-376,-942,-451,-757,249,-840,-510,792,-873,-689,-875,-841,337,111,576,-47,-174,594,320,481,-975,-398,-101,965,-107,876,-835,-268,-125,279,167,498,410,716,814,-341,875,-696,-548,-925,-312,-351,-766,-975,832,882,50,-341,477,-556,-787,574,45,111,612,-989,60,777,-258,-991,129,909,579,-461,698,393,271,573,770,795,647,-542,-556,953,-445,-724,836,605,7,386,-951,219,33,93,-597,-355,103,536,-505,917,544,624,826,123,-764,597,-410,506,243,-640,301,-36,-110,744,-10,444,-906,-101,49,100,-715,170,-607,390,-664,-205,-964,438,-669,-470,429,947,-846,328,144,-537,-74,733,968,-831,-834,270,132,55,87,-877,-501,180,21,621,-646,379,-136,-254,-231,200,540,-123,-289,944,407,-860,964,633,468,108,-904,-533,-159,-862,-365,79,407,840,-866,-433,-964,-294,747,129,-600,-826,-492,263,-81,350,-464,-541,-773,247,-524,706,459,-559,413,-73,548,581,466,-537,718,-898,541,198,-985,748,765,-950,-546,585,178,-147,758,759,-811,-323,109,-275,208,408,971,684,188,503,-802,-399,-569,745,-818,896,-719,900,-929,822,98,-915,570,-64,-793,-903,-479,385,22,-721,217,210,-45,-674,-992,-763,806,-948,920,-6,555,-882,594,-941,935,849,-972,-783,822,-901,-888,-80,-744,754,856,-464,923,-550,993,-55,-271,210,-772,756,535,-764,992,414,-640,985,-591,914,-824,-924,972,-888,924,-999,-599,746,-828,-415,-260,-500,-661,-404,108,-738,45,101,279,846,-689,506,603,918,814,668,333,-825,727,741,-838,902,816,-792,-913,814,-719,-440,560,-548,144,-700,24,482,-32,-867,816,-913,306,168,932,617,-325,608,608,-438,350,-59,-191,77,-245,-29,-21,-355,178,139,-541,458,698,-981,982,-157,-681,79,-602,286,284,-712,372,-409,455,378,-719,-797,59,888,-235,-591,-170,573,485,657,-383,-462,-698,867,676,-240,398,374,-221,453,-783,170,-467,-385,-471,889,-25,974,-520,-570,352,-167,-367,-589,-278,397,-180,624,43,-622,281,733,-85,583,673,-409,-657,72,-961,194,-475,-745,-636,57,-58,-107,-53,916,-133,499,-580,-708,-667,52,-298,127,-478,594,-249,637,-954,-968,443,33,614,117,697,-969,-811,735,224,-287,-937,588,843,78,-446,-137,-6,493,-565,486,784,-233,-462,-441,966,132,-773,-283,-230,-728,-251,-787,304,-564,329,1,-534,590,-191,763,-696,-128,424,-780,949,977,82,16,470,516,-497,254,-643,113,885,-604,-754,-888,113,88,-617,934,300,760,-630,-297,-166,-91,-707,643,-255,-331,-485,-831,-39,-463,-854,-957,552,688,632,-872,15,-938,241,-100,-543,486,12,569,-426,467,576,946,300,-980,-278,-865,1,88,777,745,829,-635,913,-209,-99,-868,-94,-547,892,-462,-346,-93,-328,894,879,129,453,-36,-229,-900,-568,-652,-881,804,-560,-159,938,440,-998,788,185,830,-847,171,-306,53,302,600,579,194,-862,-767,-826,-117,-800,-947,-988,652,90,-145,751,594,275,869,398,714,-217,337,154,-216,125,-588,-312,278,582,381,-596,-116,-19,-944,-849,192,-712,-603,-925,-440,-477,-841,-788,612,86,962,206,-638,905,-396,-851,-312,940,303,545,139,787,-767,-510,370,686,-107,-673,-332,22,-522,932,382,-53,-920,942,469,-762,-846,81,396,-810,-640,757,-832,-36,979,-145,-23,355,-527,-884,142,-222,-322,-488,-535,644,-161,132,-334,389,137,-952,-664,216,989,878,526,-856,-41,-78,-594,392,-320,-427,-644,-268,500,405,-913,973,594,228,-249,-728,740,215,915,-348,-580,-419,-959,629,-371,-551,-155,-309,-673,-629,-166,359,293,312,-249,-954,884,179,-223,458,-416,-137,431,-822,-909,-745,-477,903,543,-562,-445,-964,92,-332,665,720,117,-490,-589,516,-119,318,-125,-753,-297,698,-708,-412,-123,141,-954,534,-996,549,784,-833,876,-693,-929,419,-182,-302,455,909,366,193,702,-444,775,-814,-928,-271,503,20,-25,-793,-209,339,-133,741,-520,-15,275,-517,-466,132,-350,-517,439,-207,902,-670,563,430,-761,2,-377,-986,557,-602,-801,702,127,702,-205,-825,981,585,514,-79,326,993,905,-326,-523,-488,806,199,-6,318,-935,-31,720,627,-528,958,-370,94,971,-740,565,-757,-965,-235,-982,-98,-61,998,-512,-474,-8,886,-480,-30,-366,69,554,-487,-659,-378,903,-595,590,623,-895,-937,654,-193,229,698,67,-133,940,174,631,958,-923,-356,-970,-363,169,22,-404,761,991,229,-170,619,814,170,-759,717,647,830,340,752,965,-6,-441,268,-308,698,-865,-367,-54,839,-409,22,-517,-307,731,724,714,-600,486,779,629,-611,398,516,559,638,234,279,541,-426,31,507,568,663,-225,-667,434,-18,38,-620,-179,628,474,303,-678,205,101,-891,605,-413,887,307,-25,285,-177,-393,-4,-943,959,-462,-296,-10,-882,-655,-274,-35,-323,-839,946,715,-460,-232,416,-985,-856,810,292,244,919,-30,903,879,-650,-48,238,173,558,-766,302,590,-156,-921,-419,-39,-577,379,998,100,539,945,-112,-847,-287,-696,-760,-144,-885,531,-826,-893,-425,-923,985,-76,28,296,-830,-340,530,545,-750,-553,623,-97,408,-953,-717,479,219,894,424,-893,-953,-790,-590,-714,66,-403,890,312,-224,-535,388,-165,461,-510,-869,631,149,733,249,471,-819,-128,-625,661,-9,-270,140,-790,-376,-435,-684,-329,-226,-201,29,912,468,-8,224,-755,529,-314,79,-9,175,282,-305,-603,16,943,867,196,-112,-758,-143,879,-29,-930,-838,668,-366,-449,-661,481,422,440,466,-110,-567,-309,207,-965,449,-641,25,-376,641,792,93,-343,808,-40,925,-230,275,-145,-278,-681,-76,-117,986,631,433,-602,112,-72,838,-422,891,-656,341,98,-622,-210,530,476,486,171,341,-421,900,223,612,825,992,-113,-320,-286,205,603,596,265,307,103,662,-581,-969,573,70,921,916,-589,93,-632,274,-377,916,-167,866,257,485,766,-447,97,664,-455,-943,-583,258,334,-980,-72,-401,327,-896,-738,818,-793,834,-112,-798,824,372,294,-735,-281,989,-819,551,855,510,109,694,-936,-721,358,-319,-665,774,-987,742,866,-60,-659,266,116,-325,158,322,-417,-881,523,-520,490,-110,-256,-791,-48,-3,833,-120,-420,-58,-426,-284,221,-995,397,628,851,482,370,791,-578,784,130,610,-468,-639,-68,114,-520,-471,666,-957,491,-590,-748,-556,479,-842,323,-940,172,970,-152,-534,974,-682,-905,899,799,537,690,-706,394,-107,903,926,254,-91,113,733,437,-220,775,1,262,-900,444,-185,-670,-232,-53,502,-262,794,967,-215,-887,-865,-316,911,672,-553,-794,66,413,-818,-8,-333,90,-821,-527,-400,-42,-752,601,-707,-579,45,107,-250,885,-873,-675,-304,921,-707,554,-893,-573,-762,-982,-828,-242,-704,238,-829,-522,-697,-90,567,-519,382,-832,511,702,768,877,-804,-114,57,-54,-228,184,270,540,105,635,94,211,-864,405,301,-693,-837,670,544,-594,-852,920,388,787,-526,-230,-972,-941,-455,868,935,-259,-245,-8,686,599,-751,29,139,426,-262,-766,-363,-127,638,-988,179,873,681,-203,-648,901,-283,739,688,263,-418,716,321,126,584,256,866,-588,-678,625,-989,-430,-272,223,996,465,456,-294,-589,167,-210,589,113,-529,-541,464,-628,248,276,-866,-488,857,922,832,-17,506,89,-77,991,483,-379,-998,-874,348,224,-878,-114,-247,-99,296,992,690,-41,105,-765,490,-358,-321,-261,917,-188,250,847,-266,82,-96,-686,-756,826,-695,726,-480,-621,925,868,676,-953,-173,-571,20,-803,-505,-216,155,672,18,-282,-685,696,456,-695,-418,-294,-774,315,788,129,701,-895,28,-994,904,547,-615,829,488,-939,948,-684,-438,-31,-415,129,825,812,-198,-84,-470,189,-315,986,566,266,-308,791,-345,-447,-7,-644,-269,-979,-638,-365,641,-181,-536,129,-48,-588,517,513,453,-898,-284,278,913,517,-806,-483,-221,-121,-497,-655,-782,267,-863,-128,820,202,228,-449,223,589,258,-63,-592,721,-934,432,-867,656,-55,659,830,733,10,817,250,204,-666,-971,-844,-164,-553,-627,-897,-344,245,995,857,-527,-381,153,-865,876,-910,-385,597,-844,-953,803,884,64,535,714,-202,-455,531,-879,821,937,-777,976,-154,-331,-577,-51,324,740,17,254,-787,709,-592,-580,585,-503,34,256,-275,153,132,-391,-783,-333,-603,14,211,-999,208,33,938,430,82,-216,-828,504,805,495,244,-104,-251,529,-395,229,-978,-810,726,55,518,-549,-792,-350,133,-502,316,529,584,-399,602,-208,706,540,-778,-212,-602,-607,-634,-797,960,682,171,-217,285,775,-988,306,965,810,-565,483,-738,-358,-793,467,212,522,69,-203,-804,-329,588,901,-715,883,-310,-318,-651,128,-43,-617,-190,-871,165,-905,903,249,474,941,133,908,498,467,-377,704,-66,835,299,-997,-368,495,-327,-707,396,30,-824,-841,711,-475,359,-258,-93,-757,-130,-855,-663,-154,466,883,-139,-401,791,-641,-934,-585,-864,72,-677,434,74,-46,2,820,246,-528,-150,495,-297,-365,-980,-937,376,-1,-695,-754,216,-286,164,-318,-402,-975,354,-611,-544,419,-124,-409,-508,198,-901,638,-775,173,531,544,644,-618,39,-652,16,131,-590,-535,-797,-213,-290,418,500,946,-827,-902,-955,526,-440,-500,19,508,164,583,-220,335,221,77,-492,-247,-379,-774,207,732,-427,-704,-64,55,-240,138,841,542,-371,341,488,-125,512,532,-526,-928,-894,492,652,342,148,-568,-323,-557,509,257,268,-797,482,-525,935,-945,-230,-56,182,602,-844,23,144,-216,-635,-295,731,876,-689,-794,-979,-511,697,745,830,-81,-822,-420,361,759,836,-371,961,319,103,969,446,945,-86,-371,620,69,651,-236,925,-911,541,657,-962,851,862,-869,-660,632,876,-830,-449,-873,-251,984,885,-341,-387,919,977,788,889,496,806,-124,-875,426,-982,849,-810,942,-989,731,672,-878,655,607,-748,995,313,-799,-762,936,-673,-13,921,-715,718,-466,-795,695,-677,-833,264,-871,115,389,628,132,311,817,147,394,621,-180,515,277,-500,840,345,812,-959,582,822,-559,-358,743,-202,-640,-650,75,-872,-255,314,392,-53,-571,-146,-425,560,-762,-535,-292,631,-913,600,220,436,-900,60,-146,985,173,-564,807,686,151,623,-515,583,972,632,711,-282,-53,176,737,375,-970,-688,9,-660,-224,789,970,-65,389,190,-629,561,-677,224,619,496,733,499,255,-43,122,812,-460,168,445,-676,958,-535,572,695,912,674,-993,-79,-986,-145,-217,984,790,-828,247,-766,806,570,458,425,139,264,-2,-606,-706,-880,-793,-94,360,724,230,391,-811,-198,86,-899,-450,165,95,-437,-979,877,-453,810,-877,867,-956,-998,437,574,426,-351,-89,-576,42,204,-383,321,-889,-950,45,413,441,306,-712,-400,480,-163,765,-425,400,858,-475,-980,668,-280,886,784,-279,396,432,-779,-882,-584,-356,160,620,333,-446,803,456,599,289,-103,-95,649,496,-615,-513,334,32,959,192,630,-948,-67,-650,-988,-209,71,480,-777,291,598,-362,-992,-169,-669,414,384,-793,-130,-17,568,839,961,218,408,-581,777,-257,451,736,934,81,860,-59,503,871,731,-426,352,953,864,-50,-336,945,780,68,359,237,274,-698,-779,-84,-859,-745,-866,548,-327,910,-636,-803,719,-628,350,579,312,-146,524,43,500,-51,69,438,971,805,383,824,-127,-185,61,-779,116,354,136,329,608,269,-123,-645,252,314,-376,-29,685,974,-377,-3,-99,-780,-887,-599,168,254,838,139,59,294,-37,932,-891,-975,-774,297,378,361,-374,60,-297,576,414,-972,-110,-962,71,-425,-915,693,644,-15,986,829,459,154,83,297,-706,-858,-335,329,-853,-227,426,-628,-856,-195,805,-231,937,-419,-655,424,-392,307,461,678,881,619,372,598,-323,431,427,-864,-415,-490,506,-49,-275,-829,-646,-129,16,779,316,159,-343,121,-998,-406,702,-581,-982,-690,726,552,988,680,244,433,279,920,-136,-221,-943,521,289,635,-527,-986,805,-174,-43,-106,-395,-727,-873,335,394,-872,928,169,-381,-980,478,-655,571,539,-974,-185,45,377,-265,981,-771,-136,503,517,-501,-951,603,-623,-53,-439,344,624,-94,470,-41,-700,670,-112,541,-638,-93,93,-293,-449,-295,-195,438,750,-745,-754,731,-517,110,307,-926,681,355,749,-868,-698,-617,475,926,289,18,-42,661,-239,845,203,122,-175,-631,901,448,73,-294,-114,-177,33,132,-372,516,-685,934,662,995,290,411,-800,664,867,674,663,156,-235,-378,-110,525,-460,-907,-279,438,-539,-378,-41,534,401,845,-570,-493,-23,57,-904,364,65,757,359,-572,242,559,-908,109,306,828,-662,-928,-477,227,669,135,393,-537,-427,853,158,532,460,-441,450,963,65,-500,93,161,863,-842,-9,295,-415,-767,-146,-323,414,-766,-422,751,-622,100,-21,-880,-765,-628,-417,-119,-702,740,-514,831,-628,935,794,436,-565,-113,-330,-702,45,734,592,629,966,-480,-621,381,-174,29,205,203,-871,-816,395,-563,-445,977,317,-74,790,802,-243,-838,810,-376,671,-755,510,-586,-385,-372,-852,-720,-669,-812,-201,-291,641,697,811,-154,-27,939,103,-631,-551,730,-581,765,-344,-790,640,412,-629,450,-964,-885,694,619,-471,-618,-753,-324,-338,-350,-64,460,432,-423,231,243,423,-796,182,-474,-428,704,-671,64,469,-15,273,183,-530,716,-367,-421,831,-599,-802,-567,-218,-483,181,443,167,-882,-23,-401,-306,-792,841,-810,-516,96,-212,129,-200,117,-807,-657,-825,465,525,-356,254,-769,222,85,-369,419,517,486,-990,-301,-71,249,-111,978,847,582,-741,761,845,-257,-70,-294,871,803,822,-863,-781,-930,674,816,-286,-72,-953,935,-986,-249,428,603,-763,437,-625,238,-314,263,217,-394,-81,475,-560,-236,-709,442,469,-765,318,365,-629,536,434,-955,352,-852,-27,472,-843,59,-704,584,-338,-468,94,110,842,852,-627,59,-469,291,-392,-30,-945,-102,-588,597,133,803,35,576,339,-458,621,-235,-237,-333,-690,-81,725,-395,-424,-540,209,669,569,51,594,942,-816,-875,306,-136,94,361,761,578,31,-33,381,-934,-456,-206,-320,-762,631,442,-96,940,-639,-298,-382,9,161,826,-249,-269,-50,-655,-254,133,-531,-948,996,635,485,831,214,-484,-129,-332,-346,487,534,334,724,165,-151,-299,178,283,402,795,-708,-436,694,43,367,-355,387,-887,777,929,-763,847,564,722,678,-149,-689,-451,592,38,-890,126,-555,833,-635,293,-465,542,-351,-990,411,-59,-354,105,983,-987,749,443,-802,600,372,-565,447,10,-770,125,860,-387,746,525,723,855,-348,-759,762,89,534,-630,-296,-744,-621,-885,196,25,293,252,110,42,-231,308,-285,-859,815,-838,223,-882,359,157,-197,179,-318,-473,107,406,-233,-131,-505,-626,311,199,-370,763,386,825,-139,-321,151,970,794,919,351,-491,-867,239,-256,356,356,-897,-414,-840,354,267,-241,-538,-253,525,403,314,972,-285,-414,-398,-522,972,-500,338,-276,650,381,-409,642,-267,100,775,971,916,204,328,-908,789,560,446,56,-681,907,875,916,383,190,888,-902,775,-437,-352,747,136,985,-455,-141,367,135,-498,-827,-692,-723,-856,-776,480,544,-684,269,177,834,-602,568,814,-653,558,197,536,446,295,311,-917,-984,132,218,-998,676,-923,441,-116,-349,686,192,-73,829,488,-520,447,876,821,-303,710,-707,-734,524,-361,823,-205,-825,342,-837,485,424,-822,-310,-285,-748,-634,-135,765,250,515,451,-485,-484,354,-997,-5,-126,879,-183,570,662,109,835,260,747,658,-945,921,74,-783,479,-429,-533,-830,286,-281,-392,-776,-516,930,811,-991,-555,-673,362,-479,322,-691,-527,-788,878,-865,320,714,394,140,445,521,134,-481,810,-314,90,-722,-145,-551,69,536,-328,625,466,-517,633,984,-117,68,-495,-795,376,50,-584,255,184,808,42,-348,21,-513,-827,-845,6,983,-160,-831,-739,768,-383,402,304,361,27,-157,916,-339,-100,-201,801,477,76,251,-473,564,-494,711,445,547,-637,-534,-893,-392,-307,185,-409,533,353,-76,374,-957,-674,-249,476,353,666,466,-913,-433,-735,887,-956,414,211,-429,-22,716,-645,-576,336,-210,-111,516,397,582,-299,-938,188,-872,-15,-365,-830,384,385,719,-190,51,185,-104,690,522,-144,734,-64,-932,-622,914,856,-268,-662,266,521,299,-218,-9,-46,482,52,-785,609,-889,-78,852,494,-693,644,-623,431,-171,272,194,-649,-799,-72,287,-659,378,274,-802,-890,684,463,703,56,-755,-232,-989,799,892,-702,482,-997,220,407,569,599,51,945,103,952,290,-702,-697,491,298,662,904,-323,9,-898,-141,-307,637,-364,749,954,403,832,827,295,-797,309,371,495,-284,13,95,839,-41,-729,791,-678,-359,-833,885,-987,902,790,-311,-89,964,620,677,675,-671,426,629,804,331,529,173,606,-162,-456,102,626,556,-730,538,-412,-460,329,-90,181,496,-132,193,398,-342,954,-691,-304,647,985,-629,976,484,-927,780,-112,602,26,-432,-560,569,669,-860,199,938,677,859,-449,80,-231,804,-424,710,70,-953,-632,97,-572,63,-182,-513,506,-206,-956,579,-353,5,181,673,572,693,315,314,905,-486,252,583,-626,875,-264,215,753,311,-2,-177,430,366,920,857,-498,-262,-583,-991,604,-539,660,-676,465,-159,-930,110,-466,458,-576,-560,971,748,-904,-582,623,-169,706,376,-785,-296,-727,717,-857,-734,647,-282,76,-935,-201,-247,-402,-541,76,-864,372,219,245,978,-323,668,-582,-279,489,-414,212,185,489,-9,-365,776,694,-93,493,910,172,141,-299,-679,205,499,73,875,-969,-778,-989,402,513,255,380,-810,-4,871,-89,-515,-470,-804,669,-980,186,-696,795,-47,210,362,-137,-545,-424,563,-152,853,135,920,728,165,-784,738,-433,728,-7,-979,918,988,891,-98,-527,-579,170,-785,-487,-644,-481,-618,308,801,743,-828,-670,-681,807,177,-828,-57,171,899,-819,386,637,-179,187,-297,-159,178,-236,-268,-847,309,225,322,523,738,677,-885,-880,59,916,935,230,-681,-746,110,495,-502,-874,-261,-530,-693,-802,-820,127,385,-118,-959,-364,645,-228,-211,-46,-930,-889,-523,807,861,-408,926,-80,-419,934,-777,-101,-812,332,-533,-242,531,206,227,837,476,406,37,-66,-639,77,570,-994,921,-641,32,990,-458,509,871,-524,-826,870,395,-173,805,690,798,992,96,-735});
    
    public void test_longestConsecutive(){
    	//System.out.printf("%d \r\n", longestConsecutive(new int[]{1, 0}));
    	//System.out.printf("%d \r\n", longestConsecutive(new int[]{-1, 0, 1}));
    	//System.out.printf("%d \r\n", longestConsecutive(new int[]{1, 0, -1}));
    	//System.out.printf("%d \r\n", longestConsecutive(new int[]{-7,-1,3,-9,-4,7,-3,2,4,9,4,-9,8,-7,5,-1,-7}));
    	System.out.printf("%d \r\n", longestConsecutive(new int[]{7,-2,9,9,1,9,8,-4,6,-6,-6,4,1,3,6,3,5,-2,3,4,-6,1,5,-9,6,1,2,-2,1}));
    	//System.out.printf("%d \r\n", longestConsecutive(largeArray.toArray(int)));
    }
    
    public int longestConsecutive(int[] num) {
    	HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();     	
    	for(int n : num) map.put(n, false);
    	int longest = 0;
    	for(int n: num){
    		if (map.get(n)) continue;
    		int len = 1;
    		map.put(n, true);    		
    		for(int j=n+1;map.containsKey(j);j++){
    			map.put(j, true);
    			len ++;
    		}
    		for(int j=n-1;map.containsKey(j);j--){
    			map.put(j, true);
    			len ++;
    		}
    		if (len > longest) longest = len;
    	}
    	return longest;
    }
    
    public void test_lengthOfLongestSubstring(){
    	//System.out.printf("%d\r\n", lengthOfLongestSubstring(""));
    	//System.out.printf("%d\r\n", lengthOfLongestSubstring("abcdefgabcdfeds"));
    	//System.out.printf("%d\r\n", lengthOfLongestSubstring("qopubjguxhxdipfzwswybgfylqvjzhar"));
    	System.out.printf("%d\r\n", lengthOfLongestSubstring("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijklmnopqrstuvwxyzABCD"));
    }
    
    public int lengthOfLongestSubstring(String s) {
    	int ret = 0, start = 0;
        char[] chs = s.toCharArray();
    	HashMap<Character, Integer> set = new HashMap<Character, Integer>();
        for(int i=0;i<chs.length;i++){
    		if (set.containsKey(chs[i])){
    			int last = set.get(chs[i]);
    			if (last >= start){
        			if (i - start > ret) ret = i - start;
    				start = last + 1;
    			}
    		}
   			set.put(chs[i], i);
        }
        if (chs.length - start > ret) ret = chs.length - start;
        return ret;
    }
    
    public void trest_ladderLength(){
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	System.out.printf("%d", ladderLength("a", "c", dict));
    }
      
    public int ladderLength(String start, String end, Set<String> dict) {
        Stack<String> tovisit = new Stack<String>();
        tovisit.add(start);
        dict.remove(start);
        int dist = 2;
        
        while(dict.size() > 0 && tovisit.size() > 0){
        	Stack<String> nexttovisit = new Stack<String>();
        	
        	while(!tovisit.isEmpty()){
	        	//generate new words
	        	String visit = tovisit.pop();
	        	//System.out.printf("%s %d\r\n", visit, dist);
	        	
	    		char[] chs = visit.toCharArray();
	        	for(int i=0;i<visit.length();i++){
	        		char ch = chs[i];
	        		for(char newch='a';newch<='z';newch++){
	        			if (newch==ch) continue;
	        			chs[i] = newch;
	        			String newword = String.copyValueOf(chs);
	        			//System.out.printf("newword %s end %s\r\n", newword, end);
	        			if (newword.equals(end)) return dist;
	        			if (dict.contains(newword)) {
	        				nexttovisit.add(newword);
	        				dict.remove(newword);
	        			}
	        		}
	        		chs[i] = ch;
	        	}
        	}
        	tovisit = nexttovisit;
            dist ++;
        }
        
        return 0;
    }
    
    public int maxProduct(int[] A) {
        if (A.length == 0) return 0;
        
        int maxpre = A[0], minpre = A[0], maxhere, minhere, max=A[0];
        for(int i=1;i<A.length;i++){
        	maxhere = Math.max(Math.max(maxpre*A[i],  minpre*A[i]), A[i]);
        	minhere = Math.min(Math.min(maxpre*A[i],  minpre*A[i]), A[i]);
        	max = Math.max(maxhere, max);
        	maxpre = maxhere;
        	minpre = minhere;
        }
        
        return max;
    }
    
    public int maxProfit(int[] prices) {
        int start = 0, max = 0, total = 0;
        for(int i=1;i<prices.length;i++){
        	int diff = prices[i] - prices[start];
        	if (diff < max) {
        		if (max > 0) total += max;
        		start = i;
        		max = 0;
        	}
        	else{
        		max = diff;
        	}
        }
        
        if (max > 0) total += max;
        
        return total;
    }
    
    public void trest_findLadders(){
    	HashSet<String> dict = new HashSet<String>();
    	dict.add("a");
    	dict.add("b");
    	dict.add("c");
    	List<List<String>> ret = new ArrayList<List<String>>();
    	//ret = findLadders("a", "c", dict);
    	for(List<String> list : ret){
    		for(String word : list){
    			System.out.printf("%s ", word);
    		}
    		System.out.println();
    	}
    	
    	//Input: 	"hot", "dog", ["hot","cog","dog","tot","hog","hop","pot","dot"]
    	//Expected: ["hot","dot","dog"],["hot","hog","dog"]]   	
    	dict = new HashSet<String>();
    	dict.add("hot");
    	dict.add("cog");
    	dict.add("dog");
    	dict.add("tot");
    	dict.add("hog");
    	dict.add("hop");
    	dict.add("pot");
    	dict.add("dot");
    	//ret = findLadders("hot", "dog", dict);
    	for(List<String> list : ret){
    		for(String word : list){
    			System.out.printf("%s ", word);
    		}
    		System.out.println();
    	}
    	
    	//Input: 	"red", "tax", ["ted","tex","red","tax","tad","den","rex","pee"]
    	//Expected: 	[["red","ted","tad","tax"],["red","ted","tex","tax"],["red","rex","tex","tax"]]
    	dict = new HashSet<String>();
    	dict.add("ted");
    	dict.add("tex");
    	dict.add("red");
    	dict.add("tax");
    	dict.add("tad");
    	dict.add("den");
    	dict.add("rex");
    	dict.add("pee");
    	//ret = findLadders("red", "tax", dict);
    	for(List<String> list : ret){
    		for(String word : list){
    			System.out.printf("%s ", word);
    		}
    		System.out.println();
    	}
    	
    	//timeout
    	//Last executed input: 	"cet", "ism", 
    	dict = new HashSet<String>();
    	for(String word : new String[]{"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"}){
    		dict.add(word);
    	}
    	ret = findLadders("cet", "ism", dict);
    	for(List<String> list : ret){
    		for(String word : list){
    			System.out.printf("%s ", word);
    		}
    		System.out.println();
    	}
    }
    
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
    	List<List<String>> ret = new ArrayList<List<String>>();

        
    	return ret;
    }
    
    private void test_numTrees(){
    	System.out.printf("%d %d\r\n", 2, numTrees(2));
    	System.out.printf("%d %d\r\n", 3, numTrees(3));
    }
    
    public int numTrees(int n) {
    	if (n<0) return -1;
    	if (n<1) return 1;
    	
    	int[] results = new int[n+1];
        results[0]=1;

        for(int i=1;i<=n;i++){
            int sum = 0;
        	for(int j=1;j<=i;j++){
        		sum += results[i-j]*results[j-1];
        		//System.out.printf("%d %d %d\r\n", i, j, sum);
        	}
        	results[i]=sum;
        }
        
        return results[n];
    }
    
    //pascal's triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows>0) {
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(1);
        	ret.add(list);
        }
        for(int i=2;i<=numRows;i++){
        	List<Integer> list = new ArrayList<Integer>();
        	list.add(1);
        	List<Integer> lastRow = ret.get(i-2);
        	for(int j=1;j<i-1;j++){
        		list.add(lastRow.get(j-1)+lastRow.get(j));
        	}
        	list.add(1);
        	ret.add(list);
        }
        
        return ret;
    }    
    
    private void test_getRow(){
    	List<Integer> list = getRow(3);
    	for(Integer i : list) System.out.printf("%d ", i);
    	System.out.println();
    	list = getRow(4);
    	for(Integer i : list) System.out.printf("%d ", i);
    	System.out.println();
    }
    
    public List<Integer> getRow(int rowIndex) {
    	List<Integer> lastRow;
    	List<Integer> list;
        if (rowIndex>=0) {
        	list = new ArrayList<Integer>();
        	list.add(1);
        	lastRow = list;
        }
        else return null;
        
        for(int i=1;i<=rowIndex;i++){
        	list = new ArrayList<Integer>();
        	list.add(1);
        	for(int j=1;j<=i-1;j++){
        		list.add(lastRow.get(j-1)+lastRow.get(j));
        	}
        	list.add(1);
        	lastRow = list;
        }
        
        return list;
    }
}




