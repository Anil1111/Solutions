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
    public int FindMaxConsecutiveOnes(int[] nums) {
        int max = 0, count = 0;
        foreach(int num in nums){
            if (num == 1){
                count ++;
                if (count > max) max = count;
            }
            else{
                count = 0;
            }
        }
        return max;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.FindMaxConsecutiveOnes(new int[]{1,1,0,1,1,1})); 
          
        }
    }
}
