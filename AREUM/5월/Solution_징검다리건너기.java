package com.pro.algo;

public class Solution_징검다리건너기 {
	public int solution(int[] stones, int k) {
        int answer = 0;
        k--;
        
        int left = 0;
        int right = 200000000;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (check(mid, stones, k)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    static boolean check(int mid, int[] stones, int k) {
        int cnt = 0;
        
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] < mid) {
                if (cnt < k) {
                    cnt++;
                } else {
                    return false;
                }
            } else {
                cnt = 0;
            }
        }
        
        return true;
    }
}
