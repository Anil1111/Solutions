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
    public bool ValidPalindrome(string s) {
        for(int i=0;i<s.Length/2;i++){
            if (s[s.Length-1-i] != s[i]){
                var left = s.Remove(i,1);
                var right = string.Join("", left.Reverse());
                
                //Console.WriteLine(i+" "+left+" "+right);
                
                if (left==right) return true;
                
                left = s.Remove(s.Length-1-i,1);
                 right = string.Join("", left.Reverse());
                
                //Console.WriteLine(i+" "+left+" "+right);
                
                if (left==right) return true;
                
                return false;
            }
        }
        
        return true;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
    
            Console.WriteLine(p.ValidPalindrome("abc"));
            Console.WriteLine(p.ValidPalindrome("abca"));
            Console.WriteLine(p.ValidPalindrome("abcba"));
        }
    }
}

