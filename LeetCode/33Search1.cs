public class Solution {
    public int Search(int[] A, int target) {
        int l=0,r=A.Length-1;
        while(l<r){
            int m = (l+r)/2;
            if (A[m]==target) return m;
            if (A[l] < A[m]) { //left half is sorted
                if (A[l] <= target && target < A[m]) r = m - 1;
                else l = m + 1;
            } else if (A[m] < A[r]){ //right half is sorted
                if (A[m] < target && target <= A[r]) l = m + 1;
                else r = m - 1;
            }
            else l++;
        }
        
        return A[l]==target ? l : -1;
    }
}
