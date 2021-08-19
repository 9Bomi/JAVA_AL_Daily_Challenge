class Solution {
    public long solution(long n) {
        
        double ans = Math.pow(n,0.5);
        
        if((ans-Math.floor(ans))!= 0) 
            return -1;
        
        return (long) Math.pow(ans+1,2);
    }
}