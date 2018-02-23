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
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
    public int Rob(TreeNode root) {
        int with, without;
        Rob(root, out with, out without);
        return with > without ? with : without;
    }
    
    void Rob(TreeNode root, out int with, out int without){
        if (root == null){
            with = 0;
            without = 0;
        }
        else{
            int rw, rwo;
            Rob(root.right, out rw, out rwo);
            int lw, lwo;
            Rob(root.left, out lw, out lwo);
            //Console.WriteLine(root.val+" "+lw+" "+lwo+" "+rw+" "+rwo);
            with = root.val + rwo + lwo;
            without = (lwo > lw ? lwo : lw) + (rwo > rw ? rwo : rw);
        }
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(3);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            Console.WriteLine(p.Rob(root));
            //[3,4,5,1,3,null,1]
            root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(3);
            root.right.right = new TreeNode(1);
            Console.WriteLine(p.Rob(root));
        }
    }
}

