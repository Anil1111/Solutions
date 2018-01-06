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
    public double FindMaxAverage(int[] nums, int k) {
        if (nums.Length < k) return 0;
        
        double ret = 0;        
        for(int i=0;i<k;i++) ret += nums[i];
        double sum = ret;
        for(int i=k;i<nums.Length;i++){
            sum = sum + nums[i] - nums[i-k];
            if (sum > ret) ret = sum;
        }
        
        return ret / k;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.FindMaxAverage(new int[]{0,4,0,3,2}, 1));
            Console.WriteLine(p.FindMaxAverage(new int[]{5}, 1));
            Console.WriteLine(p.FindMaxAverage(new int[]{1,12,-5,-6,50,3}, 4));
        }
    }
}


