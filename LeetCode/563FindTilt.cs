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
 
    int sum = 0;
    public int FindTilt(TreeNode root) {
        if (root == null) return 0;
        
        int left = root.left != null ? Sum(root.left) : 0;
        int right = root.right != null ? Sum(root.right) : 0;

        sum += Math.Abs(left - right);        
        
        return sum;
    }
        
        private int Sum(TreeNode root){
            int left = root.left != null ? Sum(root.left) : 0;
            int right = root.right != null ? Sum(root.right) : 0;
            
            sum += Math.Abs(left - right);
            return root.val + left + right;
        }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            Console.WriteLine(p.FindTilt(root));
        }
    }
}


