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
    public string[] FindRelativeRanks(int[] nums) {
        var ret = new string[nums.Length];
        var dict = new Dictionary<int, int>();
        for(int i=0;i<nums.Length;i++){
            dict[nums[i]] = i;
        }
        
        var sorted = nums.OrderByDescending(num => num).ToList();
        
        for(int i=0;i<sorted.Count();i++){
            var index = dict[sorted[i]];
            if (i==0) ret[index] = "Gold Medal";
            else if (i==1) ret[index] = "Silver Medal";
            else if (i==2) ret[index] = "Bronze Medal";
            else ret[index] = (i+1).ToString();
        }
        return ret;
    }                   
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(string.Join(",", p.FindRelativeRanks(new int[]{5,4,3,2,1}))); 
            Console.WriteLine(string.Join(",", p.FindRelativeRanks(new int[]{10,3,8,9,4})));
        }
    }
}
