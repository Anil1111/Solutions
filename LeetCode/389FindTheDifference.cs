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
    public char FindTheDifference(string s, string t) {
        int[] map = new int[26];
        foreach(var ch in s){
            map[ch-'a']++;
        }
        foreach(var ch in t){
            map[ch-'a']--;
            if (map[ch-'a']<0) return ch;  
        }
        
        return 'a';
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            Console.WriteLine("Hello "+p.FindTheDifference("abcd", "abcde"));
        }
    }
}
