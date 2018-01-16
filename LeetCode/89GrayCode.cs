public class Solution {
    public IList<int> GrayCode(int n) {
        var result = new List<int>();
        for (int i = 0; i < 1<<n; i++){
            result.Add(i ^ i>>1);
        }
        return result;
    }
}
