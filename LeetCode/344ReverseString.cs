public class Solution {
    public string ReverseString(string s) {
        return string.Join("", s.ToCharArray().Reverse());
    }
}
