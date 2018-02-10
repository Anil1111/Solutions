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
    public IList<string> FindItinerary(string[,] tickets) {
        var dict = new Dictionary<string, List<string>>();
        for(int i=0;i<tickets.GetLength(0);i++){
            List<string> list;
            if (!dict.TryGetValue(tickets[i,0], out list)) list = new List<string>();
            list.Add(tickets[i,1]);
            dict[tickets[i,0]] = list;
        }
               
        var ret = new List<string>();
        var next = "JFK";
        ret.Add(next);
        DFS(dict, next, ret);
        return ret;
    }
        
        void DFS(Dictionary<string, List<string>> dict, string curr, List<string> ret){
            if (dict.ContainsKey(curr)){
                var sorted = dict[curr].OrderBy(s => s);
                while(dict[curr].Count() > 0){
                    var next = sorted.First();
                    dict[curr].Remove(next);
                    DFS(dict, next, ret);
                    ret.Insert(1, next);
                }
            }
        }
               
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            //["JFK","ANU","EZE","AXA","TIA","ANU","JFK","TIA","ANU","TIA","JFK"]
            Console.WriteLine(string.Join(",", p.FindItinerary(new string[,]{{"EZE","AXA"},{"TIA","ANU"},{"ANU","JFK"},{"JFK","ANU"},{"ANU","EZE"},{"TIA","ANU"},{"AXA","TIA"},{"TIA","JFK"},{"ANU","TIA"},{"JFK","TIA"}})));
            Console.WriteLine(string.Join(",", p.FindItinerary(new string[,]{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}})));
            Console.WriteLine(string.Join(",", p.FindItinerary(new string[,]{{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}})));
            Console.WriteLine(string.Join(",", p.FindItinerary(new string[,]{{"MUC","LHR"},{"JFK","MUC"},{"SFO","SJC"},{"LHR","SFO"}})));
            Console.WriteLine(string.Join(",", p.FindItinerary(new string[,]{{"JFK","ATL"},{"ATL","JFK"}})));
        }
    }
}
