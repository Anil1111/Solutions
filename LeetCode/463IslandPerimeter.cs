public class Solution {
    public int IslandPerimeter(int[,] grid) {
        int count = 0;
        for(int i=0;i<grid.GetLength(0);i++){
            for(int j=0;j<grid.GetLength(1);j++){
                if (grid[i,j] == 1) count += 4 - Connect(grid, i, j);
            }
        }
        return count;
    }
        
        private int Connect(int[,] grid, int i, int j){
            int count = 0;
            if (i > 0 && grid[i-1,j] == 1) count++;
            if (j > 0 && grid[i,j-1] == 1) count++;
            if (i < grid.GetLength(0) - 1 && grid[i+1,j] == 1) count ++;
            if (j < grid.GetLength(1) - 1 && grid[i,j+1] == 1) count ++;

            return count;
        }
}
