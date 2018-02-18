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
    public IList<string> LetterCasePermutation(string S) {
        var ret = new List<string>();
        if (S == null) return ret;
        if (S == "") {
            ret.Add(S);
            return ret;
        }
        return LetterCase(S, 0).ToList();
    }
    
    HashSet<string> LetterCase(string S, int pos){
        var ret = new HashSet<string>();
        string changed = "";        
        if (S[pos] != char.ToLower(S[pos])){
            changed += pos>0 ? S.Substring(0,pos) : "";
            changed += char.ToLower(S[pos]);
            changed += pos<S.Length-1 ? S.Substring(pos+1) : "";
        }
        else if (S[pos] != char.ToUpper(S[pos])){
            changed += pos>0 ? S.Substring(0,pos) : "";
            changed += char.ToUpper(S[pos]);
            changed += pos<S.Length-1 ? S.Substring(pos+1) : "";            
        }
        //Console.WriteLine(pos+" "+S+" "+changed);
        
        if (pos == S.Length-1){
            ret.Add(S);
            if (changed != "") ret.Add(changed);
            return ret;
        }
        
        ret.UnionWith(LetterCase(S, pos+1));
        if (changed != "") ret.UnionWith(LetterCase(changed, pos+1));
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",",p.LetterCasePermutation("a1b2")));
        }
    }
}

