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
        
    public int[] FindMode(TreeNode root) {
        List<int> ret = new List<int>();
        
        if (root != null){
            var dict = new Dictionary<int, int>();
            var list = new List<TreeNode>();
            list.Add(root);
            while(list.Count > 0){
                int count = 0;
                var newlist = new List<TreeNode>();
                foreach(var node in list){
                    dict.TryGetValue(node.val, out count);
                    dict[node.val] = count + 1;
                    
                    if (node.left != null) newlist.Add(node.left);
                    if (node.right != null) newlist.Add(node.right);
                }
                list = newlist;
            }
            
            int max=0, val;
            foreach(var key in dict.Keys){
                if (dict[key] > max){
                    max = dict[key];
                    val = max;
                }
            }
            
            foreach(var key in dict.Keys){
                if (dict[key] == max){
                    ret.Add(key);
                }
            }
        }
        
        return ret.ToArray();
    }         
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var root = new TreeNode(1);
            root.right = new TreeNode(2);
            root.right.left = new TreeNode(2);
            Console.WriteLine(string.Join(",", p.FindMode(root))); 
        }
    }
}
