public class Solution {
    public int MinimumLengthEncoding(string[] words) {
        HashSet<string> wordset = new HashSet<string>(), fset = new HashSet<string>();
        List<string> sorted = words.OrderByDescending(w => w.Length).ToList();
        foreach(var word in sorted){
            if (wordset.Contains(word)) continue;
            fset.Add(word);
            
            for (int i=1;i<word.Length;i++){
                var r1 = word.Substring(i);
                wordset.Add(r1);
            }
        }
        int ret = 0;
        foreach(var word in fset) ret += word.Length+1;
        return ret;
    }
    
    public static string Reverse( string s )
    {
        char[] charArray = s.ToCharArray();
        Array.Reverse( charArray );
        return new string( charArray );
    }
}
