public class MyStack {
    Queue<int> queue = new Queue<int>();
    
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void Push(int x) {
        queue.Enqueue(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int Pop() {
        var newqueue = new Queue<int>();        
        int count = queue.Count()-1;
        for(int i=0;i<count;i++){
            newqueue.Enqueue(queue.Dequeue());
        }
        var p = queue.Dequeue();
        queue = newqueue;
        return p;        
    }
    
    /** Get the top element. */
    public int Top() {
        var newqueue = new Queue<int>();        
        int p = 0;
        int count = queue.Count();
        for(int i=0;i<count;i++){
            p = queue.Dequeue();
            newqueue.Enqueue(p);
        }
        queue = newqueue;
        return p;
    }
    
    /** Returns whether the stack is empty. */
    public bool Empty() {
        return queue.Count == 0;        
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.Push(x);
 * int param_2 = obj.Pop();
 * int param_3 = obj.Top();
 * bool param_4 = obj.Empty();
 */
