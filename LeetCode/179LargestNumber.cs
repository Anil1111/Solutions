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
    public string LargestNumber(int[] nums) {
        var list = nums.Select(n => n.ToString());
        var list1 = list.OrderByDescending(s => s.PadRight(10, s[0]));
        var list2 = list.OrderByDescending(s => s.PadRight(10, s[s.Length-1]));        
        var str1 = string.Join("", list1).TrimStart('0');
        var str2 = string.Join("", list2).TrimStart('0');
        var ret = string.Compare(str1, str2) > 0 ? str1 : str2;
        return ret == "" ? "0" : ret;
    }    
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.LargestNumber(new int[]{824,938,1399,5607,6973,5703,9609,4398,8247}));//"9609938824824769735703560743981399"
            Console.WriteLine(p.LargestNumber(new int[]{0, 0}));
            Console.WriteLine(p.LargestNumber(new int[]{121, 12}));
            Console.WriteLine(p.LargestNumber(new int[]{3, 30, 34, 5, 9}));
        }
    }
}

