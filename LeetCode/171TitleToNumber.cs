public class Solution {
    public int TitleToNumber(String s) {
        int ret = 0;
        for(int i=0;i<s.Length;i++){
            ret *= 26;
            int val = (int)(s[i]-'A')+1;
            ret += val;
        }
        return ret;
    }
}
