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
    int guessNumber(int n) {
        int low = 1, high = n;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int g = guess(mid);
            if (g == 0) return mid;
            if (g == -1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return 0;
    }

    int guess(int n){
        if (n < 6) return 1;
        if (n > 6) return -1;
        return 0;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            Console.WriteLine(p.guessNumber(10));
        }
    }
}
