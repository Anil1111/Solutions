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
    public bool CheckRecord(string s) {
        int a = 0, l = 0;
        foreach(var ch in s){
            switch(ch){
                case 'A':
                    a++;
                    if (a > 1) return false;
                    l = 0;
                    break;
                case 'L':
                    l ++;
                    if (l > 2) return false;
                    break;
                case 'P':
                    l=0;
                    break;
            }
        }
        return true;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CheckRecord("PPALLP"));
            Console.WriteLine(p.CheckRecord("PPALLL"));
            Console.WriteLine(p.CheckRecord("LPLPLPLPLPL"));
        }
    }
}


