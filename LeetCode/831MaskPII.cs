public class Solution {
    public string MaskPII(string S) {
        if (char.IsLetter(S, 0)){
            int start = S.IndexOf("@");
            string lower = S.ToLower();
            return lower[0]+"*****"+lower[start-1]+lower.Substring(start);            
        }
        else{
            string output = "";
            int count = 0;
            for(int i=S.Length-1;i>=0;i--){
                if (char.IsDigit(S, i)){
                    if (output.Length < 4){
                        output = S[i] + output;
                    }
                    count ++;
                }
            }
            if (count < 11){
                return "***-***-"+output;
            }
            else{
                string temp = "+";
                for(int i=0;i<count - 10;i++) temp+="*";
                return temp+"-***-***-"+output;
            }
        }
    }
}
