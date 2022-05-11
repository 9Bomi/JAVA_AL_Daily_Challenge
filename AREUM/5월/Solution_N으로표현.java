package com.pro.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution_N으로표현 {
	public int solution(int N, int number) {
        int answer = 1;
        
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<Integer>());
        
        Set<Integer> set = new HashSet<>();
        set.add(N);
        
        dp.add(set);
        
        while (answer < 9) {
            if (dp.get(answer).contains(number)) {
                return answer;
            }
            
        	Set<Integer> temp = new HashSet<>();
            answer++;
            
            for (int i = 1; i <= answer / 2; i++) {
                Integer[] list1 = dp.get(i).toArray(new Integer[0]);
                Integer[] list2 = dp.get(answer - i).toArray(new Integer[0]);
            
                for (int j = 0; j < list1.length; j++) {
                    for (int k = j; k < list2.length; k++) {
                        int first = list1[j];
                        int second = list2[k];
                        
                        temp.add(first + second);
                        temp.add(first - second);
                        temp.add(second - first);
                        temp.add(first * second);
                        
                        if (second != 0) {
                            temp.add(first / second);
                        }
                        
                        if (first != 0) {
                            temp.add(second / first);
                        }
                    }
                }
            }
            
            int res = N;
            for (int k = 0; k < answer - 1; k++) {
                res = res  * 10 + N;
            }

            temp.add(res);
            dp.add(temp);
        }
        
        return -1;
    }
}
