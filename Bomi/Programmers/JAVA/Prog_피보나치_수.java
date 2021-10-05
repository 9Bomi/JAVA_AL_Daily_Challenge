class Solution {
    static int fibo[];
    
    static int fibonacci(int n){
        
        if(n<=1 || fibo[n]!=0)
            return fibo[n];
        
        return fibo[n] = (fibonacci(n-1)+fibonacci(n-2))%1234567;
    }
    
    public int solution(int n) {
        fibo = new int[n+1];
        fibo[1] =1;
        return fibonacci(n);
    }
}