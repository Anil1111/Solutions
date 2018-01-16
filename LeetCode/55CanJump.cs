public class Solution {
    public bool CanJump(int[] A) {
        int max = 0;
        for(int i=0;i<A.Length;i++){
            if(i>max) {return false;}
            max = Math.Max(A[i]+i,max);
        }
        return true;
    }
}
