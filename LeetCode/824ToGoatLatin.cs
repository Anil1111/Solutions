public class Solution {
    public string ToGoatLatin(string S) {
        StringBuilder builder = new StringBuilder();
        int index = 1;
        foreach(string word in S.Split()){
            char first = word[0];
            bool isVow = "AEIOUaeiou".IndexOf(first) >= 0;
            if (isVow){
                builder.Append(word);
            }
            else{
                builder.Append(word.Substring(1));
                builder.Append(first);
            }
            builder.Append("ma");
            for(int i=0;i<index;i++) builder.Append('a');
            builder.Append(' ');
            index++;
        }
        
        return builder.ToString().Trim();
    }
}
