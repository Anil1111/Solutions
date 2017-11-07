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
    public bool CanConstruct(string ransomNote, string magazine) {
        var dict = new Dictionary<char, int>();
        foreach(var ch in magazine.ToCharArray()){
            if (!dict.ContainsKey(ch)) dict[ch] = 0;
            dict[ch] = dict[ch] + 1;
        }
        foreach(var ch in ransomNote.ToCharArray()){
            if (!dict.ContainsKey(ch)) return false;
            int n = dict[ch]-1;
            if (n == 0) dict.Remove(ch);
            else dict[ch] = n;
        }
        return true;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            Console.WriteLine(p.CanConstruct("aa","ab"));
        }
    }
}
