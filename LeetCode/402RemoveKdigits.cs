public class Solution {
    public string RemoveKdigits(string num, int k) {
        int i = num.IndexOf('0');
        while (i>=0 && k>=i){
            k-=i;
            do{
                i++;
            }while(i<num.Length&&num[i]=='0');
            num = num.Substring(i);
            i = num.IndexOf('0');
        }
        
        while(num!="" && k>0){
            for(i=1;i<num.Length;i++){
                if (num[i-1]>num[i]) break;
            }
            num = num.Remove(i-1,1);
            k--;            
        }
        return num == "" ? "0" : num;
    }
}
