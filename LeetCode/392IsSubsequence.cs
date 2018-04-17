public class Solution {
    public bool IsSubsequence(string s, string t) {
        return IsSubsequence(s, t, 0, 0);
    }
    
    bool IsSubsequence(string s, string t, int sstart, int tstart) {
        if (sstart >= s.Length) return true;
        
        while(tstart < t.Length && s[sstart] != t[tstart]){
            tstart++;
        }
        
        if (tstart < t.Length && s[sstart] == t[tstart]){
            return IsSubsequence(s, t, sstart+1, tstart+1);
        }
        
        return false;
    }
}
