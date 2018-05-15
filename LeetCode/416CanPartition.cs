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
    public bool CanPartition(int[] nums) {
        int sum = 0;
        foreach(int i in nums) sum += i;       
        
        if (sum % 2 == 1) return false;
        
        sum /= 2;

        Array.Sort(nums);
        return Sum(nums, sum);
    }
    
    bool Sum(int[] nums, int target){
        if (target==0) return true;
        
        for(int i=nums.Length-1;i>=0;i--){
            //Console.WriteLine(i+" "+nums[i]+" "+target);
            if (nums[i] > target) return false;
            
            if (nums[i] > 0 && nums[i] <= target){
                int temp = nums[i];               
                nums[i]=0;
                if (Sum(nums, target-temp)) return true;
                nums[i]=temp;
            }
        }
        
        return false;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //Console.WriteLine(p.CanPartition(new int[]{3,3,3,4,5}));
            Console.WriteLine(p.CanPartition(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
                                                       1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,100}));
        }
    }
}    

    
    
