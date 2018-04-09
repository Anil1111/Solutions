public class Solution {
    public int LengthLongestPath(string input) {
        string[] paths = input.Split('\n');
        int[] stack = new int[paths.Length+1];
        int maxLen = 0;
        foreach(string s in paths){
            int lev = s.LastIndexOf('\t')+1, curLen = stack[lev+1] = stack[lev]+s.Length-lev+1;
            if(s.Contains(".")) maxLen = Math.Max(maxLen, curLen-1);
        }
        return maxLen;
    }
}
