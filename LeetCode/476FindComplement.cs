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
    public int FindComplement(int num) {        
        int count = 0, ret = num;
        while(num != 0){
            count = (count << 1) + 1;
            num = num >> 1;
        }
        
        //print(count);
        ret = ret ^ count;
        
        return ret;
    }
        
        private void print(int x){
            Console.WriteLine(Convert.ToString(x, 2));
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
    
            foreach(var i in new int[]{2, 5, 0, 6}){
                Console.WriteLine(Convert.ToString(i, 2)+" => "+Convert.ToString(p.FindComplement(i), 2));
            }
        }
    }
}

