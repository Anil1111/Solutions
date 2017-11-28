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
    public string AddStrings(string num1, string num2) {
        StringBuilder sb = new StringBuilder();
        int len = num1.Length > num2.Length ? num1.Length : num2.Length;
        
        int sum = 0;
        for(int i=1;i<=len;i++){
            var n1 = 0;
            var i1 = num1.Length-i;
            if (i1 >=0) n1 = (int)(num1[i1]-'0');                           
            var n2 = 0;
            var i2 = num2.Length-i;
            if (i2 >=0) n2 = (int)(num2[i2]-'0');
            
            sum = n1 + n2 + sum;
            sb.Insert(0, (char)(sum%10+(int)'0'));
            sum = sum / 10;
            
            //Console.WriteLine(n1+" "+n2+" "+sum+" "+sb.ToString());
        }
        
        if (sum > 0) sb.Insert(0, (char)(sum+(int)'0'));
        
        return sb.ToString();
    }

        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.AddStrings("1232", "29"));
        }
    }
}
