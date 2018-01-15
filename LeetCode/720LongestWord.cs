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
    public string LongestWord(string[] words) {
        var set = new HashSet<string>(words);
        var sorted = words.OrderByDescending(w => w.Length);
        int max = 0;
        var list = new List<string>();        
        foreach(var w in sorted){
            if (w.Length < max) break;
            if (!set.Contains(w)) continue;
            
            set.Remove(w);
            bool flag = true;
            for(int i=1;i<w.Length;i++){
                if (set.Contains(w.Substring(0, w.Length-i))){
                    set.Remove(w);
                }
                else{
                    flag = false;
                    break;
                }
            }
            if (flag){
                max = w.Length;
                list.Add(w);
            }
        }
        
        //Console.WriteLine(string.Join(",", list));
        return list.OrderBy(w => w).FirstOrDefault();
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.LongestWord(new string[]{"w","wo","wor","worl","world"}));
        }
    }
}

