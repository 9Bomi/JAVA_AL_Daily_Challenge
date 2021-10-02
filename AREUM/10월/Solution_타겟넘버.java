package com.pro.algo;

class Solution_타겟넘버 {
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
      
        make(0,0,target,numbers);
        
        return cnt;
    }
    
    public static void make(int index, int sum, int target, int[] numbers){
        if(index==numbers.length){
            if(sum==target) cnt++;
            return;
        }
        
        make(index+1, sum+numbers[index], target, numbers);
        make(index+1, sum-numbers[index], target, numbers);
    }
}
