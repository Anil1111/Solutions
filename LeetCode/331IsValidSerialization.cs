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
    public bool IsValidSerialization(string preorder) {
        int depth = 1;
        foreach(var token in preorder.Split(',')){
            if (depth == 0) return false;
            if (token == "#") depth--;
            else depth++;
        }
        return depth == 0;
    }        
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.IsValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
            Console.WriteLine(p.IsValidSerialization("1,#"));
            Console.WriteLine(p.IsValidSerialization("9,#,#,1"));
        }
    }
}

