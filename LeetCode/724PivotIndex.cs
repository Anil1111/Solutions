public class Solution {
    public int PivotIndex(int[] nums) {
        int[] left = new int[nums.Length], right = new int[nums.Length];
        for(int i=1;i<nums.Length;i++){
            left[i] = left[i-1] + nums[i-1];
            right[nums.Length-i-1] = right[nums.Length-i] +  nums[nums.Length-i];
        }
        
        for(int i=0;i<nums.Length;i++){
            if (left[i]==right[i]) return i;
        }
        
        return -1;
    }
}
