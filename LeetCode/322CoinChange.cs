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
        
    public int CoinChange(int[] coins, int amount) {
        var dp = new int[amount+1];
        for(int i=0;i<amount;i++){
          dp[i] = int.MaxValue;  
        } 
        
        for(int i=amount-1;i>=0;i--){
            foreach(int c in coins){
                if (c+i >= 0 && c+i <= amount && dp[c+i] < int.MaxValue){
                    int d = dp[c+i] + 1;
                    if (dp[i] > d) dp[i] = d;
                }
            }
        }
        
        return dp[0] == int.MaxValue ? -1 : dp[0];
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CoinChange(new int[]{1,2,5}, 11));
            Console.WriteLine(p.CoinChange(new int[]{2147483647}, 2));
            Console.WriteLine(p.CoinChange(new int[]{1}, 1));
            Console.WriteLine(p.CoinChange(new int[]{1}, 0));
        }
    }
}
