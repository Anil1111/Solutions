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
    public bool JudgeSquareSum(int c) {
        for(long i=0;i*i<=c;i++){
            var r = Math.Sqrt(c-i*i);
            if (r == (int)r) return true;
        }
        
        return false;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.JudgeSquareSum(2147483646));
            Console.WriteLine(p.JudgeSquareSum(2));
            Console.WriteLine(p.JudgeSquareSum(3));
        }
    }
}


