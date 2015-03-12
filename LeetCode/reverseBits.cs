public class Solution {
    public uint reverseBits(uint n) {
        uint ret = 0;
        for(int i=0;i<32;i++){
            ret = ret << 1;
            ret = ret | (n & 1);
            
            n = n>>1;
        }while(n>0);
        
        return ret;
    }
}
