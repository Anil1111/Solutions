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
    public IList<int[]> KSmallestPairs(int[] nums1, int[] nums2, int k) {
        IList<int[]> ret = new List<int[]>();
        if (nums1.Length == 0 || nums2.Length == 0 || k == 0) {
            return ret;
        }
        
        int[] index = new int[nums1.Length];
        while (k-- > 0) {
            int min_val = int.MaxValue;
            int in1 = -1;
            for (int i = 0; i < nums1.Length; i++) {
                if (index[i] >= nums2.Length) {
                    continue;
                }
                if (nums1[i] + nums2[index[i]] < min_val) {
                    min_val = nums1[i] + nums2[index[i]];
                    in1 = i;
                }
            }
            if (in1 == -1) {
                break;
            }
            int[] temp = new int[]{nums1[in1], nums2[index[in1]]};
            ret.Add(temp);
            index[in1]++;
        }
        return ret;
  }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p= new Program();
            foreach(var pair in p.KSmallestPairs(new int[]{1,2,4,5,6}, new int[]{3,5,7,9}, 3)){
                Console.Write(pair[0]+","+pair[1]+" ");
            }
            Console.WriteLine();

            foreach(var pair in p.KSmallestPairs(new int[]{1,7,11}, new int[]{2,4,6}, 3)){
                Console.Write(pair[0]+","+pair[1]+" ");
            }
            Console.WriteLine();
            
            foreach(var pair in p.KSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 10)){
                Console.Write(pair[0]+","+pair[1]+" ");
            }
            Console.WriteLine();
            
            foreach(var pair in p.KSmallestPairs(new int[]{1,1,2}, new int[]{1,2,3}, 2)){
                Console.Write(pair[0]+","+pair[1]+" ");
            }
            Console.WriteLine();
                                  
            foreach(var pair in p.KSmallestPairs(new int[]{1,2,3}, new int[]{1,2}, 3)){
                Console.Write(pair[0]+","+pair[1]+" ");
            }            
        }
    }
}
