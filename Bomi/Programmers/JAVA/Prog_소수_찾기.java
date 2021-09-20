class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean isNotPrime[] = new boolean[n+1];
        
        for(int i=2;i<=n;i++){
            
            if(isNotPrime[i])
                continue;
            
            for(int j=i*2;j<=n;j+=i)
                isNotPrime[j] = true;
        }
        
        for(int i=2;i<=n;i++)
            if(!isNotPrime[i])
                answer++;
        
        return answer;
    }
}