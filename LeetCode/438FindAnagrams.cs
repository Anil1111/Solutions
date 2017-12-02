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
    public IList<int> FindAnagrams(string s, string p) {
        var ret = new List<int>();
        var dict = new Dictionary<char, int>();
        foreach(var ch in p){
            int val = 0;
            dict.TryGetValue(ch, out val);
            dict[ch] = val + 1;
        }
        
        var check = new Dictionary<char, int>();
        for(int j=0;j<p.Length&&j<s.Length;j++){
            var ch = s[j];
            if (dict.ContainsKey(ch)){
                int val = 0;
                check.TryGetValue(ch, out val);
                check[ch] = val + 1;
            }
        }
        if (Match(dict, check)) ret.Add(0);
        
        for(int i=1;i<=s.Length-p.Length;i++){
            var ch = s[i-1];
            if (dict.ContainsKey(ch)){
                check[ch] --;
                if (check[ch] == 0) check.Remove(ch);
            }
            ch = s[i+p.Length-1];
            if (dict.ContainsKey(ch)){
                int val = 0;
                check.TryGetValue(ch, out val);
                check[ch] = val + 1;
            }
            if (Match(dict, check)) ret.Add(i);
        }
                       
        return ret;
    }
        
        public bool Match(Dictionary<char, int> dict, Dictionary<char, int> check){
            if (dict.Count() == check.Count()){
                bool match = true;
                foreach(var key in dict.Keys){
                    if (dict[key] != check[key]) match = false;
                }
                
                return match;
            }
            
            return false;
        }
        
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(string.Join(",", p.FindAnagrams(s: "", p: "a")));
            Console.WriteLine(string.Join(",", p.FindAnagrams(s: "cbaebabacd", p: "abc")));
            Console.WriteLine(string.Join(",", p.FindAnagrams(s: "abab", p: "ab")));
            Console.WriteLine(string.Join(",", p.FindAnagrams(s: "baa", p: "aa")));
        }
    }
}
