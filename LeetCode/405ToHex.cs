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
    public string ToHex(int num) {
        long n;
        StringBuilder sb = new StringBuilder();

        if (num >= 0){ 
            n = num;            
        }
        else {
            n = uint.MaxValue + num + 1;
        }
        
        while(n > 0){
            int r = (int)(n % 16);
            sb.Insert(0, GetHex(r));
            n = n / 16;
        }
            
        if (n < 0) sb.Insert(0, '-');
        if (sb.Length == 0) sb.Append('0');
            
        return sb.ToString();
    }
    
    public char GetHex(int num){
        if (num < 10) return (char)((int)'0'+num);
        else return (char)((int)'a'+num-10);
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.ToHex(-1));
            Console.WriteLine(p.ToHex(0));
            Console.WriteLine(p.ToHex(65536));
        }
    }
}
