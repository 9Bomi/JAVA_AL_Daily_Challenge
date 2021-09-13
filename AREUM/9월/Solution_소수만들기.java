package com.pro.algo;

class Solution_소수만들기 {
    static int answer=0;
    public int solution(int[] nums) {
        

        combination(0,0,0,nums);

        return answer;
    }
    
    public static void combination(int start, int cnt, int sum, int nums[]){
        if(cnt==3) {
            if(isSosu(sum)) answer++;
            return;
        }
        
        for(int i=start; i<nums.length; i++){
            combination(i+1, cnt+1, nums[i]+sum, nums);
        }
        
    }
    public static boolean isSosu(int n){
        if(n==1) return false;
        for(int i=2; i<n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
}