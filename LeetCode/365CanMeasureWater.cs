//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Windows;

namespace Rextester
{
    public class Program
    {
    public class Point{
        public int X{get; set;}
        public int Y{get; set;}
        public Point(int x, int y){
            X = x;
            Y = y;
        }
    }
    public bool CanMeasureWater(int x, int y, int z) {
        bool[,] dp = new bool[x+1,y+1];
        
        List<Point> list = new List<Point>();        
        Add(dp, list, new Point(0,0));
        Add(dp, list, new Point(x,0));
        Add(dp, list, new Point(0,y));
        Add(dp, list, new Point(x,y));
        while(list.Count > 0){
            var first = list.First();
            list.RemoveAt(0);
            int x1 = first.X;
            int y1 = first.Y;
            
            if (x1+y1 == z) return true;            
            //Console.WriteLine(x1+" "+y1);
            
            if (!dp[0,y1]) Add(dp, list, new Point(0, y1));
            if (!dp[x1,0]) Add(dp, list, new Point(x1, 0));
            if (x1+y1 < x && !dp[x1+y1,0]) Add(dp, list, new Point(x1+y1,0));
            if (x1+y1 < y && !dp[0, x1+y1]) Add(dp, list, new Point(0, x1+y1));
            if (!dp[x,y1]) Add(dp, list, new Point(x, y1));
            if (!dp[x1,y]) Add(dp, list, new Point(x1,y));

            int y2 = y-y1;
            int x2 = x-y2;
            if (y2 > 0 && x2 > 0 && !dp[x2,y2]) Add(dp, list, new Point(x2,y2));
            x2 = x-x1;
            y2 = y1-x2;
            if (x2 > 0 && y2 > 0 && !dp[x2,y2]) Add(dp, list, new Point(x2,y2));
        }
        
        return false;
    }
        
        void Add(bool[,] dp, List<Point> list, Point point){
            dp[point.X, point.Y] = true;
            list.Add(point);
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.CanMeasureWater(3,5,4));
            Console.WriteLine(p.CanMeasureWater(2,6,5));
            //Console.WriteLine(p.CanMeasureWater(22003,31237,1));
        }
    }
}
