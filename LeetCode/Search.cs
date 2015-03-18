public class Solution {
    public bool Search(int[] A, int target) {
        for(int i=0;i<A.Length;i++){
            if (A[i]==target) return true;
        }

        return false;
    }
}
