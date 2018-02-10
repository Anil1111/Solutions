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
        var dict = new Dictionary<string, SortedDictionary<string, int>>();
        for(int i=0;i<tickets.GetLength(0);i++){
            SortedDictionary<string, int> sortedDict;
            if (!dict.TryGetValue(tickets[i,0], out sortedDict)) sortedDict = new SortedDictionary<string, int>();
            int count;
            sortedDict.TryGetValue(tickets[i,1], out count);
            sortedDict[tickets[i,1]] = count + 1;
            dict[tickets[i,0]] = sortedDict;
        }
               
        var ret = new List<string>();
        var next = "JFK";
        ret.Add(next);
        DFS(dict, next, ret);
        return ret;
    }
        
        void DFS(Dictionary<string, SortedDictionary<string, int>> dict, string curr, List<string> ret){
            if (dict.ContainsKey(curr)){
                //Console.WriteLine(curr+" "+string.Join(",",dict[curr].Keys));
                while(dict[curr].Keys.Count() > 0){
                    var next = dict[curr].Keys.First();
                    dict[curr][next]--;
                    if (dict[curr][next]==0) dict[curr].Remove(next);
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
