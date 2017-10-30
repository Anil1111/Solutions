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
        
    public int RomanToInt(string s) {
        int ret = 0;
        var list = new List<int>();
        foreach(char ch in s){
            switch(ch){
                case 'I':
                    list.Add(1);
                    break;
                case 'V':
                    list.Add(5);
                    break;
                case 'X':
                    list.Add(10);
                    break;
                case 'L':
                    list.Add(50);
                    break;
                case 'C':
                    list.Add(100);
                    break;
                case 'D':
                    list.Add(500);
                    break;
                case 'M':
                    list.Add(1000);
                    break;
            }
        }
        
        for(int i=0;i<list.Count-1;i++){
            if (list[i]<list[i+1]) ret-=list[i];
            else ret+=list[i];                
        }
        return ret+list[list.Count-1];
    }
               
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            Console.WriteLine(p.RomanToInt("III"));
            Console.WriteLine(p.RomanToInt("IV"));
            Console.WriteLine(p.RomanToInt("XIII"));
            Console.WriteLine(p.RomanToInt("XVIII"));
        }
    }
}
