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
    public int FindContentChildren(int[] g, int[] s) {
        Array.Sort(g);
        Array.Sort(s);
        int ret = 0;
        int gi = 0, si = 0;
        while(gi<g.Length&&si<s.Length){
            //Console.WriteLine(si+" s "+s[si]+" "+gi+" g "+g[gi]);
            if (s[si]>=g[gi]){
                ret++;
                si++;
                gi++;
            }
            else{
                si++;
            }
        }
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.FindContentChildren(new int[]{1,2,3}, new int[]{1,1}));
            Console.WriteLine(p.FindContentChildren(new int[]{1,2}, new int[]{1,2,3}));
        }
    }
}
