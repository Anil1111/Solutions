public class Solution {
    public bool IsAnagram(string s, string t) {
        return String.Concat(s.OrderBy(c => c)) == String.Concat(t.OrderBy(c => c));
    }
}
