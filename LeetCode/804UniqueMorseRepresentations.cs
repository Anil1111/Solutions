public class Solution {
    public int UniqueMorseRepresentations(string[] words) {
        string[] codes = new string[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<string> converted = new HashSet<string>();
        foreach(string word in words){
            string temp = "";
            foreach(char c in word){
                temp += codes[c-'a'];
            }
            converted.Add(temp);
        }
        return converted.Count();
    }
}
