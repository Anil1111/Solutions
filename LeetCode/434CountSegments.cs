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
    public int CountSegments(string s) {
        return s.Split(" ".ToCharArray(), StringSplitOptions.RemoveEmptyEntries).Count();
    }

        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CountSegments("Hello, my name is John"));
            Console.WriteLine(p.CountSegments(""));
        }
    }
}
