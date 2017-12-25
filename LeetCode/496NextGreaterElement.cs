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
    public int[] NextGreaterElement(int[] findNums, int[] nums) {
        var ret = new List<int>();
        var dict = new Dictionary<int, int>();
        for(int i=0;i<nums.Length;i++){
            dict[nums[i]] = i+1;
        }
        
        //assume numbers in first array always exist in second array
        for(int i=0;i<findNums.Length;i++){
            int start;
            int val = -1;
            if (dict.TryGetValue(findNums[i], out start)){
                for(int j=start;j<nums.Length;j++){
                    if (nums[j] > findNums[i]){
                        val = nums[j];
                        break;
                    }
                }                
            }    
            ret.Add(val);
        }
        
        return ret.ToArray();
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",", p.NextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}))); 
            Console.WriteLine(string.Join(",", p.NextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}))); 
        }
    }
}
