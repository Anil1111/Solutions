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
    public IList<string> SummaryRanges(int[] nums) {
        var ret = new List<string>();
        if (nums == null || nums.Length == 0) return ret;
        
        int last = nums[0];
        string str = last.ToString();
        for(int i=1;i<nums.Length;i++){
            if (nums[i]-1==last){
                last++;
            }
            else if (last.ToString() == str){
                ret.Add(str);
                last = nums[i];
                str = last.ToString();
            }
            else{
                ret.Add(str+"->"+last.ToString());
                last = nums[i];
                str = last.ToString();
            }
        }
        if (last.ToString() == str){
            ret.Add(str);
        }
        else{
            ret.Add(str+"->"+last.ToString());
        }
        
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",",p.SummaryRanges(new int[]{0,1,2,4,5,7})));
        }
    }
}

