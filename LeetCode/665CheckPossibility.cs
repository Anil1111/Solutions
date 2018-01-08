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
    public bool CheckPossibility(int[] nums) {
        int count = 0, index = 0;
        for(int i=1;i<nums.Length;i++){
            if (nums[i-1]>nums[i]){
                count++;
                index = i;
            }
            if (count > 1) break;
        }
        
        if (count == 1 && index > 0 && index < nums.Length-1){
            bool flag = true;
            int val = nums[index-1];
            nums[index-1] = nums[index];
            for(int i=1;i<nums.Length;i++){
                if (nums[i-1]>nums[i]){
                    flag = false;
                    break;
                }
            }
            if (!flag){
                flag = true;
                nums[index] = nums[index-1] = val;
                for(int i=1;i<nums.Length;i++){
                    if (nums[i-1]>nums[i]){
                        flag = false;
                        break;
                    }
                }
            }
            return flag;
        }
        
        return count < 2;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CheckPossibility(new int[]{1,3,4,5,2})); 
            Console.WriteLine(p.CheckPossibility(new int[]{2,3,3,2,4})); 
            Console.WriteLine(p.CheckPossibility(new int[]{3,4,2,3})); 
            Console.WriteLine(p.CheckPossibility(new int[]{4,2,3})); 
            Console.WriteLine(p.CheckPossibility(new int[]{4,2,1})); 
            
        }
    }
}
