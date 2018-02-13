//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{  
    public class Program
    {              
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}
        
    public ListNode ReverseKGroup(ListNode head, int k) {
        if (k<=1 || (head == null)) return head;
        
        var start = new ListNode(0);
        start.next = head;
        ListNode previous = start, current = head, leading = head;
        while(current != null){
            int index;            
            for(index = 0;index<k;index++){
                if (leading == null) break;
                leading = leading.next;
            }
            if (index < k) break;
            
            for(index=0;index<k-1;index++){
                var next = current.next;
                current.next = next.next;
                next.next=previous.next;
                previous.next = next;
            }
            
            for(index=0;index<k;index++){
                previous = previous.next;
            }
            current=previous.next;
        }
        return start.next;
    }     
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new ListNode(1);
            root.next = new ListNode(2);
            var ret = p.ReverseKGroup(root, 2);
            while(ret != null) {
                Console.Write(ret.val+" ");
                ret = ret.next;
            }
            Console.WriteLine();
        }
    }
}

