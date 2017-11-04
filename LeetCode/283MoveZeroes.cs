public class Solution {
    public void MoveZeroes(int[] nums) {
        int prev = -1;
        for(int i=0;i<nums.Length;i++){
            if (nums[i]!=0){
                if (prev >= 0) {
                    nums[prev]=nums[i];
                    nums[i] = 0;
                    prev = nums[prev+1] == 0 ? prev + 1 : i;
                }
            }
            else if (prev < 0){
                prev = i;
            }
        }
    }
}
