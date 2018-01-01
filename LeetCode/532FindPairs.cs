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
    /*
    public class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int x) { val = x; }
    }
    */
        
    public int FindPairs(int[] nums, int k) {
        if (k<0) return 0;
        var dict = new Dictionary<int, int>();
        foreach(var num in nums){
            int count;
            dict.TryGetValue(num, out count);
            dict[num]=count+1;            
        }
        int ret = 0;
        foreach(var key in dict.Keys){
            int count;
            if (k==0){
                ret += dict[key] > 1 ? 1 : 0;
            }
            else if (dict.TryGetValue(key+k, out count)){
                ret ++;
            }
        }        
        return ret;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(p.FindPairs(new int[]{3, 1, 4, 1, 5}, 2)); //2
            Console.WriteLine(p.FindPairs(new int[]{1, 2, 3, 4, 5}, 1)); //4
            Console.WriteLine(p.FindPairs(new int[]{1, 3, 1, 5, 4}, 0)); //1
        }
    }
}


