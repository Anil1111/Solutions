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
    public string ReverseStr(string s, int k) {
        var builder = new StringBuilder();
        for(int i=0;i<s.Length;i+=2*k){           
            if (i+k < s.Length){
                var sub = string.Join("", s.Substring(i, k).Reverse());
                builder.Append(sub);
                builder.Append(i+2*k<s.Length ? s.Substring(i+k, k) : s.Substring(i+k));
            }
            else{
                builder.Append(string.Join("", s.Substring(i).Reverse()));
            }
        }
        return builder.ToString();
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(p.ReverseStr("abcdefg", 2)); //bacdfeg
            Console.WriteLine(p.ReverseStr("abcd", 4)); //dcba
        }
    }
}


