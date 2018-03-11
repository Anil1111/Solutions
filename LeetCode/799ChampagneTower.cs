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
    public double ChampagneTower(int poured, int query_row, int query_glass) {
        double p = poured;
        for(int i=0;i<query_row;i++){
            if (p <= 0) return 0;
            if (p > (i+1)){
                p = p - i - 1;
            }
            else p = 0;
        }
        Console.WriteLine(p);
        if (p == 0) return 0;
        else if (query_row == 0){
            return p > 1 ? 1 : p;
        }
        else{
            double count = (query_row - 1)*2 + 2;
            Console.WriteLine(p+" "+count+" "+p/count);
            if (query_glass == 0 || query_glass == query_row) return p / count > 1 ? 1 : p/count;
            else return p * 2.0 / count > 1 ? 1 : p * 2.0 / count;
        }
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p= new Program();
            Console.WriteLine(p.ChampagneTower(6,3,1));
            //Console.WriteLine(p.ChampagneTower(2,1,1));
        }
    }
}
