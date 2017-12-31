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
    public bool DetectCapitalUse(string word) {
        if (string.IsNullOrEmpty(word)) return true;
            
        bool first = char.IsUpper(word[0]);
        if (first){
            var rest = word.Substring(1);
            if (rest == rest.ToUpper()) return true;
            else if (rest == rest.ToLower()) return true;
            return false;
        }
        else {
            return word == word.ToLower();
        }
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(p.DetectCapitalUse("USA")); 
            Console.WriteLine(p.DetectCapitalUse("leetcode")); 
            Console.WriteLine(p.DetectCapitalUse("Sun")); 
            Console.WriteLine(p.DetectCapitalUse("bAd")); 
            Console.WriteLine(p.DetectCapitalUse("FlaG"));
        }
    }
}

