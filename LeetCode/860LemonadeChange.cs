public class Solution {
    public bool LemonadeChange(int[] bills) {
        int b5 = 0, b10 = 0;
        foreach(var bill in bills){
            switch(bill){
                case 5:
                    b5++;
                    break;
                case 10:
                    b5--;
                    if (b5<0) return false;
                    b10++;                    
                    break;
                case 20:
                    int m = 3;
                    if (b10>0){
                        b10--;
                        m = 1;
                    }
                    b5-=m;
                    if (b5<0) return false;
                    break;
            }
        }
        return true;
    }
}
