public class Solution {
    public bool WordPattern(string pattern, string str) {
        var words = str.Split(' ');
        if (words.Length != pattern.Length) return false;
        
        var dict1 = new Dictionary<char, string>();
        var dict2 = new Dictionary<string, char>();
        for(int i=0;i<pattern.Length;i++){
            var ch = pattern[i];
            var word = words[i];
            if (dict1.ContainsKey(ch)){
                if (dict1[ch] != word){
                    return false;
                }
            }
            else if (dict2.ContainsKey(word)){
                if (dict2[word] != ch){
                    return false;
                }
            }
            else {
                dict1[ch] = word;
                dict2[word] = ch;
            }
        }
        
        return true;
    }
}
