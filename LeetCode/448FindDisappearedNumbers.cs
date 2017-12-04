public class Solution {
    public IList<int> FindDisappearedNumbers(int[] nums) {
        IList<int> ret = new List<int>();
        for(int i=0;i<nums.Length;i++){
            int index = (nums[i] > 0 ? nums[i] : -nums[i]) - 1;
            if (nums[index]>0) nums[index]=-nums[index];
        }
        for(int i=0;i<nums.Length;i++){
            if (nums[i]>0) ret.Add(i+1);
            else nums[i]=-nums[i];
        }
            
        return ret;    
    }
}
