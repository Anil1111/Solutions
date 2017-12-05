public class Solution {
    public int MinMoves(int[] nums) {
        int sum = 0, min = int.MaxValue;
        for(int i=0;i<nums.Length;i++){
            sum += nums[i];
            if (nums[i]<min) min = nums[i];
        }
        return sum - nums.Length*min;        
    }
}
