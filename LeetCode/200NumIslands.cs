public class Solution {
    public int NumIslands(char[,] grid) {
        var set = new HashSet<int>();
        int len = grid.GetLength(1);
        int count = 0;
        for(int i=0;i<grid.GetLength(0);i++){
            for(int j=0;j<len;j++){
                if (Island(grid, i, j)){
                    if (!set.Contains(i * len + j)){
                        count ++;
                        FillIsland(grid, set, i, j);
                    } 
                }                
            }
        }
        return count;
    }
    
    private void FillIsland(char[,] grid, HashSet<int> set, int i, int j){
        int len = grid.GetLength(1);
        set.Add(i*len+j);
        
        if (!set.Contains((i-1)*len+j) && Island(grid, i-1, j)) FillIsland(grid, set, i-1, j);
        if (!set.Contains((i+1)*len+j) && Island(grid, i+1, j)) FillIsland(grid, set, i+1, j);
        if (!set.Contains((i)*len+j-1) && Island(grid, i, j-1)) FillIsland(grid, set, i, j-1);
        if (!set.Contains((i)*len+j+1) && Island(grid, i, j+1)) FillIsland(grid, set, i, j+1);
    }
    
    private bool Island(char[,] grid, int i, int j){
        if (i < 0 || i >= grid.GetLength(0) || j < 0 || j >= grid.GetLength(1)){
            return false;
        }
        
        return grid[i, j] == '1';
    }
}
