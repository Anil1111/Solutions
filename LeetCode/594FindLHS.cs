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
    public int FindLHS(int[] nums) {
        var dict = new Dictionary<int, int>();
        foreach(var num in nums){
            int count;
            dict.TryGetValue(num, out count);
            dict[num] = count + 1;
        }
        int ret = 0;
        foreach(var key in dict.Keys){
            int count;
            if (dict.TryGetValue(key+1, out count)){
                count += dict[key];
                if (count > ret) ret = count;
            }
        }
        return ret;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(p.FindLHS(new int[]{1,3,2,2,5,2,3,7}));
        }
    }
}


