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
    public char NextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.Length - 1;
        while(start<end){
            int mid = start + (end-start)/2;
            
            //Console.WriteLine(start+" "+mid+" "+end);

            if (letters[mid]<target){
                start = mid+1;
            }
            else if (target<letters[mid]){
                end = mid;
            }
            else end = mid;
        }
               
        while (target >= letters[end]){
            end++;
            if (end > letters.Length-1){
                end = 0;
                break;
            }
        }
        return letters[end];
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.NextGreatestLetter("eeekqqqvvy".ToCharArray(), 'q'));
            Console.WriteLine(p.NextGreatestLetter("cfj".ToCharArray(), 'k'));
            Console.WriteLine(p.NextGreatestLetter("cfj".ToCharArray(), 'j'));
        }
    }
}

