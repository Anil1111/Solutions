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
        public string IntToRoman(int num) {
            string[] M = new string[]{"", "M", "MM", "MMM"};
            string[] C = new string[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
            string[] X = new string[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
            string[] I = new string[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
            return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.IntToRoman(1));
            Console.WriteLine(p.IntToRoman(14));
        }
    }
}

