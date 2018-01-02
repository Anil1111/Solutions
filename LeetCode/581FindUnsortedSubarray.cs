public class Solution {
    public int FindUnsortedSubarray(int[] nums) {
        var list = new List<int>(nums);
        Array.Sort(nums);
        int ret = nums.Length;
        for(int i=0;i<nums.Length;i++) {
            if (nums[i] != list[i]) break;
            ret--;
        }
        for(int i=nums.Length-1;i>=0;i--) {
            if (nums[i] != list[i]) break;
            ret--;
        }
        return Math.Max(0, ret);
    }
}
