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
    public int NthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        var indices = new int[primes.Length];
        var factors = new List<int>(primes);
        for(int i=1;i<n;i++){
            int min = int.MaxValue;
            for(int j=0;j<factors.Count;j++){
                if (factors[j] < min) min = factors[j];
            }
            
            ugly[i] = min;
            for(int j=0;j<factors.Count;j++){               
                if (factors[j]==min){
                    indices[j]++;
                    factors[j] = primes[j]*ugly[indices[j]];
                }
            }
        }
        return ugly[n-1];           
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.NthSuperUglyNumber(12, new int[]{2,7,13,19}));//[1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32]
        }
    }
}
