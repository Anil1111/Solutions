public class Solution {
    public int NumJewelsInStones(string J, string S) {
        var set = new HashSet<char>(J.ToCharArray());
        int ret = 0;
        foreach(var ch in S){
            if (set.Contains(ch)) ret++;
        }
        return ret;
    }
}
