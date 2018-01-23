//Rextester.Program.Main is the entry point for your code. Don't change it.
//Compiler version 4.0.30319.17929 for Microsoft (R) .NET Framework 4.5

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text.RegularExpressions;

namespace Rextester
{
public class Trie {
    public class TrieNode {
        public char val;
        public bool isWord; 
        public TrieNode[] children = new TrieNode[26];
        public TrieNode() {}
        public TrieNode(char c){
            val = c;
            children = null;
            isWord = false;
        }
    }

    private TrieNode[] children = new TrieNode[26];
        
    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void Insert(string word) {
        var nodes = children;
        var last = nodes;
        foreach(var c in word){
            int i = c-'a';
            if (nodes[i] == null){
                nodes[i] = new TrieNode(c);
            }
            if (nodes[i].children == null){
                nodes[i].children = new TrieNode[26];
            }
            last = nodes;
            nodes = nodes[i].children;
        }
        last[word[word.Length-1]-'a'].isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public bool Search(string word) {
        var nodes = children;
        TrieNode[] last = null;
        foreach(var c in word){
            int i = c-'a';
            if (nodes == null) return false;
            if (nodes[i] == null) return false;
            last = nodes;
            nodes = nodes[i].children;
        }
        
        return last == null ? false : last[word[word.Length-1]-'a'].isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public bool StartsWith(string prefix) {
        var nodes = children;
        foreach(var c in prefix){
            int i = c-'a';
            if (nodes == null) return false;
            if (nodes[i] == null) return false;        
            nodes = nodes[i].children;
        }
        
        return true;
    }
}    

 /**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.Insert(word);
 * bool param_2 = obj.Search(word);
 * bool param_3 = obj.StartsWith(prefix);
 */
    
    public class Program
    {
     
        public static void Main(string[] args)
        {
            //Your code goes here
            Console.WriteLine("Hello, world!");
            //["Trie","insert","search","startsWith"] '
            //[[],["a"],["a"],["a"]]
            //["Trie","insert","search","search","startsWith","startsWith"]
            //[[],["ab"],["a"],["ab"],["a"],["ab"]]
            var t = new Trie();
            t.Insert("ab");
            Console.WriteLine(t.Search("a"));
            Console.WriteLine(t.Search("ab"));
            Console.WriteLine(t.StartsWith("a"));
            Console.WriteLine(t.StartsWith("ab"));
        }
    }
}

