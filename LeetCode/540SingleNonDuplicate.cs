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
    public int SingleNonDuplicate(int[] nums) {
        int start=1, end=nums.Length-1;
        while(start<end){
            int mid = start + (end - start) / 2;
            if (mid % 2 == 0) mid --;
            
            if (nums[mid-1]==nums[mid]){
                start = mid + 2;
            }
            else{
                end = mid;
            }
            //Console.WriteLine(nums[mid]+" ["+mid+"] "+nums[start]+" ["+start+"] "+nums[end]+" ["+end+"]");
        }
        return nums[start-1];
    }      
      
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            //ask if input is sorted
            var p = new Program();        
            Console.WriteLine(p.SingleNonDuplicate(new int[]{1,1,2,3,3,4,4,8,8}));
            Console.WriteLine(p.SingleNonDuplicate(new int[]{3,3,7,7,10,11,11}));
        }
    }
}
