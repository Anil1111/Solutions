//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }
}
    
    public class Program
    {
        
    public TreeNode LowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root != null){
            if (p.val < root.val && root.val > q.val)
                root = root.left;
            else if (p.val > root.val && root.val < q.val)
                root = root.right;
            else
                return root;
        }
        
        return null;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            var program = new Program();
            var root = new TreeNode(6);
            var p = new TreeNode(3);
            var q = new TreeNode(5);
            var node = new TreeNode(2);
            root.left = node;
            root.right = new TreeNode(8);
            node.left = new TreeNode(0);
            node.right = new TreeNode(4);
            node = node.right;
            node.left = p;
            node.right = q;
            node = root.right;
            node.left = new TreeNode(7);
            node.right = new TreeNode(9);
            node = program.LowestCommonAncestor(root, p, q);
            Console.WriteLine(node == null ? "null" : node.val.ToString());
        }
    }
}
