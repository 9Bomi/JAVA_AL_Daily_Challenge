import java.util.Arrays;

class Solution {
    public Integer[] solution(int N, int[] stages) {
        
        int count[] = new int[N+2];
        int sum[] = new int[N+2];
        for(int num:stages)
            count[num]++;
        
        sum[N+1] = count[N+1];
        for(int i=N;i>0;i--)
            sum[i] = sum[i+1]+count[i];
    
        double fail[] = new double[N+1];
        for(int i=1;i<=N;i++)
        	fail[i] =  (sum[i] == 0) ? 0 : (double)count[i]/sum[i];
        
        Integer[] answer = new Integer[N];
        for(int i=0;i<N;i++)
            answer[i] = i+1;
        
        Arrays.sort(answer,(n1, n2)->{
            if(fail[n1]==fail[n2])
                return n1-n2;
            return Double.compare(fail[n2], fail[n1]);
        });
        
        return answer;
    }
}