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
    public bool JudgePoint24(int[] nums) {
        var vals = Calculate(nums.Select(n => (double)n).ToList());
        
        //need to calcualte 2 by 2 results
        Sublists(vals, nums, 0, 1);
        Sublists(vals, nums, 0, 2);
        Sublists(vals, nums, 0, 4);
        
        //Console.WriteLine(string.Join(" ", vals));
        return vals.Any(v => v.ToString() == "24");
    }            
        
        void Sublists(List<double> ret, int[] nums, int x, int y){
            var l1 = new List<double>();
            var l2 = new List<double>();
            for(int i=0;i<nums.Length;i++){
                if (i == x || i == y) l1.Add((double)nums[i]);
                else l2.Add((double)nums[i]);
            }
            
            l1 = Calculate(l1);
            l2 = Calculate(l2);
            foreach(var v1 in l1){
                foreach(var v2 in l2){
                    AddVal(ret, v1, v2);
                }
            }
        }
        
        List<double> Calculate(List<double> nums){
            if (nums.Count == 1) return nums.ToList();
            
            var ret = new List<double>();
            var visited = new HashSet<string>();
            for(int i=0;i<nums.Count;i++){
                var val = nums[i];
                var sublist = new List<double>(nums);
                var key = val.ToString();
                if (visited.Contains(key)) continue;
                visited.Add(key);

                sublist.RemoveAt(i);
                
                var subvals = Calculate(sublist);
                
                //Console.WriteLine(val+": ["+string.Join(",", sublist)+"]"+" ["+string.Join(" ", subvals)+"]");
                    
                foreach(var subval in subvals){                       
                    AddVal(ret, val, subval);
                }
            }
            
            return ret;
        }
        
        void AddVal(List<double> ret, double val, double subval){
            ret.Add(val + subval);
            ret.Add(val - subval);
            ret.Add(subval - val);
            ret.Add(val * subval);
            if (subval != 0) ret.Add(val / subval);
            if (val != 0) ret.Add(subval / val);
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.JudgePoint24(new int[]{1,9,1,2}));
            //Console.WriteLine(p.JudgePoint24(new int[]{3,3,8,8}));
            //Console.WriteLine(p.JudgePoint24(new int[]{1,2,3,4}));
        }
    }
}

