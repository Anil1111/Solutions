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
    public IList<int> DiffWaysToCompute(string input) {
        string numStr="";
        var ops = new List<char>();
        var vals = new List<int>();
        foreach(var ch in input){
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

        return Compute(ops, vals).ToList();
    }
        
        List<int> Compute(List<char> ops, List<int> vals){           
            var ret = new List<int>();
            if (ops.Count == 0){
                ret.Add(vals.First());
                return ret;
            }
            if (ops.Count == 1){
                ret.Add(Compute1(ops.First(), vals.First(), vals.Last()));
                return ret;
            }
            
            var val = vals.First();
            var subops = ops.GetRange(1, ops.Count-1);
            var subvals = vals.GetRange(1, vals.Count-1);
            var subret = Compute(subops, subvals);
            foreach(var sub1 in subret){
                ret.Add(Compute1(ops.First(), vals.First(), sub1));
            }
            val = vals.Last();
            subops = ops.GetRange(0, ops.Count-1);
            subvals = vals.GetRange(0, vals.Count-1);
            subret = Compute(subops, subvals);
            foreach(var sub in subret){
                ret.Add(Compute1(ops.Last(), sub, vals.Last()));
            }

            //Console.WriteLine(string.Join("", ops)+" "+string.Join(",",vals));
            
            for(int i=1;i<ops.Count-1;i++){
                subops = ops.GetRange(0, i);
                subvals = vals.GetRange(0, i+1);
                subret = Compute(subops, subvals);

                subops = ops.GetRange(i+1, ops.Count-i-1);
                subvals = vals.GetRange(i+1, vals.Count-i-1);
                var subret1 = Compute(subops, subvals);

                foreach(var sub in subret){
                    foreach(var sub1 in subret1){
                        ret.Add(Compute1(ops[i], sub, sub1));
                    }
                }
            }
            return ret;
        }
        
        int Compute1(char op, int v1, int v2){
            switch(op){
                case '+': return v1+v2;
                case '-': return v1-v2;
                case '*': return v1*v2;
                case '/': return v1/v2;
            }
            return 0;
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(" ",p.DiffWaysToCompute("2*3-4*5")));
            Console.WriteLine(string.Join(" ",p.DiffWaysToCompute("2-1-1")));
        }
    }
}

