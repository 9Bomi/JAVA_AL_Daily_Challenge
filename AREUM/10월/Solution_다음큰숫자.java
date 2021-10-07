package com.pro.algo;

class Solution_다음큰숫자 {
    public int solution(int n) {
        
        String binary = Integer.toString(n,2);
        int cnt = binary.length() - binary.replace("1","").length();
        
        while(true){
            n++;
            String temp = Integer.toString(n,2);
            
            int past =temp.length() - temp.replace("1","").length();
            
            if(past==cnt) break;
        }
        
        return n;
    }
}