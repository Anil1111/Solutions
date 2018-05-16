//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;

namespace Rextester
{
    public class Program
    {
    public string FindReplaceString(string S, int[] indexes, string[] sources, string[] targets) {
        StringBuilder builder = new StringBuilder();
        
        var sDict = new Dictionary<int, string>();
        var tDict = new Dictionary<int, string>();
        for(int i=0;i<indexes.Length;i++){
            sDict[indexes[i]]=sources[i];
            tDict[indexes[i]]=targets[i];
        }
        Array.Sort(indexes);
        
        //Console.WriteLine(string.Join(",",indexes));
        
        int last = 0;
        for(int i=0;i<indexes.Length;i++){
            int curr = indexes[i];
            if (curr > last){
                builder.Append(S.Substring(last, curr-last));
                last = curr;
            }
            if (Match(S,curr,sDict[indexes[i]])){
                builder.Append(tDict[indexes[i]]);
                last=curr+sDict[indexes[i]].Length;
            }
        }
        if (last < S.Length) builder.Append(S.Substring(last));
        return builder.ToString();
    }
    
    bool Match(string S, int start, string source){
                          
        for(int i=0;i<source.Length;i++){
            if (S[i+start]!=source[i]) return false;
        }
        //Console.WriteLine(source+" "+S.Substring(start, source.Length));
        return true;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //Console.WriteLine(p.CanPartition(new int[]{3,3,3,4,5}));
            //Console.WriteLine(p.FindReplaceString("vmokgggqzp",new int[]{3,5,1},new string[]{"kg","ggq","mo"},new string[]{"s","so","bfr"}));
            Console.WriteLine(p.FindReplaceString("jjievdtjfb",new int[]{4,6,1},new string[]{"md","tjgb","jf"},new string[]{"foe","oov","e"}));
        }
    }
}    

    
    
