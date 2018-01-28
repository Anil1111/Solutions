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
    public int HIndex(int[] citations) {
        var sorted = citations.ToList().OrderByDescending(c => c).ToList();
        for(int i=sorted.Count-1;i>=0;i--){
            if (sorted[i] >= i+1) return i+1;
        }
        
        return 0;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.HIndex(new int[]{}));
            Console.WriteLine(p.HIndex(new int[]{1}));
            Console.WriteLine(p.HIndex(new int[]{0}));
            Console.WriteLine(p.HIndex(new int[]{3,0,6,1,5}));
        }
    }
}
