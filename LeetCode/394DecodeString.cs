public class Solution {
    public string DecodeString(string s) {
        if (s.Length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.Length; i ++) {
            char c = s[i];
            if (Char.IsDigit(c)) {
                int digit_begin = i;
                while (s[i] != '[') i++;
                int num = int.Parse(s.Substring(digit_begin, i-digit_begin));
                int count = 1;
                int str_begin = i+1;
                i ++;
                while (count != 0) {
                    if (s[i] == '[') count ++;
                    else if (s[i] == ']') count --;
                    i ++;
                }
                i--;
                string str = DecodeString(s.Substring(str_begin, i-str_begin));
                for (int j = 0; j < num; j ++) {
                    sb.Append(str);
                }
            } else {
                sb.Append(c);
            }
        }
        return sb.ToString();
    }
}
