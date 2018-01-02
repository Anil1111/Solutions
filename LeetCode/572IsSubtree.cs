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
        
    public bool IsSubtree(TreeNode s, TreeNode t) {
        bool ret = Same(s, t);
        if (ret) return true;
        if (s.left != null){
            ret = IsSubtree(s.left, t);
            if (ret) return true;
        }
        if (s.right != null){
            ret = IsSubtree(s.right, t);
            if (ret) return true;
        }
        return false;
    }
    
    private bool Same(TreeNode s, TreeNode t) {
        if (s.val != t.val) return false;
        if (s.left != null){
            if (t.left == null) return false;
            bool ret = Same(s.left, t.left);
            if (!ret) return false;
        }
        else if (t.left != null) return false;
            
        if (s.right != null){
            if (t.right == null) return false;
            bool ret = Same(s.right, t.right);
            if (!ret) return false;
        }
        else if (t.right != null) return false;
            
        return true;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(3);
            root.left = new TreeNode(4);
            root.right = new TreeNode(5);
            root.left.left = new TreeNode(1);
            root.left.right = new TreeNode(2);
            var t = new TreeNode(4);
            t.left = new TreeNode(1);
            t.right = new TreeNode(2);
            Console.WriteLine(p.IsSubtree(root, t));
            t.right.left = new TreeNode(0);
            Console.WriteLine(p.IsSubtree(root, t));
        }
    }
}


