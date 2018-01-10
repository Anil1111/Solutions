public class Solution {
    public int FindLengthOfLCIS(int[] nums) {
        if (nums == null || nums.Length == 0) return 0;
        int ret = 1, count = 1;        
        for(int i=1;i<nums.Length;i++){
            if (nums[i]>nums[i-1]){
                count++;
                if (count > ret) ret = count;
            }
            else{
                count = 1;
            }
        }
        return ret;
    }
}
