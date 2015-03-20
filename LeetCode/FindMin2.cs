public class Solution {
    public int FindMin(int[] num) {
        int min=num[0], l=0, r=num.Length-1;
        while(l<r){
            int m = (l+r)/2;
            if (num[m]<min) min = num[m];
            if (num[l] < num[m]) { //left half is sorted
                if (num[l]<min) min=num[l];
                l = m + 1;
            } 
            else if (num[l] > num[m]) { //right half is sorted
                if (num[m+1]<min) min=num[m=1];
                r = m - 1;
            } 
            else {
                l++;
            }
        }
        
        return Math.Min(num[l], min);
    }
}
