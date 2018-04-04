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
    public int KthSmallest(int[,] matrix, int k) {
        int n = matrix.GetLength(0);
        int[] starts = new int[n];
        int count = 0;
        int start = 0;
        while(count < k){
            int min = int.MaxValue;
            start = -1;
            for(int i=0;i<n;i++){
                if (starts[i]<n){
                    int val = matrix[i,starts[i]];
                    if (val < min){
                        start = i;
                        min = val;
                    }
                }
            }
            count++;
            starts[start]++;
        }
        return matrix[start, starts[start]-1];
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.KthSmallest(new int[,]{{1}}, 1));
            Console.WriteLine(p.KthSmallest(new int[,]{{1,5,9},{10,11,13},{12,13,15}}, 8));
        }
    }
}
