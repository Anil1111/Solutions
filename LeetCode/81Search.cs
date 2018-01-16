public class Solution {
    public bool Search(int[] A, int target) {
        int l=0,r=A.Length-1;
        while(l<r){
            int m = (l+r)/2;
            if (A[m]==target) return true;
            if (A[l] < A[m]) { //left half is sorted
                if (A[l] <= target && target < A[m]) r = m - 1;
                else l = m + 1;
            } else if (A[l] > A[m]) { //right half is sorted
                if (A[m] < target && target <= A[r]) l = m + 1;
                else r = m - 1;
            } else l++;
        }
        
        return A[l]==target;
    }
}
