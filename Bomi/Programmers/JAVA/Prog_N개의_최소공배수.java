import java.util.*;

class Solution {
    static long gcd(long a, long b){
        if(b == 0)  return a;

        return gcd(b,a%b);
    }   
    
    public long solution(int[] arr) {
        
        Stack<Long> stack = new Stack<>();
        for(int num: arr)
            stack.push((long)num);
        
        while(stack.size()>1){
            long num1 = stack.pop();
            long num2 = stack.pop();
            
            long gcd = gcd(Math.max(num1,num2),Math.min(num1,num2));
            
            stack.push(num1*num2/gcd);
        }
        
        return stack.pop();
    }
}