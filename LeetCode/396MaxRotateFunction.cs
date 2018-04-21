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
    public int MaxRotateFunction(int[] A) {
        int len = A.Length;
        if (len == 0) return 0;
        
        int sum = 0, total = 0;
        for(int i=0;i<len;i++){
            sum += i*A[i];
            total += A[i];
        }
        int max = sum;
        for(int i=1;i<len;i++){
            //Console.WriteLine(sum);
            sum = sum - total + len*A[i-1];
            
            if (sum > max) max = sum;
        }
        return max;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.MaxRotateFunction(new int[]{4,3,2,6}));
        }
    }
}
