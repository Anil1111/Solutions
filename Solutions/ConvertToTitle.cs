public class Solution {
    public String ConvertToTitle(int n) {
        StringBuilder ret = new StringBuilder();
        while(n>0){
            n--;
            int val = n % 26;
            ret.Insert(0, (char)('A'+val));
            n/=26;
        }
        return ret.ToString();
    }
}

