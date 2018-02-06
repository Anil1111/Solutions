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
    public int MaxProfit(int[] prices) {
        int sell = 0, prev_sell = 0, buy = int.MinValue, prev_buy;
        foreach (int price in prices) {
            prev_buy = buy;
            buy = Math.Max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.Max(prev_buy + price, prev_sell);
        }
        return sell;        
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.MaxProfit(new int[]{1,2,3,0,2}));
        }
    }
}
