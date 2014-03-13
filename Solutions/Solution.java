public class Solution {
    public boolean isPalindrome(String s) {
        char[] list = new char[s.length()];
        int size = 0;
        for(int i=0;i<s.length();i++){
            char c = Character.toLowerCase(s.charAt(i));
            if ((c>='a' && c<='z') || (c>='0' && c<='9')){
                list[size] = c;
                size ++;
            }
        }
        
        if(size == 0) return true;

        int i=0, j=size-1;
        while(i<j){
            if (list[i] != list[j]) return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    
    
}
