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
    public IList<IList<string>> Partition(string s) {        
        var ret = new HashSet<string>();
        
        for(int i=1;i<=s.Length;i++){
            var sub = s.Substring(0, i);
            if (Valid(sub)){
                if (sub.Length < s.Length){
                    foreach(var l in Partition(s.Substring(i))){
                        var sublist = new List<string>();
                        sublist.Add(sub);
                        sublist.AddRange(l);
                        ret.Add(string.Join(",", sublist));                                            
                    }
                }
                else{
                    var sublist = new List<string>();
                    sublist.Add(sub);
                    ret.Add(string.Join(",", sublist));                    
                }
            }
        }
        
        var list = new List<IList<string>>();
        foreach(var l in ret.Select(sub => sub.Split(','))){
            list.Add(l);
        }
        
        return list;
    }
    
    bool Valid(string s){
        int i=0, j=s.Length-1;
        while(i<j){
            if (s[i]!=s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
                
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            foreach(var list in p.Partition("aab")){
                Console.WriteLine(string.Join(",",list));
            }
        }
    }
}

