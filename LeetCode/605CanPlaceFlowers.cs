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
    public bool CanPlaceFlowers(int[] flowerbed, int n) {
        int len = 0, sum = 0;
        for(int i=0;i<flowerbed.Length;i++){
            if(flowerbed[i]==1) {
                sum += (len-1)/2;                
                if (sum >= n) return true;
                len=0;
            }
            else {
                len ++;                
            }
        }
        sum += (len-1)/2;
        if (sum >= n) return true;
        
        len=0;
        for(int i=0;i<flowerbed.Length&&flowerbed[i]==0;i++){
            len++;
        }
        if (len>1 && len<flowerbed.Length) sum++;
        if (len == flowerbed.Length) sum++;
        int right=0;
        for(int i=flowerbed.Length-1;i>=len&&flowerbed[i]==0;i--){
            right++;
        }
        if (right>1) sum++;
        //Console.WriteLine(len+" "+right+" "+sum);
            
        return sum >= n;
    }
       
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            
            Console.WriteLine(p.CanPlaceFlowers(new int[]{1,0,0,0,1}, 1));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{1,0,0,0,1}, 2));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0,0,1,0,1}, 1));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0}, 1));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0,0,0}, 2));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0,0,1}, 2));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0,1,0}, 1));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{1,0,0,0,0}, 2));
            Console.WriteLine(p.CanPlaceFlowers(new int[]{0,0}, 2));
        }
    }
}


