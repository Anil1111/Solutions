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
        
    public int DistributeCandies(int[] candies) {
        var set = new HashSet<int>(candies);
        return Math.Min(candies.Length/2, set.Count);
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(p.DistributeCandies(new int[]{1,1,2,2,3,3}));
            Console.WriteLine(p.DistributeCandies(new int[]{1,1,2,3}));
        }
    }
}


