public class Solution {
    public int FirstUniqChar(string s) {
        var dict = new Dictionary<char, int>();
        var array = s.ToCharArray();
        foreach(var ch in array){
            if (!dict.ContainsKey(ch)) dict[ch]=0;
            dict[ch] = dict[ch]+1;
        }
        for(int i=0;i<array.Length;i++)
            if (dict[array[i]]==1) return i;
        return -1;
    }
}
