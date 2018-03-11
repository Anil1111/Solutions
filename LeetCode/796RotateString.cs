public class Solution {
    public bool RotateString(string A, string B) {
        if (A==null) return B == null;
        if (A=="") return B == "";
        if (A.Length != B.Length) return false;
        if (A == B) return true;
        
        for(int i=1;i<A.Length;i++){
            if (A[i] == B[0]){
                var tmp = A.Substring(i)+A.Substring(0, i);
                if (tmp == B) return true;
            }
        }    
        return false;
    }   
}
