public class Solution {
    public int[] ConstructRectangle(int area) {
        int w = 0, l = 0, min = area;
        
        for(int i=1;i<=area/i;i++){
            if (area % i == 0){
                int j = area / i;
                if (j-i<min){
                    min = j-i;
                    w = j;
                    l = i;
                }
            }
        }
        
        return new int[] {w, l}; 
    }
}
