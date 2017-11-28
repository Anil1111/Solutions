public class Solution {
    public IList<string> FizzBuzz(int n) {
        var ret = new List<string>();
        for(int i=1;i<=n;i++){
            var m3 = i%3==0;
            var m5 = i%5==0;
            if (m3&&m5) ret.Add("FizzBuzz");
            else if (m3) ret.Add("Fizz");
            else if (m5) ret.Add("Buzz");
            else ret.Add(i.ToString());
        }
        return ret;
    }
}
