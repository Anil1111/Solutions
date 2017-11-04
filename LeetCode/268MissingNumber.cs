public class Solution {
    public int MissingNumber(int[] nums) {
        int ret = 0;
        foreach(var num in nums) ret ^= num;
        for(int i=0;i<=nums.Length;i++) ret ^= i;
        return ret;
    }
}
