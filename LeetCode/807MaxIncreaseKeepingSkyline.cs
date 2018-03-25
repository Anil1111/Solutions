public class Solution {
    public int MaxIncreaseKeepingSkyline(int[][] grid) {
        int[] rows = new int[grid.Length];
        int[] cols = new int[grid.Length];
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid.Length;j++){
                if (grid[i][j] > rows[i]) rows[i] = grid[i][j];
                if (grid[i][j] > cols[j]) cols[j] = grid[i][j];
            }
        }
        int ret = 0;
        for(int i=0;i<grid.Length;i++){
            for(int j=0;j<grid.Length;j++){
                int newvalue = Math.Min(rows[i], cols[j]);
                ret += newvalue - grid[i][j];
            }
        }        
        return ret;
    }
}
