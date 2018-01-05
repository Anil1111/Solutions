//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Text;

namespace Rextester
{
    public class Program
    {
       
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
        
    public TreeNode MergeTrees(TreeNode t1, TreeNode t2) {        
        if (t1 != null || t2 != null){
            if (t1 == null) t1 = new TreeNode(t2.val);
            else if (t2 == null) t2 = new TreeNode(t1.val);                       
            else t1.val += t2.val;
            
            var left = MergeTrees(t1.left, t2.left);
            var right = MergeTrees(t1.right, t2.right);
            t1.left = left;
            t1.right = right;
        }
        
        return t1;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.left.left = new TreeNode(4);
            root.right = new TreeNode(3);
            var t2 = new TreeNode(2);
            t2.right = new TreeNode(3);
            Console.WriteLine(p.MergeTrees(root, t2).val);
        }
    }
}


