public class Solution {
    public class Position {
        public int r;
        public int c;
    }
    
    public int[,] FloodFill(int[,] image, int sr, int sc, int newColor) {
        int color = image[sr, sc];
        if (color == newColor) return image;
        
        var list = new List<Position>();
        list.Add(new Position(){r=sr, c=sc});
        while(list.Count > 0){
            var newlist = new List<Position>();
            foreach(var p in list){
                image[p.r, p.c] = newColor;
                if (IsValid(image, p.r-1, p.c, color)) newlist.Add(new Position(){r=p.r-1, c=p.c});
                if (IsValid(image, p.r, p.c-1, color)) newlist.Add(new Position(){r=p.r, c=p.c-1});
                if (IsValid(image, p.r+1, p.c, color)) newlist.Add(new Position(){r=p.r+1, c=p.c});
                if (IsValid(image, p.r, p.c+1, color)) newlist.Add(new Position(){r=p.r, c=p.c+1});
            }
            list = newlist;
        }
        return image;
    }
    
    private bool IsValid(int[,] image, int r, int c, int color) {
        if (r < 0 || r >= image.GetLength(0)) return false;
        if (c < 0 || c >= image.GetLength(1)) return false;
        return image[r,c] == color;
    }
}
