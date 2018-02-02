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
    public bool IsAdditiveNumber(string num) {
        int len = num.Length;
        for(int l1=1;l1<=len/2;l1++){
            for(int l2=1;len-l1-l2>=Math.Max(l1,l2);l2++){
                var ret = Verify(num,l1,l2);
                //Console.WriteLine(num.Substring(0,l1)+" "+num.Substring(l1,l2)+" "+num.Substring(l1+l2)+" "+ret);
                if (ret) return true;
            }
        }
        return false;        
    }
        
        bool Verify(string num, int l1, int l2){
            var s1 = num.Substring(0,l1);
            var i1 = long.Parse(s1);
            if (i1.ToString() != s1) return false;
            var s2 = num.Substring(l1,l2);
            var i2 = long.Parse(s2);                 
            if (i2.ToString() != s2) return false;
            
            var s3 = num.Substring(l1+l2);           
            var s12 = (i1+i2).ToString();
            
            while(s3.StartsWith(s12)){
                s3 = s3.Substring(s12.Length);
                var tmp = i2;
                i2 = i1+i2;
                i1 = tmp;
                s12 = (i1+i2).ToString();
            }
            if (s3 == "") return true;
            
            return false;
        }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.IsAdditiveNumber("221474836472147483649"));
            Console.WriteLine(p.IsAdditiveNumber("199111992"));
            Console.WriteLine(p.IsAdditiveNumber("0235813"));
            Console.WriteLine(p.IsAdditiveNumber("101"));
            Console.WriteLine(p.IsAdditiveNumber("123"));
            Console.WriteLine(p.IsAdditiveNumber("112358"));
        }
    }
}
