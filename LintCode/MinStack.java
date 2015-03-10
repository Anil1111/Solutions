class MinStack {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> min = new Stack<Integer>();
    
    public void push(int x) {
        stack.push(x);
        if (!min.empty()){ 
            int val = min.peek();
            if (x <= val) min.push(x);
        }
        else min.push(x);
    }

    public void pop() {
        int val0 = stack.peek();
        stack.pop();
        int val1 = min.peek();
        if (val0 == val1) min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min.peek();
    }
}
