public class Solution {
    public int[] SingleNumber(int[] nums) {
        int r = nums[0];
        for(int i=1;i<nums.Length;i++) {
            r = r ^ nums[i];
        }
        
        r = r & (-r);
        
        List<int> list1 = new List<int>(), list2 = new List<int>();
        foreach(int num in nums){
            if ((num & r) == 0){
                list2.Add(num);
            }
            else{
                list1.Add(num);
            }
        }
        
        return new int[]{SingleNumber(list1), SingleNumber(list2)};
    }
    
    private int SingleNumber(List<int> nums){
        int r = nums[0];
        for(int i=1;i<nums.Count();i++) {
            r = r ^ nums[i];
        }
        return r;
    }
}
