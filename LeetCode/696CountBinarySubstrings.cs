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
    public int CountBinarySubstrings(string s) {
        int ret = 0, last = 0, current = 0;
        char prev = 'a';
        for(int i=s.Length-1;i>=0;i--){
            var ch = s[i];
            if (ch != prev){
                prev = ch;                
                last = current;
                current = 1;
                if (last >= current) ret++;
            }            
            else{
                current ++;
                if (last >= current) ret++;
            }
        }
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CountBinarySubstrings("00110011"));
            Console.WriteLine(p.CountBinarySubstrings("10101"));                       
        }
    }
}

