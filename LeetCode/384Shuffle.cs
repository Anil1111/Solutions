public class Solution {
    int[] _nums;
    Random rand = new Random();
    
    public Solution(int[] nums) {
        _nums = nums;
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] Reset() {
        return _nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] Shuffle() {
        List<int> list = new List<int>();
        for(int i=0;i<_nums.Length;i++) list.Add(i);
        
        int[] ret = new int[_nums.Length];
        for(int i=0;i<_nums.Length;i++){
            int next = rand.Next(list.Count);
            ret[i] = _nums[list[next]];
            list.RemoveAt(next);
        }
        
        return ret;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.Reset();
 * int[] param_2 = obj.Shuffle();
 */
