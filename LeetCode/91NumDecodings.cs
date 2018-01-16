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
        if (string.IsNullOrEmpty(s)) return 0;
        
        int ret = 0;
        int val;
        if (s.Length > 1 && int.TryParse(s.Substring(0,2), out val)){
            if (val > 0 && val < 27) {
                if (s.Length > 2) ret += NumDecodings(s.Substring(2));
                else ret += 1;
            }
        }
        if (s.Length > 0 && int.TryParse(s.Substring(0,1), out val)){
            if (val > 0){
                if (s.Length > 1) ret += NumDecodings(s.Substring(1));
                else return 1;
            }
            else return 0;
        }
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.NumDecodings("4757562545844617494555774581341211511296816786586787755257741178599337186486723247528324612117156948"));
            Console.WriteLine(p.NumDecodings("012"));
            Console.WriteLine(p.NumDecodings("123"));
            Console.WriteLine(p.NumDecodings("1"));
            Console.WriteLine(p.NumDecodings("0"));
            Console.WriteLine(p.NumDecodings(""));
        }
    }
}

