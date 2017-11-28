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
    public int ThirdMax(int[] nums) {
        int? m1=null,m2=null,m3=null;
        foreach(var n in nums){
            if (m1 == n || m2 == n || m3 == n) continue;
            if (m1 == null || n > m1){
                m3 = m2;
                m2 = m1;
                m1 = n;
            }
            else if (m2 == null || n > m2){
                m3 = m2;
                m2 = n;
            }
            else if (m3 == null || n > m3) m3 = n;
            //Console.WriteLine(string.Join(" ", new int[]{m1.GetValueOrDefault(), m2.GetValueOrDefault(), m3.GetValueOrDefault()}));
        }

        return m3 == null ? m1.GetValueOrDefault() : m3.Value;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.ThirdMax(new int[]{3, 2, 1}));
            //Console.WriteLine(p.ThirdMax(new int[]{5, 2, 2}));
            Console.WriteLine(p.ThirdMax(new int[]{1,2,-2147483648}));
        }
    }
}
