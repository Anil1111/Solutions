public class Solution {
    public int LongestPalindrome(string s) {
        var dict = new Dictionary<char, int>();
        foreach(var ch in s){
            if (!dict.ContainsKey(ch)) dict[ch]=0;
            dict[ch]++;
        }
        int odd = 0, even = 0;
        foreach(var val in dict.Values){
            even += val / 2 * 2;
            odd += val %2;
        }
        if (odd > 0) return even + 1;
        else return even;
    }
}
