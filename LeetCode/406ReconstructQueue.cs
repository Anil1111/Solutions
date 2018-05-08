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
    public int[,] ReconstructQueue(int[,] people) {
        var result = new List<int[]>();
        var dict = new Dictionary<int, List<int>>();
        for(int i=0;i<people.GetLength(0);i++){
            int l = people[i,0];
            int r = people[i,1];
            List<int> list;
            list = dict.TryGetValue(l, out list) ? list : new List<int>();
            list.Add(r);
            dict[l] = list;
        }
        
        List<int> keys = dict.Keys.OrderByDescending(x=>x).ToList();
        for(int i=0;i<keys.Count;i++){
            var list = dict[keys[i]];
            list.Sort();
            foreach(int j in list){
                //Console.WriteLine("{"+keys[i]+","+j+"} "+result.Count+" "+string.Join(",",list));
                result.Insert(j, new int[]{keys[i], j});
            }
        }
        
        var ret = new int[people.GetLength(0),2];
        for(int i=0;i<people.GetLength(0);i++){
            ret[i,0]=result[i][0];
            ret[i,1]=result[i][1];
        }
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();

            var people = p.ReconstructQueue(new int[,] {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}});
            for(int i=0;i<people.GetLength(0);i++){
                Console.Write("{"+people[i,0]+","+people[i,1]+"},");
            }
            Console.WriteLine();
        }
    }
}
