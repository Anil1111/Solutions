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
    public int NumSquares(int n) {
        var dict = new Dictionary<int, int>();
        dict[n] = 0;
        for(int i=(int)Math.Sqrt(n);i>0;i--){
            var newdict = new Dictionary<int, int>();
            foreach(int val in dict.Keys){
                int v = val - i*i;
                int count = 1;
                while(v >= 0){
                    if (!newdict.ContainsKey(v) || newdict[v] > dict[val]+count){
                        newdict[v] = dict[val]+count;
                    }
                    v -= i*i;
                    count++;
                }
                if (v==0) return newdict[0];
            }
            foreach(var key in newdict.Keys){
                if (!dict.ContainsKey(key) || dict[key] > newdict[key]) dict[key] = newdict[key];
            }
            
            //Console.WriteLine((i*i)+" "+string.Join(" ",dict.Keys.ToList().Select(k => k+","+dict[k])));
        }
        
        return dict.Keys.Where(k => k == 0).Min(k => dict[k]);
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.NumSquares(481));
            Console.WriteLine(p.NumSquares(459));
            Console.WriteLine(p.NumSquares(17)); //2
            Console.WriteLine(p.NumSquares(10)); //2
            Console.WriteLine(p.NumSquares(12)); //3
            Console.WriteLine(p.NumSquares(13)); //2
        }
    }
}
