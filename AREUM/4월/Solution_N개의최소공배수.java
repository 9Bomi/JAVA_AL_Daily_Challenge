package com.pro.algo;

public class Solution_N개의최소공배수 {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        for (int i = 1;  i < arr.length; i++) {
            int gcd = gcd(answer, arr[i]);
            answer = answer/gcd * arr[i];
        }
 
        return answer;
    }
    
    public int gcd(int a, int b) {
       if (b == 0) {
            return a;
        }
        
        return gcd(b, a % b);
    }
}
