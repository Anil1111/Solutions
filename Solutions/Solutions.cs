using System;
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
    }
}
