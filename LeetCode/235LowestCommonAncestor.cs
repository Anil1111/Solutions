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
        bool foundp, foundq;
        var node = Search(root, p, q, out foundp, out foundq);        
        if (foundp && foundq) return node;
        else return null;
    }
    
    private TreeNode Search(TreeNode root, TreeNode p, TreeNode q, out bool foundp, out bool foundq){        
        foundp = false;
        foundq = false;
        
        if (root != null){
            bool lp = false, lq = false;
            if (root.left != null){                
                var node = Search(root.left, p, q, out foundp, out foundq);
                Console.WriteLine("left " + root.val + " " + foundp + " " + foundq);
                if (foundp && foundq) return node;
            }
            bool rp = false, rq = false;
            if (root.right != null){
                var node = Search(root.right, p, q, out rp, out rq);
                Console.WriteLine("right " + root.val + " " + rp + " " + rq);
                if (rp && rq) {
                    foundp = true;
                    foundq = true;
                    return node;
                }
            }
            
            foundp = root == p ? true : foundp || rp;
            foundq = root == q ? true : foundq || rq;
        }   
        
        Console.WriteLine("root " + root.val + " " + foundp + " " + foundq);
        return root;
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
