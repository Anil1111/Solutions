public class Solution {
    public int PeakIndexInMountainArray(int[] A) {
        int max = 0, ret = 0;
        for(int i=0;i<A.Length;i++){
            if (A[i]>max){
                max=A[i];
                ret = i;
            }
        }
        return ret;
    }
}
