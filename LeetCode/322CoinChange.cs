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
        dp[0] = 0;
        for(int i=1;i<=amount;i++) dp[i] = amount+1;
        
        foreach(var coin in coins){
            for(int i=coin;i<=amount;i++){                
                dp[i] = Math.Min(dp[i], dp[i-coin]+1);
            }
            //Console.WriteLine(coin+" "+string.Join(",",dp));
        }
        
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CoinChange(new int[]{2}, 3));
            Console.WriteLine(p.CoinChange(new int[]{1,2,5}, 11));
            Console.WriteLine(p.CoinChange(new int[]{2147483647}, 2));
            Console.WriteLine(p.CoinChange(new int[]{1}, 1));
            Console.WriteLine(p.CoinChange(new int[]{1}, 0));
        }
    }
}
