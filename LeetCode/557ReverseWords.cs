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
    public string ReverseWords(string s) {
        var builder = new StringBuilder();
        var words = s.Split(' ');
        foreach(var word in words){
            builder.Append(string.Join("", word.Reverse()) + " ");
        }
        return builder.ToString().Trim();
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.ReverseWords("Let's take LeetCode contest"));//"s'teL ekat edoCteeL tsetnoc"
        }
    }
}


