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
    public int GetMoneyAmount(int n) {
        int[,] dp = new int[n+1,n+1];
        return GetMoneyAmount(dp, 1, n);
    }

    private int GetMoneyAmount(int[,] dp, int lower, int upper) {
        if (lower >= upper) {
            return 0;
        }
        if (dp[lower,upper] != 0) {
            return dp[lower,upper];
        }

        int maximum = int.MaxValue;
        for (int i = lower; i <= upper; i++) {
            maximum = Math.Min(maximum, Math.Max(GetMoneyAmount(dp, lower, i-1), GetMoneyAmount(dp, i+1, upper)) + i);
        }
        dp[lower,upper] = maximum;

        return maximum;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p= new Program();
            Console.WriteLine(p.GetMoneyAmount(4)); //4
            Console.WriteLine(p.GetMoneyAmount(3)); //2
            Console.WriteLine(p.GetMoneyAmount(2)); //1
            Console.WriteLine(p.GetMoneyAmount(1)); //0
        }
    }
}
