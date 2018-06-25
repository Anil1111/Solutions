public class Solution {
    public bool BuddyStrings(string A, string B) {
        if (A.Length != B.Length || A.Length < 2) return false;
        
        List<char> diffa = new List<char>(), diffb = new List<char>();
        HashSet<char> seta = new HashSet<char>();
        for(int i=0;i<A.Length;i++){
            seta.Add(A[i]);
            if (A[i] != B[i]) {
                diffa.Add(A[i]);
                diffb.Add(B[i]);
                
                if (diffa.Count > 2) return false;
            }
        }
        
        if (diffa.Count == 0) return seta.Count < A.Length;
        if (diffa[0]==diffb[1] && diffa[1]==diffb[0]) return true;
        return false;
    }
}
