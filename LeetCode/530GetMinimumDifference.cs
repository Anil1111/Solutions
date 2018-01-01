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
        
    public int GetMinimumDifference(TreeNode root) {
        var list = new List<TreeNode>();
        list.Add(root);
        var vals = new List<int>();
        while(list.Count > 0){
            var newlist = new List<TreeNode>();
            foreach(var node in list){
                vals.Add(node.val);
                if (node.left != null) newlist.Add(node.left);
                if (node.right != null) newlist.Add(node.right);
            }
            list = newlist;
        }
        vals.Sort();
        int min = int.MaxValue;
        for(int i=1;i<vals.Count;i++){
            var diff = vals[i] - vals[i-1];
            if (diff < min) min = diff;
        }
        return min;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.right = new TreeNode(3);
            root.right.left = new TreeNode(2);
            //[236,104,701,null,227,null,911]            
            Console.WriteLine(p.GetMinimumDifference(root)); 
            root = new TreeNode(236);
            root.left = new TreeNode(104);
            root.right = new TreeNode(701);
            root.left.right = new TreeNode(227);
            root.right.right = new TreeNode(911);
            Console.WriteLine(p.GetMinimumDifference(root)); 
        }
    }
}


