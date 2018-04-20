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
    public int LongestSubstring(string s, int k) {
        int max = 0;
        for(int i=0;i<s.Length;i++){   
            if (max > s.Length-i) break;
            
            int[] array = new int[26];
            
            for(int j=i;j<s.Length;j++){
                //Console.WriteLine(i+" "+j);
                int len = j - i + 1;

                array[s[j]-'a']++;
                
                bool flag = true;
                for(int x=0;x<26;x++){
                    if (array[x]>0 && array[x]<k){
                      flag = false;
                      break;  
                    } 
                }
                if (flag && max<len){
                    //Console.WriteLine(i+" "+j+" "+flag+" "+len);
                    max = len;
                }
            }
        }
        return max;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.LongestSubstring("aacbbbdc", 2));
        }
    }
}
