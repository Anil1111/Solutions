public class Solution {
    public bool Exist(char[,] board, string word) {
        char[] chs = word.ToCharArray();
        for(int i=0;i<board.GetLength(0);i++){
            for(int j=0;j<board.GetLength(1);j++){
                if (board[i, j] == chs[0]){
                    board[i, j] = '0';
                    if (Check(board, i, j, chs, 1))
                        return true;
                    board[i, j] = chs[0];
                }
            }
        }
        return false;
    }
    
    private bool Check(char[,] board, int i, int j, char[] chs, int start){
        if (chs.Length == start) return true;
                   
        if (Match(board, i-1, j, chs[start])){
            board[i-1, j] = '0';
            if (Check(board, i-1, j, chs, start + 1)){
                return true;
            }
            board[i-1, j] = chs[start];
        }
        if (Match(board, i+1, j, chs[start])){
            board[i+1, j] = '0';
            if (Check(board, i+1, j, chs, start + 1)){
                return true;
            }
            board[i+1, j] = chs[start];
        }
        if (Match(board, i, j-1, chs[start])){
            board[i, j-1] = '0';
            if (Check(board, i, j-1, chs, start + 1)){
                return true;
            }
            board[i, j-1] = chs[start];
        }
        if (Match(board, i, j+1, chs[start])){
            board[i, j+1] = '0';
            if (Check(board, i, j+1, chs, start + 1)){
                return true;
            }
            board[i, j+1] = chs[start];
        }
       
        return false;
    }
    
    private bool Match(char[,] board, int i, int j, char ch){
        if (i<0 || j<0 || i>board.GetLength(0)-1 || j>board.GetLength(1)-1){
            return false;
        }            
        
        if (board[i, j] == '0'){
            return false;
        }
        
        return ch == board[i, j];
    }
}
