package com.pro.algo;

class Solution_멀쩡한사각형 {
    public long solution(int w, int h) {
        long answer = (long)w*h-w-h;
        
        int cd = gcd(Math.max(w,h), Math.min(w,h));

        answer += cd;
        
        return answer;
    }
    
    public static int gcd(int a, int b) {    
        if(a%b==0) return b;
        else return gcd(b, a%b);
    }
}