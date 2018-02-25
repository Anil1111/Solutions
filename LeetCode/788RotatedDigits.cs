public class Solution {
    public int RotatedDigits(int N) {
        int ret = 0;
        for(int i=1;i<=N;i++){
            if (Valid(i)) ret++;
        }
        return ret;
    }
    
    bool Valid(int num){
        var str = num.ToString();
        return str.IndexOfAny(new char[]{'2','5','6','9'})>=0 &&
            str.IndexOfAny(new char[]{'3','4','7'}) < 0;
    }
}
