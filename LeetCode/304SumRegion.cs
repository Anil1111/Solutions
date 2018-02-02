//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
public class NumMatrix {
    public int[,] m;
    public NumMatrix(int[,] matrix) {
        m = new int[matrix.GetLength(0)+1,matrix.GetLength(1)+1];
        for(int i=0;i<matrix.GetLength(0);i++){
            for(int j=0;j<matrix.GetLength(1);j++){
                m[i+1,j+1]=m[i,j+1]+m[i+1,j]-m[i,j]+matrix[i,j];
            }
        }
    }
    
    public int SumRegion(int row1, int col1, int row2, int col2) {
        //Console.WriteLine(m[row2+1,col2+1]+"-"+m[row1,col2]+"-"+m[row2,col1]+"+"+m[row1,col1]);
        return m[row2+1,col2+1]-m[row1,col2+1]-m[row2+1,col1]+m[row1,col1];
    }
}
    
    public class Program
    {              
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new NumMatrix(new int[,]{{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}});
            for(int i=0;i<p.m.GetLength(0);i++){
                for(int j=0;j<p.m.GetLength(1);j++){
                    Console.Write(p.m[i,j]+" ");
                }
                Console.WriteLine();
            }
            Console.WriteLine(p.SumRegion(2,1,4,3));//8
            Console.WriteLine(p.SumRegion(1,1,2,2));//11
            Console.WriteLine(p.SumRegion(1,2,2,4));//12
        }
    }
}
