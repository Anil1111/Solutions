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
    public IList<int> FindMinHeightTrees(int n, int[,] edges) {       
        var leaves = new List<int>();
        if (n == 1){
            leaves.Add(0);
            return leaves;
        }
        
        HashSet<int>[] adj = new HashSet<int>[n];
        for(int i=0;i<n;i++) adj[i] = new HashSet<int>();
        for(int i=0;i<edges.GetLength(0);i++){
            adj[edges[i,0]].Add(edges[i,1]);
            adj[edges[i,1]].Add(edges[i,0]);
        }       
        
        for (int i = 0; i < n; ++i){
            if (adj[i].Count == 1) leaves.Add(i);
        }

        while (n > 2) {
            n -= leaves.Count;
            var newLeaves = new List<int>();
            foreach (int i in leaves) {
                int j = adj[i].First();
                adj[j].Remove(i);
                if (adj[j].Count == 1) newLeaves.Add(j);
            }
            leaves = newLeaves;
        }

        return leaves;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(string.Join(",",p.FindMinHeightTrees(1, new int[,]{})));
            Console.WriteLine(string.Join(",",p.FindMinHeightTrees(7, new int[,]{{0,1},{1,2},{1,3},{2,4},{3,5},{4,6}})));
            Console.WriteLine(string.Join(",",p.FindMinHeightTrees(6, new int[,]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}})));
        }
    }
}
