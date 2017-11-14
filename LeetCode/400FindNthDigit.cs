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
    public int FindNthDigit(int n) {
        int len = 1;
        int count = 9;
        while(n>len*count){
            n-=len*count;
            len ++;
            count *=10;
        }
        count /= 9;
        count += (n-1)/len;
        var str = count.ToString();
        return str[(n-1)%len]-'0';
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            for(int i=9;i<20;i++)
            {
                Console.WriteLine("Hello "+p.FindNthDigit(i));
            }
        }
    }
}
