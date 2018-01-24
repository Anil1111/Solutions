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
    public int ComputeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (C-A) * (D-B);
        int area2 = (G-E) * (H-F);
        
        int left = Math.Max(A, E);
        int right = Math.Min(G, C);
        int bottom = Math.Max(F, B);
        int top = Math.Min(D, H);
        
        //If overlap
        int overlap = 0;
        if(right > left && top > bottom){
             overlap = (right - left) * (top - bottom);
        }
        
        return area1+area2-overlap;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.ComputeArea(-2,-2,2,2,-2,-2,2,2));
            Console.WriteLine(p.ComputeArea(-3,0,3,4,0,-1,9,2));
        }
    }
}

