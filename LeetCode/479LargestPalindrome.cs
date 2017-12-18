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
        long ret = 0;
        long a = 0, b = 0, c = 1;
        for(int i=0;i<n;i++){
            a = a * 10 + 9;
            c *= 10;
        }
        b = a;
        c *= 10;
        
        //Console.WriteLine(a);
        while(a>0){
            long p = a * b;
            
            if (IsPalindrome(p)){
                if (p > ret) ret = p;
            }
            else if (p<ret || b < c){
                a--;
                b = a;
                continue;
            }
            
            b--;
            if (b==0){
                a --;
                b = a;
                if (a * b < ret) break;
            }
        }
        
        Console.WriteLine(ret);
        return (int)(ret % 1337);
    }
        
    public bool IsPalindrome(long x) {
        if (x<0) return false;
        
        long div=1;
        while(x/div>=10) div*=10;
        while(x>0){
            long top = x/div;
            long bottom = x%10;
            if (top != bottom) return false;
            x = x%div/10;
            div/=100;
        }
        
        return true;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //Console.WriteLine(p.LargestPalindrome(1));//9 9
            //Console.WriteLine(p.LargestPalindrome(2));//9009 987
            //Console.WriteLine(p.LargestPalindrome(3));//906609 123
            //Console.WriteLine(p.LargestPalindrome(4));//99000099 597
            //Console.WriteLine(p.LargestPalindrome(5));//9966006699 677 
            //Console.WriteLine(p.LargestPalindrome(6));//999000000999 2118
            //Console.WriteLine(p.LargestPalindrome(7));  //9420645460249 149
            Console.WriteLine(p.LargestPalindrome(8));  //
            
        }
    }
}
