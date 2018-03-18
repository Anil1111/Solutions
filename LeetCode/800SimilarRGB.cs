public class Solution {
    public string SimilarRGB(string color) {
        string ret = "#";
        
        for(int i=1;i<color.ToCharArray().Length;i+=2){
            ret += Similar(color[i], color[i+1]);
        }
        
        return ret;
    }
    
    string Similar(char x, char y){
        string ret = "";
        string index = "0123456789abcdef";
        int vx = index.IndexOf(x);
        int vy = index.IndexOf(y);
        
        int min = Math.Abs(vy-vx);
        int d = vx;
        if (vx+1 <= 15){
            var m = Math.Abs((vx+1)*15+vx+1-(vx*15+vy));
            if (m < min) d = vx+1;
        }
        if (vx-1 >= 0){
            var m = Math.Abs((vx-1)*15+vx-1-(vx*15+vy));
            if (m < min) d = vx-1;
        }
        ret += (char)index[d];
        ret += (char)index[d];
        return ret;
    }
}
