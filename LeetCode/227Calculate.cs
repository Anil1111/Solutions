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
    public int Calculate(string s) {
        string numStr="";
        var ops = new List<char>();
        var vals = new List<int>();
        foreach(var ch in s){
            switch(ch){
                case '+':
                case '-':
                case '*':
                case '/':
                    ops.Add(ch);
                    vals.Add(int.Parse(numStr));
                    numStr = "";
                    break;
                default:
                    numStr += ch;
                    break;
            }
        }
        vals.Add(int.Parse(numStr));
        
        //Console.WriteLine(string.Join("",ops)+" "+string.Join(",",vals));
        while(ops.Count > 0){
            var newops = new List<char>();
            int offset = 0;
            for(int i=0;i<ops.Count;i++){
                switch(ops[i]){
                    case '+':
                    case '-':
                        newops.Add(ops[i]);
                        break;
                    case '*':
                        vals[i-offset] = vals[i-offset]*vals[i+1-offset];
                        vals.RemoveAt(i+1-offset);                    
                        offset++;
                        break;
                    case '/':
                        vals[i-offset] = vals[i-offset]/vals[i+1-offset]; 
                        vals.RemoveAt(i+1-offset);
                        offset++;
                        break;
                }
            }
                       
            if (newops.Count == ops.Count) break;
            
            ops = newops;
        }
        
        //Console.WriteLine(string.Join("",ops)+" "+string.Join(",",vals));        
        int ret = vals[0];
        for(int i=0;i<ops.Count;i++){
            switch(ops[i]){
                case '+':
                    ret += vals[i+1];
                    break;
                case '-':
                    ret -= vals[i+1];
                    break;
            }
        }
        
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.Calculate("2*3*4"));
            Console.WriteLine(p.Calculate("2*3+4"));
            Console.WriteLine(p.Calculate("3+2*2"));
        }
    }
}

