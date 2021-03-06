﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Solutions
{
    public class Solution
    {
        #region evalRPN
        public int evalRPN(String[] tokens)
        {
            List<int> numList = new List<int>();
            for (int i = 0; i < tokens.Length; i++)
            {
                switch (tokens[i])
                {
                    case "+":
                        Console.WriteLine("Handle +");
                        if (numList.Count < 2) throw new InvalidCastException("not enough number for +");
                        int newvalue = numList[numList.Count - 2] + numList[numList.Count - 1];
                        numList[numList.Count - 2] = newvalue;
                        numList.RemoveAt(numList.Count - 1);
                        break;
                    case "-":
                        Console.WriteLine("Handle -");
                        if (numList.Count < 2) throw new InvalidCastException("not enough number for -");
                        newvalue = numList[numList.Count - 2] - numList[numList.Count - 1];
                        numList[numList.Count - 2] = newvalue;
                        numList.RemoveAt(numList.Count - 1);
                        break;
                    case "*":
                        Console.WriteLine("Handle *");
                        if (numList.Count < 2) throw new InvalidCastException("not enough number for *");
                        newvalue = numList[numList.Count - 2] * numList[numList.Count - 1];
                        numList[numList.Count - 2] = newvalue;
                        numList.RemoveAt(numList.Count - 1);
                        break;
                    case "/":
                        Console.WriteLine("Handle /");
                        if (numList.Count < 2) throw new InvalidCastException("not enough number for /");
                        newvalue = numList[numList.Count - 2] / numList[numList.Count - 1];
                        numList[numList.Count - 2] = newvalue;
                        numList.RemoveAt(numList.Count - 1);
                        break;
                    default:
                        Console.WriteLine("Add " + tokens[i]);
                        int result;
                        if (int.TryParse(tokens[i], out result))
                        {
                            numList.Add(result);
                        }
                        else
                        {
                            throw new InvalidCastException(tokens[i] + " not a number");
                        }
                        break;
                }
            }

            if (numList.Count != 1) throw new InvalidCastException("no result, possible invalid input");

            return numList[0];
        }
        #endregion

        #region findSteps
        private string SortedCommaDelimitedString(List<int> list)
        {
            StringBuilder ret = new StringBuilder();

            list.Sort();
            foreach (int i in list)
            {
                ret.Append(i);
                ret.Append(',');
            }

            return ret.ToString(0, ret.Length - 1);
        }

        /// <summary>
        /// string is sorted List<int> command delimieted string representation 
        /// </summary>
        /// <param name="n"></param>
        /// <returns></returns>
        private Dictionary<string, List<int>> findStepsList(int n)
        {
            Dictionary<string, List<int>> ret = new Dictionary<string, List<int>>();

            if (n == 1)
            {
                ret.Add("1", new List<int> { 1 });
            }
            else
            {
                Dictionary<string, List<int>> subset = findStepsList(n - 1);
                foreach (string key in subset.Keys)
                {
                    List<int> list = subset[key];

                    //Console.WriteLine(string.Format("{1}    {0}", key, n - 1));

                    //append 1
                    List<int> copy = new List<int>();
                    copy.AddRange(list);
                    copy.Add(1);

                    string copyString = SortedCommaDelimitedString(copy);
                    if (!ret.ContainsKey(copyString))
                    {
                        ret.Add(copyString, copy);
                    }

                    //Console.WriteLine(string.Format("{1} +1 {0}", copyString, n));

                    //add 1 to each element
                    for (int i = 0; i < list.Count; i++)
                    {
                        //Console.WriteLine(string.Format("{1} ++ {0}", copyString, n - 1));
                        copy = new List<int>(list);
                        copy[i] = copy[i] + 1;

                        copyString = SortedCommaDelimitedString(copy);
                        if (!ret.ContainsKey(copyString))
                        {
                            ret.Add(copyString, copy);

                            //Console.WriteLine(string.Format("{1} ++ {0}", copyString, n));
                        }
                    }
                }
            }

            return ret;
        }

        public int findSteps(int n)
        {
            Dictionary<string, List<int>> ret = findStepsList(n);

            foreach (string key in ret.Keys)
            {
                Console.WriteLine(key);
            }

            return ret.Count;
        }
        #endregion

        #region isAnagram
        private Dictionary<char, int> StringToCharDict(string input1)
        {
            Dictionary<char, int> dict = new Dictionary<char, int>();
            foreach (char c in input1.ToCharArray())
            {
                if (dict.ContainsKey(c))
                {
                    dict[c]++;
                }
                else
                {
                    dict[c] = 1;
                }
            }

            return dict;
        }

        public bool isAnagram(string input1, string input2)
        {
            if (input1.Length != input2.Length) return false;

            Dictionary<char, int> dict1 = StringToCharDict(input1),
                dict2 = StringToCharDict(input2);

            if (dict1.Keys.Count != dict2.Keys.Count) return false;

            foreach (Char c in dict1.Keys)
            {
                if (dict1[c] != dict2[c]) return false;
            }

            return true;
        }
        #endregion

        #region generate all anagrams
        /// <summary>
        /// basic answer, using recursive calls
        /// </summary>
        /// <param name="input"></param>
        /// <returns></returns>
        public List<string> allAnagrams(string input)
        {
            HashSet<string> ret = new HashSet<string>();

            if (input.Length > 1)
            {
                for (int i = 0; i < input.Length; i++)
                {
                    string subinput = input.Substring(0, i) + input.Substring(i + 1, input.Length - i - 1);

                    string singlechar = input.Substring(i, 1);
                    List<string> subanagrams = allAnagrams(subinput);

                    //Console.WriteLine("{0} {1} {2}", singlechar, subinput, subanagrams.Count);

                    //combine the letter
                    foreach (string subanagram in subanagrams)
                    {
                        for (int j = 0; j <= subanagram.Length; j++)
                        {
                            string newstring = subanagram.Insert(j, singlechar);
                            if (!ret.Contains(newstring)) ret.Add(newstring);
                        }
                    }
                }
            }
            else
            {
                ret.Add(input);
            }

            return ret.ToList();
        }
        #endregion

        #region generate all anagrams optimized
        /// <summary>
        /// for sub anagram, only need to take unique single char from input
        /// </summary>
        /// <param name="input"></param>
        /// <returns></returns>
        public List<string> allAnagramsOptimized(string input)
        {
            HashSet<string> ret = new HashSet<string>();
            HashSet<char> charSet = new HashSet<char>();

            if (input.Length > 1)
            {
                for (int i = 0; i < input.Length; i++)
                {
                    if (charSet.Contains(input[i]))
                    {
                        continue;
                    }

                    //calculate anagram from subinput
                    charSet.Add(input[i]);

                    string singlechar = input.Substring(i, 1);
                    string subinput = input.Substring(0, i) + input.Substring(i + 1, input.Length - i - 1);
                    List<string> subanagrams = allAnagramsOptimized(subinput);

                    //Console.WriteLine("{0} {1} {2}", singlechar, subinput, subanagrams.Count);

                    //combine the singlechar back to anagrams from subinput
                    foreach (string subanagram in subanagrams)
                    {
                        for (int j = 0; j <= subanagram.Length; j++)
                        {
                            string newstring = subanagram.Insert(j, singlechar);
                            if (!ret.Contains(newstring)) ret.Add(newstring);
                        }
                    }
                }
            }
            else
            {
                ret.Add(input);
            }

            return ret.ToList();
        }
        #endregion

        #region stave
        double center(string input, out int sum){
            sum = 0;
            int weightedsum = 0;
            for(int i=0;i<input.Length;i++){
                int digit = Convert.ToInt32(input[i]);
                sum+=digit;
                weightedsum += (i+1)*digit;
            }                       
            return weightedsum/(double)sum;
        }
                
        bool closeenough(double c1, double c2){
            double diff = Math.Abs(c1 - c2);
            return (diff < 0.0000001);
        }

        /// <summary>
        /// TODO: possible optimization, char to int once
        /// for each calculation, save the intermediate sum and weightedsum
        /// </summary>
        /// <param name="input"></param>
        public void stave(string input)
        {
            /*
            123232111119232333277777999
            7 15 6
            7512839182731294837512653698759387212532563849823857812519853546649398328875256156256652116394915985281859358394738256421937941843758954891723598716547856473245243546392898871987152656238458214518158188152527386384518234758325165316563487283746285745938476523546127534721652812736459874658475366423876152387491872658763218276354827768598716283764571652637451962837648726876547826359871629836547862534761798346918275676473829648651672346981726587619462561625162561527384273482748237482734827348274827
            10 262 229
            */
            int length = input.Length / 2;
            //search length backward
            for (int len = length; len > 0; len--)
            {
                try
                {
                    //start index of first half
                    for (int j = 0; j < input.Length - len * 2; j++)
                    {
                        int sum;
                        double cent = center(input.Substring(j, len), out sum);
                        //Console.WriteLine("a {0} {1} {2} {3} {4}", len, j, len, cent, sum);
                        //start index of second half
                        for (int k = j + len; k < input.Length - len; k++)
                        {
                            int testsum;
                            double testcent = center(input.Substring(k, len), out testsum);
                            //Console.WriteLine("b {0} {1} {2} {3} {4} {5}", j, k, len, testcent, sum, testsum);
                            if (sum == testsum && (closeenough(cent, testcent) ||
                                  closeenough((len - testcent), cent)))
                            {
                                Console.WriteLine("{0} {1} {2}", j, k, len);
                                return;
                            }
                        }
                    }
                }
                catch (Exception ex)
                {
                    //Console.WriteLine("{0} {1}", ex.Message, ex.StackTrace);
                }
            }
        }
        #endregion
    }
}
