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
    public bool RepeatedSubstringPattern(string s) {
        string nextStr = s;
        int len = s.Length;
        if(len < 1) return false;
        for(int i = 1; i <= len / 2; i++){
            if(len % i == 0){
                nextStr = LeftShift(s, i);
                if(nextStr == s) return true;
            }
        }
        return false;
    }
    
    public string LeftShift(string s, int l){
        string ret = s.Substring(l);
        ret += s.Substring(0, l);
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
    
            Console.WriteLine(p.RepeatedSubstringPattern("abaababaab"));
            Console.WriteLine(p.RepeatedSubstringPattern("abcabcabcabc"));
            Console.WriteLine(p.RepeatedSubstringPattern("aaaa"));
            Console.WriteLine(p.RepeatedSubstringPattern("abab"));
        }
    }
}
