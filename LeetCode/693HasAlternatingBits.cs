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
    public bool HasAlternatingBits(int n) {
        int last = n % 2;
        while(n!=0){
            n = n / 2;
            int curr = n % 2;
            //Console.WriteLine(n+" "+last+" "+curr);
            if (curr == last) return false;
            last = curr;            
        }
        return true;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.HasAlternatingBits(5));
        }
    }
}

