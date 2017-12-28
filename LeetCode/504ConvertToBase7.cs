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
    public string ConvertToBase7(int num) {
        if (num == 0) return "0";
            
        var builder = new StringBuilder();
        
        bool negative = num < 0;
        if (negative) num = -num;
        
        while(num > 0){
            int d = num % 7;
            builder.Insert(0, d.ToString());
            num = num / 7;
        }
               
        if (negative) builder.Insert(0, '-');
        
        return builder.ToString();
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(p.ConvertToBase7(100)); 
            Console.WriteLine(p.ConvertToBase7(-7)); 
        }
    }
}
