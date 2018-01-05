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
        
    public string Tree2str(TreeNode t) {
        var builder = new StringBuilder();
        if (t != null){
            builder.Append(t.val);
            if (t.left != null || t.right != null){
                builder.Append("("+Tree2str(t.left)+")");
                if (t.right != null) builder.Append("("+Tree2str(t.right)+")");
            }
        }
        return builder.ToString();
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
            Console.WriteLine(p.Tree2str(root));
        }
    }
}


