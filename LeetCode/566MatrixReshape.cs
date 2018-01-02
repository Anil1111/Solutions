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
    public int[,] MatrixReshape(int[,] nums, int r, int c) {
        if (r * c != nums.GetLength(0) * nums.GetLength(1)) return nums;
        
        var ret = new int[r,c];
        int row = 0, count = 0;
        for(int i=0;i<nums.GetLength(0);i++){
            for(int j=0;j<nums.GetLength(1);j++){
                ret[row, count] = nums[i,j];
                count++;
                if (count >= c){
                    count = 0;
                    row ++;
                }
            }
        }
        return ret;
    }
        
        private string Print(int[,] input){
            var builder = new StringBuilder();
            for(int i=0;i<input.GetLength(0);i++){
                for(int j=0;j<input.GetLength(1);j++){
                    builder.Append(input[i,j]);
                    builder.Append(",");
                }
                builder.Append("\r\n");
            }
            return builder.ToString();
        }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.Print(p.MatrixReshape(new int[,]{{1,2},{3,4}}, 1, 4)));
            Console.WriteLine(p.Print(p.MatrixReshape(new int[,]{{1,2},{3,4}}, 2, 4)));
            Console.WriteLine(p.Print(p.MatrixReshape(new int[,]{{1,2},{3,4}}, 4, 1)));
        }
    }
}


