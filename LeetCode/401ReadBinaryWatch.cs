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
    public IList<string> ReadBinaryWatch(int num) {
        var list = new List<string>();
        
        for(int i=0;i<1024;i++){
            int digits = 0;
            int d = i;
            while(d>0){
                if ((d&1) == 1) digits++;
                d=d>>1;
            }
            if (digits == num){
                int hour = i / 64;
                int min = i % 64;
                
                if (hour < 12 && min < 60){
                    list.Add(hour.ToString()+":"+min.ToString("00"));
                }
            }
        }
        
        return list;
    }   
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            foreach(var s in p.ReadBinaryWatch(2)){
                Console.Write(s+" ");
            }
            Console.WriteLine();
        }
    }
}
