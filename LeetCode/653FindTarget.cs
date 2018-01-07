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
        
    public bool FindTarget(TreeNode root, int k) {
        if (root == null) return false;
        
        Sorted(root);
        int l = 0, r = sorted.Count - 1;
        while(l<r){
            var sum = sorted[l] + sorted[r];
            if (sum < k) l++;
            else if (sum > k) r--;
            else return true;
        }
        
        return false;
    }

        private List<int> sorted = new List<int>();
        private void Sorted(TreeNode root){
            if (root.left != null){
                Sorted(root.left);
            }
            sorted.Add(root.val);
            if (root.right != null){
                Sorted(root.right);
            }
        }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(5);
            root.left = new TreeNode(3);
            root.right = new TreeNode(6);
            root.left.left = new TreeNode(2);
            root.left.right = new TreeNode(4);
            root.right.right = new TreeNode(7);
            Console.WriteLine(p.FindTarget(root, 9));
            Console.WriteLine(p.FindTarget(root, 28));
        }
    }
}


