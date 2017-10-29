    public string Multiply(string num1, string num2) {
        var list1 = num1.Select(c => c - '0').ToList();
        var list2 = num2.Select(c => c - '0').ToList();
        var sum = new List<int>();
        
        for(int i=0;i<list1.Count()*list2.Count()+1;i++){
            sum.Add(0);
        }
        
        for(int i=list1.Count()-1;i>=0;i--){
            for(int j=list2.Count()-1;j>=0;j--){
                sum[(i+1)*(j+1)-1] += list1[i]*list2[j];
            }
        }
      
        for(int i=sum.Count()-1;i>=0;i--){
            if (i-2 >= 0) sum[i-2] += sum[i] / 100;
            if (i-1 >= 0) sum[i-1] += sum[i] / 10;
            sum[i] = sum[i] % 10;
        }
        
        while(sum.Count() > 1 && sum[0] == 0){
            sum.RemoveAt(0);
        }
        
        return string.Join("", sum);
    }
