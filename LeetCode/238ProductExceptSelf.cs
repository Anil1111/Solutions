public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int len = nums.Length;
        var dp = new int[len];
        dp[0] = 1;
        for(int i=1;i<len;i++){
            dp[i] = dp[i-1] * nums[i-1];
        }
        var right = 1;
        for(int i=len-1;i>=0;i--){
            dp[i] *= right;
            right *= nums[i];
        }
        return dp;
    }
}
