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

    public int PathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        return PathSumFrom(root, sum) + PathSum(root.left, sum) + PathSum(root.right, sum);
    } 
        
    public int PathSumFrom(TreeNode node, int sum) {
        if (node == null) return 0;
        
        return (node.val == sum ? 1 : 0) + PathSumFrom(node.left, sum - node.val) + PathSumFrom(node.right, sum - node.val);
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(10);
            root.left = new TreeNode(5);
            root.right = new TreeNode(-3);
            var node = root.right;
            node.right = new TreeNode(11);
            node = root.left;
            node.left = new TreeNode(3);
            node.right = new TreeNode(2);
            node.left.left = new TreeNode(3);
            node.left.right = new TreeNode(-2);
            node.right.right = new TreeNode(1);
            
            Console.WriteLine(p.PathSum(root, 8));
        }
    }
}
