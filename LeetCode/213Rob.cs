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
    public int Rob(int[] nums) {
        if (nums.Length == 1) return nums[0];
        
        int include = 0, exclude = 0;
        for (int j = 1; j < nums.Length; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = e>i ? e:i;
        }
        int first = include>exclude ? include:exclude;
        
        include = 0;
        exclude = 0;
        for (int j = 0; j < nums.Length-1; j++) {
            int i = include, e = exclude;
            include = e + nums[j];
            exclude = e>i ? e:i;
        }
        int second = include>exclude ? include:exclude;
        return first>second ? first:second;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.Rob(new int []{4,1,2,3}));
        }
    }
}

