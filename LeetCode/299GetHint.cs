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
    public string GetHint(string secret, string guess) {        
        var dict = new Dictionary<char, int>();
        int a = 0, b = 0;
        var list = new List<char>();
        for(int i=0;i<secret.Length;i++){
            var ch = secret[i];
            if (guess[i] == ch){
                a++;
            }
            else{
                int count;
                dict.TryGetValue(ch, out count);
                dict[ch] = count + 1;
                list.Add(guess[i]);
            }
        }
        for(int i=0;i<list.Count;i++){
            var ch = list[i];
            int count;
            if (dict.TryGetValue(ch, out count)){
                b++;
                
                if (count == 1) dict.Remove(ch);
                else dict[ch] = count - 1;
            }
        }
        return a.ToString()+"A"+b.ToString()+"B";
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.GetHint("1122", "1222"));
            Console.WriteLine(p.GetHint("11", "10"));
        }
    }
}
