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
    public int CombinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        for(int i=0;i<dp.Length;i++) dp[i] = -1;
        return CombinationSum4(nums, target, dp);
    }
        
    public int CombinationSum4(int[] nums, int target, int[] dp) {
        int count = 0;
        for(int i=nums.Length-1;i>=0;i--){
            int num = nums[i];
            if (num == target){
                count ++;
            }
            else if (num < target){                
                int temp = dp[target - num];
                if (temp < 0){
                    temp = CombinationSum4(nums, target - num, dp);
                    //Console.WriteLine((target-num) + " " + temp);
                    dp[target - num] = temp;
                }
                count += temp;
            }
        }
        return count;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p= new Program();
            Console.WriteLine(p.CombinationSum4(new int[]{3,33,333}, 10000));
            Console.WriteLine(p.CombinationSum4(new int[]{1,2,3}, 32));
            Console.WriteLine(p.CombinationSum4(new int[]{1,2,3}, 4));
        }
    }
}
