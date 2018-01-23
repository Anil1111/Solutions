public class Solution {
    public int MinSubArrayLen(int s, int[] nums) {
        int left = 0, min = int.MaxValue, sum = 0;
        for(int i=0;i<nums.Length;i++){
            sum += nums[i];
            while (sum >= s){
                int len = i-left+1;
                if (len < min) min = len;
                sum -= nums[left];
                left++;
            }
        }
        
        return min == int.MaxValue ? 0 : min;
    }
}
