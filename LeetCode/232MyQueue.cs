//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
public class MyQueue {
    Stack<int> stack = new Stack<int>();
        
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void Push(int x) {
        stack.Push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int Pop() {
        var newstack = new Stack<int>();
        int count = stack.Count()-1;
        for(int i=0;i<count;i++){
            newstack.Push(stack.Pop());
        }
        var p = stack.Pop();
        new Stack<int>(newstack);
        return p;
    }
    
    /** Get the front element. */
    public int Peek() {
        var newstack = new Stack<int>();      
        int p = 0;
        int count = stack.Count();
        for(int i=0;i<count;i++){
            p = stack.Pop();
            newstack.Push(p);
        }
        stack = new Stack<int>(newstack);
        return p;
    }
    
    /** Returns whether the queue is empty. */
    public bool Empty() {
        return stack.Count() == 0;
    }
}
    public class Program
    {
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new MyQueue();
            p.Push(1);
            p.Push(2);
            Console.WriteLine("peek " + p.Peek());
            Console.WriteLine("peek " + p.Peek());
            Console.WriteLine(p.Empty());
        }
    }
}
