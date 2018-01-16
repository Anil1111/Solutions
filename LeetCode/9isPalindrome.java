public class Solution {
    public boolean isPalindrome(int x) {
        if (x<0) return false;
        
        int div=1;
        while(x/div>=10) div*=10;
        while(x>0){
            int top = x/div;
            int bottom = x%10;
            if (top != bottom) return false;
            x = x%div/10;
            div/=100;
        }
        return true;
    }
}

