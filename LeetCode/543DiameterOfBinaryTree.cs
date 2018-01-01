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
        
    public int DiameterOfBinaryTree(TreeNode root) {
        int max = 0, dl = 0, dr = 0;
        if (root == null) return 0;
        if (root.left != null){
            var ml  = DiameterOfBinaryTree(root.left);
            if (ml > max) max = ml;
            dl = Depth(root.left);
        }
        if (root.right != null){
            var mr  = DiameterOfBinaryTree(root.right);
            if (mr > max) max = mr;
            dr = Depth(root.right);
        }
        
        var d = dl+dr;
        if (d > max) return d;
        else return max;
    }
        
        private int Depth(TreeNode root){
            int depth = 1;
            if (root.left != null) depth = Depth(root.left) + 1;
            if (root.right != null){
                var dr = Depth(root.right) + 1;
                if (dr > depth) depth = dr;
            }
            return depth;
        }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            Console.WriteLine(p.DiameterOfBinaryTree(root));
            Console.WriteLine(p.DiameterOfBinaryTree(null));
        }
    }
}


