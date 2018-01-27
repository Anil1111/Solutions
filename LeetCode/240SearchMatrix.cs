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
    public bool SearchMatrix(int[,] matrix, int target) {
        int c = matrix.GetLength(1), r = matrix.GetLength(0); 
        if (r == 0 || c == 0) return false;
               
        return Search(matrix, 0, r-1, 0, c-1, target);
    }
        
        bool Search(int[,] matrix, int lr, int rr, int lc, int rc, int target){
            //Console.WriteLine(lr+" "+rr+", "+lc+" "+rc);
            if(lr<=rr && lc<=rc){
                int mr = lr + (rr-lr)/2;
                int mc = lc + (rc-lc)/2;
                
                //Console.WriteLine(lr+" "+rr+", "+lc+" "+rc+" "+matrix[mr,mc]+" "+target);
                if (matrix[mr,mc] > target){
                    if (Search(matrix, lr, mr-1, lc, rc, target)) return true;
                    if (Search(matrix, mr, rr, lc, mc-1, target)) return true;
                    return false;
                }
                else if (matrix[mr,mc] < target){
                    if (Search(matrix, lr, rr, mc+1, rc, target)) return true;
                    if (Search(matrix, mr+1, rr, lc, rc, target)) return true;
                    return false;
                }
                else return true;
            }
            
            return false;
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.SearchMatrix(new int[,]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
            Console.WriteLine(p.SearchMatrix(new int[,]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},20));
            Console.WriteLine(p.SearchMatrix(new int[,]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}},5));
            Console.WriteLine(p.SearchMatrix(new int[,]{{1,1}},2));
            Console.WriteLine(p.SearchMatrix(new int[,]{{1,4},{2,5}},2));
        }
    }
}

