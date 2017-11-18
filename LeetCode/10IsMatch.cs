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
    public bool IsMatch(string s, string p) {
        if (p == "") return s == "";
        bool first_match = (s != "" && 
                               (p[0] == s[0] || p[0] == '.'));
        
        if (p.Length >= 2 && p[1] == '*'){
            return (IsMatch(s, p.Substring(2)) || 
                    (first_match && IsMatch(s.Substring(1), p)));
        } else {
            return first_match && IsMatch(s.Substring(1), p.Substring(1));
        }
    }
        
        public static void Main(string[] args)
        {
            var p = new Program();
            //Your code goes here
            Console.WriteLine(p.IsMatch("aa", "a*"));
        }
    }
}
