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
    public int NumSimilarGroups(string[] A) {
        var r = new bool[A.Length, A.Length];
        
        for(int i=0;i<A.Length;i++){
            for(int j=i+1;j<A.Length;j++){
                int count = 0;
                for(int k=0;k<A[i].Length;k++){
                    if (A[i][k]!=A[j][k]) count++;
                    if (count > 2) break;
                }
                if (count == 2) {
                    //Console.WriteLine(count+" "+i+" "+A[i]+" "+j+" "+A[j]);
                    r[i,j]=true;
                    r[j,i]=true;
                }
            }
        }
        
        int ret = 0;
        var v = new HashSet<int>();
        for(int i=0;i<r.GetLength(0);i++){
            if (!v.Contains(i)){
                ret++;
                var stack = new Stack<int>();
                stack.Push(i);
                while(stack.Count>0){
                    var p = stack.Pop();
                    for(int j=0;j<r.GetLength(0);j++){
                        if (!v.Contains(j) && r[p,j]){
                            v.Add(j);
                            stack.Push(j);
                        }
                    }
                }
            }
        }
        
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //2
            Console.WriteLine(p.NumSimilarGroups(new string[]{"ajdidocuyh","djdyaohuic","ddjyhuicoa","djdhaoyuic","ddjoiuycha","ddhoiuycja","ajdydocuih","ddjiouycha","ajdydohuic","ddjyouicha"}));
            //5
            Console.WriteLine(p.NumSimilarGroups(new string[]{"kccomwcgcs","socgcmcwkc","sgckwcmcoc","coswcmcgkc","cowkccmsgc","cosgmccwkc","sgmkwcccoc","coswmccgkc","kowcccmsgc","kgcomwcccs"}));
            //2
            Console.WriteLine(p.NumSimilarGroups(new string[]{"tars","rats","arts","star"}));
            //1
            Console.WriteLine(p.NumSimilarGroups(new string[]{"blw","bwl","wlb"}));
        }
    }
}
