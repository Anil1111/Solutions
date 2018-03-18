public class Solution {
    public int SuperPow(int a, int[] b) {
        int ret = 1;
        a = a % 1337;
        for(int i=b.Length-1;i>=0;i--){
            ret = ret * pow(a, b[i]) % 1337;
            a = pow(a, 10);
        }
        return ret;
    }
    
    int pow(int a, int b){
        int ret = 1;
        for(int i=0;i<b;i++){
            ret = ret * a % 1337;
        }
        return ret;
    }
}
