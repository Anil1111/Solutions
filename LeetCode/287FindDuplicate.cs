//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
    public class Program
    {
    public int FindDuplicate(int[] nums) {
        Array.Sort(nums);
        int last = nums[0];
        for(int i=1;i<nums.Length;i++){
            if (nums[i] == last) return last;
            last = nums[i];
        }            
        return last;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.FindDuplicate(new int[]{3,1,3,4,2}));
            Console.WriteLine(p.FindDuplicate(new int[]{2,1,2}));
            Console.WriteLine(p.FindDuplicate(new int[]{1,2,2}));
        }
    }
}
