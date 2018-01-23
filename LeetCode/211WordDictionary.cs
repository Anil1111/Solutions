//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
public class TrieNode{
    public TrieNode[] Children = new TrieNode[26];
    public bool IsWord = false;
    public char Val;
    public TrieNode(char val){
        Val = val;
    }
}

public class WordDictionary {
    TrieNode root = new TrieNode(' ');
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        
    }
    
    /** Adds a word into the data structure. */
    public void AddWord(string word) {
        var node = root;
        foreach(var ch in word){
            var nodes = node.Children;
            int i = ch - 'a';
            if (nodes[i] == null){
                nodes[i] = new TrieNode(ch);
            }
            node = nodes[i];
        }
        node.IsWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public bool Search(string word) {
        var list = new List<TrieNode>();
        list.Add(root);
        foreach(var ch in word){
            var newlist = new List<TrieNode>();
            foreach(var node in list){
                var nodes = node.Children;
                if (ch == '.'){
                    for(int i=0;i<nodes.Count();i++){
                        if (nodes[i]!=null) newlist.Add(nodes[i]);
                    }
                }
                else {
                    int i = ch - 'a';
                    if (nodes[i] != null && nodes[i].Val == ch) newlist.Add(nodes[i]);
                }
            }
            list = newlist;
        }
        foreach(var node in list){
            if (node.IsWord) return true;
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.AddWord(word);
 * bool param_2 = obj.Search(word);
 */
    
    public class Program
    {
     
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            //["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
            //[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
            var t = new WordDictionary();
            //t.AddWord("ab");
            //Console.WriteLine(t.Search("a"));
            //Console.WriteLine(t.Search("ab"));
            //["WordDictionary","addWord","addWord","addWord","addWord","search","search","addWord","search","search","search","search","search","search"]
            //[[],["at"],["and"],["an"],["add"],["a"],[".at"],["bat"],[".at"],["an."],["a.d."],["b."],["a.d"],["."]]
            //[null,null,null,null,null,false,false,null,true,true,false,false,true,false]
            t.AddWord("at");
            t.AddWord("and");
            t.AddWord("an");
            t.AddWord("add");
            Console.WriteLine(t.Search("a"));
            Console.WriteLine(t.Search(".at"));
            t.AddWord("bat");
            Console.WriteLine(t.Search(".at"));
            Console.WriteLine(t.Search("an."));
            Console.WriteLine(t.Search("a.d."));
            Console.WriteLine(t.Search("b."));
            Console.WriteLine(t.Search("a.d"));
            Console.WriteLine(t.Search("."));
        }
    }
}

