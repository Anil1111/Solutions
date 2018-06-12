public class Solution {
    public bool BackspaceCompare(string S, string T) {
        return Backspace(S)==Backspace(T);
    }
    
    public string Backspace(string S){
        var builder = new StringBuilder();
        foreach(var ch in S){
            if (ch=='#'){
                if (builder.Length>0){
                    builder.Remove(builder.Length-1,1);
                }
            }
            else{
                builder.Append(ch);
            }
        }
        
        return builder.ToString();
    }
}
