public class Solution {
    public int FindMin(int[] num) {
        int left = 0, right = num.Length - 1;
        int mid = (left+right)/2;
        while(num[left]!=num[right]){
            if (num[left]<num[right]){
                return num[left];
            }
            else{ 
                if (num[mid]<num[right]){
                    right = mid;
                }
                else{
                    left = mid+1;
                }
                mid = (left+right)/2;
            }
        }
        return num[mid];
    }
}
