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
    public IList<IList<int>> LargeGroupPositions(string S) {
        IList<IList<int>> ret = new List<IList<int>>();
        char last = ' ';
        int count = 0, start = 0;
        for(int i=0;i<S.Length;i++){
            char ch = S[i];
            if (ch==last){
                count++;
            }
            else{
                if (count >= 3){
                    var list = new List<int>();
                    list.Add(start);
                    list.Add(i-1);
                    ret.Add(list);
                }
                start = i;
                count = 1;
                last = ch;
            }
        }
        if (count >= 3){
            var list = new List<int>();
            list.Add(start);
            list.Add(S.Length-1);
            ret.Add(list);
        }
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            foreach(var list in p.LargeGroupPositions("aaa")) Console.WriteLine(string.Join(",",list));
        }
    }
}
