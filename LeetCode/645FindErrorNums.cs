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
    public int[] FindErrorNums(int[] nums) {
        var ret = new List<int>();
        var set = new HashSet<int>();
        for(int i=0;i<nums.Length;i++){
            if (set.Contains(nums[i])) ret.Add(nums[i]);
            else set.Add(nums[i]);
        }
        for(int i=0;i<nums.Length;i++){
            if (!set.Contains(i+1)){
                ret.Add(i+1);
                break;
            }
        }
        
        return ret.ToArray();
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",",p.FindErrorNums(new int[]{1,5,3,2,2,7,6,4,8,9})));
            Console.WriteLine(string.Join(",",p.FindErrorNums(new int[]{3,2,3,4,6,5})));
            Console.WriteLine(string.Join(",",p.FindErrorNums(new int[]{3,2,2})));
            Console.WriteLine(string.Join(",",p.FindErrorNums(new int[]{1,2,2,4})));
        }
    }
}


