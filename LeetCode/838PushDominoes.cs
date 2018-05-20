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
    public string PushDominoes(string dominoes) {
        char[] ret = dominoes.ToCharArray();
        int lastR = -1;
        for(int i=0;i<ret.Length;i++){
            //Console.WriteLine(i+" "+ret[i]+" "+string.Join("", ret));
            switch(ret[i]){               
                case 'L':
                   // Console.WriteLine(i+" "+lastR+" "+ret[i]+" "+string.Join("", ret));
                    if (lastR < 0){
                        for(int j=i-1;j>=0&&ret[j]=='.';j--){
                            ret[j]='L';
                        }
                    }
                    else{
                        int r = lastR+1;
                        for(int l=i-1;l>r;l--,r++){
                            ret[l]='L';
                            ret[r]='R';
                        }
                        lastR = -1;
                    }
                    break;
                case 'R':
                    //Console.WriteLine(i+" "+ret[i]+" "+string.Join("", ret));
                    if (lastR >= 0){
                        for(int r=lastR+1;r<i;r++){
                            ret[r]='R';
                        }                
                    }
                    lastR = i;
                    break;
            }
        }
        
        if (lastR >= 0){
            for(int i=lastR+1;i<dominoes.Length;i++){
                ret[i]='R';
            }                
        }
        
        return string.Join("", ret);
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.PushDominoes("L.....RR.RL.....L.R."));
        }
    }
}
