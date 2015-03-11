/**
* "2", "", etc
*/
public class Solution {
    public List<String> letterCombinations(String digits) {
        String[] dict = {"", "", "abc", "def", "ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> ret = new ArrayList<String>();
        for(int i = 0;i<digits.length();i++){
            int val = (int)digits.charAt(i) - '0';
            List<String> newret = new ArrayList<String>();
            if (ret.size()==0) ret.add("");
            for(String r:ret){
                for(int j=0;j<dict[val].length();j++){
                    newret.add(r+dict[val].charAt(j));
                }
            }
            if (newret.size()>0) ret=newret;
        }
        return ret;
    }
}
