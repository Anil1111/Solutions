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
        int count1 = 1;
        int total = tickets.GetLength(0)+1;
        DFS(dict, next, ref count1, total, ret);
        return ret;
    }
        
        void DFS(Dictionary<string, SortedDictionary<string, int>> dict, string curr, ref int count, int total, List<string> ret){
            if (dict.ContainsKey(curr)){
                //Console.WriteLine(count+" "+curr+" "+string.Join(",",dict[curr].Keys));
                var list = dict[curr].Keys.Where(key => dict[curr][key] > 0).ToList();
                for(int i=0;i<list.Count;i++){
                    var next = list[i];
                    //Console.WriteLine(count+" "+curr+" "+next+" "+string.Join(",",list));
                    dict[curr][next]--;
                    count++;
                    DFS(dict, next, ref count, total, ret);
                    if (count == total) {
                        ret.Insert(1, next);
                        return;
                    }
                    dict[curr][next]++;
                    count--;
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
