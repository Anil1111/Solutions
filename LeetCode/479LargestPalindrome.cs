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
    public int LargestPalindrome(int n) {
        if (n==1) return 9;
        long a = 0, b = 0;
        long max = (long)(Math.Pow(10, n)) - 1;
        a = max;
        
        //Console.WriteLine(a);
        while(a>0){          
            long p = MakePalindrome(a);
            //Console.WriteLine(p);
            for (b=max;b*b>=p;b--){
                if (p%b==0){
                    return (int)(p%1337);
                }
            }
            a--;
        }
        
        return 0;
    }
        
    public long MakePalindrome(long x) {
        var str = x.ToString()+string.Join("", x.ToString().Reverse());
        //Console.WriteLine(str);
        return long.Parse(str);
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //for(int i=999;i>990;i--) Console.WriteLine(p.MakePalindrome(i));
            //Console.WriteLine(p.LargestPalindrome(1));//9 9
            //Console.WriteLine(p.LargestPalindrome(2));//9009 987
            //Console.WriteLine(p.LargestPalindrome(3));//906609 123
            //Console.WriteLine(p.LargestPalindrome(4));//99000099 597
            //Console.WriteLine(p.LargestPalindrome(5));//9966006699 677 
            //Console.WriteLine(p.LargestPalindrome(6));//999000000999 2118
            //Console.WriteLine(p.LargestPalindrome(7));  //9420645460249 149
            Console.WriteLine(p.LargestPalindrome(8));  // 475
            
        }
    }
}
