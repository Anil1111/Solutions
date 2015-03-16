public class Solution {
    public int FindPeakElement(int[] num) {
        if (num.Length<=1) return 0;
        for(int i=1;i<num.Length-1;i++){
            if (num[i-1]<num[i] && num[i+1]<num[i]) return i;
        }
        if (num[num.Length-2]<num[num.Length-1]) return num.Length-1;
        return 0;
    }
}
