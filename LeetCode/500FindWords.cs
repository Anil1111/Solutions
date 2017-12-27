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
    public string[] FindWords(string[] words) {
        var ret = new List<string>();
        var dict = new Dictionary<char, HashSet<char>>();
        var charsets = new char[][]{"qwertyuiop".ToArray(), "asdfghjkl".ToArray(), "zxcvbnm".ToArray()};
        foreach(var charset in charsets){
            foreach(var ch in charset){
                dict[ch] = new HashSet<char>(charset);
            }
        }
        
        foreach(var word in words){
            var lower = word.ToLower();
            var charset = dict[lower[0]];
            bool flag = true;
            for(int i=1;i<lower.Length;i++){
                if (!charset.Contains(lower[i])){
                    flag = false;
                    break;
                }
            }
            if (flag) ret.Add(word);
        }
        
        return ret.ToArray();
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",", p.FindWords(new string[]{"Hello", "Alaska", "Dad", "Peace"}))); 
        }
    }
}
