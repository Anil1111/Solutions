public class Solution {
    public bool IsUgly(int num) {
        if (num == 0) return false;
        
        foreach(int n in new int[]{2, 3, 5}){
            while(num % n == 0){
                num = num / n;
            }
        }
        
        return num == 1;
    }
}
