public class Solution {
    public IList<int> SelfDividingNumbers(int left, int right) {
        var ret = new List<int>();
        for(int i=left;i<=right;i++){
            if (i<1) continue;
            if (i>=1&&i<10) ret.Add(i);
            else{
                int n = i;
                while(n>0){
                    int r = n % 10;
                    if (r == 0) break;
                    if (i % r != 0) break;
                    n = n / 10;
                }
                if (n == 0) ret.Add(i);
            }
        }
        return ret;
    }
}
