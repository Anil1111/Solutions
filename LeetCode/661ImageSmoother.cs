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
    public int[,] ImageSmoother(int[,] M) {
        var ret = new int[M.GetLength(0), M.GetLength(1)];
        
        for(int i=0;i<ret.GetLength(0);i++){
            for(int j=0;j<ret.GetLength(1);j++){
                ret[i,j]=Avg(M, i, j);
            }
        }
        
        return ret;
    }
        
        public int Avg(int[,] M, int x, int y){
            int sum = 0, count = 0;
            for(int i=-1;i<=1;i++){
                for(int j=-1;j<=1;j++){
                    if (x+i >= 0 && x+i < M.GetLength(0) &&
                        y+j >= 0 && y+j < M.GetLength(1)){
                        sum += M[x+i,y+j];
                        count ++;
                    }
                }
            }
            //Console.WriteLine(x+" "+y+" "+sum+" "+count);
            return sum/count;
        }
        
        private static void Print(int[,] ret){
            for(int i=0;i<ret.GetLength(0);i++){
                for(int j=0;j<ret.GetLength(1);j++){
                    Console.Write(ret[i,j]+" ");
                }
                Console.WriteLine();
            }
        }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            var ret = p.ImageSmoother(new int[,]{{1,1,1},{1,0,1},{1,1,1}});
            Print(ret);
            Console.WriteLine();
            
            ret = p.ImageSmoother(new int[,]{{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}});            
            //[[4,4,5],[5,6,6],[8,9,9],[11,12,12],[13,13,14]]
            Print(ret);
        }
    }
}


