public class Solution {
    public int DominantIndex(int[] nums) {
        int max = int.MinValue, sec = int.MinValue;
        int mi = -1, si = -1;
        for(int i=0;i<nums.Length;i++){
            var num = nums[i];
            if (num>max){
                if (max>sec){
                  sec=max;
                  si=mi;
                } 
                max=num;
                mi=i;
            }
            else if (num>sec){
                sec=num;
                si=i;
            }
        }
        if (max/2 >= sec) return mi;
        else return -1;
    }
}
