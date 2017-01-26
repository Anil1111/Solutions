public class Solution {
    public string GetPermutation(int n, int k) {
        var nums = new List<int>();
        k--;
        for(int i=2;i<=n;i++){
            var r = k % i;
            nums.Add(r);
            k /= i;
        }
        nums.Reverse();
        var candidates = new List<int>();
        for(int i=1;i<=n;i++){
            candidates.Add(i);
        }
        StringBuilder builder = new StringBuilder();
        foreach(var num in nums){
            builder.Append(candidates[num]);
            candidates.RemoveAt(num);
        }
        builder.Append(candidates[0]);
        return builder.ToString();
    }
}
