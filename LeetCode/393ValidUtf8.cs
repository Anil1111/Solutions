public class Solution {
    public bool ValidUtf8(int[] data) {
        int count = 0;
        
        foreach(int d in data){
            if (d < 128){//<1000
                if (count > 0) return false;
            }
            else if (d < 192){//<1100
                if (count > 0) count --;
                else return false;
            }
            else if (d < 224){//<1110
                if (count != 0) return false;
                else count = 1;
            }
            else if (d < 240){//<11110
                if (count != 0) return false;
                else count = 2;
            }
            else if (d < 248){
                if (count != 0) return false;
                else count = 3;
            }
            else return false;
        }
        
        return count == 0;
    }
}
