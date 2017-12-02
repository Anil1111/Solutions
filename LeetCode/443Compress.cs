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
    public int Compress(char[] chars) {
        if (chars == null) return 0;
        
        int lastindex = 0, appendindex = 0;
        int count = 1;
        for(int i=1;i<chars.Length;i++){
            if (chars[i] == chars[lastindex]){
                count ++;
            }
            else {
                chars[appendindex] = chars[lastindex];
                appendindex++;
                if (count > 1){
                    var countstr = count.ToString();
                    for(int j=0;j<countstr.Length;j++){
                        chars[appendindex] = countstr[j];                    
                        appendindex++;
                    }
                }
                lastindex = i;
                count = 1;
            }
            //Console.WriteLine(count+" ai "+appendindex+" li "+lastindex+" "+string.Join(",", chars));
        }
        
        if (count > 1){
            chars[appendindex] = chars[lastindex];
            appendindex++;
            var countstr = count.ToString();
            for(int j=0;j<countstr.Length;j++){
                chars[appendindex] = countstr[j];                    
                appendindex++;
            }
        }
        else{
            chars[appendindex] = chars[lastindex];
            appendindex++;
        }
        
        return appendindex;
    }
        
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            var chars = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
            var r = p.Compress(chars);
            Console.WriteLine(r+" "+string.Join(",", chars));
            
            chars = new char[]{'a'};
            r = p.Compress(chars);
            Console.WriteLine(r+" "+string.Join(",", chars));
            
            chars = new char[]{'a','a','b','b','c','c','c'};
            r = p.Compress(chars);
            Console.WriteLine(r+" "+string.Join(",", chars));
            
            chars = "zzj".ToArray();
            r = p.Compress(chars);
            Console.WriteLine(r+" "+string.Join(",", chars));
        }
    }
}
