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
    public int MaxAreaOfIsland(int[,] grid) {
        int ret = 0;
        for(int i=0;i<grid.GetLength(0);i++){
            for(int j=0;j<grid.GetLength(1);j++){
                int island = Crawl(grid, i, j);
                if (island > ret) ret = island;
            }
        }
        
        return ret;
    }
    
    private int Crawl(int[,] grid, int i, int j){
        int ret = 0;
        var connected = new List<Tuple<int, int>>();
        if (Land(grid, i, j)){
            connected.Add(new Tuple<int, int>(i,j));
            while(connected.Count > 0){
                var list = new List<Tuple<int, int>>();
                foreach(var t in connected){
                    ret++;
                    if (Land(grid, t.Item1-1, t.Item2)) list.Add(new Tuple<int, int>(t.Item1-1, t.Item2));
                    if (Land(grid, t.Item1, t.Item2-1)) list.Add(new Tuple<int, int>(t.Item1, t.Item2-1));
                    if (Land(grid, t.Item1+1, t.Item2)) list.Add(new Tuple<int, int>(t.Item1+1, t.Item2));
                    if (Land(grid, t.Item1, t.Item2+1)) list.Add(new Tuple<int, int>(t.Item1, t.Item2+1));
                }
                connected = list;
            }
            //Console.WriteLine(i+" "+j+" "+ret);
        }
        return ret;
    }
    
    private bool Land(int[,] grid, int i, int j){
        if (i>=0 && i<grid.GetLength(0) && j>=0 && j<grid.GetLength(1)){
           if (grid[i,j] == 1){
               grid[i,j] = 0;
               return true;
           }
        }
        return false;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.MaxAreaOfIsland(new int[,]{{1,1,0,0,0},{1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}}));
        }
    }
}

