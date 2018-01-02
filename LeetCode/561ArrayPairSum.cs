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
    public int ArrayPairSum(int[] nums) {
        Array.Sort(nums);
        int ret = 0;
        for(int i=0;i<nums.Length;i+=2) ret+= nums[i];
        
        return ret;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.ArrayPairSum(new int[]{1,4,3,2}));
        }
    }
}


