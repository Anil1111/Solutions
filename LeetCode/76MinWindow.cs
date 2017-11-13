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
    public string MinWindow(string s, string t) {
        if (s.Length==0||t.Length==0) return "";
        
        var dict = new Dictionary<char, int>();
        foreach(var ch in t){
            if (dict.ContainsKey(ch)) dict[ch]++;
            else dict[ch]=1;
        }
        
        int start=0,end=0,count=t.Length,minstart=-1,minlen=int.MaxValue;        
        while(start<=end&&end<s.Length){
            if (count>0){
                if (dict.ContainsKey(s[end])){
                    dict[s[end]]--;
                    if (dict[s[end]]>=0) count--;
                    //Console.WriteLine("end  +"+end+" "+s[end]+" "+dict[s[end]]+" # "+count);
                }
            }
            
            if (count>0){ 
                end++;
            }
            else{
                while(start<=end&&count==0){
                    //Console.WriteLine("start "+start+" end "+end+" len "+minlen+" # "+count);
                    int newlen = end-start+1;
                    if (newlen<minlen){
                        minlen=newlen;
                        minstart=start;
                    }

                    if (dict.ContainsKey(s[start])){
                        dict[s[start]]++;
                        if (dict[s[start]]>0){
                            count++;
                            end++;
                        }
                        //Console.WriteLine("start-"+start+" "+s[start]+" "+dict[s[start]]+" # "+count);
                    }
                    start++;
                }
            }      
            //Console.WriteLine("start "+start+" end "+end+" len "+minlen+" # "+count);
        };
        
        if (minstart>=0) return s.Substring(minstart, minlen);
        return "";
    }
        
        public static void Main(string[] args)
        {
            //Your code goes here
            var p = new Program();
            //Console.WriteLine(p.MinWindow("ADOBECODEBANC", "ABC"));
            //Console.WriteLine("result: "+p.MinWindow("a", "a"));
            //Console.WriteLine("result: "+p.MinWindow("aa", "aa"));
            Console.WriteLine("result: "+p.MinWindow(
                "rsfvquycmabtdxcmgwnoxiicpzxczxnspungqokcolwtlahrzvhwfqawraytxoloibuzpgdfsbbdeiwdddbivcenefidttrbuoclugtmjurncpqitssqwzdcelfxhwadkdrhlktueniicaqxulosktuohbnqantmsktdupaaeilgkdgfowzapuoyxdoxriklufprurtabehlipsylszampzltpjmxvxucolzfezglgutvmtgesjsikedzppzkotmdelkknrvvnqrzkzeekwmucpwrgvdvosaufkgsdeoquhqggwltuxpxplovguswmssrdzkidyzzfrgnnrghqwghjvfqpxodshuvgefjeeijvqzkjhsafyhpvohmmvpecmbkqgvxnggkwhvgppiwprlngubuqryufbfvjcsyibjhkgpbxxyoolbwgdqwwqsbtzydctdmwovgukkthiiytjwzonxkfsnzroevhhifydnsqxozhwzbhwcwlciquyrlmvhvfradwpxmnnoujnxtjcpueznyzellcuijnkokanypbmlmcjhllyiryxpxdclfxtqkeewguxvxlglnptbcrjtpikplnatmvjybqvhkucjfjutanufffawnnlacntoldmmtjufdwo",
                "jhkeiyapffpbu"));
        }
    }
}
