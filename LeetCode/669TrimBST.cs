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

    public TreeNode TrimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        
        TreeNode ret = null;
        if (root.val >= L && root.val <= R) ret = root;
        if (root.left != null){
            root.left = TrimBST(root.left, L, R);
            if (ret == null) ret = root.left;
        }
        if (root.right != null){
            root.right = TrimBST(root.right, L, R);
            if (ret == null) ret = root.right;            
        }        
        
        return ret;
    }
        
        private static void Print(TreeNode node){
            Console.WriteLine(node.val);
            if (node.left!=null) Print(node.left);
            if (node.right!=null) Print(node.right);
        }
               
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.left = new TreeNode(0);
            root.right = new TreeNode(2);
            Print(p.TrimBST(root, 1, 2));
        }
    }
}
