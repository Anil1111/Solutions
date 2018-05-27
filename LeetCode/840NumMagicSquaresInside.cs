public class Solution {
    public int NumMagicSquaresInside(int[][] grid) {
        int count = 0;
        for(int i=0;i<grid.Length-2;i++){
            for(int j=0;j<grid[i].Length-2;j++){
                int[] d = new int[10];
                bool flag = true;
                for(int k=0;k<3&&flag;k++){
                    //Console.WriteLine(i+","+j+","+k+" "+grid[i+k][j]+" "+grid[i+k][j+1]+" "+grid[i+k][j+2]);
                    for(int l=0;l<3&&flag;l++){
                        int val = grid[i+k][j+l];
                        if (val>9||val<1) flag = false;
                        else if (d[val] > 0) flag = false;
                        else d[val]=1;
                    }
                }
                if (!flag) continue;
                
                int sum = grid[i][j]+grid[i][j+1]+grid[i][j+2];
                if (sum != grid[i+1][j]+grid[i+1][j+1]+grid[i+1][j+2]){
                    continue;
                }
                if (sum != grid[i+2][j]+grid[i+2][j+1]+grid[i+2][j+2]){
                    continue;
                }
                if (sum != grid[i][j]+grid[i+1][j]+grid[i+2][j]){
                    continue;
                }
                if (sum != grid[i][j+1]+grid[i+1][j+1]+grid[i+2][j+1]){
                    continue;
                }
                if (sum != grid[i][j+2]+grid[i+1][j+2]+grid[i+2][j+2]){
                    continue;
                }
                if (sum != grid[i][j]+grid[i+1][j+1]+grid[i+2][j+2]){
                    continue;
                }
                if (sum != grid[i+2][j]+grid[i+1][j+1]+grid[i][j+2]){
                    continue;
                }
                Console.WriteLine(i+","+j+" "+flag);
                count++;
            }
        }
        
        return count;
    }
}
