class Solution {
    int[] _nums;
    public Solution(int[] nums) {
        _nums = nums;
    }
    
    public int pick(int target) {
        List list = new ArrayList();
        for(int i=0;i<_nums.length;i++){
            if (_nums[i]==target) list.add(i);
        }
        Random rand = new Random();
        int ret = rand.nextInt(list.size());
        return (int)list.get(ret);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
