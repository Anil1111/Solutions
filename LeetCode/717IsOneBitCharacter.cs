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
    public bool IsOneBitCharacter(int[] bits) {
        return Bit(bits, 0);
    }
        
        public bool Bit(int[] bits, int i){                        
            if (i == bits.Length-1){
                if (bits[i]==0) return true;
                return false;
            }
            else if (i == bits.Length-2){
                if (bits[i] == 1) return false;
                return Bit(bits, i+1);
            }
            
            if (bits[i] == 1) return Bit(bits, i+2);
            
            return Bit(bits, i+1);
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();

            Console.WriteLine(p.IsOneBitCharacter(new int[]{0,1,0}));     
            Console.WriteLine(p.IsOneBitCharacter(new int[]{1,0,0}));     
            Console.WriteLine(p.IsOneBitCharacter(new int[]{1,1,1,0}));     
            Console.WriteLine(p.IsOneBitCharacter(new int[]{1,0,0,1,1,0}));             
        }
    }
}
