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
    public void WiggleSort(int[] nums) {
        var sorted = nums.OrderBy(x => x).ToArray();
        int n = nums.Length;
        int median = sorted[n/2];
        
        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[NewIndex(i,n)] > median) {
                Swap(nums, NewIndex(left++,n), NewIndex(i++,n));
            }
            else if (nums[NewIndex(i,n)] < median) {
                Swap(nums, NewIndex(right--,n), NewIndex(i,n));
            }
            else {
                i++;
            }
        }
    }

        private int NewIndex(int index, int n) {
            return (1 + 2*index) % (n | 1);
        }
        
        private void Swap(int[] nums, int x, int y){
            int tmp = nums[x];
            nums[x] = nums[y];
            nums[y] = tmp;
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var nums = new int[]{1,2,2,1,2,1,1,1,1,2,2,2};
            p.WiggleSort(nums); Console.WriteLine(string.Join(",", nums));
            nums = new int[]{1, 5, 1, 1, 6, 4};
            p.WiggleSort(nums); Console.WriteLine(string.Join(",", nums));
            nums = new int[]{1, 3, 2, 2, 3, 1};
            p.WiggleSort(nums); Console.WriteLine(string.Join(",", nums));
            nums = new int[]{1};
            p.WiggleSort(nums); Console.WriteLine(string.Join(",", nums));
        }
    }
}
