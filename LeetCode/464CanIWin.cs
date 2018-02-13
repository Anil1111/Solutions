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
    public bool CanIWin(int n, int total) {
        if (total <= n) {
            return true;
        }
        if ((1 + n) * n / 2 < total) {
            return false;
        }
        bool?[] map = new bool?[1 << n];
        return CanWin(total, n, 0, map);        
    }

    public bool CanWin(int remains, int n, int status, bool?[] map) {
        if (map[status] != null) {
            return map[status].Value;
        }
        for (int i = n; i >= 1; i--) {
            int bit = 1 << (i - 1);
            if ((status & bit) == 0) { 
                if (i >= remains) {
                    map[status] = true;
                    return true; 
                } 

                status ^= bit;
                bool opWin = CanWin(remains - i, n, status, map);
                status ^= bit;         
                if (!opWin) {
                    map[status] = true;  
                    return true;
                }
            }
        }
        map[status] = false;
        return false;
    } 
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CanIWin(2,4));
            Console.WriteLine(p.CanIWin(5,50));
            Console.WriteLine(p.CanIWin(4,6));
        }
    }
}

