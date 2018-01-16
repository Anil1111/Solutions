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
    public int NumDecodings(string s) {
        if (string.IsNullOrEmpty(s) || s == "0") return 0;
        
        int len = s.Length;
        int[] dp = new int[len];
        
        int val = int.Parse(s.Substring(len-1));
        if (val > 0) dp[len-1] = 1;        
        if (len > 1){
            val = int.Parse(s.Substring(len-2, 1));
            if (val > 0 && dp[len-1] > 0){
                dp[len-2] = dp[len-1];
            }
            val = int.Parse(s.Substring(len-2));
            if (val >= 10 && val < 27){
                dp[len-2] += 1;
            }
        }
       
        for(int i=len-3;i>=0;i--){             
            val = int.Parse(s.Substring(i, 1));
            if (val > 0 && dp[i+1] > 0){
                dp[i] = dp[i+1];
            }
            val = int.Parse(s.Substring(i, 2));

            if (val >= 10 && val < 27){
                dp[i] += dp[i+2];
            }
        }
        
        return dp[0];
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.NumDecodings("101"));
            Console.WriteLine(p.NumDecodings("11"));
            Console.WriteLine(p.NumDecodings("10"));
            Console.WriteLine(p.NumDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
            Console.WriteLine(p.NumDecodings("012"));
            Console.WriteLine(p.NumDecodings("123"));
            Console.WriteLine(p.NumDecodings("1"));
            Console.WriteLine(p.NumDecodings("0"));
            Console.WriteLine(p.NumDecodings(""));
        }
    }
}
