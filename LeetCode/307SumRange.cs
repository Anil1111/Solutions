public class NumArray {
    private int[] b;
    private int len;
    private int[] nums;

    public NumArray(int[] nums) {
        if (nums == null || nums.Length==0) return;
        
        this.nums = nums;
        var l = Math.Sqrt(nums.Length);
        len = (int)Math.Ceiling(nums.Length/l);
        b = new int [len];
        for (int i = 0; i < nums.Length; i++)
            b[i / len] += nums[i];
    }

    public int SumRange(int i, int j) {
        int sum = 0;
        int startBlock = i / len;
        int endBlock = j / len;
        if (startBlock == endBlock) {
            for (int k = i; k <= j; k++)
                sum += nums[k];
        } else {
            for (int k = i; k <= (startBlock + 1) * len - 1; k++)
                sum += nums[k];
            for (int k = startBlock + 1; k <= endBlock - 1; k++)
                sum += b[k];
            for (int k = endBlock * len; k <= j; k++)
                sum += nums[k];
        }
        return sum;
    }

    public void Update(int i, int val) {
        int b_l = i / len;
        b[b_l] = b[b_l] - nums[i] + val;
        nums[i] = val;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.Update(i,val);
 * int param_2 = obj.SumRange(i,j);
 */
