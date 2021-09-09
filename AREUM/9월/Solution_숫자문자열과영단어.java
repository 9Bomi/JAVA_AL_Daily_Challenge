package com.pro.algo;

class Solution_숫자문자열과영단어 {
    public int solution(String s) {
        int answer = 0;
       
        String nums[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
       
        for(int i=0; i<=9; i++){
            s = s.replaceAll(nums[i], i+"");
        }
    
        answer=Integer.parseInt(s);
       
        return answer;
    }
}