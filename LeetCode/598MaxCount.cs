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
    public int MaxCount(int m, int n, int[,] ops) {
        int r = m, c = n;
        for(int i=0;i<ops.GetLength(0);i++){
            if (ops[i,0] < r) r = ops[i,0];
            if (ops[i,1] < c) c = ops[i,1];
        }
        return r*c;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(p.MaxCount(3, 3, new int[,]{{2,2},{3,3}}));
        }
    }
}


