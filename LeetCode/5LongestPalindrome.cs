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
    public string LongestPalindrome(string s) {
        var r = string.Join("",s.Reverse());
        
        var ret = "";
        var dict = new Dictionary<string, int>();
        dict[s] = 0;
        while(dict.Count>0){
            var newdict = new Dictionary<string, int>();
            foreach(var sub in dict.Keys){
                var i = dict[sub];                
                var ri = r.IndexOf(sub, i);
                
                if (ri==i) Console.WriteLine(i+" "+ri+" "+(r.Length-i)+" "+r+" "+sub);
                                   
                if (ri == i){
                    return sub;
                }
                if (sub.Length > 1){
                    newdict[sub.Substring(1)] = i;
                    newdict[sub.Substring(0, sub.Length-1)] = i+1;
                }
            }
            dict = newdict;
        }
        
        return ret;
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            var p = new Program();
            Console.WriteLine(p.LongestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
            Console.WriteLine(p.LongestPalindrome("abb"));
            Console.WriteLine(p.LongestPalindrome("babad"));
            Console.WriteLine(p.LongestPalindrome("cbbd"));
        }
    }
}

