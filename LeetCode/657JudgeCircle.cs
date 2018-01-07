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
    public bool JudgeCircle(string moves) {
        int x=0,y=0;
        
        foreach(var ch in moves){
            switch(ch){
                case 'U':
                    y--;
                    break;
                case 'D':
                    y++;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }
        
        return x==0 && y==0;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(p.JudgeCircle("UD"));
            Console.WriteLine(p.JudgeCircle("LL"));
        }
    }
}


