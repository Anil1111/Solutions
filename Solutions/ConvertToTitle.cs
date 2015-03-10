public class Solution {
    public String ConvertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while(n>0){
            n--;
            ret.Insert(0, (char)('A'+n % 26));
            n/=26;
        }
        return ret.ToString();
    }
}

