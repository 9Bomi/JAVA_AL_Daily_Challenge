package com.pro.algo;

import java.util.Arrays;

public class Solution_소수찾기 {
    static int[] nums;
    static boolean[] isSelected;
    static boolean[] isDemical;
    static int answer;
    
    public int solution(String numbers) {
        nums = new int[numbers.length()];
        isSelected = new boolean[numbers.length()];
        
        checkDemical();
        
        for (int i = 0; i < numbers.length(); i++) {
            nums[i] = numbers.charAt(i) - '0';
        }
        
        for (int i = 1; i <= numbers.length(); i++) {
            perm(0, 0, i);        
        }
        
        return answer;
    }
    
    public static void checkDemical() {
        isDemical = new boolean[10000000];
        
        Arrays.fill(isDemical, true);
        
        isDemical[0] = false;
        isDemical[1] = false;
        
        for (int i = 2; i < isDemical.length; i++) {
            if (!isDemical[i]) {
                continue;
            }
            
            for (long j = (long)i * i; j < isDemical.length; j += i ) {
                isDemical[(int)j] = false;
            }
        }
    }

    public static void perm(int cnt, int num, int n) {
        if (cnt == n) {
            if (isDemical[num]) {
                isDemical[num] = false;
                answer++;
            }
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (isSelected[i]) {
                continue;
            }
            
            isSelected[i] = true;
            perm(cnt+1, num * 10 + nums[i], n);
            isSelected[i] = false;
        }
    }
}
