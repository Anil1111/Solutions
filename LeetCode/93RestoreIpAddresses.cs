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
    public IList<string> RestoreIpAddresses(string s) {
        var ret = new HashSet<string>();
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                for(int k=1;k<=3;k++){
                    var l = s.Length-i-j-k;
                    if (l>=1 && l<=3){
                        //Console.WriteLine(s.Substring(0, i)+"."+s.Substring(i, j)+"."+s.Substring(i+j, k)+"."+s.Substring(i+j+k));
                        var ii = int.Parse(s.Substring(0, i));
                        if (ii > 255) continue;
                        var ij = int.Parse(s.Substring(i, j));
                        if (ij > 255) continue;
                        var ik = int.Parse(s.Substring(i+j, k));
                        if (ik > 255) continue;
                        var il = int.Parse(s.Substring(i+j+k));
                        if (il > 255) continue;
                        var r = ii+"."+ij+"."+ik+"."+il;
                        if (r.Length == s.Length + 3) ret.Add(r);
                    }
                }
            }
        }
        return ret.ToList();
    }
        
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join("\r\n",p.RestoreIpAddresses("010010")));
            Console.WriteLine(string.Join("\r\n",p.RestoreIpAddresses("25525511135")));
        }
    }
}

