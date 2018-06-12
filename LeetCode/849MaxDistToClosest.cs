public class Solution {
    public int MaxDistToClosest(int[] seats) {
        int max = 1;
        int start = 0, end = seats.Length-1;
        for(int i=0;i<seats.Length;i++){
            if (seats[i]!=0){
                start = i;
                break;
            }
        }
        for(int i=seats.Length-1;i>=0;i--){
            if (seats[i]!=0){
                end=i;
                break;
            }
        };
        int count = 0;
        int temp = seats.Length-end-1;
        if (temp<1) temp=1;
        max = start > temp ? start : temp;
        for(int i=start+1;i<=end;i++){
            if (seats[i]==0){
                count++;
            }
            else{
                int mid = (count+1)/2;
                if (mid>max) max = mid;
                count=0;
            }
        }
        return max;
    }
}
