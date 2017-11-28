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
        long m1=long.MinValue, m2=long.MinValue, m3=long.MinValue;
        foreach(var n in nums){
            if (n > m1){
                var tmp1 = m1;
                m1 = n;
                if (tmp1 > m2){
                    var tmp2 = m2;
                    m2 = tmp1;
                    if (tmp2 > m3) m3 = tmp2;
                }
                else if (tmp1 == m2) continue;
                else if (tmp1 > m3) m3 = tmp1;
            }
            else if (n == m1){
                continue;
            }
            else if (n > m2){
                var tmp2 = m2;
                m2 = n;
                if (tmp2 > m3) m3 = tmp2;
            }
            else if (n == m2) continue;
            else if (n > m3) m3 = n;
            
            //Console.WriteLine(string.Join(" ", new int[]{m1, m2, m3}));
        }
        
        if (m3 > long.MinValue) return (int)m3;
        else return (int)m1;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //Console.WriteLine(p.ThirdMax(new int[]{3, 2, 1}));
            //Console.WriteLine(p.ThirdMax(new int[]{5, 2, 2}));
            Console.WriteLine(p.ThirdMax(new int[]{1,2,-2147483648}));
        }
    }
}
