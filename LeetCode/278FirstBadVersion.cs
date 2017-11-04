/* The isBadVersion API is defined in the parent class VersionControl.
      bool IsBadVersion(int version); */

public class Solution : VersionControl {
    public int FirstBadVersion(int n) {
        int min = 1, max = n;
        while(min<max){
            int mid = min/2+max/2;
            if (IsBadVersion(mid)){
                max = mid;
            }
            else{
                min=mid+1;
            }
        }
        return min;
    }
}
