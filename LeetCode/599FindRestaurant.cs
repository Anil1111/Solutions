//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;
using System.Text;

namespace Rextester
{
    public class Program
    {
    public string[] FindRestaurant(string[] list1, string[] list2) {
        var dict = new Dictionary<string, int>();
        for(int i=0;i<list1.Length;i++){
            dict[list1[i]] = i;
        }
        int min = int.MaxValue;
        var list = new List<string>();
        for(int i=0;i<list2.Length;i++){
            int j;
            if (dict.TryGetValue(list2[i], out j)){
                j += i;
                //Console.WriteLine(j.ToString()+" "+list2[i]);
                if (j < min){
                    min = j;
                    list.Clear();
                    list.Add(list2[i]);
                }
                else if (j == min){
                    list.Add(list2[i]);
                }
            }
        }
        
        return list.ToArray();
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(string.Join(",",p.FindRestaurant(new string[]{"Shogun","Tapioca Express","Burger King","KFC"},new string[]{"KFC","Burger King","Tapioca Express","Shogun"})));
        }
    }
}


